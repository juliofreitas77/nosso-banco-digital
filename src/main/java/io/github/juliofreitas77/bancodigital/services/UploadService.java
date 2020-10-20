package io.github.juliofreitas77.bancodigital.services;

import io.github.juliofreitas77.bancodigital.domain.Cliente;
import io.github.juliofreitas77.bancodigital.domain.Endereco;
import io.github.juliofreitas77.bancodigital.domain.ImageCPF;
import io.github.juliofreitas77.bancodigital.domain.Proposta;
import io.github.juliofreitas77.bancodigital.dto.CPFDto;
import io.github.juliofreitas77.bancodigital.enums.StatusPropostaEnum;
import io.github.juliofreitas77.bancodigital.repositories.ImageCPFRepository;
import io.github.juliofreitas77.bancodigital.services.exceptions.FileException;
import io.github.juliofreitas77.bancodigital.services.exceptions.ObjectNotFoundException;
import io.github.juliofreitas77.bancodigital.services.exceptions.UnprocessableException;
import io.github.juliofreitas77.bancodigital.services.exceptions.ValidaPropostaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UploadService {

    @Autowired
    private ImageCPFRepository cpfRepository;

    @Autowired
    private ClienteService service;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private PropostaService propostaService;

    @Transactional
    public Proposta insert(byte[] img, Integer idCliente) {
        int t = img.length;
        if (t == 0) {
            throw new FileException("{img} não pode ser vazio");
        }
        ImageCPF ic = new ImageCPF();
        Proposta proposta = new Proposta();
        if (validaProposta(idCliente)) {
            ic.setCliente(service.find(idCliente));
            ic.setImagem(img);
            cpfRepository.save(ic);
            proposta.setCliente(ic.getCliente());
            proposta.setEndereco(enderecoService.findByClienteId(idCliente));
            proposta.setImageCPF(ic);
            proposta.setPropostaEnum(StatusPropostaEnum.ABERTO);
            propostaService.insert(proposta);
            return proposta;
        } else {
            throw new ValidaPropostaException("Proposta nao existe");
        }
    }

    public ImageCPF findById(Integer idCpf) {
        Optional<ImageCPF> obj = cpfRepository.findById(idCpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado: Id: " + idCpf +
                ", Tipo: " + ImageCPF.class.getName()));
    }

    public ImageCPF fromDTO(CPFDto dto) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.getIdCliente());
        return new ImageCPF(dto.getId(), dto.getImagcpf(), cliente, null);
    }

    public Boolean validaProposta(Integer idCliente) {
        Cliente cli = new Cliente();
        cli = service.find(idCliente);
        Endereco end = new Endereco();
        end = enderecoService.findByClienteId(idCliente);
        if (cli == null) {
            throw new UnprocessableException("Proposta com dados do Cliente invalido: " + Cliente.class.getName());
        }
        if (end == null) {
            throw new UnprocessableException("Proposta com Endereço invalido" + Endereco.class.getName() );
        }
        return true;
    }
}

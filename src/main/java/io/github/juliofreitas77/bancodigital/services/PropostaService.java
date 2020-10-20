package io.github.juliofreitas77.bancodigital.services;

import io.github.juliofreitas77.bancodigital.domain.Proposta;
import io.github.juliofreitas77.bancodigital.repositories.PropostaRepository;
import io.github.juliofreitas77.bancodigital.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository  propostaRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private UploadService uploadService;

    @Transactional
    public Proposta insert(Proposta obj){
        obj.setId(null);
        obj.setLast_update(new Date());
        obj = propostaRepository.save(obj);
        return obj;
    }

    public Proposta find(Integer id){
        Optional<Proposta> obj = propostaRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado: " + id
        + ", Tipo: " + Proposta.class.getName()));
    }

    public Proposta save(Proposta obj){
        return propostaRepository.save(obj);
    }

//    public Proposta find(Proposta obj){
//        Proposta proposta = new Proposta();
//        proposta.setId(obj.getId());
//        proposta.setCliente(obj.getCliente());
//        proposta.se
//        return proposta;
//    }
}

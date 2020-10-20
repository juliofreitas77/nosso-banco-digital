package io.github.juliofreitas77.bancodigital.services;

import io.github.juliofreitas77.bancodigital.domain.Cliente;
import io.github.juliofreitas77.bancodigital.domain.Endereco;
import io.github.juliofreitas77.bancodigital.dto.EnderecoNewDTO;
import io.github.juliofreitas77.bancodigital.services.exceptions.ObjectNotFoundException;
import io.github.juliofreitas77.bancodigital.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private ClienteService service;

    @Transactional
    public Endereco insert(Endereco obj) {
        obj.setId(null);
        obj = repository.save(obj);
        return obj;
    }

    public List<Endereco> findAll(){
        return repository.findAll();
    }

    public Endereco fromDTO(EnderecoNewDTO dto) {
        Endereco endereco = new Endereco(null, dto.getCep(), dto.getRua(), dto.getBairro(), dto.getComplemento(),
                dto.getCidade(), dto.getEstado(), service.find(dto.getIdCliente()));
        return endereco;
    }

    public Endereco find(Integer id) {
        Optional<Endereco> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto Nao encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

   public Endereco findByClienteId(Integer id){
        return repository.findByClienteId(id);
   }

//    public Endereco encontrarPeloIdCliente(Integer id){
//        return repository.encontrarPeloIdCliente(id);
//    }


}

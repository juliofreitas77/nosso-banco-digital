package io.github.juliofreitas77.bancodigital.resources;

import io.github.juliofreitas77.bancodigital.domain.Endereco;
import io.github.juliofreitas77.bancodigital.dto.EnderecoDTO;
import io.github.juliofreitas77.bancodigital.dto.EnderecoNewDTO;
import io.github.juliofreitas77.bancodigital.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Endereco endereco = service.find(id);
        return ResponseEntity.ok().body(endereco);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EnderecoDTO>> findAll(){
        List<Endereco> list  = service.findAll();
        List<EnderecoDTO> listDTO = list.stream().map(obj -> new EnderecoDTO(obj))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Void> insert(@Valid @RequestBody EnderecoNewDTO objDto){
        Endereco obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

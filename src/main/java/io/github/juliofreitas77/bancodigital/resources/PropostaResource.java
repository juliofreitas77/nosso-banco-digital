package io.github.juliofreitas77.bancodigital.resources;

import io.github.juliofreitas77.bancodigital.domain.Proposta;
import io.github.juliofreitas77.bancodigital.dto.PropostaDTO;
import io.github.juliofreitas77.bancodigital.enums.StatusPropostaEnum;
import io.github.juliofreitas77.bancodigital.services.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping(value = "upload/proposta")
public class PropostaResource {

    @Autowired
    private PropostaService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        Proposta proposta = service.find(id);
        return ResponseEntity.ok().body(proposta);
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody PropostaDTO objDto) throws IOException {
            Proposta proposta = service.find(objDto.getId());
            if (objDto.getPropostaAceite() == 1){
                proposta.setPropostaEnum(StatusPropostaEnum.APROVADO);
                service.save(proposta);
            }else{
                proposta.setPropostaEnum(StatusPropostaEnum.RECUSADO);
                service.save(proposta);
            }
        return ResponseEntity.noContent().build();
    }
}

package io.github.juliofreitas77.bancodigital.resources;

import io.github.juliofreitas77.bancodigital.domain.ImageCPF;
import io.github.juliofreitas77.bancodigital.domain.Proposta;
import io.github.juliofreitas77.bancodigital.services.ClienteService;
import io.github.juliofreitas77.bancodigital.services.EnderecoService;
import io.github.juliofreitas77.bancodigital.services.PropostaService;
import io.github.juliofreitas77.bancodigital.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

@RestController
@RequestMapping("/upload")
@Valid
public class UploadResource {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private ClienteService service;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        ImageCPF imageCPF = uploadService.findById(id);
        return ResponseEntity.ok().body(imageCPF);
    }

    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Void> upload(@RequestParam MultipartFile img, Integer idCliente) throws IOException {

        byte[] bytes = img.getBytes();
        InputStream stream = new ByteArrayInputStream(bytes);

        byte[] toArray = new byte[stream.available()];
        stream.read(toArray);

        Proposta obj = uploadService.insert(toArray, idCliente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/proposta/{id}")
                .buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
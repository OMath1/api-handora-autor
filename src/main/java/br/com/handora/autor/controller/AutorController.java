package br.com.handora.autor.controller;

import br.com.handora.autor.model.Autor;
import br.com.handora.autor.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

//    Para sua API REST:
//            6.1 Em caso de sucesso, a resposta de sua API devera retorna no cabeçalho a location do novo recurso criado, o STATUS HTTP 201 e o corpo devera ser vazio.
//            6.2 Em caso de falha, a resposta de sua API devera retorna o STATUS HTTP 400 e o corpo devera conter as mensagens amigaveis sobre os erros de validação

//localhost:8080/autores/2

    @GetMapping("/{id}")
    public ResponseEntity<Autor> consultar(@PathVariable Long id) {
        Autor autor = autorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(autor);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Autor> cadastrar (@RequestBody @Valid Autor autor, UriComponentsBuilder uriComponentsBuilder) {
        autorRepository.save(autor);

        URI uri = uriComponentsBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

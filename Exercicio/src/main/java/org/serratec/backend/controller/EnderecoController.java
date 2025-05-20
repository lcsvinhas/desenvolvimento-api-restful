package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Endereco;
import org.serratec.backend.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @PostMapping
    public Endereco inserir(@Valid @RequestBody Endereco endereco) {
        return repository.save(endereco);
    }
}

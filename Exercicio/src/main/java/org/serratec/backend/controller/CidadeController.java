package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Cidade;
import org.serratec.backend.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;

    @PostMapping
    public Cidade inserir(@Valid @RequestBody Cidade cidade) {
        return repository.save(cidade);
    }
}
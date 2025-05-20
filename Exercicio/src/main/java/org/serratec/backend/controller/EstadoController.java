package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Estado;
import org.serratec.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @PostMapping
    public Estado inserir(@Valid @RequestBody Estado estado) {
        return repository.save(estado);
    }
}

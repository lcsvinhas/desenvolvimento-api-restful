package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Cliente;
import org.serratec.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository Repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente inserir(@Valid @RequestBody Cliente cliente) {
        return Repository.save(cliente);
    }
}

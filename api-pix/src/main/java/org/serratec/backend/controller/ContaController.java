package org.serratec.backend.controller;

import org.serratec.backend.entity.Conta;
import org.serratec.backend.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService service;

    @GetMapping
    public ResponseEntity<List<Conta>> listarContas() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Conta> inserirConta(@RequestBody Conta conta) {
        return ResponseEntity.ok(service.inserir(conta));
    }
}

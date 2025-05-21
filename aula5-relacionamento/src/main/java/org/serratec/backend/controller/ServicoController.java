package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Servico;
import org.serratec.backend.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;

    @GetMapping
    public List<Servico> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> listarPorId(@PathVariable Long id) {
        Optional<Servico> servico = repository.findById(id);
        if (servico.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servico.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico inserir(@Valid @RequestBody Servico servico) {
        return repository.save(servico);
    }

    @PostMapping("/varios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Servico> inserir(@Valid @RequestBody List<Servico> servicos) {
        return repository.saveAll(servicos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(@PathVariable Long id, @Valid @RequestBody Servico servico) {
        if (repository.findById(id).isPresent()) {
            servico.setId(id);
            return ResponseEntity.ok(repository.save(servico));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

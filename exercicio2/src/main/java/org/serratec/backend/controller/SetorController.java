package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Setor;
import org.serratec.backend.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorRepository repository;

    @GetMapping
    public List<Setor> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Setor> listarPorId(@PathVariable Long id) {
        Optional<Setor> setores = repository.findById(id);
        if (setores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(setores.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Setor inserir(@Valid @RequestBody Setor setores) {
        return repository.save(setores);
    }

    @PostMapping("/varios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Setor> inserir(@Valid @RequestBody List<Setor> setores) {
        return repository.saveAll(setores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Setor> atualizar(@PathVariable Long id, @Valid @RequestBody Setor setores) {
        if (repository.findById(id).isPresent()) {
            setores.setId(id);
            return ResponseEntity.ok(repository.save(setores));
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

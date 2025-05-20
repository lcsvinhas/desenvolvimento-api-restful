package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Proprietario;
import org.serratec.backend.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @Autowired
    private ProprietarioRepository repository;

    @GetMapping
    public List<Proprietario> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proprietario> listarPorId(@PathVariable Long id) {
        Optional<Proprietario> proprietario = repository.findById(id);
        if (proprietario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(proprietario.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario inserir(@Valid @RequestBody Proprietario proprietario) {
        return repository.save(proprietario);
    }

    @PostMapping("/varios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Proprietario> inserir(@Valid @RequestBody List<Proprietario> proprietarios) {
        return repository.saveAll(proprietarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proprietario> atualizar(@PathVariable Long id, @Valid @RequestBody Proprietario proprietario) {
        if (repository.findById(id).isPresent()) {
            proprietario.setId(id);
            return ResponseEntity.ok(repository.save(proprietario));
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

package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Funcionario;
import org.serratec.backend.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping
    public List<Funcionario> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> listarPorId(@PathVariable Long id) {
        Optional<Funcionario> funcionario = repository.findById(id);
        if (funcionario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcionario.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario inserir(@Valid @RequestBody Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @PostMapping("/varios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Funcionario> inserir(@Valid @RequestBody List<Funcionario> funcionarios) {
        return repository.saveAll(funcionarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
        if (repository.findById(id).isPresent()) {
            funcionario.setId(id);
            return ResponseEntity.ok(repository.save(funcionario));
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

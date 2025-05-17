package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.entity.Veiculo;
import org.serratec.backend.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;

    @GetMapping
    public List<Veiculo> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> listarPorId(@PathVariable Long id) {
        Optional<Veiculo> veiculo = repository.findById(id);
        if (veiculo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(veiculo.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo inserir(@Valid @RequestBody Veiculo veiculo) {
        return repository.save(veiculo);
    }

    @PostMapping("/varios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Veiculo> inserir(@Valid @RequestBody List<Veiculo> veiculos) {
        return repository.saveAll(veiculos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @Valid @RequestBody Veiculo veiculo) {
        if (repository.findById(id).isPresent()) {
            veiculo.setId(id);
            return ResponseEntity.ok(repository.save(veiculo));
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

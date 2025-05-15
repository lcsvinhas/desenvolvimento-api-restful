package org.serratec.backend.controller;

import org.serratec.backend.entity.Produto;
import org.serratec.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> listarPorId(@PathVariable Long id) {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto inserir(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @PostMapping("/varios")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Produto> inserir(@RequestBody List<Produto> produtos) {
        return repository.saveAll(produtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        if (repository.findById(id).isPresent()) {
            produto.setId(id);
            return ResponseEntity.ok(repository.save(produto));
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

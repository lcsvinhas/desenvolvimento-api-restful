package org.serratec.backend.controller;

import org.serratec.backend.dto.UsuarioRequestDTO;
import org.serratec.backend.dto.UsuarioResponseDTO;
import org.serratec.backend.entity.Usuario;
import org.serratec.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
//        return ResponseEntity.ok(service.buscarPorId(id));
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDTO inserir(@RequestBody UsuarioRequestDTO usuario) {
        return service.inserir(usuario);
    }

//    @PostMapping("/lista")
//    @ResponseStatus(HttpStatus.CREATED)
//    public List<UsuarioResponseDTO> inserirLista(@RequestBody List<Usuario> lista) {
//        return service.inserirLista(lista);
//    }
//
//    @PutMapping("/atualizar/{id}")
//    public ResponseEntity<UsuarioResponseDTO> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
//        return ResponseEntity.ok(service.atualizar(id, usuario));
//    }
//
//    @DeleteMapping("/deletar/{id}")
//    public ResponseEntity<Void> deletar(@PathVariable Long id) {
//        service.deletar(id);
//        return ResponseEntity.noContent().build();
//    }
}

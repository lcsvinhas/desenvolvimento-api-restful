package org.serratec.backend.controller;

import org.serratec.backend.dto.ConsultaDTO;
import org.serratec.backend.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService service;

//    @PostMapping
//    public ResponseEntity<ConsultaDTO> inserir(@RequestBody Consulta consulta) {
//        return ResponseEntity.ok(service.inserir(consulta));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }
}

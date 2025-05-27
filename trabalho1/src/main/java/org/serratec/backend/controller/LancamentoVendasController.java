package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.service.LancamentoVendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/vendas")
public class LancamentoVendasController {

    @Autowired
    private LancamentoVendasService service;

    @GetMapping("/{id}")
    public ResponseEntity<LancamentoVendasResponseDTO> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LancamentoVendasResponseDTO inserirLancamento(@Valid @RequestBody LancamentoVendas lancamentoVendas) {
        return service.inserirLancamentoVenda(lancamentoVendas);
    }
}

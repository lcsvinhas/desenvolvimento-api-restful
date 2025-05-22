package org.serratec.backend.controller;

import org.serratec.backend.entity.Transacao;
import org.serratec.backend.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
    @Autowired
    private TransacaoService service;

    @PostMapping
    public Transacao realizarTransacao(@RequestParam Long idOrigem, @RequestParam Long idDestino, @RequestParam Double valor) {
        return service.realizarTransacao(idOrigem, idDestino, valor);
    }

    @GetMapping
    public List<Transacao> listarTransacoes(@RequestParam Long idOrigem) {
        return service.listarTransacoes(idOrigem);
    }


}

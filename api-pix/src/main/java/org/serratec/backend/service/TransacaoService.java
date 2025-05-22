package org.serratec.backend.service;

import org.serratec.backend.entity.Conta;
import org.serratec.backend.entity.Transacao;
import org.serratec.backend.exception.TransacaoException;
import org.serratec.backend.repository.ContaRepository;
import org.serratec.backend.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {
    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaRepository contaRepository;

    public Transacao realizarTransacao(Long idOrigem, Long idDestino, Double valor) {
        if (valor.equals(0.)) {
            throw new TransacaoException("Valor deve ser positivo!");
        }

        Optional<Conta> origem = contaRepository.findById(idDestino);
        if (origem.isEmpty()) {
            throw new TransacaoException("Conta origem não encontrada!");
        }

        Optional<Conta> destino = contaRepository.findById(idOrigem);
        if (destino.isEmpty()) {
            throw new TransacaoException("Conta destino não encontrada!");
        }

        Conta contaOrigem = origem.get();
        Conta contaDestino = destino.get();

        if (contaOrigem.getSaldo() < valor) {
            throw new TransacaoException("Saldo insuficiente!");
        }

        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
        contaRepository.save(contaOrigem);

        contaDestino.setSaldo(contaDestino.getSaldo() + valor);
        contaRepository.save(contaDestino);

        Transacao transacao = new Transacao();
        transacao.setOrigem(contaOrigem);
        transacao.setDestino(contaDestino);
        transacao.setValor(valor);
        transacao.setHorario(LocalDateTime.now());

        return transacaoRepository.save(transacao);
    }

    public List<Transacao> listarTransacoes(Long id) {
        return transacaoRepository.findByOrigemIdOrDestinoId(id, id);
    }
}

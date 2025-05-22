package org.serratec.backend.service;

import org.serratec.backend.entity.Conta;
import org.serratec.backend.exception.ContaException;
import org.serratec.backend.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
    @Autowired
    private ContaRepository repository;

    public Conta inserir(Conta conta) {
        Optional<Conta> c = repository.findByNumeroConta(conta.getNumeroConta());
        if (c.isPresent()) {
            throw new ContaException("Conta já existe!");
        }
        return repository.save(conta);
    }

    public List<Conta> listar() {
        return repository.findAll();
    }

    public Conta listarPorId(Long id) {
        for (Conta conta : repository.findAll()) {
            if (conta.getId().equals(id)) {
                return conta;
            }
        }
        throw new ContaException("Conta não encontrada!");
    }
}

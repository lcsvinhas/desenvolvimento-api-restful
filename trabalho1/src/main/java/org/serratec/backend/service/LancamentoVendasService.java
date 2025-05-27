package org.serratec.backend.service;

import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.entity.Vendedor;
import org.serratec.backend.exception.LancamentoVendasException;
import org.serratec.backend.repository.LancamentoVendasRepository;
import org.serratec.backend.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoVendasService {
    @Autowired
    private LancamentoVendasRepository repository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public LancamentoVendasResponseDTO inserirLancamentoVenda(LancamentoVendas lancamentoVenda) {
        Optional<LancamentoVendas> l = repository.findByCodigoVenda(lancamentoVenda.getCodigoVenda());
        if (l.isPresent()) {
            throw new LancamentoVendasException("Venda já lançada!");
        }

        Vendedor vendedor = null;
        Long codigo = lancamentoVenda.getVendedor().getCodigoVendedor();
        Optional<Vendedor> v = vendedorRepository.findById(codigo);
        if (v.isPresent()) {
            vendedor = v.get();
        } else {
            throw new LancamentoVendasException("Vendedor não encontrado");
        }
        lancamentoVenda.setVendedor(vendedor);
        LancamentoVendas lancamentoVendas = repository.save(lancamentoVenda);
        return new LancamentoVendasResponseDTO(lancamentoVendas.getDataVenda(), lancamentoVendas.getValorVenda(), lancamentoVendas.getVendedor().getNome());
    }

    public LancamentoVendasResponseDTO listarPorId(Long codigoVenda) {
        Optional<LancamentoVendas> l = repository.findByCodigoVenda(codigoVenda);
        if (l.isEmpty()) {
            throw new LancamentoVendasException("Venda inexistente!");
        }
        LancamentoVendas lancamentoVendas = l.get();
        return new LancamentoVendasResponseDTO(lancamentoVendas.getDataVenda(), lancamentoVendas.getValorVenda(), lancamentoVendas.getVendedor().getNome());
    }
}

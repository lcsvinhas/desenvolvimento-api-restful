package org.serratec.backend.dto;

import org.serratec.backend.entity.Vendedor;

import java.time.LocalDate;

public record LancamentoVendasResponseDTO(LocalDate dataVenda, Double valorVenda, String nomeVendedor) {
}

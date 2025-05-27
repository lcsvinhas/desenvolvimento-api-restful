package org.serratec.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
public class LancamentoVendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoVenda;
    @PastOrPresent
    private LocalDate dataVenda;
    private Double valorVenda;

    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    @JsonBackReference
    private Vendedor vendedor;

    public Long getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(Long codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}

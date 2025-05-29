package org.serratec.backend.dto;

import org.serratec.backend.entity.Procedimentos;

import java.io.Serializable;

public class ProcedimentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tipoExame;
    private Integer quantidade;
    private Double valorProcedimento;
    private Double subtotal = 0.0;

    public ProcedimentoDTO() {
    }

    public ProcedimentoDTO(Procedimentos procedimento) {
        this.tipoExame = procedimento.getExame().getTipo();
        this.quantidade = procedimento.getQuantidade();
        this.valorProcedimento = procedimento.getValorProcedimento();
        this.subtotal = procedimento.getSubTotal();
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorProcedimento() {
        return valorProcedimento;
    }

    public void setValorProcedimento(Double valorProcedimento) {
        this.valorProcedimento = valorProcedimento;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}

package org.serratec.backend.entity;

import jakarta.persistence.*;

@Entity
public class Procedimentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    private Double valorProcedimento;

    @ManyToOne
    @JoinColumn(name = "id_consulta")
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "id_exame")
    private Exame exame;

    @Transient
    private Double subTotal = 0.0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Double getSubTotal() {
        subTotal = quantidade * valorProcedimento;
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}

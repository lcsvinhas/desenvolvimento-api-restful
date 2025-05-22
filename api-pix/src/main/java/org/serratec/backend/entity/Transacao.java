package org.serratec.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_origem")
    private Conta origem;
    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Conta destino;
    @NotNull
    private Double valor;
    @NotNull
    private LocalDateTime horario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getOrigem() {
        return origem;
    }

    public void setOrigem(Conta origem) {
        this.origem = origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public void setDestino(Conta destino) {
        this.destino = destino;
    }

    public @NotNull Double getValor() {
        return valor;
    }

    public void setValor(@NotNull Double valor) {
        this.valor = valor;
    }

    public @NotNull LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(@NotNull LocalDateTime horario) {
        this.horario = horario;
    }
}

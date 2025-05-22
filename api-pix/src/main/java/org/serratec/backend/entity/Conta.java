package org.serratec.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String numeroConta;
    @NotBlank
    private String nomeTitular;
    @NotBlank
    private String cpf;
    @NotNull
    private Double saldo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(@NotBlank String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public @NotBlank String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(@NotBlank String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank String cpf) {
        this.cpf = cpf;
    }

    public @NotNull Double getSaldo() {
        return saldo;
    }

    public void setSaldo(@NotNull Double saldo) {
        this.saldo = saldo;
    }
}

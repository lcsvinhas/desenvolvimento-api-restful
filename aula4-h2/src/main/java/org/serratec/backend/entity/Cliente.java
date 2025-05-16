package org.serratec.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "nome não pode ser nulo ou vazio")
    @Size(min = 3, max = 60, message = "tamanho de caracteres incorreto para o nome")
    private String nome;

    @Email(message = "email no formato incorreto")
    private String email;

    @CPF(message = "cpf inválido")
    private String cpf;

    @PastOrPresent(message = "impossível ter nascido no futuro")
    private LocalDate dataNascimento;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

package org.serratec.backend.entity;

import jakarta.persistence.*;

@Entity
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] dados;
    private String tipo;
    private String nome;

    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    public Foto() {
    }

    public Foto(Long id, byte[] dados, String tipo, String nome, Funcionario funcionario) {
        this.id = id;
        this.dados = dados;
        this.tipo = tipo;
        this.nome = nome;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getDados() {
        return dados;
    }

    public void setDados(byte[] dados) {
        this.dados = dados;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}

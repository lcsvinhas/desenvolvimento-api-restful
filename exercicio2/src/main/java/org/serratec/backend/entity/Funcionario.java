package org.serratec.backend.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo_funcionario"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Gerente.class, name = "g"),
        @JsonSubTypes.Type(value = Diretor.class, name = "d")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_funcionario", discriminatorType = DiscriminatorType.STRING)
public abstract class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String nome;
    protected String cpf;
    protected Double salario;
    protected String turno;

    @ManyToOne
    @JoinColumn(name = "id_setor")
    protected Setor setor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}

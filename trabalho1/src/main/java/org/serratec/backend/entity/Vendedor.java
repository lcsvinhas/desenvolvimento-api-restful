package org.serratec.backend.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo_vendedor"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = VendedorAutonomo.class, name = "va"),
        @JsonSubTypes.Type(value = VendedorEmpresa.class, name = "ve")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_vendedor", discriminatorType = DiscriminatorType.STRING)
public abstract class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long codigoVendedor;
    @NotBlank
    protected String nome;
    @Email
    protected String email;
    @DecimalMin("1518.")
    protected Double salario;

    public Long getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Long codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}

package org.serratec.backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("d")
public class Diretor extends Funcionario {
    private String nivelHierarquico;

    public String getNivelHierarquico() {
        return nivelHierarquico;
    }

    public void setNivelHierarquico(String nivelHierarquico) {
        this.nivelHierarquico = nivelHierarquico;
    }
}

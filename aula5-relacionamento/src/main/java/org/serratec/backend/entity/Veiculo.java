package org.serratec.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 7, max = 7, message = "Placa inválida")
    private String placa;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @Embedded
    private Caracteristica caracteristica;

    @OneToOne
    @JoinColumn(name = "id_proprietario")
    private Proprietario proprietario;

    @JsonManagedReference
    @OneToMany(mappedBy = "veiculo")
    private List<Manutencao> manutencoes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @Size(min = 7, max = 7, message = "Placa inválida") String getPlaca() {
        return placa;
    }

    public void setPlaca(@Size(min = 7, max = 7, message = "Placa inválida") String placa) {
        this.placa = placa;
    }

    public @NotBlank String getMarca() {
        return marca;
    }

    public void setMarca(@NotBlank String marca) {
        this.marca = marca;
    }

    public @NotBlank String getModelo() {
        return modelo;
    }

    public void setModelo(@NotBlank String modelo) {
        this.modelo = modelo;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public List<Manutencao> getManutencoes() {
        return manutencoes;
    }
}

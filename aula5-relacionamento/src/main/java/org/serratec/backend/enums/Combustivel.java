package org.serratec.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.serratec.backend.exception.EnumException;

public enum Combustivel {
    DIESEL(1, "Diesel"), FLEX(2, "Flex"), GASOLINA(3, "Gasolina");

    private Integer codigo;
    private String tipo;

    Combustivel(Integer codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    @JsonCreator
    public static Combustivel verificarCategoria(Integer valor){
        for(Combustivel combustivel : Combustivel.values()){
            if(valor.equals(combustivel.codigo)){
                return combustivel;
            }
        }
        throw new EnumException("Combustível de carro inválida");
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

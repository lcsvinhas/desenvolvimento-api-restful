package org.serratec.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.serratec.backend.exception.EnumException;

public enum Categoria {
    SUV, HATCH, PICAPE, SEDAN, CONVERSIVEL, COUPE;

    @JsonCreator
    public static Categoria verificarCategoria(String valor){
        for(Categoria categoria : Categoria.values()){
            if(valor.equals(categoria.name())){
                return categoria;
            }
        }
        throw new EnumException("Categoria de carro inválida");
    }

}

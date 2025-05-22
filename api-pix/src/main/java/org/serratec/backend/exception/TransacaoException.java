package org.serratec.backend.exception;

public class TransacaoException extends RuntimeException {
    public TransacaoException(String mensagem) {
        super(mensagem);
    }
}

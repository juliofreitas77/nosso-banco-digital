package io.github.juliofreitas77.bancodigital.services.exceptions;

public class ValidaPropostaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ValidaPropostaException(String message) {
        super(message);
    }

    public ValidaPropostaException(String message, Throwable cause) {
        super(message, cause);
    }
}

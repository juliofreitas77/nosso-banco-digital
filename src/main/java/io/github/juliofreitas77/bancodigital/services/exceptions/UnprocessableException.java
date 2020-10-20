package io.github.juliofreitas77.bancodigital.services.exceptions;

public class UnprocessableException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UnprocessableException(String msg) {
        super(msg);
    }

    public UnprocessableException(String msg, Throwable cause) {
        super(msg,cause);
    }


}

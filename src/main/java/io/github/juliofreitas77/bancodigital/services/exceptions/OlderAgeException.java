package io.github.juliofreitas77.bancodigital.services.exceptions;

public class OlderAgeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public OlderAgeException(String msg) {
        super(msg);
    }
    public OlderAgeException(String msg, Throwable cause) {
        super(msg,cause);
    }
}

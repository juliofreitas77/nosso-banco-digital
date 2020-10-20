package io.github.juliofreitas77.bancodigital.services.exceptions;

public class ClienteDuplicadoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ClienteDuplicadoException(String msg){
        super(msg);
    }
    
    public  ClienteDuplicadoException(String msg, Throwable cause) {
        super(msg,cause);
    }
}

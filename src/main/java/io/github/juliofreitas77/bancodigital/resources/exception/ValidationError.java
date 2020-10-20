package io.github.juliofreitas77.bancodigital.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StantardError {
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Long timeStamp, Integer status, String error, String message, String path) {
        super(timeStamp, status, error, message, path);
    }

    public List<FieldMessage> getErros() {
        return errors;
    }

    public void addError(String fieldName, String message ) {
        errors.add(new FieldMessage(fieldName, message));
    }
}

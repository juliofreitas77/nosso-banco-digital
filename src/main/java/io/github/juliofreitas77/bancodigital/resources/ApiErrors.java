package io.github.juliofreitas77.bancodigital.resources;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    public List<String> getErrors() {
        return errors;
    }

    private List<String> errors;

    public ApiErrors(String mensagemErro){
        this.errors = Arrays.asList(mensagemErro);
    }


}

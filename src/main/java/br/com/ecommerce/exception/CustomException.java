package br.com.ecommerce.exception;

import br.com.ecommerce.response.Error;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class CustomException extends RuntimeException {

    public Error error;

    public CustomException(String type, String message) {
        List<String> listDescription = new ArrayList();
        listDescription.add(message);
        error = new Error(HttpStatus.NOT_FOUND.toString(), type, listDescription);
    }

}

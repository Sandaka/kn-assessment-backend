package com.kuehnenagel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 8/10/22
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ContactNotFoundException(String message) {
        super(message);
    }
}

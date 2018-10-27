package com.shvg.spring.springboot.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContactInfoNotFoundException extends RuntimeException {

    public ContactInfoNotFoundException(String s) {
        super(s);
    }
}

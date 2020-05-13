package com.mind.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidNumberFoundException extends Exception{

    private static final long serialVersionUID = 1L;
  
    public InvalidNumberFoundException(String message){
        super("Invalid Number");
    }
}
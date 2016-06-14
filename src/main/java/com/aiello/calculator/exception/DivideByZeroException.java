package com.aiello.calculator.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="num2 is zero - cannot divide by a value of zero")
public class DivideByZeroException extends RuntimeException {

    /**
     * Unique ID for Serialized object
     */
    private static final long serialVersionUID = 3620199505147655172L;

    public DivideByZeroException(String message) {
        super(message);
    }
}

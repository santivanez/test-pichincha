package com.prueba.pichincha.exception;

public class MovementException extends Exception {

    public MovementException(ErrorMessage s) {
        super(s.getMessage());
    }

}

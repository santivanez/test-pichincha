package com.prueba.pichincha.exception;

public class ClientException extends Exception{

    public ClientException(ErrorMessage s) {
        super(s.getMessage());
    }

}

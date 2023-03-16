package com.prueba.pichincha.exception;

public enum ErrorMessage {

    ACCOUNT_NOT_EXISTS("Cuenta no existente"),
    CLIENT_NOT_EXISTS("Cliente no existe"),
    CLIENT_DUPLICATED("Cliente ya existente");


    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

package com.prueba.pichincha.exception;

public class AccountException extends Exception {

    public AccountException(ErrorMessage s) {
        super(s.getMessage());
    }

}

package com.prueba.pichincha.service;

import com.prueba.pichincha.controller.request.AccountRequest;
import com.prueba.pichincha.exception.AccountException;

public interface AccountService {

    public void addAcount(AccountRequest inputForm) throws AccountException;

}

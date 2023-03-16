package com.prueba.pichincha.controller;

import com.prueba.pichincha.controller.request.AccountRequest;
import com.prueba.pichincha.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.prueba.pichincha.controller.messages.GeneralAPIMessages.ADD_ACCOUNT_SUCCESS;

@RestController
@RequestMapping(value = "/cuentas")
public class AccountsController {

    AccountServiceImpl accountServiceImpl;

    @Autowired
    public AccountsController(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;
    }

    @PostMapping(value = "/nueva-cuenta")
    public ResponseEntity addAccount(@RequestBody AccountRequest inputForm) {
        try {
            accountServiceImpl.addAcount(inputForm);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ADD_ACCOUNT_SUCCESS);
        } catch (com.prueba.pichincha.exception.AccountException e) {
            throw new RuntimeException(e);
        }

    }

    @PutMapping
    public ResponseEntity<Object> updateAccount(@RequestBody AccountRequest updatedForm,
                                                @PathVariable Long id) {
        accountServiceImpl.updateAccount(updatedForm, id);
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountServiceImpl.deleteAccount(id);
    }

}

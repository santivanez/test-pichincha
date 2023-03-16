package com.prueba.pichincha.controller;

import com.prueba.pichincha.controller.request.ClientRequest;
import com.prueba.pichincha.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClientsController {

    ClientServiceImpl clientServiceImpl;

    @Autowired
    public ClientsController(ClientServiceImpl clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }

    @PostMapping(value = "/nuevo-cliente")
    public void createUser(@RequestBody ClientRequest input) {
        clientServiceImpl.createUser(input);
    }

}

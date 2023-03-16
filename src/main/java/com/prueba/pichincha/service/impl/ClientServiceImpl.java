package com.prueba.pichincha.service.impl;

import com.prueba.pichincha.controller.request.ClientRequest;
import com.prueba.pichincha.entity.Client;
import com.prueba.pichincha.entity.Person;
import com.prueba.pichincha.repository.ClientRepository;
import com.prueba.pichincha.repository.PersonRepository;
import com.prueba.pichincha.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;
    PersonRepository personRepository;

    public ClientServiceImpl(ClientRepository clientRepository,
                             PersonRepository personRepository) {
        this.clientRepository = clientRepository;
        this.personRepository = personRepository;
    }

    public void createUser(ClientRequest input) {
        Person person = Person.builder()
                .name(input.getName().toUpperCase())
                .address(input.getAddress().toUpperCase())
                .phone(input.getPhone())
                .build();
        Client client = Client.builder()
                .status(input.isStatus())
                .password(input.getPassword())
                .personId(person)
                .build();
        personRepository.save(person);
        clientRepository.save(client);
    }
}

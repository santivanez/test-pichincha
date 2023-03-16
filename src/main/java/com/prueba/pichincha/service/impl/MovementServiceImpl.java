package com.prueba.pichincha.service.impl;

import com.prueba.pichincha.controller.request.MovementRequest;
import com.prueba.pichincha.entity.Account;
import com.prueba.pichincha.entity.Client;
import com.prueba.pichincha.entity.Movement;
import com.prueba.pichincha.entity.Person;
import com.prueba.pichincha.exception.MovementException;
import com.prueba.pichincha.repository.AccountRepository;
import com.prueba.pichincha.repository.ClientRepository;
import com.prueba.pichincha.repository.MovementRepository;
import com.prueba.pichincha.repository.PersonRepository;
import com.prueba.pichincha.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

import static com.prueba.pichincha.exception.ErrorMessage.ACCOUNT_NOT_EXISTS;
import static com.prueba.pichincha.exception.ErrorMessage.CLIENT_NOT_EXISTS;

@Service
public class MovementServiceImpl implements MovementService {

    MovementRepository movementRepository;
    ClientRepository clientRepository;
    PersonRepository personRepository;
    AccountRepository accountRepository;

    @Autowired
    public MovementServiceImpl(MovementRepository movementRepository,
                               ClientRepository clientRepository,
                               PersonRepository personRepository,
                               AccountRepository accountRepository) {
        this.movementRepository = movementRepository;
        this.clientRepository = clientRepository;
        this.personRepository = personRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void processMovement(MovementRequest movementRequest) throws MovementException {
        Optional<Client> optionalClient = clientRepository.findClientByPersonName(movementRequest.getClientName());
        Optional<Account> optionalAccount = accountRepository.findByNumberAccount(movementRequest.getNumberAccount());
        if (optionalClient.isEmpty()) {
            throw new MovementException(CLIENT_NOT_EXISTS);
        } else if (optionalAccount.isEmpty()) {
            throw new MovementException(ACCOUNT_NOT_EXISTS);
        } else {
            Client client = optionalClient.get();
            Account account = optionalAccount.get();

            double newBalance = Double.sum(account.getInitialBalance(), movementRequest.getAmount());
            Movement movement = Movement.builder()
                    .value(movementRequest.getAmount())
                    .date(new Date())
                    .balance(newBalance)
                    .build();
            account.setInitialBalance(newBalance);

            accountRepository.save(account);
            movementRepository.save(movement);
        }
    }

    @Override
    public void findUserMovementByDate(String clientName, String initDate, String endDate) {
        Optional<Person> optionalPerson = personRepository.findByName(clientName);

    }
}

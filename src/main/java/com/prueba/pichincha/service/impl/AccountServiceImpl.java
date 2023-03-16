package com.prueba.pichincha.service.impl;

import com.prueba.pichincha.controller.request.AccountRequest;
import com.prueba.pichincha.entity.Account;
import com.prueba.pichincha.entity.Person;
import com.prueba.pichincha.exception.AccountException;
import com.prueba.pichincha.repository.AccountRepository;
import com.prueba.pichincha.repository.ClientRepository;
import com.prueba.pichincha.repository.PersonRepository;
import com.prueba.pichincha.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.prueba.pichincha.exception.ErrorMessage.CLIENT_DUPLICATED;

@Service
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;
    ClientRepository clientRepository;
    PersonRepository personRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,
                              ClientRepository clientRepository,
                              PersonRepository personRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.personRepository = personRepository;
    }

    public void addAcount(AccountRequest accountRequest) throws AccountException {
        Optional<Person> optionalPerson = personRepository.findByName(accountRequest.getClientName().toUpperCase());
        if (optionalPerson.isEmpty()) {
            throw new AccountException(CLIENT_DUPLICATED);
        } else {
            Person person = optionalPerson.get();
            Account account = Account.builder()
                    .numberAccount(accountRequest.getNumberAccount())
                    .status(Boolean.TRUE)
                    .type(accountRequest.getType())
                    .initialBalance(accountRequest.getInitialBalance())
                    .client(person.getClient())
                    .build();

            accountRepository.save(account);
        }
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public void updateAccount(AccountRequest updatedForm, Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        else {
            //
        }
    }
}

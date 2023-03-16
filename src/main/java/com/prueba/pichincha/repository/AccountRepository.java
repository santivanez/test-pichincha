package com.prueba.pichincha.repository;

import com.prueba.pichincha.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByNumberAccount(String numberAccount);

}

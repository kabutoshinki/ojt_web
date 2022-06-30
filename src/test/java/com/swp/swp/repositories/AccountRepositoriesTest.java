package com.swp.swp.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swp.swp.model.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoriesTest {
    @Autowired private AccountRepositories accountRepositories;
    @Test
    void testFindByEmail() {
        Iterable<Account> accountList = accountRepositories.findAll();
        for (Account account2 : accountList) {
            assertNotNull(accountRepositories.findByEmail(account2.getEmail()));
        }
       
    }

    @Test
    void testFindById() {
        Iterable<Account> accountList = accountRepositories.findAll();
        for (Account account : accountList) {
            assertNotNull(accountRepositories.findById(account.getId()));
        }
    }
}

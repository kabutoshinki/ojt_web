package com.swp.swp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swp.swp.model.Account;
import com.swp.swp.repositories.AccountRepositories;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
    @Autowired private AccountService accountService;
    @Autowired private AccountRepositories accountRepositories;
    @Test
    void testCheckRole() {
    }

    @Test
    void testFindByRole() {
        Iterable<Account> list = accountRepositories.findAll();
        for (Account account : list) {
            assertNotNull(accountService.findByRole(account.getRole()));
        }

    }

    @Test
    void testGetAll() {
        ArrayList<Account> expected = (ArrayList<Account>) accountRepositories.findAll();
        ArrayList<Account> actual = (ArrayList<Account>) accountService.findAll();
        assertEquals(expected.size(), actual.size());
    }

    @Test
    void testGetById() {
        Iterable<Account> list = accountRepositories.findAll();
        System.out.println("Account: " + list.iterator().toString());
        for (Account account : list) {
            Account expected = accountRepositories.findById(account.getId());
            Account actual = accountService.findById(account.getId());
            assertEquals(expected.getFullName(), actual.getFullName());
        }
        
    }

    @Test
    void testGetByString() {
        Iterable<Account> list = accountRepositories.findAll();
        for (Account account : list) {
            Account expected = accountRepositories.findByEmail(account.getEmail());
            Account actual = accountService.getByString(account.getEmail());
            assertEquals(expected.getFullName(), actual.getFullName());
        }
    }


    @Test
    void testInsertInfor() {
        String email ="danghuudat163@gmail.com";
        String phone = "test";
        String avatar = "test";
        String address =  "test";
        Date date = new Date(2021, 1, 12);
        String fullName = "test";
        assertTrue(accountService.insertInfor(email, fullName, address, date, phone, avatar));

    }

    @Test
    void testIsExist() {
        Iterable <Account> accountList = accountRepositories.findAll();
        for (Account account : accountList) {
            
            assertTrue(accountService.isExist(account.getEmail()));
        }
    }

    @Test
    void testUpdateStatus() {

    }

    @Test
    void testInsertAccount() {
        Account account = new Account("fullName", "email", "role");
        assertTrue(accountService.save(account));
    }
}

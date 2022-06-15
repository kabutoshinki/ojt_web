package com.swp.swp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.swp.model.Account;
import com.swp.swp.repositories.AccountRepositories;

@Service
public class AccountService implements AccountServiceInterface, CRUDInterface<Account> {
    @Autowired
    private AccountRepositories accountRepositories;

    public AccountService(AccountRepositories accountRepositories) {
        this.accountRepositories = accountRepositories;
    }


    @Override
    public boolean updateStatus(int id, String status) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<Account> getAll() {
        Iterable<Account> accountList = accountRepositories.findAll();
        return accountList;
    }

    @Override
    public Account getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isExist(String value) {
        if (accountRepositories.findByEmail(value) != null)
            return true;
        else
            return false;
    }

}

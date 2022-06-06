package com.swp.swp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.swp.repositories.AccountRepositories;

@Service
public class AccountService implements AccountServiceInterface {
    @Autowired
    private AccountRepositories accountRepositories;
    
    public AccountService(AccountRepositories accountRepositories) {
        this.accountRepositories = accountRepositories;
    }

    @Override
    public boolean isEmailExist(String email) {
        if(accountRepositories.findByEmail(email)!=null)
            return true;
        else
            return false;
    }
    
}

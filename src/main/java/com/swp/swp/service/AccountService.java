package com.swp.swp.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.swp.model.Account;
import com.swp.swp.repositories.AccountRepositories;

@Service
public class AccountService {
    @Autowired
    private AccountRepositories accountRepositories;

    public AccountService(AccountRepositories accountRepositories) {
        this.accountRepositories = accountRepositories;
    }

    public boolean checkRole( String role, HttpServletRequest request){
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        Account account = accountRepositories.findByEmail(email);
        
        if(account.getRole().equals(role))
            return true;
        else
            return false;
    }

    public boolean insertInfor(String email, String fullName, String address, Date dob, String phone, String avatar){
        try {
            Account account = getByString(email);
            account.setAddress(address);
            /*account.setDateOfBirth(dob);*/
            account.setFullName(fullName);
            account.setPhone(phone);
            /*account.setAvatar(avatar);*/
            accountRepositories.save(account);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean insertAccount(Account newAccount) {
        try {
            accountRepositories.save(newAccount);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateStatus(int id, String status) {
        // TODO Auto-generated method stub
        return false;
    }

    public Iterable<Account> getAll() {
        Iterable<Account> accountList = accountRepositories.findAll();
        return accountList;
    }

    public Account getById(int id) {
        Account account = accountRepositories.findById(id);
        return account;
    }

    public boolean isExist(String value) {
        if (accountRepositories.findByEmail(value) != null)
            return true;
        else
            return false;
    }


    public Account getByString(String value) {
        //System.out.println(value);
        Account account = accountRepositories.findByEmail(value);
        return account;
    }

    public Iterable<Account> findByRole(String role) {
        Iterable<Account> accountList = accountRepositories.findAll();
        List<Account> a = new ArrayList<>();
        for (Account x: accountList) {
            /*if (x.getRole().equalsIgnoreCase(role)) {
                a.add(x);
            }*/
        }
        accountList = a;

        return accountList;
    }
}

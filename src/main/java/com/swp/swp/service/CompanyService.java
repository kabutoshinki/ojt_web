package com.swp.swp.service;

import com.swp.swp.database.Database;
import com.swp.swp.model.Account;
import com.swp.swp.model.Company;
import com.swp.swp.model.Student;
import com.swp.swp.repositories.AccountRepositories;
import com.swp.swp.repositories.CompanyRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Autowired
    private CompanyRepositories companyRepositories;

    public boolean save(Company newCompany) {
        try {
            logger.info("insert Data: " +  companyRepositories.save(newCompany));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Iterable<Company> getAll() {
        Iterable<Company> companyList = companyRepositories.findAll();
        return companyList;
    }

    public Company findById(int id) {
        Company company = companyRepositories.findById(id);
        return company;
    }

    public Company findByAccount(Account account) {
        return companyRepositories.findByAccount(account);
    }
}

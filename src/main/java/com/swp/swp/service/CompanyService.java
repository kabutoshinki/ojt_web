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
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Autowired
    private CompanyRepositories companyRepositories;

    public boolean save(Company newCompany) {
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\companies");
        try {
            logger.info("insert Data: " +  companyRepositories.save(newCompany));
            logger.info("ID " + newCompany.getId());
            System.out.println(newCompany.getId());
            File file = new File(currentWorkingDir + "\\" + newCompany.getId());
            //if (!file.exists()){
                file.mkdirs();
            //}
            /*file.createNewFile();*/
            System.out.println(file.exists());
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

    public Iterable<Company> getAvailable() {
        Iterable<Company> companyList = companyRepositories.findAll();
        ArrayList <Company> temp = new ArrayList<>();
        for (Company x: companyList) {
            if (x.getAccount().getStatus() == null || x.getAccount().getStatus().equalsIgnoreCase("Disable") == false)
                temp.add(x);
        }
        return temp;
    }

    public Company findById(int id) {
        Company company = companyRepositories.findById(id);
        return company;
    }

    public Company findByAccount(Account account) {
        return companyRepositories.findByAccount(account);
    }
}

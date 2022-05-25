/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swp.swp.database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.swp.swp.model.Account;
import com.swp.swp.model.CompanyDetail;
import com.swp.swp.repositories.AccountRepositories;
import com.swp.swp.repositories.CompanyDetailRepositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ADMIN
 */
@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(AccountRepositories accountRepositories, CompanyDetailRepositories companyDetailRepositories){
        
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Account accountA = new Account("test","test");
                Account accountB = new Account("test1","test1@gmail.com");
                CompanyDetail company1 = new CompanyDetail(10,"FPT SOFTWARE",
                "DESRIPTION", "ADRESS","IMG URL",
                "JOB DESCRIPTION","JOB REQUIREMENTS");
                CompanyDetail company2 = new CompanyDetail(10,"FPT SOFTWARE2",
                "DESRIPTION2", "ADRESS2","IMG URL2",
                "JOB DESCRIPTION2","JOB REQUIREMENTS2");
                logger.info("insert Data: " + accountRepositories.save(accountB));
                logger.info("insert Data: " + accountRepositories.save(accountA));
                logger.info("insert Data: " + companyDetailRepositories.save(company1));
                logger.info("insert Data: " + companyDetailRepositories.save(company2));
            }
      
        };
    }
}


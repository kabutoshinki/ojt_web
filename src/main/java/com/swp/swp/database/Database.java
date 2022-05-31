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
import com.swp.swp.model.Job;
import com.swp.swp.repositories.AccountRepositories;
import com.swp.swp.repositories.CompanyDetailRepositories;
import com.swp.swp.repositories.JobRepositories;

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
    CommandLineRunner initDatabase(AccountRepositories accountRepositories, 
    CompanyDetailRepositories companyDetailRepositories, JobRepositories jobRepositories){
        
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Account accountA = new Account("test","test");
                Account accountB = new Account("test1","test1@gmail.com");
                CompanyDetail company1 = new CompanyDetail("FPT SOFTWARE",
                "Information Technology & Services  10,001+ employees  377 on LinkedIn\n"+
                "Established since 1999, a leading IT Service provider in Southeast Asia with 52 offices in 18 countries and 700+ customers worldwide.", 
                "Đường D1, Đ. D1, Phường Tân Phú, Quận 9, Thành phố Hồ Chí Minh");
                CompanyDetail company2 = new CompanyDetail("FPT SOFTWARE2",
                "Information Technology & Services  10,001+ employees  377 on LinkedIn\n"+
                "Established since 1999, a leading IT Service provider in Southeast Asia with 52 offices in 18 countries and 700+ customers worldwide.", 
                "Đường D1, Đ. D1, Phường Tân Phú, Quận 9, Thành phố Hồ Chí Minh");
                Job job1 = new Job(company1);
                Job job2 = new Job(10, "Clarify requirements, initiative solutions and develop deliverable software in the iterations of Scrum\n"
                +"Participate in building and developing system architecture\n" +
                "Create technical documents such as: system architecture, high level design\n"+
                "Developing new features/product improvements\n"+
                "Research and solve difficult technical issues\n"
                , "Strong understanding of WebRTC\n"+
                "2 years Experienced in developing web apps with ReactJS, NodeJS\n"+
                "Experience in building and deploying applications on the cloud (AWS)\n"+
                "Have in-depth knowledge of Object Oriented Design and Data Structures\n"+
                "Knowledge of infra, networking", 1, company2);
                logger.info("insert Data: " + accountRepositories.save(accountB));
                logger.info("insert Data: " + accountRepositories.save(accountA));
                logger.info("insert Data: " + companyDetailRepositories.save(company1));
                logger.info("insert Data: " + companyDetailRepositories.save(company2));
                logger.info("insert Data: "+ jobRepositories.save(job1));
                logger.info("insert Data: "+ jobRepositories.save(job2));
                
            }
      
        };
    }
}


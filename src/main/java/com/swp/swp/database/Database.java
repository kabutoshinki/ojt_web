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
import com.swp.swp.model.CV;
import com.swp.swp.model.Company;
import com.swp.swp.model.Job;
import com.swp.swp.model.Major;
import com.swp.swp.model.OjtProcess;
import com.swp.swp.model.Position;
import com.swp.swp.model.StudentApplyJobs;
import com.swp.swp.repositories.AccountRepositories;
import com.swp.swp.repositories.CVRepositories;
import com.swp.swp.repositories.CompanyRepositories;
import com.swp.swp.repositories.JobRepositories;
import com.swp.swp.repositories.MajorRepositories;
import com.swp.swp.repositories.OjtProcessRepositories;
import com.swp.swp.repositories.PositionRepositories;
import com.swp.swp.repositories.StudentApplyJobsRepositories;

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
    CompanyRepositories companyRepositories,
     JobRepositories jobRepositories, 
     CVRepositories cvRepositories,
     MajorRepositories majorRepositories,
     PositionRepositories positionRepositories,
     StudentApplyJobsRepositories studentApplyJobsRepositories,
     OjtProcessRepositories ojtProcessRepositories){
        
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Account accountA = new Account("FPT SOFTWARE","danghuudat163@gmail.com","COMPANY");
<<<<<<< HEAD
                Account accountB = new Account("FPT SOFTWARE2","datdhse150011@fpt.edu.vn","STUDENT");
=======
                Account accountB = new Account("FPT SOFTWARE2","datdhse@fpt.edu.vn","COMPANY");
>>>>>>> 26c4eacbba2ba4706c3beb9bd9a8b4875dc2fbf2
                Account accountC = new Account("test2", "akai792001@gmail.com", "EMPLOYEE");
                Account accountD = new Account("test3", "hoanmalai2001@gmail.com", "EMPLOYEE");
                Account accountE = new Account("FPT","hoan123hahaha@gmail.com","COMPANY");
                String startDate = "6/3/2022";
                String endDate = "20/6/2022";
                Company company1 = new Company("FPT SOFTWARE",
                "Information Technology & Services  10,001+ employees  377 on LinkedIn\n"+
                "Established since 1999, a leading IT Service provider in Southeast Asia with 52 offices in 18 countries and 700+ customers worldwide.", 
                "Đường D1, Đ. D1, Phường Tân Phú, Quận 9, Thành phố Hồ Chí Minh");
                company1.setAccountId(accountE);
                Company company2 = new Company("FPT SOFTWARE2",
                "Information Technology & Services  10,001+ employees  377 on LinkedIn\n"+
                "Established since 1999, a leading IT Service provider in Southeast Asia with 52 offices in 18 countries and 700+ customers worldwide.", 
                "Đường D1, Đ. D1, Phường Tân Phú, Quận 9, Thành phố Hồ Chí Minh");
                company2.setAccountId(accountB);
                Position position = new Position("Backend");
                 Position position2 = new Position("Frontend");
                Job job2 = new Job(10, "Clarify requirements, initiative solutions and develop deliverable software in the iterations of Scrum\n"
                +"Participate in building and developing system architecture\n" +
                "Create technical documents such as: system architecture, high level design\n"+
                "Developing new features/product improvements\n"+
                "Research and solve difficult technical issues\n"
                , "Strong understanding of WebRTC\n"+
                "2 years Experienced in developing web apps with ReactJS, NodeJS\n"+
                "Experience in building and deploying applications on the cloud (AWS)\n"+
                "Have in-depth knowledge of Object Oriented Design and Data Structures\n"+
                "Knowledge of infra, networking", "Processing",startDate, endDate ,company2,position2);
                Job job1 = new Job(10, "Clarify requirements, initiative solutions and develop deliverable software in the iterations of Scrum\n"
                +"Participate in building and developing system architecture\n" +
                "Create technical documents such as: system architecture, high level design\n"+
                "Developing new features/product improvements\n"+
                "Research and solve difficult technical issues\n"
                , "Strong understanding of WebRTC\n"+
                "2 years Experienced in developing web apps with ReactJS, NodeJS\n"+
                "Experience in building and deploying applications on the cloud (AWS)\n"+
                "Have in-depth knowledge of Object Oriented Design and Data Structures\n"+
                "Knowledge of infra, networking", "Processing",startDate, endDate ,company1,position2);
                OjtProcess ojtProcess = new OjtProcess(1, "detail", 1, accountA);
                logger.info("insert Data: " + accountRepositories.save(accountB));
                logger.info("insert Data: " + accountRepositories.save(accountA));
                logger.info("insert Data: " + accountRepositories.save(accountC));
                logger.info("insert Data: " + accountRepositories.save(accountD));
                logger.info("insert Data: " + accountRepositories.save(accountE));
                logger.info("insert Data: " + companyRepositories.save(company1));
                logger.info("insert Data: " + companyRepositories.save(company2));
                positionRepositories.save(position2);
                positionRepositories.save(position);
                logger.info("insert Data: "+ jobRepositories.save(job1));
                logger.info("insert Data: "+ jobRepositories.save(job2));
                ojtProcessRepositories.save(ojtProcess);
                CV cv = new CV("test",accountA);
                cvRepositories.save(cv);
                
                
                StudentApplyJobs std = new StudentApplyJobs(job2, accountA,accountB, "watting", "Spring");
                StudentApplyJobs std1 = new StudentApplyJobs(job1, accountB,accountA, "watting", "Spring");
                StudentApplyJobs std3 = new StudentApplyJobs(job1, accountB,accountA, "watting", "Spring");
                studentApplyJobsRepositories.save(std);
                studentApplyJobsRepositories.save(std1);
                studentApplyJobsRepositories.save(std3);
                 Major major = new Major("SE");
                 majorRepositories.save(major);
                 
                 positionRepositories.save(position);
                 major.getPosition().add(position);
                 majorRepositories.save(major);
                 major.getPosition().add(position2);
                 positionRepositories.save(position2);
                 majorRepositories.save(major);
                 
                 positionRepositories.save(position);
               
                
            
                
                
            }
      
        };
    }
}


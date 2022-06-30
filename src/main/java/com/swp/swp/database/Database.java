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


import com.swp.swp.model.*;
import com.swp.swp.repositories.*;

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
     StudentRepositories studentRepositories,
     EmployeeRepositories employeeRepositories,
     JobRepositories jobRepositories,
     CVRepositories cvRepositories,
     MajorRepositories majorRepositories,
     PositionRepositories positionRepositories,
     StudentApplyJobsRepositories studentApplyJobsRepositories,
     OjtProcessRepositories ojtProcessRepositories){
        
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Account accountA = new Account("test3", "hoanmalai2001@gmail.com", "EMPLOYEE");
                Account accountB = new Account("FPT SOFTWARE","danghuudat112363@gmail.com", "COMPANY");
                Account accountC = new Account("FPT SOFTWARE2","hoannsse150010@fpt.edu.vn","COMPANY");
                Account accountD = new Account("FPT","hoan123hahaha@gmail.com","STUDENT");
                Account accountE = new Account("FPT","kabutoshinki@gmail.com","STUDENT");
                Account accountF = new Account("FPT","huynhse151464@fpt.edu.vn","EMPLOYEE");
                Account accountG = new Account("FPT","hoanghuy1vip@gmail.com","COMPANY");
                Employee employeeA = new Employee();
                Student studentD = new Student();
                studentD.setStudentId("SE1500000");

                Student studentE = new Student();
                studentE.setStudentId("SE1500001");
                Employee employeeF = new Employee();
                employeeF.setAccount(accountF);
                studentD.setAccount(accountD);
                studentE.setAccount(accountE);
                String startDate = "6/3/2022";
                String endDate = "20/6/2022";


                Company company1 = new Company(
                "Information Technology & Services  10,001+ employees  377 on LinkedIn\n"+
                "Established since 1999, a leading IT Service provider in Southeast Asia with 52 offices in 18 countries and 700+ customers worldwide.", 
                accountB);
                Company company2 = new Company(
                        "Information Technology & Services  10,001+ employees  377 on LinkedIn\n"+
                        "Established since 1999, a leading IT Service provider in Southeast Asia with 52 offices in 18 countries and 700+ customers worldwide.",
                accountC);

                Company company3 = new Company(
                        "Information Technology & Services  10,001+ employees  377 on LinkedIn\n"+
                                "Established since 1999, a leading IT Service provider in Southeast Asia with 52 offices in 18 countries and 700+ customers worldwide.",
                        accountG);

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
                "Knowledge of infra, networking", "Processing",startDate, endDate ,company2,position2, employeeA);
                Job job1 = new Job(10, "Clarify requirements, initiative solutions and develop deliverable software in the iterations of Scrum\n"
                +"Participate in building and developing system architecture\n" +
                "Create technical documents such as: system architecture, high level design\n"+
                "Developing new features/product improvements\n"+
                "Research and solve difficult technical issues\n"
                , "Strong understanding of WebRTC\n"+
                "2 years Experienced in developing web apps with ReactJS, NodeJS\n"+
                "Experience in building and deploying applications on the cloud (AWS)\n"+
                "Have in-depth knowledge of Object Oriented Design and Data Structures\n"+
                "Knowledge of infra, networking", "Processing",startDate, endDate ,company1,position2, employeeA);
                OjtProcess ojtProcess = new OjtProcess(1, "detail", 1, studentD);
                logger.info("insert Data: " + companyRepositories.save(company1));
                logger.info("insert Data: " + companyRepositories.save(company2));
                logger.info("insert Data: " + companyRepositories.save(company3));
                logger.info("insert Data: " + employeeRepositories.save(employeeA));
                logger.info("insert Data: " + employeeRepositories.save(employeeF));
                logger.info("insert Data: " + studentRepositories.save(studentD));
                logger.info("insert Data: " + studentRepositories.save(studentE));
                logger.info("insert Data: " + accountRepositories.save(accountE));
                logger.info("insert Data: " + accountRepositories.save(accountA));
                logger.info("insert Data: " + accountRepositories.save(accountF));
                logger.info("insert Data: " + accountRepositories.save(accountB));
                logger.info("insert Data: " + accountRepositories.save(accountC));
                logger.info("insert Data: " + accountRepositories.save(accountD));
                logger.info("insert Data: " + accountRepositories.save(accountG));



                positionRepositories.save(position2);
                positionRepositories.save(position);
                logger.info("insert Data: "+ jobRepositories.save(job1));
                logger.info("insert Data: "+ jobRepositories.save(job2));
                ojtProcessRepositories.save(ojtProcess);
                CV cv = new CV("test", studentD);
                cvRepositories.save(cv);
                
                
                StudentApplyJob std = new StudentApplyJob(job2, studentD, employeeA, "watting", "Spring");
                StudentApplyJob std1 = new StudentApplyJob(job1, studentD, employeeA, "watting", "Spring");
                StudentApplyJob std3 = new StudentApplyJob(job1, studentD, employeeA, "watting", "Spring");
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


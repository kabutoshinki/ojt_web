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
import com.swp.swp.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;

/**
 *
 * @author ADMIN
 */
@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(AccountService accountService,
                                   CompanyService companyService,
                                   StudentService studentService,
                                   EmployeeService employeeService,
                                   JobService jobService,
                                   SemesterService semesterService,
                                   CVService cvService,
                                   MajorService majorService,
                                   StudentApplyJobsService studentApplyJobsService,
                                   OjtProcessService ojtProcessService,
                                   PositionRepositories positionService
    ){

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                Account employeeAccountA = new Account("test3", "danghuudat163@gmail.com", "EMPLOYEE");
                Account companyAccount1 = new Account("FPT SOFTWARE","hoannsse150010@fpt.edu.vn", "COMPANY");
                Account companyAccount2 = new Account("FPT SOFTWARE2","kaitokid792001@gmail.com","COMPANY");
                Account studentAccount1 = new Account("FPT","datdhse150011@fpt.edu.vn","STUDENT");
                Employee employeeA = new Employee();
                employeeA.setAccount(employeeAccountA);
                Student student1 = new Student();
                student1.setStudentId("SE1500000");

                student1.setAccount(studentAccount1);
                //String startDate = "6/3/2022";
                //String endDate = "20/6/2022";
                Date startDate = Date.valueOf("2022-03-06");
                Date endDate = Date.valueOf("2022-06-20");
                Company company1 = new Company(
                        "Information Technology & Services  10,001+ employees  377 on LinkedIn\n"+
                                "Established since 1999, a leading IT Service provider in Southeast Asia with 52 offices in 18 countries and 700+ customers worldwide.",
                        companyAccount1);
                Company company2 = new Company(
                        "Information Technology & Services  10,001+ employees  377 on LinkedIn\n"+
                                "Established since 1999, a leading IT Service provider in Southeast Asia with 52 offices in 18 countries and 700+ customers worldwide.",
                        companyAccount2);
                Position position = new Position("Backend");
                Position position2 = new Position("Frontend");
                Major major = new Major("SE");
                position.setMajor(major);
                position2.setMajor(major);



                Job job2 = new Job(10, "Clarify requirements, initiative solutions and develop deliverable software in the iterations of Scrum\n"
                        +"Participate in building and developing system architecture\n" +
                        "Create technical documents such as: system architecture, high level design\n"+
                        "Developing new features/product improvements\n"+
                        "Research and solve difficult technical issues\n"
                        , "Strong understanding of WebRTC\n"+
                        "2 years Experienced in developing web apps with ReactJS, NodeJS\n"+
                        "Experience in building and deploying applications on the cloud (AWS)\n"+
                        "Have in-depth knowledge of Object Oriented Design and Data Structures\n"+
                        "Knowledge of infra, networking", "Accepted",startDate, endDate ,company2,position2, employeeA);
                Job job1 = new Job(10, "Clarify requirements, initiative solutions and develop deliverable software in the iterations of Scrum\n"
                        +"Participate in building and developing system architecture\n" +
                        "Create technical documents such as: system architecture, high level design\n"+
                        "Developing new features/product improvements\n"+
                        "Research and solve difficult technical issues\n"
                        , "Strong understanding of WebRTC\n"+
                        "2 years Experienced in developing web apps with ReactJS, NodeJS\n"+
                        "Experience in building and deploying applications on the cloud (AWS)\n"+
                        "Have in-depth knowledge of Object Oriented Design and Data Structures\n"+
                        "Knowledge of infra, networking", "Accepted",startDate, endDate ,company1,position2, employeeA);
                //OjtProcess ojtProcess = new OjtProcess(1, "detail", 1, student1);



                CV cv = new CV("test", student1);
                cv.setStatus("Active");

                Semester semester = new Semester("Spring", 2022);
                student1.setSemester(semester);

                StudentApplyJob std = new StudentApplyJob(job2, student1, "Waiting", semester, cv);
                StudentApplyJob std1 = new StudentApplyJob(job1, student1, "Waiting", semester, cv);
                StudentApplyJob std3 = new StudentApplyJob(job1, student1, "Waiting", semester, cv);
                std.setEmployee(employeeA);
                std1.setEmployee(employeeA);
                std3.setEmployee(employeeA);

                semesterService.save(semester);

                majorService.save(major);

                logger.info("insert Data: " + companyService.save(company1));
                logger.info("insert Data: " + companyService.save(company2));

                logger.info("insert Data: " + employeeService.save(employeeA));

                logger.info("insert Data: " + studentService.save(student1));

                logger.info("insert Data: " + accountService.save(employeeAccountA));
                logger.info("insert Data: " + accountService.save(companyAccount1));
                logger.info("insert Data: " + accountService.save(companyAccount2));
                logger.info("insert Data: " + accountService.save(studentAccount1));


                logger.info("insert Data: " + positionService.save(position));
                logger.info("insert Data: " + positionService.save(position2));

                logger.info("insert Data: "+ jobService.save(job1));
                logger.info("insert Data: "+ jobService.save(job2));


                logger.info("insert Data: " + cvService.save(cv));

                //logger.info("insert Data: " + ojtProcessService.save(ojtProcess));

                logger.info("insert Data: " + studentApplyJobsService.save(std));
                logger.info("insert Data: " + studentApplyJobsService.save(std1));
                logger.info("insert Data: " + studentApplyJobsService.save(std3));

/*
 */
            }

        };
    }
}
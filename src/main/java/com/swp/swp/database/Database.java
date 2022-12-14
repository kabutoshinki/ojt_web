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

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;

/**
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
                        PositionRepositories positionService) {

                return new CommandLineRunner() {
                        @Override
                        public void run(String... args) throws Exception {
                                File file = new File(
                                                Paths.get("").toAbsolutePath() + "/src/main/resources/static/avatar");
                                file.mkdirs();
                                file = new File(Paths.get("").toAbsolutePath() + "/target/classes/static/avatar");
                                file.mkdirs();
                                Account employeeAccountA = new Account("Employee1", "danghuudat163@gmail.com", "EMPLOYEE");

                                Account employeeAccountB = new Account("test3", "huynhse151464@fpt.edu.vn", "EMPLOYEE");
                                Account companyAccount1 = new Account("FPT SOFTWARE", "kaitokid792001@gmail.com",
                                                "COMPANY");
                                                companyAccount1.setAvatar("/avatar/1.png");
                                Account companyAccount2 = new Account("DXC Technology", "hoannsse150010@fpt.edu.vn",
                                                "COMPANY");
                                                companyAccount2.setAvatar("/avatar/2.png");
                                Account companyAccount3 = new Account("ProGrad", "mori792001@gmail.com",
                                                "COMPANY");
                                                companyAccount3.setAvatar("/avatar/3.jpg");
                                Account companyAccount4 = new Account("Viettel Digital", "akai792001@gmail.com",
                                                "COMPANY");
                                                companyAccount4.setAvatar("/avatar/4.png");
                                Account companyAccount5 = new Account("Ascend Technology", "ran792001@gmail.com",
                                                "COMPANY");
                                                companyAccount5.setAvatar("/avatar/5.png");
                                Account companyAccount6 = new Account("Appen", "shinichi792001@gmail.com",
                                                "COMPANY");
                                                companyAccount6.setAvatar("/avatar/6.png");
                                Account companyAccount7 = new Account("Hitachi Vantara", "haibara792001@gmail.com",
                                                "COMPANY");
                                                companyAccount7.setAvatar("/avatar/7.jpg");
                                Account accountExternal = new Account("External", "", "COMPANY");
                                accountExternal.setStatus("Hidden");
                                Company companyExternal = new Company();
                                companyExternal.setAccount(accountExternal);
                                Account studentAccount1 = new Account("Dang Huu Dat", "datdhse150011@fpt.edu.vn", "STUDENT");
                                Account accountAdmin = new Account("FPT", "hoanghuy1vip@gmail.com", "ADMIN");
                                Employee employeeAdmin = new Employee();
                                employeeAdmin.setAccount(accountAdmin);
                                Employee employeeA = new Employee();
                                employeeA.setAccount(employeeAccountA);
                                Employee employeeB = new Employee();
                                employeeB.setAccount(employeeAccountB);
                                Student studentD = new Student();
                                studentD.setAccount(studentAccount1);
                                studentD.setStudentId("SE150011");
                                // String startDate = "6/3/2022";
                                // String endDate = "20/6/2022";
                                Date startDate = Date.valueOf("2022-03-06");
                                Date endDate = Date.valueOf("2022-06-20");
                                Company company1 = new Company(
                                                "Information Technology & Services  10,001+ employees  377 on LinkedIn\n"+
                                                "Established since 1999, a leading IT Service provider in Southeast Asia with 52 offices in 18 countries and 700+ customers worldwide.",
                                                companyAccount1);
                                Company company2 = new Company(
                                                "DXC Technology is a Fortune 500 global IT services leader.\n "+
                                                "Our more than 130,000 people in 70-plus countries are entrusted by our customers to deliver what matters most.\n"+
                                                 "We use the power of technology to deliver mission critical IT services across the Enterprise Technology Stack to drive business impact.\n" 
                                                 +"DXC is an employer of choice with strong values, and fosters a culture of inclusion, belonging and corporate citizenship. We are DXC.",
                                                companyAccount2);
                                Company company3 = new Company(
                                                "ProGrad is a new-age coding school where you can master tech skills that are in-demand today (and will be tomorrow). We offer in-demand skills like Full-stack Development and Web development.",
                                                companyAccount3);
                                Company company4 = new Company(
                                                "T???ng C??ng ty D???ch v??? s??? Viettel (Viettel Digital).\n "+
                                                "T???ng C??ng ty th??nh vi??n th??? 8 c???a T???p ??o??n C??ng nghi???p\n"+
                                                " Vi???n th??ng Qu??n ?????i. S??? ra ?????i c???a T???ng C??ng ty nh???m t???o n???n m??ng cho qu?? tr??nh chuy???n d???ch s???, th???c hi???n chi???n l?????c ph??t tri???n c???a Viettel trong giai ??o???n m???i\n"+
                                                 "giai ??o???n Ki???n t???o x?? h???i s???. T??? nay t???i 2025, T???ng C??ng ty ?????t hai m???c ti??u tr???ng t??m l???n: C?? 26 tri???u kh??ch h??ng tr??n h??? sinh th??i; ph??t tri???n 600.000 ??i???m ch???p nh???n thanh to??n & cung c???p d???ch v???.\n" ,
                                                companyAccount4);
                                Company company5 = new Company(
                                                "Ascend Technology was established in August 23th 2017, belongs to Ascend Group.\n "+
                                                "We aim to be an IT hub of cooperation and take responsibility for research and development on the core e- payment platform for Truemoney products.\n"+
                                                 " Following with the mission of Ascend Group, we are 'CREATING LIFE OPPORTUNITIES FOR ALL WITH DIGITAL SERVICES AND INFRASTRUCTURE'.\n" ,
                                                companyAccount5);
                                Company company6 = new Company(
                                                "TIBCO Software unlocks the potential of real-time data for making faster, smarter decisions.\n "+
                                                " Our Connected Intelligence Platform seamlessly connects any application or data source; intelligently unifies data for greater access, trust, and control; and confidently predicts outcomes in real-time and at scale\n"+
                                                 "Learn how solutions to our customers most critical business challenges are made possible by TIBCO at www.tibco.com.\n",
                                                companyAccount6);
                                Company company7 = new Company(
                                                "Hitachi Vantara, a wholly owned subsidiary of Hitachi, Ltd., helps data-driven leaders use the value in their data to innovate intelligently and reach outcomes that matter for business and society.\n "+
                                                "what we call a double bottom line. Only Hitachi Vantara combines 100+ years of experience in operational technology (OT) and 60+ years in IT to unlock the power of data from your business, your people and your machines.\n"+
                                                "We help enterprises store, enrich, activate and monetize data for better customer experiences, new revenue streams and lower business costs.\n",
                                                companyAccount7);
                                Position position = new Position("Backend");
                                Position position2 = new Position("Frontend");
                                Major major = new Major("SE");
                                position.setMajor(major);
                                position2.setMajor(major);

                                
                                Job job1 = new Job(10,
                                        "Clarify requirements, initiative solutions and develop deliverable software in the iterations of Scrum\n"
                                        + "Participate in building and developing system architecture\n"+
                                        "Create technical documents such as: system architecture, high level design\n"+
                                        "Developing new features/product improvements\n" +
                                        "Research and solve difficult technical issues\n",

                                        "Strong understanding of WebRTC\n"+
                                        "Good knowledge with C++, Java or Javascript\n" +
                                        "2 years Experienced in developing web apps with ReactJS, NodeJS\n"+
                                        "Experience in building and deploying applications on the cloud (AWS)\n"+
                                        "Have in-depth knowledge of Object Oriented Design and Data Structures\n"+
                                        "Knowledge of infra, networking",
                                                "Accepted", startDate, Date.valueOf("2022-09-20"), company1, position2,
                                                employeeA);
                                job1.setBenefit("Not Available");
                                Job job2 = new Job(10,
                                "Training hour: Monday through Friday, 9:00AM ??? 6:00PM\n"
                                                + "Address: Etown 5, 364 Cong Hoa, Ward 13, Tan Binh District, HCMC\n"
                                                +
                                                "Working from home\n"
                                                +
                                                "Start to work on the day as request from DXC after passing interview\n"
                                                ,
                                "Fresh graduates or final-year students in Computer Science, Information Technology, Software Engineering or related technical field.\n"
                                                + "Good knowledge in Object-oriented programming concept.\n" +
                                                "Has knowledge or relevant work experience in any of the following programming languages or technologies: Java/Java EE\n"
                                                +
                                                "Basic English communication from Pre-Intermediate\n",
                                "Accepted", startDate, Date.valueOf("2022-08-20"), company2, position2,
                                employeeA);
                                job2.setBenefit("Not Available");
                                Job job3 = new Job(10,
                                        "Full-time CTC: 13+ LPA (on successfully completing the training and internship)\n"
                                        + "Students from any degree/stream - with 60% marks throughout 10th, 12th, UG/PG, knowledge in one of the programming languages: C++/Java/Python\n"+
                                        "Training Duration: 8- 12 weeks (6-8 hours per day - Monday to Friday)\n"+
                                        "A stipend of INR 22K per month will be paid during the training program and internship\n" +
                                        "The training program is completely sponsored by Thoughtworks. All the students need is a functional laptop and a good internet connection.\n",

                                        "You possess a Degree/Diploma in Computer Science, Engineering or related field.\n"+
                                        "You have at least 1 year experience, ideally within a Software Engineer role.\n" +
                                        "You possess strong knowledge of C, C#, C++, Django, HTML, HTML5 / CSS, Javascript, Java, Matlab, Node.js, Meteor.js, PHP, React Native, Typescript, Bootstrap, AngularJS and .NET\n"+
                                        "You possess strong analytical skills and are comfortable dealing with numerical data\n"+
                                        "You are highly goal driven and work well in fast paced environments\n"+
                                        "You pay strong attention to detail and deliver work that is of a high standard",
                                                "Accepted", startDate, Date.valueOf("2022-09-20"), company3, position2,
                                                employeeA);
                                                job3.setBenefit("Not Available");
                                Job job4 = new Job(10,
                                        "Tham gia ph??t tri???n c??c d??? ??n trong H??? sinh th??i T??i ch??nh s??? (Viettel Pay, Mobile Money, v?? c?? nh??n, v?? doanh nghi???p, ...). Cung c???p s???n ph???m ???ng d???ng thanh to??n v?? chuy???n ti???n v???i s??? l?????ng giao d???ch r???t l???n, ????i h???i hi???u n??ng x??? l?? cao\n"
                                        + "X??y d???ng c??c h??? th???ng T??i ch??nh ??i???n t??? cho c??c th??? tr?????ng n?????c ngo??i m?? Viettel ?????u t??\n"+
                                        "Tham gia l??m r?? nghi???p v???, thi???t k??? gi???i ph??p, ph??t tri???n n??ng c???p h??? th???ng theo y??u c???u\n"+
                                        "Tham gia review thi???t k???, review code, t???i ??u h??? th???ng ????p ???ng l??u l?????ng truy c???p cao\n" +
                                        "Nghi??n c???u ??p d???ng c??ng ngh??? m???i n??ng cao ch???t l?????ng, t???i ??u ngu???n l???c ph??t tri???n\n",

                                        "T???t nghi???p ?????i h???c lo???i Kh?? tr??? l??n, chuy??n ng??nh C??ng ngh??? th??ng tin, K??? s?? ph???n m???m.\n"+
                                        "Ti???ng Anh t????ng ??????ng 550+ TOEIC\n" +
                                        "C?? ??t nh???t 01 n??m kinh nghi???m v???i v??? tr?? Java Developer ho???c v??? tr?? t????ng ??????ng. ??u ti??n c?? kinh nghi???m trong l??nh v???c T??i ch??nh - ng??n h??ng\n"+
                                        "Th??nh th???o Java Core, c??c framework Java nh?? EE, Spring, Struts, Hibernate ... v?? m???t s??? design pattern th??ng d???ng\n"+
                                        "T?? duy v??? thi???t k??? h?????ng ?????i t?????ng v?? n???m v???ng ki???n th???c v??? c???u tr??c d??? li???u v?? gi???i thu???t, l???p tr??nh h?????ng ?????i t?????ng\n"+
                                        "Th??nh th???o SQL, PLSQL, c?? ki???n th???c v??? c??c h??? qu???n tr??? c?? s??? d??? li???u Oracle/MySQL, noSQL,",
                                                "Accepted", startDate, Date.valueOf("2022-09-20"), company4, position,
                                                employeeA);
                                                job4.setBenefit("Not Available\n");
                                Job job5 = new Job(10,
                                        "Work in development team to help team complete task of developing product.\n"
                                        + "Design system based on the industry best practice\n"+
                                        "Create test cases, develop unit test program, running unit test, and create unit test report\n"+
                                        "Design system based on the industry best practice\n",

                                        "Strong in Java frameworks such as Spring, Springboot,...\n"+
                                        "Nice to have experience in client-side frameworks such as ReactJS, Angular, Flux/Redux,..\n" +
                                        "Good DB skill (SQL, NoSQL)\n"+
                                        "Experience with API (Open API/Swagger)\n"+
                                        "Nice to have knowledge of AWS/OCP, CI/CD, Microservice,...\n"+
                                        "Able to use English at work",
                                                "Accepted", startDate, Date.valueOf("2022-09-20"), company5, position2,
                                                employeeA);
                                        job5.setBenefit("Not Available");
                                Job job6 = new Job(10,
                                        "In this project, you will be provided with a passage, a one-sentence summary of the passage, and 3 questions per summary to help us assess whether the summary is comprehensive and faithful.\n"
                                        + "You will need to read the passage and the summary, and then answer all the questions provided\n"+
                                        "You will be able to work from home on your own time\n",

                                        "You must pass the project???s qualification quiz.\n"+
                                        "You must have a good command of English in order to understand the project-related materials, such as guidelines.\n",
                                                "Accepted", startDate, Date.valueOf("2022-09-20"), company6, position2,
                                                employeeA);
                                        job6.setBenefit("Not Available");
                                Job job7 = new Job(10,
                                        "We are looking for motivated and experienced Java developer/Fullstack Developer software professional.\n"+
                                        "Our Java developer must have knowledge in all stages of software development.\n"+
                                        "The candidate should be familiar with development life cycle, agile development methodology and change management with hands on experience in latest internet technologies and client-server architecture.\n",

                                        "Fullstack JS (NodeJS, ReactJS, Angular 2+).\n"+
                                        "Develop RESTful API.\n" +
                                        "Develop relational and non-relational databases.\n"+
                                        "Familiar with agile practices such as Scrum or Kanban.\n"+
                                        "Develop end-user applications.\n"+
                                        "OOP, design pattern.\n"+
                                        "Able to write well-structured and maintainable code.",
                                                "Accepted", startDate, Date.valueOf("2022-09-20"), company7, position2,
                                                employeeA);
                                        job7.setBenefit("Not Available");
                                // OjtProcess ojtProcess = new OjtProcess(1, "detail", 1, studentD);

                                Job jobExternal = new Job();
                                jobExternal.setCompany(companyExternal);
                                jobExternal.setStatus("Hidden");
                                jobExternal.setSlot(1000000000);

                                CV cv = new CV("test", studentD);
                                cv.setDescription("front end javascript java C++");
                                cv.setStatus("Active");

                                Semester semester = new Semester("Spring", 2022);
                                semester.setStartDate(startDate);
                                semester.setEndDate(endDate);
                                studentD.setSemester(semester);

                                StudentApplyJob std = new StudentApplyJob(job2, studentD, "Waiting", semester, cv);
                                StudentApplyJob std1 = new StudentApplyJob(job1, studentD, "Waiting", semester, cv);
                                StudentApplyJob std3 = new StudentApplyJob(job1, studentD, "Waiting", semester, cv);
                                // std.setEmployee(employeeA);
                                std1.setEmployee(employeeA);
                                std3.setEmployee(employeeA);

                                OjtProcess process = new OjtProcess();
                                process.setStudent(studentD);
                                // process.setCompany(company1);
                                process.setApplication(std1);
                                process.setStatus("Interning");

                                semesterService.save(semester);

                                majorService.save(major);

                                logger.info("insert Data: " + companyService.save(company1));
                                logger.info("insert Data: " + companyService.save(company2));
                                logger.info("insert Data: " + companyService.save(company3));
                                logger.info("insert Data: " + companyService.save(company4));
                                logger.info("insert Data: " + companyService.save(company5));
                                logger.info("insert Data: " + companyService.save(company6));
                                logger.info("insert Data: " + companyService.save(company7));
                                logger.info("insert Data: " + companyService.save(companyExternal));

                                logger.info("insert Data: " + employeeService.save(employeeA));
                                logger.info("insert Data: " + employeeService.save(employeeB));
                                logger.info("insert Data: " + employeeService.save(employeeAdmin));

                                

                                logger.info("insert Data: " + accountService.save(accountAdmin));
                                logger.info("insert Data: " + accountService.save(employeeAccountA));
                                logger.info("insert Data: " + accountService.save(employeeAccountB));
                                logger.info("insert Data: " + accountService.save(companyAccount1));
                                logger.info("insert Data: " + accountService.save(companyAccount2));
                                logger.info("insert Data: " + accountService.save(companyAccount3));
                                logger.info("insert Data: " + accountService.save(companyAccount4));
                                logger.info("insert Data: " + accountService.save(companyAccount5));
                                logger.info("insert Data: " + accountService.save(companyAccount6));
                                logger.info("insert Data: " + accountService.save(companyAccount7));

                                logger.info("insert Data: " + studentService.save(studentD));
                                logger.info("insert Data: " + accountService.save(studentAccount1));
                                

                                logger.info("insert Data: " + accountService.save(accountExternal));

                                logger.info("insert Data: " + positionService.save(position));
                                logger.info("insert Data: " + positionService.save(position2));

                                logger.info("insert Data: " + jobService.save(job1));
                                logger.info("insert Data: " + jobService.save(job2));
                                logger.info("insert Data: " + jobService.save(job3));
                                logger.info("insert Data: " + jobService.save(job4));
                                logger.info("insert Data: " + jobService.save(job5));
                                logger.info("insert Data: " + jobService.save(job6));
                                logger.info("insert Data: " + jobService.save(job7));
                                logger.info("insert Data: " + jobService.save(jobExternal));

                                logger.info("insert Data: " + cvService.save(cv));

                                // logger.info("insert Data: " + ojtProcessService.save(ojtProcess));
                                // ojtProcessService.save(process);
                                logger.info("insert Data: " + studentApplyJobsService.save(std));
                                logger.info("insert Data: " + studentApplyJobsService.save(std1));
                                logger.info("insert Data: " + studentApplyJobsService.save(std3));

                        }

                };
        }
}
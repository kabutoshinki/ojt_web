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
                                Account employeeAccountA = new Account("test3", "danghuudat163@gmail.com", "EMPLOYEE");
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
                                Account studentAccount1 = new Account("FPT", "datdhse150011@fpt.edu.vn", "STUDENT");
                                Account accountAdmin = new Account("FPT", "ojt.sender@gmail.com", "ADMIN");
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
                                                "Tổng Công ty Dịch vụ số Viettel (Viettel Digital).\n "+
                                                "Tổng Công ty thành viên thứ 8 của Tập đoàn Công nghiệp\n"+
                                                " Viễn thông Quân đội. Sự ra đời của Tổng Công ty nhằm tạo nền móng cho quá trình chuyển dịch số, thực hiện chiến lược phát triển của Viettel trong giai đoạn mới\n"+
                                                 "giai đoạn Kiến tạo xã hội số. Từ nay tới 2025, Tổng Công ty đặt hai mục tiêu trọng tâm lớn: Có 26 triệu khách hàng trên hệ sinh thái; phát triển 600.000 điểm chấp nhận thanh toán & cung cấp dịch vụ.\n" ,
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
                                "Training hour: Monday through Friday, 9:00AM – 6:00PM\n"
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
                                        "Tham gia phát triển các dự án trong Hệ sinh thái Tài chính số (Viettel Pay, Mobile Money, ví cá nhân, ví doanh nghiệp, ...). Cung cấp sản phẩm ứng dụng thanh toán và chuyển tiền với số lượng giao dịch rất lớn, đòi hỏi hiệu năng xử lý cao\n"
                                        + "Xây dựng các hệ thống Tài chính điện tử cho các thị trường nước ngoài mà Viettel đầu tư\n"+
                                        "Tham gia làm rõ nghiệp vụ, thiết kế giải pháp, phát triển nâng cấp hệ thống theo yêu cầu\n"+
                                        "Tham gia review thiết kế, review code, tối ưu hệ thống đáp ứng lưu lượng truy cập cao\n" +
                                        "Nghiên cứu áp dụng công nghệ mới nâng cao chất lượng, tối ưu nguồn lực phát triển\n",

                                        "Tốt nghiệp Đại học loại Khá trở lên, chuyên ngành Công nghệ thông tin, Kỹ sư phần mềm.\n"+
                                        "Tiếng Anh tương đương 550+ TOEIC\n" +
                                        "Có ít nhất 01 năm kinh nghiệm với vị trí Java Developer hoặc vị trí tương đương. Ưu tiên có kinh nghiệm trong lĩnh vực Tài chính - ngân hàng\n"+
                                        "Thành thạo Java Core, các framework Java như EE, Spring, Struts, Hibernate ... và một số design pattern thông dụng\n"+
                                        "Tư duy về thiết kế hướng đối tượng và nắm vững kiến thức về cấu trúc dữ liệu và giải thuật, lập trình hướng đối tượng\n"+
                                        "Thành thạo SQL, PLSQL, có kiến thức về các hệ quản trị cơ sở dữ liệu Oracle/MySQL, noSQL,",
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

                                        "You must pass the project’s qualification quiz.\n"+
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
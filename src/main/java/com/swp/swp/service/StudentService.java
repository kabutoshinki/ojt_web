package com.swp.swp.service;

import com.swp.swp.database.Database;
import com.swp.swp.model.Account;
import com.swp.swp.model.Company;
import com.swp.swp.model.Student;
import com.swp.swp.model.StudentApplyJob;
import com.swp.swp.repositories.CompanyRepositories;
import com.swp.swp.repositories.StudentRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Autowired
    private StudentRepositories studentRepositories;

    public boolean save(Student newStudent) {
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\target\\classes\\static\\students");
        //Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\students");
        try {
            logger.info("insert Data: " + studentRepositories.save(newStudent));
            File file = new File(currentWorkingDir + "\\" + newStudent.getId());
            /*file.createNewFile();*/
            //if (!file.exists()){
            File cvFolder = new File(currentWorkingDir + "\\" + newStudent.getId() + "\\CV");
            File imgFolder = new File(currentWorkingDir + "\\" + newStudent.getId() + "\\image");
            File requestFolder = new File(currentWorkingDir + "\\" + newStudent.getId() + "\\Request");
            file.mkdirs();
            cvFolder.mkdirs();
            imgFolder.mkdirs();
            requestFolder.mkdirs();
            //}
            System.out.println(file.exists());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Iterable<Student> findAll() {
        Iterable<Student> studentList = studentRepositories.findAll();
        return studentList;
    }

    public Iterable<Student> findAllActive() {
        Iterable<Student> studentList = studentRepositories.findAll();
        ArrayList <Student> temp = new ArrayList<>();
        for (Student x: studentList) {
            if (x.getAccount().getStatus() == null || x.getAccount().getStatus().equalsIgnoreCase("Inactive") == false)
                temp.add(x);
        }
        return temp;
    }

    public Student findById(int id) {
        Student student = studentRepositories.findById(id);
        return student;
    }

    public Student findByAccount(Account account) {
        return studentRepositories.findByAccount(account);
    }

    public boolean alreadyApplied(Student student, Company company) {
        for (StudentApplyJob x: student.getApplyList()) {
            if (x.getJob().getCompany().equals(company) && x.getSemester().equals(student.getSemester())) {
                return true;
            }
        }
        return false;
    }

}
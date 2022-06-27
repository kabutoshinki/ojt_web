package com.swp.swp.service;

import com.swp.swp.model.Account;
import com.swp.swp.model.Company;
import com.swp.swp.model.Student;
import com.swp.swp.repositories.CompanyRepositories;
import com.swp.swp.repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepositories studentRepositories;

    public boolean insertStudent(Student newStudent) {
        try {
            studentRepositories.save(newStudent);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Iterable<Student> getAll() {
        Iterable<Student> studentList = studentRepositories.findAll();
        return studentList;
    }

    public Student findById(int id) {
        Student student = studentRepositories.findById(id);
        return student;
    }

    public Student findByAccount(Account account) {
        return studentRepositories.findByAccount(account);
    }
}

package com.swp.swp.repositories;

import com.swp.swp.model.Account;
import com.swp.swp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepositories extends JpaRepository<Student,Integer> {
    Student findById(int id);
    Student findByStudentId(String id);
    Student findByAccount(Account account);
}

package com.swp.swp.repositories;

import com.swp.swp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositories extends JpaRepository<Student,Integer> {
    Student findById(int id);
}

package com.swp.swp.repositories;

import com.swp.swp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import com.swp.swp.model.CV;

public interface CVRepositories extends JpaRepository<CV, Integer> {
    CV findById(int id);

    Iterable<CV> findByStudent(Student student);
}

package com.swp.swp.repositories;

import com.swp.swp.model.CV;
import com.swp.swp.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepositories extends JpaRepository<Semester, Integer> {
    Semester findById(int id);

    Semester findTopByOrderByIdDesc();
}

package com.swp.swp.repositories;

import com.swp.swp.model.Company;
import com.swp.swp.model.ExternalRequest;
import com.swp.swp.model.Job;
import com.swp.swp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalRequestRepositories extends JpaRepository<ExternalRequest, Integer> {
    ExternalRequest findById(int id);
    Iterable<ExternalRequest> findByStudent(Student student);
}

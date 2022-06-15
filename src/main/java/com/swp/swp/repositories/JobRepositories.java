package com.swp.swp.repositories;

import com.swp.swp.model.CompanyDetail;
import com.swp.swp.model.Job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepositories extends JpaRepository<Job, Integer> {
    Job findById(int id);
    Iterable<Job> findByCompanyDetail(CompanyDetail company);
}

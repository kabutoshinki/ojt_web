package com.swp.swp.repositories;

import com.swp.swp.model.Job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepositories extends JpaRepository<Job, Integer> {
    
}

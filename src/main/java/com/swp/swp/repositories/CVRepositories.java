package com.swp.swp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swp.swp.model.CV;

public interface CVRepositories extends JpaRepository<CV, Integer> {
    
}

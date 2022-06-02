package com.swp.swp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swp.swp.model.Major;

public interface MajorRepositories extends JpaRepository<Major, Integer> {
    
}

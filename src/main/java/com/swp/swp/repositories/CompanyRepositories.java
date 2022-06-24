package com.swp.swp.repositories;

import com.swp.swp.model.Company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepositories extends JpaRepository<Company,Integer> {
    Company findById(int id);
}

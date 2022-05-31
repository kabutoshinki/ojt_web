package com.swp.swp.repositories;

import com.swp.swp.model.CompanyDetail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDetailRepositories extends JpaRepository<CompanyDetail,Integer> {
    CompanyDetail findById(int id);
}

package com.swp.swp.repositories;

import com.swp.swp.model.Account;
import com.swp.swp.model.Company;

import com.swp.swp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepositories extends JpaRepository<Company,Integer> {
    Company findById(int id);

    Company findByAccount(Account account);
}

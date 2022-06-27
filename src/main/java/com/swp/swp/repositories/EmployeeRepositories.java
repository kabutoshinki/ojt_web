package com.swp.swp.repositories;

import com.swp.swp.model.Account;
import com.swp.swp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositories extends JpaRepository<Employee,Integer> {
    Employee findById(int id);

    Employee findByAccount(Account account);
}

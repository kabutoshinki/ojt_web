package com.swp.swp.service;

import com.swp.swp.database.Database;
import com.swp.swp.model.Account;
import com.swp.swp.model.Employee;
import com.swp.swp.model.Student;
import com.swp.swp.repositories.EmployeeRepositories;
import com.swp.swp.repositories.StudentRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Autowired
    private EmployeeRepositories employeeRepositories;

    public boolean save(Employee newEmployee) {
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static");
        try {
            logger.info("insert Data: " + employeeRepositories.save(newEmployee));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Iterable<Employee> getAll() {
        Iterable<Employee> employeeList = employeeRepositories.findAll();
        return employeeList;
    }

    public Employee findById(int id) {
        Employee employee = employeeRepositories.findById(id);
        return employee;
    }

    public Employee findByAccount(Account account) {
        return employeeRepositories.findByAccount(account);
    }
}

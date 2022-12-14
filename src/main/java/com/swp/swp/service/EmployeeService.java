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

import java.util.ArrayList;

@Service
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Autowired
    private EmployeeRepositories employeeRepositories;

    public boolean save(Employee newEmployee) {
        try {
            logger.info("insert Data: " + employeeRepositories.save(newEmployee));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Iterable<Employee> findAll() {
        Iterable<Employee> employeeList = employeeRepositories.findAll();
        return employeeList;
    }

    public Iterable<Employee> findAllActive() {
        Iterable<Employee> employeeList = employeeRepositories.findAll();
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee x: employeeList) {
            if (x.getAccount().getRole().equalsIgnoreCase("EMPLOYEE"))
            if (x.getAccount().getStatus() == null
                    || x.getAccount().getStatus().equalsIgnoreCase("Inactive") == false)
                temp.add(x);
        }
        return temp;
    }
    public Employee findById(int id) {
        Employee employee = employeeRepositories.findById(id);
        return employee;
    }

    public Employee findByAccount(Account account) {
        return employeeRepositories.findByAccount(account);
    }
}

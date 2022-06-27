package com.swp.swp.service;

import com.swp.swp.model.Account;
import com.swp.swp.model.Employee;
import com.swp.swp.model.Student;
import com.swp.swp.repositories.EmployeeRepositories;
import com.swp.swp.repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepositories employeeRepositories;

    public boolean insertStudent(Employee newEmployee) {
        try {
            employeeRepositories.save(newEmployee);
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

    public Employee getById(int id) {
        Employee employee = employeeRepositories.findById(id);
        return employee;
    }

    public Employee findByAccount(Account account) {
        return employeeRepositories.findByAccount(account);
    }
}

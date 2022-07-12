package com.swp.swp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swp.swp.model.Account;
import com.swp.swp.model.Company;
import com.swp.swp.repositories.CompanyRepositories;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTest {
    @Autowired private CompanyService companyService;
    @Autowired private CompanyRepositories companyRepositories; 
    @Test
    void testGetAll() {
        Iterable<Company> expected = companyRepositories.findAll();
        Iterable<Company> actual = companyService.getAll();
        assertEquals(expected.iterator().next().getAccount().getFullName(), actual.iterator().next().getAccount().getFullName());
    }

    @Test
    void testGetById() {
        Iterable<Company> compayList = companyRepositories.findAll();
        for (Company company : compayList) {
            Company expected = companyRepositories.findById(company.getId());
            Company actual = companyService.getById(company.getId());
            assertEquals(expected.getAccount().getFullName(), actual.getAccount().getFullName());
        }
    }

    @Test
    void testInsertCompany() {
        Account account = new Account("fullName", "email", "role");
        Company company = new Company("companyName", account);
        assertTrue(companyService.save(company));
    }
}

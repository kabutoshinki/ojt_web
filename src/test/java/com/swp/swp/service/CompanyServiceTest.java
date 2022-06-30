package com.swp.swp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        assertEquals(expected.iterator().next().getName(), actual.iterator().next().getName());
    }

    @Test
    void testGetById() {
        Iterable<Company> compayList = companyRepositories.findAll();
        for (Company company : compayList) {
            Company expected = companyRepositories.findById(company.getId());
            Company actual = companyService.getById(company.getId());
            assertEquals(expected.getName(), actual.getName());
        }
    }

    @Test
    void testInsertCompany() {
        Company company = new Company("companyName", "companyDescription", "companyAdress");
        assertTrue(companyService.insertCompany(company));
    }
}

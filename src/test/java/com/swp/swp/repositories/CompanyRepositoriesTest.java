package com.swp.swp.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swp.swp.model.Company;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyRepositoriesTest {
    @Autowired CompanyRepositories companyRepositories;
    @Test
    void testFindById() {
        Iterable<Company> companyList = companyRepositories.findAll();
        for (Company company : companyList) {
            assertNotNull(companyRepositories.findById(company.getId()));
        }
    }
}

package com.swp.swp.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swp.swp.model.Company;
import com.swp.swp.model.Job;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobRepositoriesTest {
    @Autowired private JobRepositories jobRepositories;
    @Test
    void testFindByCompany() {
        Iterable<Job> jobList = jobRepositories.findAll();
        
        for (Job job : jobList) {
            assertNotNull(jobRepositories.findByCompany(job.getCompany()));
            
        }
    }

    @Test
    void testFindById() {
        Iterable<Job> jobList = jobRepositories.findAll();
        for (Job job : jobList) {
            assertNotNull(jobRepositories.findById(job.getId()));
            
        }
    }
}

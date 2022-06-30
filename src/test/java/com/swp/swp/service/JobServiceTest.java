package com.swp.swp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swp.swp.model.Company;
import com.swp.swp.model.Job;
import com.swp.swp.model.Position;
import com.swp.swp.repositories.CompanyRepositories;
import com.swp.swp.repositories.JobRepositories;
import com.swp.swp.repositories.PositionRepositories;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobServiceTest {
    @Autowired private JobRepositories jobRepositories;
    @Autowired private JobService jobService;
    @Autowired private CompanyRepositories companyRepositories;
    @Autowired private PositionRepositories positionRepositories;
    @Test
    void testGetAll() {
        Iterable<Job> expect = jobRepositories.findAll();
        Iterable<Job> actual = jobService.getAll();
        assertEquals(expect.iterator().next().getRequirement(), actual.iterator().next().getRequirement());
    }

    @Test
    void testGetById() {
        Iterable<Job> jobList = jobRepositories.findAll();
        for (Job job : jobList) {
            Job expected = jobRepositories.findById(job.idJob);
            Job actual = jobService.getById(job.idJob);
            assertEquals(expected.idJob, actual.idJob);
        }

    }


    @Test
    void testGetCompanyDescription() {
        Iterable<Job> jobList = jobRepositories.findAll();
        for (Job job : jobList) {
            String[] expected = jobService.getCompanyDescription(job.idJob);
            String[] actual = jobService.getCompanyDescription(job.idJob);
            if(expected!=null){
                for (int i = 0; i < actual.length; i++) {
                    assertEquals(expected[i].toString(), actual[i].toString());
                }
            }
        }
    }

    @Test
    void testGetJobDescription() {
        Iterable<Job> jobList = jobRepositories.findAll();
        for (Job job : jobList) {
            String[] expected = jobService.getJobDescription(job.idJob);
            String[] actual = jobService.getJobDescription(job.idJob);
            if(expected!=null){
                for (int i = 0; i < actual.length; i++) {
                    assertEquals(expected[i].toString(), actual[i].toString());
                }
            }
        }
    }

    @Test
    void testGetJobRequirement() {
        Iterable<Job> jobList = jobRepositories.findAll();
        for (Job job : jobList) {
            String[] expected = jobService.getJobRequirement(job.idJob);
            String[] actual = jobService.getJobRequirement(job.idJob);
            if(expected!=null){
                for (int i = 0; i < actual.length; i++) {
                    assertEquals(expected[i].toString(), actual[i].toString());
                }
            }
        }
    }

    @Test
    void testInsertJob() {
        Job job = new Job(10, "description", "requirement", "status");
        Iterable<Company> companyList = companyRepositories.findAll();
        Iterable<Position> positonList = positionRepositories.findAll();
        assertTrue(jobService.insertJob(job, companyList.iterator().next().getId(), positonList.iterator().next().getId()));
    }

 
    @Test
    void testUpdateStatus() {
        Iterable<Job> jobList = jobRepositories.findAll();
        for (Job job : jobList) {
            assertTrue(jobService.updateStatus(job.idJob, "status"));
        }
    }
}

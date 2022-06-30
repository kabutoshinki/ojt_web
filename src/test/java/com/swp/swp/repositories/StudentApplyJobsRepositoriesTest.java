package com.swp.swp.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swp.swp.model.StudentApplyJobs;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplyJobsRepositoriesTest {
    @Autowired private StudentApplyJobsRepositories stdR;
    @Test
    void testFindByAccount() {
        Iterable<StudentApplyJobs> list = stdR.findAll();
        for (StudentApplyJobs studentApplyJobs : list) {
            assertNotNull(stdR.findByAccount(studentApplyJobs.getAccount()));
        }
    }

    @Test
    void testFindById() {
        Iterable<StudentApplyJobs> list = stdR.findAll();
        for (StudentApplyJobs studentApplyJobs : list) {
            assertNotNull(stdR.findById(studentApplyJobs.getId()));
        }
    }

    @Test
    void testFindByJob() {
        Iterable<StudentApplyJobs> list = stdR.findAll();
        for (StudentApplyJobs studentApplyJobs : list) {
            assertNotNull(stdR.findByJob(studentApplyJobs.getJob()));
        }
    }
}

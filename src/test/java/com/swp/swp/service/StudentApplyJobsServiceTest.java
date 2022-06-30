package com.swp.swp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swp.swp.model.Account;
import com.swp.swp.model.StudentApplyJobs;
import com.swp.swp.repositories.AccountRepositories;
import com.swp.swp.repositories.StudentApplyJobsRepositories;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentApplyJobsServiceTest {
    @Autowired private StudentApplyJobsRepositories repositories;
    @Autowired private StudentApplyJobsService service;
    @Autowired private AccountRepositories account;
    @Test
    void testGetAll() {
        ArrayList<StudentApplyJobs> expected = (ArrayList<StudentApplyJobs>) repositories.findAll();
        ArrayList<StudentApplyJobs> actual = (ArrayList<StudentApplyJobs>) service.getAll();
        for (int i = 0; i < actual.size(); i++) {
           assertEquals(expected.get(i).getId(), actual.get(i).getId());
        }
    }

    @Test
    void testGetApplyByAccount() {
        Iterable<StudentApplyJobs> accountList = repositories.findAll();
        Account account1 = new Account("fullName", "email", "role");
        account.save(account1);
        for (StudentApplyJobs account : accountList) {
            assertNotNull(service.getApplyByAccount(account.getAccount()));
        }
      
    }

    @Test
    void testGetApplyByCompanyId() {
        Iterable<StudentApplyJobs> companyList = repositories.findAll();
            assertNotNull(service.getApplyByCompanyId(1));
        
    }

    @Test
    void testGetById() {

    }

    @Test
    void testGetByString() {

    }

    @Test
    void testIsExist() {

    }

    @Test
    void testUpdateStatus() {
        Iterable<StudentApplyJobs> applyList = repositories.findAll();

    }
}

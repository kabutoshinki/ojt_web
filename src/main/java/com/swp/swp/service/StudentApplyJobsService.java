package com.swp.swp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.swp.model.Account;
import com.swp.swp.model.Company;
import com.swp.swp.model.Job;
import com.swp.swp.model.StudentApplyJobs;
import com.swp.swp.repositories.CompanyRepositories;
import com.swp.swp.repositories.JobRepositories;
import com.swp.swp.repositories.StudentApplyJobsRepositories;

@Service
public class StudentApplyJobsService {
    @Autowired private StudentApplyJobsRepositories studentApplyJobsRepositories;
    @Autowired private CompanyRepositories companyRepositories;
    @Autowired private JobRepositories jobRepositories;
    @Autowired private AccountService accountService;
    

    

    public StudentApplyJobsService(StudentApplyJobsRepositories studentApplyJobsRepositories,
                                   CompanyRepositories companyRepositories, JobRepositories jobRepositories) {
        this.studentApplyJobsRepositories = studentApplyJobsRepositories;
        this.companyRepositories = companyRepositories;
        this.jobRepositories = jobRepositories;
    }

    public boolean updateStatus(int id, String status) {
        StudentApplyJobs candidate = studentApplyJobsRepositories.findById(id);
        try {
            candidate.setStatus(status);
            studentApplyJobsRepositories.save(candidate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Iterable<StudentApplyJobs> getAll() {
        Iterable<StudentApplyJobs> candidates = studentApplyJobsRepositories.findAll();
        return candidates;
    }

    public StudentApplyJobs getById(int id) {
        return null;
    }

    public boolean isExist(String value) {
        // TODO Auto-generated method stub
        return false;
    }
    public Iterable<StudentApplyJobs> getApplyByCompanyId(int id){
        Company company = companyRepositories.findById(id);
        ArrayList<StudentApplyJobs> candidatesList = new ArrayList<>();
        Iterable<Job> jobs = jobRepositories.findByCompany(company);
        for (Job job : jobs) {
           Iterable<StudentApplyJobs> candidates= studentApplyJobsRepositories.findByJob(job);
           for (StudentApplyJobs candidate : candidates) {
                candidatesList.add(candidate);
           }
        }
        return candidatesList;
    }
    public Iterable<StudentApplyJobs> getApplyByAccount(Account account){
        Iterable <StudentApplyJobs> apply = studentApplyJobsRepositories.findByAccount(account);
        return apply;
    }

    public StudentApplyJobs getByString(String value) {
        // TODO Auto-generated method stub
        return null;
    }
    
}

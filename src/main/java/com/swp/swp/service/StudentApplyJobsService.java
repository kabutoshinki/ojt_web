package com.swp.swp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.swp.model.CompanyDetail;
import com.swp.swp.model.Job;
import com.swp.swp.model.StudentApplyJobs;
import com.swp.swp.repositories.CompanyDetailRepositories;
import com.swp.swp.repositories.JobRepositories;
import com.swp.swp.repositories.StudentApplyJobsRepositories;

@Service
public class StudentApplyJobsService implements CRUDInterface<StudentApplyJobs> {
    @Autowired private StudentApplyJobsRepositories studentApplyJobsRepositories;
    @Autowired private CompanyDetailRepositories companyDetailRepositories;
    @Autowired private JobRepositories jobRepositories;
    

    

    public StudentApplyJobsService(StudentApplyJobsRepositories studentApplyJobsRepositories,
            CompanyDetailRepositories companyDetailRepositories, JobRepositories jobRepositories) {
        this.studentApplyJobsRepositories = studentApplyJobsRepositories;
        this.companyDetailRepositories = companyDetailRepositories;
        this.jobRepositories = jobRepositories;
    }

    @Override
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

    @Override
    public Iterable<StudentApplyJobs> getAll() {
        Iterable<StudentApplyJobs> candidates = studentApplyJobsRepositories.findAll();
        return candidates;
    }

    @Override
    public StudentApplyJobs getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isExist(String value) {
        // TODO Auto-generated method stub
        return false;
    }
    public Iterable<StudentApplyJobs> getApplyByCompanyId(int id){
        CompanyDetail company = companyDetailRepositories.findById(id);
        ArrayList<StudentApplyJobs> candidatesList = new ArrayList<>();
        Iterable<Job> jobs = jobRepositories.findByCompanyDetail(company);
        for (Job job : jobs) {
           Iterable<StudentApplyJobs> candidates= studentApplyJobsRepositories.findByJob(job);
           for (StudentApplyJobs candidate : candidates) {
                candidatesList.add(candidate);
           }
        }
        return candidatesList;
    }

    @Override
    public StudentApplyJobs getByString(String value) {
        // TODO Auto-generated method stub
        return null;
    }
    
}

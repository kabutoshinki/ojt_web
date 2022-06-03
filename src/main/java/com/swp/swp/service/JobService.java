package com.swp.swp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.swp.model.CompanyDetail;
import com.swp.swp.model.Job;
import com.swp.swp.model.Position;
import com.swp.swp.repositories.CompanyDetailRepositories;
import com.swp.swp.repositories.JobRepositories;
import com.swp.swp.repositories.PositionRepositories;

@Service
public class JobService implements JobServiceInterface {

    @Autowired JobRepositories jobRepositories;
    @Autowired CompanyDetailRepositories companyDetailRepositories;
    @Autowired PositionRepositories positionRepositories;
    @Override
    public Iterable<Job> getAllJobs() {
        return jobRepositories.findAll();
    }
    @Override
    public String[] getJobDescription(int id) {
        Job job = jobRepositories.findById(id);
        return job.getDescription().split("\n");
    }
    @Override
    public String[] getJobRequiment(int id) {
        Job job = jobRepositories.findById(id);
        return job.getRequirement().split("\n");
    }
    @Override
    public boolean insertJob(Job job, int companyId, int positionId) {
        CompanyDetail company = companyDetailRepositories.findById(companyId);
        Position position = positionRepositories.findById(positionId);
        position.getJobs().add(job);
        job.setCompanyDetail(company);
        try {
            jobRepositories.save(job);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}

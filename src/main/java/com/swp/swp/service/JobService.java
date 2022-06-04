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


    public JobService(JobRepositories jobRepositories, CompanyDetailRepositories companyDetailRepositories
    , PositionRepositories positionRepositories
    ){
        super();
        this.jobRepositories =jobRepositories;
        this.positionRepositories = positionRepositories;
        this.companyDetailRepositories = companyDetailRepositories;
    }
    @Override
    public Iterable<Job> getAllJobs() {
        return jobRepositories.findAll();
    }
    @Override
    public String[] getJobDescription(int id) {
        Job job = jobRepositories.findById(id);
        try {
            return job.getDescription().split("\n");
            
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public String[] getJobRequiment(int id) {
        Job job = jobRepositories.findById(id);
        try {
            return job.getRequirement().split("\n");
            
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public boolean insertJob(Job job, int companyId, int positionId) {
        CompanyDetail company = companyDetailRepositories.findById(companyId);
        Position position = positionRepositories.findById(positionId);
        job.setCompanyDetail(company);
        try {
            jobRepositories.save(job);
            position.getJobs().add(job);
            positionRepositories.save(position);
            return true;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());;
            return false;
        }
    }
    @Override
    public String[] getCompanyDescription(int id) {
        Job job = jobRepositories.findById(id);
        CompanyDetail company = job.getCompanyDetail();
        try {
            return company.getCompanyDescription().split("\n");
            
        } catch (Exception e) {
            return null;
        }

    }
    @Override
    public Job getJob(int id) {
        try {
            return jobRepositories.findById(id);
        } catch (Exception e) {
            return null;
        }
    }
    
}

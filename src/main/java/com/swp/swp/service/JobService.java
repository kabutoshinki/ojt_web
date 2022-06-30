package com.swp.swp.service;

import com.swp.swp.database.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.swp.model.Company;
import com.swp.swp.model.Job;
import com.swp.swp.model.Position;
import com.swp.swp.repositories.CompanyRepositories;
import com.swp.swp.repositories.JobRepositories;
import com.swp.swp.repositories.PositionRepositories;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class JobService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Autowired
    JobRepositories jobRepositories;
    @Autowired
    CompanyRepositories companyRepositories;
    @Autowired
    PositionRepositories positionRepositories;

    public JobService(JobRepositories jobRepositories, CompanyRepositories companyRepositories,
            PositionRepositories positionRepositories) {
        super();
        this.jobRepositories = jobRepositories;
        this.positionRepositories = positionRepositories;
        this.companyRepositories = companyRepositories;
    }

    public String[] getJobDescription(int id) {
        Job job = jobRepositories.findById(id);
        try {
            return job.getDescription().split("\n");

        } catch (Exception e) {
            return null;
        }
    }

    public String[] getJobRequirement(int id) {
        Job job = jobRepositories.findById(id);
        try {
            return job.getRequirement().split("\n");

        } catch (Exception e) {
            return null;
        }
    }

    public String[] getCompanyDescription(int id) {
        Job job = jobRepositories.findById(id);
        Company company = job.getCompany();
        try {
            return company.getDescription().split("\n");

        } catch (Exception e) {
            return null;
        }

    }

    public boolean insertJob(Job job, int companyId, int positionId) {
        Company company = companyRepositories.findById(companyId);
        Position position = positionRepositories.findById(positionId);
        job.setCompany(company);
        job.setPosition(position);
        try {
            jobRepositories.save(job);
            positionRepositories.save(position);
            return true;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            ;
            return false;
        }
    }

    public boolean updateStatus(int id, String status) {
        try {
            Job job = jobRepositories.findById(id);
            job.setStatus(status);
            jobRepositories.save(job);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Iterable<Job> getAll() {
        Iterable<Job> jobs = jobRepositories.findAll();
        return jobs;
    }

    public boolean save(Job newJob) {
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\companies");
        try {
            logger.info("insert Data: " +  jobRepositories.save(newJob));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Job findById(int id) {
        return jobRepositories.findById(id);
    }
    public boolean isExist(String value) {
        // TODO Auto-generated method stub
        return false;
    }

    public Job getByString(String value) {
        // TODO Auto-generated method stub
        return null;
    }

}

package com.swp.swp.service;

import com.swp.swp.model.Job;

public interface JobServiceInterface {
    Iterable<Job> getAllJobs();
    String[] getJobDescription(int jobId);
    String[] getJobRequiment(int jobId);
    String[] getCompanyDescription(int jobId);
    Job getJob(int id);
    boolean insertJob(Job job, int companyId, int positionId);
}

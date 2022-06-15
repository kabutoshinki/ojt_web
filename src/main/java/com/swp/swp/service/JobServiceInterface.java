package com.swp.swp.service;

import com.swp.swp.model.Job;

public interface JobServiceInterface {
    String[] getJobDescription(int jobId);
    String[] getJobRequiment(int jobId);
    String[] getCompanyDescription(int jobId);
    boolean insertJob(Job job, int companyId, int positionId);
}

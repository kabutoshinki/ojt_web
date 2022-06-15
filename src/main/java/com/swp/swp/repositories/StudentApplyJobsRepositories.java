package com.swp.swp.repositories;

import com.swp.swp.model.Job;
import com.swp.swp.model.StudentApplyJobs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentApplyJobsRepositories extends JpaRepository<StudentApplyJobs,Integer> {
    StudentApplyJobs findById(int id);
    Iterable<StudentApplyJobs> findByJob(Job job);
}

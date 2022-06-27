package com.swp.swp.repositories;

import com.swp.swp.model.Job;
import com.swp.swp.model.StudentApplyJob;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentApplyJobsRepositories extends JpaRepository<StudentApplyJob,Integer> {
    StudentApplyJob findById(int id);
    Iterable<StudentApplyJob> findByJob(Job job);
    //Iterable <StudentApplyJob> findByAccount(Account account);
}

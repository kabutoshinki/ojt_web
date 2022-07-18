package com.swp.swp.service;

import java.util.ArrayList;

import com.swp.swp.database.Database;
import com.swp.swp.model.Student;
import com.swp.swp.model.StudentApplyJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp.swp.model.Company;
import com.swp.swp.model.Job;
import com.swp.swp.repositories.CompanyRepositories;
import com.swp.swp.repositories.JobRepositories;
import com.swp.swp.repositories.StudentApplyJobsRepositories;

@Service
public class StudentApplyJobsService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
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
        StudentApplyJob candidate = studentApplyJobsRepositories.findById(id);
        try {
            /*candidate.setStatus(status);*/
            studentApplyJobsRepositories.save(candidate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Iterable<StudentApplyJob> findAll() {
        Iterable<StudentApplyJob> candidates = studentApplyJobsRepositories.findAll();
        return candidates;
    }

    public Iterable<StudentApplyJob> findAllApplications() {
        Iterable<StudentApplyJob> candidates = studentApplyJobsRepositories.findAll();
        ArrayList <StudentApplyJob> applyList = new ArrayList<>();
        for (StudentApplyJob x: candidates) {
            if (x.getJob().getCompany().getAccount().getFullName().equals("External") == false) {
                applyList.add(x);
            }
        }
        return applyList;
    }

    public StudentApplyJob findById(int id) {
        return studentApplyJobsRepositories.findById(id);
    }

    public boolean isExist(String value) {
        // TODO Auto-generated method stub
        return false;
    }
    public Iterable<StudentApplyJob> findApplyByCompany(Company company){
        ArrayList<StudentApplyJob> candidatesList = new ArrayList<>();
        Iterable<Job> jobs = jobRepositories.findByCompany(company);
        for (Job job : jobs) {
            Iterable<StudentApplyJob> candidates= studentApplyJobsRepositories.findByJob(job);
            for (StudentApplyJob candidate : candidates) {
                if (candidate.getStatus().equalsIgnoreCase("waiting") == false &&
                    candidate.getStatus().equalsIgnoreCase("Denied") == false)
                        candidatesList.add(candidate);
            }
        }
        return candidatesList;
    }
    public Iterable<StudentApplyJob> findApplyByStudent(Student student){
        Iterable <StudentApplyJob> lst = studentApplyJobsRepositories.findByStudent(student);
        ArrayList <StudentApplyJob> applyList = new ArrayList<>();
        for (StudentApplyJob x: lst) {
            if (x.getJob().getStatus().equalsIgnoreCase("Hidden") == false) {
                applyList.add(x);
            }
        }
        return applyList;
    }

    public StudentApplyJob getByString(String value) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean save(StudentApplyJob newApplication) {
        try {
            logger.info("insert Data: " +  studentApplyJobsRepositories.save(newApplication));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
package com.swp.swp.service;

import com.swp.swp.database.Database;
import com.swp.swp.model.CV;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

@Service
public class JobService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Autowired
    JobRepositories jobRepositories;
    @Autowired
    CompanyRepositories companyRepositories;
    @Autowired
    PositionRepositories positionRepositories;

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
    public Iterable<Job> findAll() {
        Iterable<Job> jobs = jobRepositories.findAll();
        return jobs;
    }

    public Iterable<Job> findByCompany(Company company) {
        Iterable<Job> jobList = jobRepositories.findByCompany(company);
        return jobList;
    }

    public Job firstOfCompany(Company company) {
        Iterable<Job> jobList = jobRepositories.findByCompany(company);
        for (Job job: jobList) {
            return job;
        }
        return null;
    }

    public Iterable<Job> findAllActiveByCompany(Company company) {
        Iterable<Job> lst = jobRepositories.findByCompany(company);
        ArrayList<Job> jobList = new ArrayList<>();
        for (Job job: lst) {
            if (job.getStatus().equalsIgnoreCase("Inactive") == false && job.getStatus().equalsIgnoreCase("Hidden") == false) {
                jobList.add(job);
            }
        }
        return jobList;
    }

    public Iterable <Job> findAllAvailable() {
        Iterable<Job> temp = jobRepositories.findAll();
        ArrayList<Job> jobs = new ArrayList<>();
        java.util.Date date = new java.util.Date();
        java.sql.Date currentDate = new Date(date.getTime());

        for (Job x: temp) {
            if (x.getStatus().equals("Accepted") == true &&
                    x.getEndDate().compareTo(currentDate) >= 0 &&
                    x.getStartDate().compareTo(currentDate) <= 0 && x.getSlot() > 0) {
                jobs.add(x);
            }
        }
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

    public Double match(Job job, CV cv) {
        double percent = 0;
        HashSet<String> set = new HashSet();
        String temp = "";
        System.out.println(); System.out.println();
        System.out.println(job.getDescription());
        System.out.println(job.getRequirement());
        System.out.println(cv.getDescription());
        for (int i = 0; i < job.getDescription().length(); i++) {
            if (!Character.isLetter(job.getDescription().charAt(i))) {
                temp = temp.toLowerCase();
                set.add(temp);
                System.out.println(temp);
                temp = "";
            } else {
                temp += job.getDescription().charAt(i);
            }
        }
        if (!temp.isEmpty()) { set.add(temp); System.out.println(temp); }
        temp = "";
        for (int i = 0; i < job.getRequirement().length(); i++) {
            if (!Character.isLetter(job.getRequirement().charAt(i))) {
                temp = temp.toLowerCase();
                set.add(temp);
                System.out.println(temp);
                temp = "";
            } else {
                temp += job.getRequirement().charAt(i);
            }
        }
        if (!temp.isEmpty()) { set.add(temp); System.out.println(temp); }
        int matched = 0, total = 0;
        temp = "";
        for (int i = 0; i < cv.getDescription().length(); i++) {
            if (!Character.isLetter(cv.getDescription().charAt(i))) {
                temp = temp.toLowerCase();
                System.out.println(temp);
                if (set.contains(temp)) {
                    matched++;
                }
                total++;
                temp = "";
            } else {
                temp += cv.getDescription().charAt(i);
            }
        }
        if (!temp.isEmpty()) {
            System.out.println(temp);
            if (set.contains(temp)) {
                matched++;
            }
            total++;
        }
        return 1.0 * matched / total * 100;
    }
}

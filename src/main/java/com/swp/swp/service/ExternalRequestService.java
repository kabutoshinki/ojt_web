package com.swp.swp.service;

import com.swp.swp.database.Database;
import com.swp.swp.model.*;
import com.swp.swp.repositories.CompanyRepositories;
import com.swp.swp.repositories.ExternalRequestRepositories;
import com.swp.swp.repositories.JobRepositories;
import com.swp.swp.repositories.PositionRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
public class ExternalRequestService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Autowired JobRepositories jobRepositories;
    @Autowired
    CompanyRepositories companyRepositories;
    @Autowired PositionRepositories positionRepositories;
    @Autowired
    ExternalRequestRepositories externalRequestRepositories;

    public Iterable<ExternalRequest> findAll() {
        Iterable<ExternalRequest> request = externalRequestRepositories.findAll();
        return request;
    }

    public Iterable<ExternalRequest> findByStudent(Student student) {
        Iterable<ExternalRequest> requestList = externalRequestRepositories.findByStudent(student);
        return requestList;
    }


    public boolean save(ExternalRequest request) {
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\companies");
        try {
            logger.info("insert Data: " +  externalRequestRepositories.save(request));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ExternalRequest findById(int id) {
        return externalRequestRepositories.findById(id);
    }

    public Iterable<ExternalRequest> findRequestByStudent(Student student) {
        return externalRequestRepositories.findByStudent(student);
    }

}
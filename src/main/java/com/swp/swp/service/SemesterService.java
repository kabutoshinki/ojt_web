package com.swp.swp.service;

import com.swp.swp.database.Database;
import com.swp.swp.model.CV;
import com.swp.swp.model.Semester;
import com.swp.swp.repositories.CVRepositories;
import com.swp.swp.repositories.SemesterRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SemesterService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Autowired
    private SemesterRepositories semesterRepositories;

    public boolean save(Semester newSemester) {
        try {
            logger.info("insert Data: " +  semesterRepositories.save(newSemester));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Iterable<Semester> findAll() {
        Iterable<Semester> semesterList = semesterRepositories.findAll();
        return semesterList;
    }

    public Semester findById(int id) {
        Semester semester = semesterRepositories.findById(id);
        return semester;
    }

    public Semester currentSemester() {
        Semester semester = semesterRepositories.findTopByOrderByIdDesc();
        return semester;
    }
}
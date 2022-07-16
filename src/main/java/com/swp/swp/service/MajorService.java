package com.swp.swp.service;

import com.swp.swp.database.Database;
import com.swp.swp.model.Major;
import com.swp.swp.repositories.MajorRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class MajorService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Autowired
    private MajorRepositories majorRepositories;

    public boolean save(Major newMajor) {
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\companies");
        try {
            logger.info("insert Data: " +  majorRepositories.save(newMajor));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Iterable<Major> findAll() {
        Iterable<Major> majorList = majorRepositories.findAll();
        return majorList;
    }

    /*public Major findById(int id) {
        Major Major = MajorRepositories.findById(id);
        return Major;
    }*/

}
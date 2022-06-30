package com.swp.swp.service;

import com.swp.swp.database.Database;
import com.swp.swp.model.Account;
import com.swp.swp.model.CV;
import com.swp.swp.repositories.CVRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
public class CVService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Autowired
    private CVRepositories cvRepositories;

    public boolean save(CV newCV) {
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\companies");
        try {
            logger.info("insert Data: " +  cvRepositories.save(newCV));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Iterable<CV> getAll() {
        Iterable<CV> CVList = cvRepositories.findAll();
        return CVList;
    }

    /*public CV findById(int id) {
        CV CV = CVRepositories.findById(id);
        return CV;
    }*/
}

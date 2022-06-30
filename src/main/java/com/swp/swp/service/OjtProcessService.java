package com.swp.swp.service;

import com.swp.swp.database.Database;
import com.swp.swp.model.Account;
import com.swp.swp.model.Company;
import com.swp.swp.model.OjtProcess;
import com.swp.swp.repositories.CompanyRepositories;
import com.swp.swp.repositories.OjtProcessRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
public class OjtProcessService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Autowired
    private OjtProcessRepositories ojtProcessRepositories;

    public boolean save(OjtProcess ojtProcess) {
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\companies");
        try {
            logger.info("insert Data: " +  ojtProcessRepositories.save(ojtProcess));

            /*File file = new File(currentWorkingDir + "\\");
            file.createNewFile();
            System.out.println(file.exists());*/
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Iterable<OjtProcess> getAll() {
        Iterable<OjtProcess> OjtProcessList = ojtProcessRepositories.findAll();
        return OjtProcessList;
    }

    /*public OjtProcess findById(int id) {
        OjtProcess ojtProcess = ojtProcessRepositories.findById(id);
        return ojtProcess;
    }*/
}

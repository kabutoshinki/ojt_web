package com.swp.swp.service;

import com.swp.swp.database.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.swp.swp.model.Position;
import com.swp.swp.repositories.PositionRepositories;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PositionService {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Autowired
    private PositionRepositories positionRepositories;

    
    public PositionService(PositionRepositories positionRepositories) {
        this.positionRepositories = positionRepositories;
    }


    public boolean save(Position newPosition) {
        Path currentWorkingDir = Path.of(Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\static\\companies");
        try {
            logger.info("insert Data: " +  positionRepositories.save(newPosition));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean updateStatus(int id, String status) {
        // TODO Auto-generated method stub
        return false;
    }


    public Iterable<Position> getAll() {
        // TODO Auto-generated method stub
        return null;
    }


    public Position getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }


    public boolean isExist(String value) {
        // TODO Auto-generated method stub
        return false;
    }


    public Position getByString(String value) {
        // TODO Auto-generated method stub
        return null;
    }


   
    
}

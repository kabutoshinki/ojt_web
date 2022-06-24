package com.swp.swp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.swp.swp.model.Position;
import com.swp.swp.repositories.PositionRepositories;

public class PositionService {

    @Autowired
    private PositionRepositories positionRepositories;

    
    public PositionService(PositionRepositories positionRepositories) {
        this.positionRepositories = positionRepositories;
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

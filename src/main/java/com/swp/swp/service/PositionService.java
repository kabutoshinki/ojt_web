package com.swp.swp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.swp.swp.model.Job;
import com.swp.swp.model.Position;
import com.swp.swp.repositories.PositionRepositories;

public class PositionService implements PositionServiceInterface, CRUDInterface<Position> {

    @Autowired
    private PositionRepositories positionRepositories;

    
    public PositionService(PositionRepositories positionRepositories) {
        this.positionRepositories = positionRepositories;
    }


    @Override
    public boolean updateStatus(int id, String status) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public Iterable<Position> getAll() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Position getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public boolean isExist(String value) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public Position getByString(String value) {
        // TODO Auto-generated method stub
        return null;
    }


   
    
}

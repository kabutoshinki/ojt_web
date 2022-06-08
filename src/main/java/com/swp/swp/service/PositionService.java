package com.swp.swp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.swp.swp.model.Job;
import com.swp.swp.repositories.PositionRepositories;

public class PositionService implements PositionServiceInterface {

    @Autowired
    private PositionRepositories positionRepositories;

    
    public PositionService(PositionRepositories positionRepositories) {
        this.positionRepositories = positionRepositories;
    }


    @Override
    public Iterable<Job> jobs() {
        // TODO Auto-generated method stub
        return null;
    }
    
}

package com.swp.swp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swp.swp.model.Position;

public interface PositionRepositories extends JpaRepository<Position, Integer> {
    
}

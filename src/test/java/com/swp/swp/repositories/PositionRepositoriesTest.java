package com.swp.swp.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swp.swp.model.Position;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PositionRepositoriesTest {
    @Autowired private PositionRepositories positionRepositories;
    @Test
    void testFindById() {
        Iterable<Position> positionList = positionRepositories.findAll();

        for (Position position : positionList) {
            assertNotNull(positionRepositories.findById(position.getId()));
        }
    }
}

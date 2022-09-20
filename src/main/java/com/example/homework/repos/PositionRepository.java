package com.example.homework.repos;

import com.example.homework.models.Position;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PositionRepository extends CrudRepository <Position, Long> {

    List<Position>findByPositionNameContainingAndLocationContaining(String positionName, String LocationName);
}

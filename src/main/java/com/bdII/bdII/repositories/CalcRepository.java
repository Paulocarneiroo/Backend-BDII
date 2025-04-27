package com.bdII.bdII.repositories;

import com.bdII.bdII.entities.Calc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CalcRepository extends MongoRepository<Calc, Long> {
}

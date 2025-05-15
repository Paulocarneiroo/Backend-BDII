package com.bdII.bdII.repositories;

import com.bdII.bdII.entities.Calc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CalcRepository extends MongoRepository<Calc, Long> {
    List<Calc> findByUserId(Long userId);

    Optional<Calc> findByIdAndUserId(Long id, Long userId);

    void deleteAllByUserId(Long userId);

}

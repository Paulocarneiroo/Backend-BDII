package com.bdII.bdII.services;

import com.bdII.bdII.entities.Calc;
import com.bdII.bdII.repositories.CalcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CalcService {

    @Autowired
    private CalcRepository repository;

    public List<Calc> findAllCalculationsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public void deleteAllCalculationsByUserId(Long userId) {
        repository.deleteAllById(Collections.singleton(userId));
    }

    public boolean deleteCalcByUserIdAndCalcId(Long userId, Long calcId) {
        Optional<Calc> calcOptional = repository.findByIdAndUserId(calcId, userId);
        if (calcOptional.isPresent()) {
            repository.deleteById(calcId);
            return true;
        }
        return false;
    }

    public Calc save(Calc calc) {
        return repository.save(calc);
    }

}

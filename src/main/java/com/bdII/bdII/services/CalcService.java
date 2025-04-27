package com.bdII.bdII.services;

import com.bdII.bdII.entities.Calc;
import com.bdII.bdII.repositories.CalcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CalcService {

    @Autowired
    private CalcRepository repository;

    public List<Calc> findAllCalculationsByUserId(Long userId) {
        return repository.findAllById(Collections.singleton(userId));
    }

    public void deleteAllCalculationsByUserId(Long userId) {
        repository.deleteAllById(Collections.singleton(userId));
    }

    public Calc save(Calc calc) {
        return repository.save(calc);
    }

}

package com.bdII.bdII.controllers;

import com.bdII.bdII.entities.Calc;
import com.bdII.bdII.services.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calcs")
public class CalcController {

    @Autowired
    private CalcService service;

    @GetMapping("/{id}")
    public ResponseEntity<List<Calc>> findAllCalculationsByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAllCalculationsByUserId(id));
    }

    @PostMapping
    public ResponseEntity<Calc> insertCalc(@RequestBody Calc calc) {
        calc = service.save(calc);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(calc.getId()).toUri();

        return ResponseEntity.created(uri).body(calc);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAllCalculationsByUserId(@PathVariable Long id) {
        service.deleteAllCalculationsByUserId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}/{id}")
    public ResponseEntity<String> deleteCalc(@PathVariable Long userId, @PathVariable Long id) {
        boolean deleted = service.deleteCalcByUserIdAndCalcId(userId, id);
        if (deleted) {
            return ResponseEntity.ok("Cálculo deletado com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Cálculo não encontrado para o usuário informado.");
        }
    }
}
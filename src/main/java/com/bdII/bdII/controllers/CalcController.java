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
    public ResponseEntity<Optional<List<Calc>>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Calc> insertCalc(@PathVariable Long userId, @RequestBody Calc calc) {
        Optional<Calc> savedCalc = service.save(userId, calc);

        if (savedCalc.isPresent()) {
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(/* savedCalc.get().getId() */).toUri();

            return ResponseEntity.created(uri).body(savedCalc.get());
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
package com.bdII.bdII.controllers;

import com.bdII.bdII.entities.Medicine;
import com.bdII.bdII.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineService service;

    @GetMapping
    public ResponseEntity<List<Medicine>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Medicine>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Medicine> insert(@RequestBody Medicine medicine) {
        medicine = service.save(medicine);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(medicine.getId()).toUri();

        return ResponseEntity.created(uri).body(medicine);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Medicine> update(@PathVariable Long id,
                                           @RequestBody Medicine medicine){
        medicine = service.update(id, medicine);
        return ResponseEntity.ok(medicine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

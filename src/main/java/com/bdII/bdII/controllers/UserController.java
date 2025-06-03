package com.bdII.bdII.controllers;

import com.bdII.bdII.entities.User;
import com.bdII.bdII.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{email}")
    public ResponseEntity<Optional<User>> findById(@PathVariable String email) {
        return ResponseEntity.ok(service.findById(email));
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        user = service.save(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getEmail()).toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping(value = "/{email}")
    public ResponseEntity<User> update(@PathVariable String email, @RequestBody User user){
        user.setEmail(email);
        return ResponseEntity.ok(service.update(email, user));
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> delete(@PathVariable String email) {
        service.delete(email);
        return ResponseEntity.noContent().build();
    }
}
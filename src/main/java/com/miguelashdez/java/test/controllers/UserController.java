package com.miguelashdez.java.test.controllers;

import com.miguelashdez.java.test.models.entities.User;
import com.miguelashdez.java.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User entity, BindingResult result) {
        if (result.hasErrors()) {
            return this.validate(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }

    @GetMapping
    public ResponseEntity<?> read() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody User user, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return this.validate(result);
        }
        User currentUser = this.service.findById(id);
        if (currentUser == null) {
            return ResponseEntity.noContent().build();
        }
        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPassword(user.getPassword());
        currentUser.setPhones(user.getPhones());
        currentUser.setModified(new Date());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(currentUser));
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@RequestBody User user, @PathVariable Long id) {
        User currentUser = this.service.findById(id);
        if (currentUser == null) {
            return ResponseEntity.noContent().build();
        }
        currentUser.setIsActive(2);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(currentUser));
    }

    private ResponseEntity<?> validate(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(e -> {
            errors.put(e.getField(), e.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
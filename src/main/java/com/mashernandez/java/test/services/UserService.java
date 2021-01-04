package com.mashernandez.java.test.services;

import com.mashernandez.java.test.models.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User save(User entity);

    void deleteById(Long id);

}
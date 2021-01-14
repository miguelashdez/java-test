package com.miguelashdez.java.test.services;

import com.miguelashdez.java.test.models.entities.User;
import com.miguelashdez.java.test.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional()
    public User save(User entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional()
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
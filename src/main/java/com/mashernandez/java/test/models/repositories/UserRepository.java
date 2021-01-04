package com.mashernandez.java.test.models.repositories;

import com.mashernandez.java.test.models.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
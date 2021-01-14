package com.miguelashdez.java.test.models.repositories;

import com.miguelashdez.java.test.models.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
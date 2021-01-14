package com.miguelashdez.java.test;

import com.miguelashdez.java.test.models.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JavaTestApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateUserStatusCodeValue201() {
        User user = new User("Angel", "angel@mail.com", "01Angel");
        ResponseEntity<User> responseEntity = this.restTemplate.postForEntity("http://localhost:" + port + "/api/users", user, User.class);
        Assertions.assertEquals(201, responseEntity.getStatusCodeValue());
    }

    @Test
    void testCreateUserStatusCodeValue400() {
        User user = new User();
        ResponseEntity<User> responseEntity = this.restTemplate.postForEntity("http://localhost:" + port + "/api/users", user, User.class);
        Assertions.assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    void testReadUsersStatusCodeValue200() {
        ResponseEntity<User[]> responseEntity = this.restTemplate.getForEntity("http://localhost:" + port + "/api/users", User[].class);
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
    }

}
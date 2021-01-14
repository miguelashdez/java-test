package com.miguelashdez.java.test.controllers;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
class UserControllerTest {

    private static final String URL = "/api/users";
    private MockMvc mockMvc;
    private final UserController configurationController = new UserController();

    @Before
    public void beforeTest() {
        mockMvc = MockMvcBuilders.standaloneSetup(configurationController).build();
    }

    @Test
    public void shouldReturnHttpCode200OnGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturnHttpCode405OnPUT() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put(URL))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }

    @Test
    public void shouldReturnHttpCode400OnGetWithoutParameter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldReturnHttpCode400OnPostWithoutParameter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(URL))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
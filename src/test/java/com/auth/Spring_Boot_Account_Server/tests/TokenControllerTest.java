package com.auth.Spring_Boot_Account_Server.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TokenControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void attemptToGetTokenWithCredentialsNotInDb() throws Exception {
        String requestBody = "{\"name\": \"test\", \"password\": \"p\"}";

        this.mvc.perform(post("/token")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void attemptToGetTokenWithCorrectCredentials() throws Exception {
        String requestBody = "{\"name\": \"Bruce\", \"password\": \"password1\"}";

        this.mvc.perform(post("/token")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
    }





}

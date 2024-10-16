package com.auth.Spring_Boot_Account_Server.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RegisterControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void registerNewCustomer() throws Exception {{
        String requestBody = "{\"name\": \"NewUser\", \"email\": \"user@example.com\", \"password\": \"strong_password\"}";

        this.mvc.perform(post("/register")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isCreated());
    }}

    @Test
    void attemptToRegisterNewCustomerWithMissingDetails() throws Exception {{
            String requestBody = "{\"name\": \"NewUser\", \"email\": \"email@example.com\"}";

            this.mvc.perform(post("/register")
                            .contentType("application/json")
                            .content(requestBody))
                    .andExpect(status().isBadRequest());
    }}
}

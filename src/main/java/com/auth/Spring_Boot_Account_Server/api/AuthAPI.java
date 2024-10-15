package com.auth.Spring_Boot_Account_Server.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthAPI {

    @GetMapping("/")
    public String health(){ return "Authorisation Server is running.";}
}


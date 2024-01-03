package com.example.demobasicauth.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@SecurityRequirement(name = "bearerAuth") 
public class TestController {

    @GetMapping("/welcome")
    public String test() {
        return "welcome to spring security";
    }

    @GetMapping("/user")
    public String user() {
        return "Welcome to User";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome to Admin";
    }

    @GetMapping("/bye")
    public String bye() {
        return "Good bye!";
    }

}

package com.example.demobasicauth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUserRequest {
    private String name;
    private String email;
    private String password;
    private String role;
}

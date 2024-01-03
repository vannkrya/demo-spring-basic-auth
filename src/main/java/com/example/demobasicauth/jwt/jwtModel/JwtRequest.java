package com.example.demobasicauth.jwt.jwtModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtRequest {
    private String email;
    private String password;
}

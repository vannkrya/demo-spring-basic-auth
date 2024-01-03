package com.example.demobasicauth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppUserResponse<T> {
    private String message;
    private Integer status;
    private  T paylodad;
}

package com.example.demobasicauth.repository;

import com.example.demobasicauth.model.AppUser;
import com.example.demobasicauth.model.AppUserRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AppUserRepository {


    @Select("""
            SElECT * FROM users
            WHERE email = #{username}
            """)
    AppUser getByEmail(String username);

    @Select("""
            INSERT INTO users(name, email, password, role)
            VALUES(#{user.name}, #{user.email}, #{user.password}, #{user.role})
            RETURNING *
            """)
    AppUser insertUser(@Param("user") AppUserRequest appUserRequest);
}

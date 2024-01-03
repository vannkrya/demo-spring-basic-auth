package com.example.demobasicauth.service;

import com.example.demobasicauth.model.AppUser;
import com.example.demobasicauth.model.AppUserDto;
import com.example.demobasicauth.model.AppUserRequest;
import com.example.demobasicauth.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.getByEmail(username);
    }

    public AppUserDto insertUser(AppUserRequest appUserRequest) {
        appUserRequest.setPassword(passwordEncoder.encode(appUserRequest.getPassword()));
        AppUser appUser = appUserRepository.insertUser(appUserRequest);
        AppUserDto appUserDto = new AppUserDto();
        appUserDto.setId(appUser.getId());
        appUserDto.setName(appUser.getName());
        appUserDto.setEmail(appUser.getEmail());
        appUserDto.setRole(appUser.getRole());
        return appUserDto;
    }
}

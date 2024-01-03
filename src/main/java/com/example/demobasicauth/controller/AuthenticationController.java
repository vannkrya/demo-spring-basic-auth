package com.example.demobasicauth.controller;


import com.example.demobasicauth.jwt.JwtTokenUtil;
import com.example.demobasicauth.jwt.jwtModel.JwtRequest;
import com.example.demobasicauth.jwt.jwtModel.JwtResponse;
import com.example.demobasicauth.model.AppUserResponse;
import com.example.demobasicauth.model.AppUserDto;
import com.example.demobasicauth.model.AppUserRequest;
import com.example.demobasicauth.service.AppUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AppUserService appUserService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    public ResponseEntity<?> insertuser(@RequestBody AppUserRequest appUserRequest) {
        AppUserDto appUserDto = appUserService.insertUser(appUserRequest);
        AppUserResponse<AppUserDto> response = AppUserResponse.<AppUserDto>builder()
                .message("success")
                .status(200)
                .paylodad(appUserDto)
                .build();
        return ResponseEntity.ok().body(response);
    }


    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody JwtRequest jwtRequest) throws Exception {
        final UserDetails userDetails = appUserService.loadUserByUsername(jwtRequest.getEmail());
        try {
            authenticate(jwtRequest.getEmail(), jwtRequest.getPassword());
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid email or password");
        }
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}

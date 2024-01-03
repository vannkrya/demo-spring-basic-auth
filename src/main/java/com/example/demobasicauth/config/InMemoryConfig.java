//package com.example.demobasicauth.config;
//
//
//import com.example.demobasicauth.jwt.JwtTokenFilter;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@AllArgsConstructor
//public class InMemoryConfig {
//
////    private final PasswordEncoder passwordEncoder;
////
////    public InMemoryConfig(PasswordEncoder passwordEncoder) {
////        this.passwordEncoder = passwordEncoder;
////    }
////
////
////    @Bean
////    UserDetailsService userDetailsService() {
////        UserDetails user = User.builder()
////                .username("user")
////                .password(passwordEncoder.encode("123"))
////                .roles("USER")
////                .build();
////        UserDetails admin = User.builder()
////                .username("admin")
////                .roles("ADMIN")
////                .password(passwordEncoder.encode("1234"))
////                .build();
////        System.out.println(user.getPassword());
////        return new InMemoryUserDetailsManager(user, admin);
////    }
//
//    private final JwtTokenFilter jwtTokenFilter;
//
//    //security config file
//    @Bean
//    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers("/auth/register").permitAll()
//                        .requestMatchers("/auth/**").permitAll()
//                        .requestMatchers("/auth/**",
//                                "/auth/**",
//                                "/v3/api-docs/**",
//                                "/swagger-ui/**",
//                                "/swagger-ui.html").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
////                .formLogin().defaultSuccessUrl("/welcome", true)
////                .and()
////                .httpBasic();
//        return httpSecurity.build();
//    }
//}

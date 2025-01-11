//package com.abdala.demo.controller;
//
//import com.abdala.demo.repository.UserRepo;
//import com.abdala.demo.security.JwtTokenProvider;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    private final UserRepo userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtTokenProvider jwtTokenProvider;
//
//    public AuthController(UserRepo userRepository,
//                          PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @PostMapping("/register")
//    public String register(@RequestBody User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//        return "User registered successfully!";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody Map<String, String> credentials) {
//        String username = credentials.get("username");
//        String password = credentials.get("password");
//
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
//
//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            throw new RuntimeException("Invalid username or password");
//        }
//
//        return jwtTokenProvider.generateToken(username);
//    }
//}
//

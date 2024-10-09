package com.cda.college_direc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cda.college_direc.service.AuthenticationService;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> authenticateUser (@RequestBody LoginRequest loginRequest) {
        try {
            // Authenticate user and generate token
            String token = authenticationService.authenticate(loginRequest.getUsername(), loginRequest.getPassword(), loginRequest.getRole());
            return ResponseEntity.ok(new JwtResponse(token, true));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JwtResponse(null, false));
        }
    }
}

class LoginRequest {
    private String username;
    private String password;
    private String role;

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

class JwtResponse {
    private String token;
    private boolean success;

    public JwtResponse(String token, boolean success) {
        this.token = token;
        this.success = success;
    }

    // Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
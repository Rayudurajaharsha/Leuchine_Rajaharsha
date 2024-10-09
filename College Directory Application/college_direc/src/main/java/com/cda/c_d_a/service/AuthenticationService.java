package com.cda.college_direc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.cda.college_direc.model.User;
import com.cda.college_direc.repo.UserRepository;
import com.cda.college_direc.util.JwtUtil;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String authenticate(String username, String password, String role) throws Exception {
        try {
            // Authenticate the user using the authentication manager
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            // Fetch the user from the database
            User user = userRepository.findByUsernameAndRole(username, role);
            if (user == null) {
                throw new Exception("User  not found with username: " + username);
            }

            // Generate and return a JWT token
            return jwtUtil.generateToken(user.getUsername());
        } catch (AuthenticationException e) {
            throw new Exception("Invalid credentials", e);
        }
    }
}
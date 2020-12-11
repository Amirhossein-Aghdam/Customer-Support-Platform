package com.service.ticketing.api;

import com.service.ticketing.models.response.auth.AuthRequest;
import com.service.ticketing.models.response.auth.AuthResponse;
import com.service.ticketing.securityConfig.JWT.JWTProvider;
import com.service.ticketing.securityConfig.JWT.JWTUserDetailsService;
import com.service.ticketing.services.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("login")
public class AuthController {
    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JWTProvider jwtTokenUtil;

    @Autowired
    private JWTUserDetailsService jwtUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataService dataService;

    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authenticationRequest)
            throws IOException, ClassNotFoundException {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(username, password);
        try {
            authenticationManager.authenticate(token);
        } catch (BadCredentialsException e) {
            logger.error("Invalid credentials", e);
            throw e;
        }


        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        AuthResponse response = new AuthResponse(jwtTokenUtil.generateToken(userDetails)
                , username, dataService.loadRoleByUsername(username)
                , dataService.loadUserByUsername(username).getId());

        return ResponseEntity.ok(response);
    }
}

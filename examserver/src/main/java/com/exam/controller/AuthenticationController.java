package com.exam.controller;

import com.exam.entity.User;
import com.exam.security.model.AuthenticationRequest;
import com.exam.security.model.AuthenticationResponse;
import com.exam.security.service.MyUserDetailsService;
import com.exam.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/auth")
    public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User not Found");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Exception Occurred");
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            e.printStackTrace();
            throw new DisabledException("User Disabled");
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new BadCredentialsException("Invalid Credentials");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Exception Occurred");
        }
    }

    // returns the details of current logged in user
    @GetMapping("/current-users")
    public UserDetails getCurrentUser(Principal principal) {

        return this.myUserDetailsService.loadUserByUsername(principal.getName());
    }
}

package com.nil.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nil.dto.AuthRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

	 private final AuthenticationManager authenticationManager;

	    public AuthController(AuthenticationManager authenticationManager) {
	        this.authenticationManager = authenticationManager;
	    }

	    @PostMapping("/login")
	    public String login(@RequestBody AuthRequest request) {
	    	Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
	        );
	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        User user = (User) authentication.getPrincipal();
	        return "Login successful! Role: " + user.getAuthorities();
	    }
}

package com.microcredential.bankmanagement.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microcredential.bankmanagement.config.JwtTokenUtil;
import com.microcredential.bankmanagement.entity.JwtRequest;
import com.microcredential.bankmanagement.entity.JwtResponse;
import com.microcredential.bankmanagement.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@PostMapping("/authenticate")
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
		
		log.info("Inside createAuthenticationToken method");
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		
		log.info("Authentication token is generated : {}",token);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) {
		
		log.info("Inside authenticate method");
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new DisabledException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new DisabledException("INVALID_CREDENTIALS", e);
		}
	}
}

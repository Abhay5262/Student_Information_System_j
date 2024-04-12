package com.student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.reqresp.LoginRequest;
import com.student.reqresp.LoginResponce;
import com.student.userdetails.ProjectUserDetails;
import com.student.utils.JwtUtils;
@CrossOrigin("*")
@RestController
@RequestMapping("/auth")

public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ProjectUserDetails projectUserDetails;
	
	@Autowired
	private JwtUtils jwtUtils;
	

	
	@PostMapping("/login")
	public ResponseEntity<LoginResponce> loginWithCredentials(@RequestBody LoginRequest loginRequest)
	{
		try {
			projectUserDetails.setRole(loginRequest.getRole());
			
			Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEnrollmentNo(), loginRequest.getPassword()));
			
			System.err.println("authenticate -> "+authenticate.isAuthenticated());
			
			UserDetails userDetails = projectUserDetails.loadUserByUsername(loginRequest.getEnrollmentNo());
			
			String token = jwtUtils.generateToken(userDetails);
			
			System.err.println(userDetails);
			
			return new ResponseEntity<LoginResponce> (new LoginResponce(token),HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<LoginResponce> (new LoginResponce("Not Valid"),HttpStatus.OK);
		
	}
	
	
	@PostMapping("/validate")
	public ResponseEntity<String> ValidateToken()
	{
		return new ResponseEntity<String> ("JWT Token Working",HttpStatus.ACCEPTED);
	}
	

}

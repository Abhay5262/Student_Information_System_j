package com.student.reqresp;

import lombok.Data;

@Data
public class LoginRequest {
	
	private String enrollmentNo;
	
	private String password;
	
	private String role;

}

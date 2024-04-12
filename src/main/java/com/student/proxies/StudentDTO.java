package com.student.proxies;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	
	private String enrollmentNo;
	
	private String password;
	
	private String name;
	
	private String gender;
	
	private Date dob;
	
	private String branch;
	
	private String contact;
	
	private String address;
	
	private String city;
	
	private Integer pinCode;
	
	private String securityKey;
	
	private String role;

}

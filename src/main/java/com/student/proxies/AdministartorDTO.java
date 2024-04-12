package com.student.proxies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdministartorDTO {
	
	private Long id;
	
	private String password;
	
	private String name;
	
	private String gender;
	
	private String contact; 
	
	private String address;
	
	private String city;
	
	private String pinCode;
	
	private String securityKey; 
	
	private String role;

}

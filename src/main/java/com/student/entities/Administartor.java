package com.student.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administartor {
	
	@Id
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

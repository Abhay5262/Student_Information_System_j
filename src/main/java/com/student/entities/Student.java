package com.student.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
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

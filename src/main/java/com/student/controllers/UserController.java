package com.student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.proxies.EducationDetailsDTO;
import com.student.proxies.FeeDetailsDTO;
import com.student.proxies.StudentDTO;
import com.student.services.EducationDetailsServices;
import com.student.services.FeeDetailsServices;
import com.student.services.StudentServices;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private StudentServices studentServices;
	
	@Autowired
	private FeeDetailsServices feeDetailsServices;
	
	@Autowired
	private EducationDetailsServices educationDetailsServices;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerWithDetails(@RequestBody StudentDTO studentDTO)
	{
		return new ResponseEntity<String>(studentServices.studentRegister(studentDTO),HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/updateUser")
	public ResponseEntity<String> updateUserDetails(@RequestBody StudentDTO studentDTO)
	{
		return new ResponseEntity<String> (studentServices.updateUser(studentDTO),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getUser/{enrollmentNo}")
	public ResponseEntity<StudentDTO> getUser(@PathVariable String enrollmentNo)
	{ 
		return new ResponseEntity<StudentDTO> (studentServices.getUser(enrollmentNo),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getFeeDetails/{id}")
	public ResponseEntity<FeeDetailsDTO> getFeeDetails(@PathVariable Long id)
	{
		return new ResponseEntity<FeeDetailsDTO> (feeDetailsServices.getFeeDetails(id),HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/addEducationDetails")
	public ResponseEntity<String> addEducationDetails(@RequestBody EducationDetailsDTO educationDetailsDTO)
	{
		return new ResponseEntity<String>(educationDetailsServices.addEducationDetails(educationDetailsDTO),HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/updateEducationDetails")
	public ResponseEntity<String> updateEducationDetails(@RequestBody EducationDetailsDTO educationDetailsDTO)
	{
		return new ResponseEntity<String> (educationDetailsServices.updateEducationDetails(educationDetailsDTO),HttpStatus.ACCEPTED);
	}

}

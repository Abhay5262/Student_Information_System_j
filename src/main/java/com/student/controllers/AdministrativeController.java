package com.student.controllers;

import java.util.List;

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

import com.student.proxies.AdministartorDTO;
import com.student.proxies.EducationDetailsDTO;
import com.student.proxies.FeeDetailsDTO;
import com.student.proxies.StudentDTO;
import com.student.services.AdministartorServices;
import com.student.services.EducationDetailsServices;
import com.student.services.FeeDetailsServices;
import com.student.services.StudentServices;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdministrativeController {
	
	@Autowired
	private AdministartorServices administartorServices;
	
	@Autowired
	private FeeDetailsServices feeDetailsServices;
	
	@Autowired
	private StudentServices studentServices;
	
	@Autowired
	private EducationDetailsServices educationDetailsServices;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerWithDetails(@RequestBody AdministartorDTO administartorDTO)
	{
		System.err.println("admin register");
		return new ResponseEntity<String>(administartorServices.AdministartorRegister(administartorDTO),HttpStatus.OK);
	}
	
	
	@PostMapping("/updateUserDetails")
	public ResponseEntity<String> updateUserDetails(@RequestBody StudentDTO studentDTO)
	{
		return new ResponseEntity<String> (studentServices.updateUser(studentDTO),HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/updateAdmin")
	public ResponseEntity<String> updateAdminDetails(@RequestBody AdministartorDTO administartorDTO)
	{
		return new ResponseEntity<String> (administartorServices.updateAdmin(administartorDTO),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/deleteUser/{enrollmentNo}")
	public ResponseEntity<String> deleteUser(@PathVariable String enrollmentNo)
	{
		return new ResponseEntity<String> (administartorServices.deleteUser(enrollmentNo),HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<StudentDTO>> getUsers()
	{
		return new ResponseEntity<List<StudentDTO>> (administartorServices.getAllUser(),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getUser/{enrollmentNo}")
	public ResponseEntity<StudentDTO> getUser(@PathVariable String enrollmentNo)
	{
		return new ResponseEntity<StudentDTO>(studentServices.getUser(enrollmentNo),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getAdmin/{id}")
	public ResponseEntity<AdministartorDTO> getAdmin(@PathVariable Long id)
	{
		return new ResponseEntity<AdministartorDTO> (administartorServices.getAdmin(id),HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/addFeeDetails")
	public ResponseEntity<String> addFeeDetails(@RequestBody FeeDetailsDTO feeDetailsDTO)
	{
		return new ResponseEntity<String>(feeDetailsServices.addFeeDetails(feeDetailsDTO),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getFeeDetails/{id}")
	public ResponseEntity<FeeDetailsDTO> getFeeDetails(@PathVariable Long id)
	{
		return new ResponseEntity<FeeDetailsDTO>(feeDetailsServices.getFeeDetails(id),HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/getEducationDetails/{id}")
	public ResponseEntity<EducationDetailsDTO> GetEducationDetails(@PathVariable Long id)
	{
		return new ResponseEntity<EducationDetailsDTO> (educationDetailsServices.getEducationDetails(id),HttpStatus.ACCEPTED);
	}

}

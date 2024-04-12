package com.student.services;

import org.springframework.stereotype.Service;

import com.student.proxies.StudentDTO;

@Service
public interface StudentServices {

	public String studentRegister(StudentDTO studentDTO);

	public String updateUser(StudentDTO studentDTO);

	public StudentDTO getUser(String enrollmentNo);

}

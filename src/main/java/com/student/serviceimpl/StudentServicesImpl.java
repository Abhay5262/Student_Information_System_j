package com.student.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.entities.Student;
import com.student.proxies.StudentDTO;
import com.student.repositories.StudentRepo;
import com.student.services.StudentServices;
import com.student.utils.Helper;

@Component
public class StudentServicesImpl implements StudentServices {
	
	@Autowired
	private StudentRepo studentRepo;
	
	
	public String studentRegister(StudentDTO studentDTO)
	{
		Student student = Helper.dtotoentity(studentDTO);
		
		student.setRole("ROLE_USER");
		
		studentRepo.save(student);
		
		return "Student Registration Successfully";
	}


	@Override
	public String updateUser(StudentDTO studentDTO) 
	{
		Optional<Student> byId = studentRepo.findById(studentDTO.getEnrollmentNo());
		
		if(byId.isPresent())
		{
			Student student=byId.get();
			
			Student stu = new Student(studentDTO.getEnrollmentNo(), studentDTO.getPassword(), studentDTO.getName(), studentDTO.getGender(), studentDTO.getDob(), studentDTO.getBranch(), studentDTO.getContact(), studentDTO.getAddress(), studentDTO.getCity(), studentDTO.getPinCode(), studentDTO.getSecurityKey(), studentDTO.getRole());
			
			studentRepo.save(stu);
			
			return "Data Update Successfully";
		}
		return "Data not Saved";
	}

	
	public StudentDTO getUser(String enrollmentNo)
	{
		Student student  = studentRepo.findById(enrollmentNo).get();
		
		StudentDTO studentDTO = Helper.entitytodto(student);
		
		return studentDTO;
	}

}

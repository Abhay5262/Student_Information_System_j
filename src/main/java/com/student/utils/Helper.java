package com.student.utils;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.entities.Administartor;
import com.student.entities.EducationDetails;
import com.student.entities.FeeDetails;
import com.student.entities.Student;
import com.student.proxies.AdministartorDTO;
import com.student.proxies.EducationDetailsDTO;
import com.student.proxies.FeeDetailsDTO;
import com.student.proxies.StudentDTO;

@Component
public class Helper {
	
	public static AdministartorDTO entitytodto(Administartor administartor)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(administartor, AdministartorDTO.class);
	}
	
	public static Administartor dtotoentity(AdministartorDTO administartorDTO)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(administartorDTO, Administartor.class);
	}
	
	
	public static EducationDetailsDTO entitytodto(EducationDetails educationDetails)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(educationDetails, EducationDetailsDTO.class);
	}
	
	public static EducationDetails dtotoentity(EducationDetailsDTO educationDetailsDTO)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(educationDetailsDTO, EducationDetails.class);
	}
	
	
	public static FeeDetailsDTO entitytodto(FeeDetails feeDetails)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(feeDetails, FeeDetailsDTO.class);
	}
	
	public static FeeDetails dtotoentity(FeeDetailsDTO feeDetailsDTO)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(feeDetailsDTO, FeeDetails.class);
	}

	
	public static StudentDTO entitytodto(Student student)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(student, StudentDTO.class);
	}
	
	public static Student dtotoentity(StudentDTO studentDTO)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(studentDTO, Student.class);
	}

}

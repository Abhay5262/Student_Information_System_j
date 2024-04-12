package com.student.services;

import org.springframework.stereotype.Service;

import com.student.proxies.EducationDetailsDTO;

@Service
public interface EducationDetailsServices {

	public String addEducationDetails(EducationDetailsDTO educationDetailsDTO);

	public String updateEducationDetails(EducationDetailsDTO educationDetailsDTO);

	public EducationDetailsDTO getEducationDetails(Long id);

}

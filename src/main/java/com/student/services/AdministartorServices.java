package com.student.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.proxies.AdministartorDTO;
import com.student.proxies.StudentDTO;

@Service
public interface AdministartorServices {

	public String AdministartorRegister(AdministartorDTO administartorDTO);

	public String updateAdmin(AdministartorDTO administartorDTO);

	public AdministartorDTO getAdmin(Long id);

	public String deleteUser(String enrollmentNo);

	public List<StudentDTO> getAllUser();

}

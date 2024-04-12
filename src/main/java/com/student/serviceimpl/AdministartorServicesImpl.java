package com.student.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.entities.Administartor;
import com.student.entities.Student;
import com.student.proxies.AdministartorDTO;
import com.student.proxies.StudentDTO;
import com.student.repositories.AdministartorRepo;
import com.student.repositories.EducationDetailsRepo;
import com.student.repositories.StudentRepo;
import com.student.services.AdministartorServices;
import com.student.utils.Helper;


@Component
public class AdministartorServicesImpl implements AdministartorServices {

	@Autowired 
	private AdministartorRepo administartorRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private EducationDetailsRepo educationDetailsRepo;
	
	
	public String AdministartorRegister(AdministartorDTO administartorDTO)
	{
		Administartor administartor = Helper.dtotoentity(administartorDTO);
		
		administartorRepo.save(administartor);
		
		return "User Registration Successfully";
	}
	
	public String updateAdmin(AdministartorDTO administartorDTO)
	{
		Optional<Administartor> byId = administartorRepo.findById(administartorDTO.getId());
		
		if(byId.isPresent())
		{
			Administartor administartor=byId.get();
			
			Administartor dtotoentity = Helper.dtotoentity(administartorDTO);
			administartorRepo.save(dtotoentity);
			
			return "Data Update Successfully";
		}
		return "Data not Saved";
	}
	
	public AdministartorDTO getAdmin(Long id)
	{
		Administartor administartor = administartorRepo.findById(id).get();
		
		AdministartorDTO administartorDTO = Helper.entitytodto(administartor);
		
		return administartorDTO;
	}


	public String deleteUser(String enrollmentNo) 
	{
		studentRepo.deleteById(enrollmentNo);
			
		return "Delete SuccessFully";
	}
	
	
	public List<StudentDTO> getAllUser()
	{
		List<Student> studentlist = studentRepo.findAll();
		
		List<StudentDTO> dtolist = new ArrayList<>();
		
		for(Student student:studentlist)
		{
			StudentDTO dto=new StudentDTO(student.getEnrollmentNo(),student.getPassword(),
					student.getName(),student.getGender(),student.getDob(),student.getBranch(),
					student.getContact(),student.getAddress(),student.getCity(),
					student.getPinCode(),student.getSecurityKey(),student.getRole());
			
			dtolist.add(dto);
		}
		return dtolist;
	}
	
	
	
	
}

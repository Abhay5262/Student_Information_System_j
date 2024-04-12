package com.student.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.entities.EducationDetails;
import com.student.proxies.EducationDetailsDTO;
import com.student.repositories.EducationDetailsRepo;
import com.student.services.EducationDetailsServices;
import com.student.utils.Helper;

@Component
public class EducationDetailsServicesImpl implements EducationDetailsServices {
	
	@Autowired
	private EducationDetailsRepo educationDetailsRepo;
	
	public String addEducationDetails(EducationDetailsDTO educationDetailsDTO)
	{
		EducationDetails educationDetails = Helper.dtotoentity(educationDetailsDTO);
		
		educationDetailsRepo.save(educationDetails);
		
		return "EducationDetails Registration Successfully";
	}

	@Override
	public String updateEducationDetails(EducationDetailsDTO educationDetailsDTO) 
	{
		Optional<EducationDetails> byId = educationDetailsRepo.findById(educationDetailsDTO.getId());
		
		if(byId.isPresent())
		{
			EducationDetails educationDetails=byId.get();
			
			EducationDetails education = new EducationDetails(educationDetailsDTO.getId(), educationDetailsDTO.getStudent_enrollmentNo(), educationDetailsDTO.getEducationType(), educationDetailsDTO.getPercentage(), educationDetailsDTO.isQualified(), educationDetailsDTO.getUpdatedBy(), educationDetailsDTO.getUpdatedDate());
			
			educationDetailsRepo.save(education);
			
			return "Data Update Successfully";
		}
		return "Data not Saved";
	}

	@Override
	public EducationDetailsDTO getEducationDetails(Long id)
	{
		Optional<EducationDetails> byId = educationDetailsRepo.findById(id);
		
		if(byId.isPresent())
		{
			EducationDetails educationDetails = byId.get();
			
			return Helper.entitytodto(educationDetails);
		}
		return null;
	}
}


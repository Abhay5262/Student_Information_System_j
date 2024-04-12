package com.student.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.entities.FeeDetails;
import com.student.proxies.FeeDetailsDTO;
import com.student.repositories.FeeDetailsRepo;
import com.student.services.FeeDetailsServices;
import com.student.utils.Helper;

@Component
public class FeeDetailsServicesImpl implements FeeDetailsServices {
	
	@Autowired
	private FeeDetailsRepo feeDetailsRepo;
	
	public FeeDetailsDTO getFeeDetails(Long id)
	{
		FeeDetails feeDetails = feeDetailsRepo.findById(id).get();
		
		FeeDetailsDTO feeDetailsDTO = Helper.entitytodto(feeDetails);
		
		return feeDetailsDTO;
	}
	
	
	public String addFeeDetails(FeeDetailsDTO feeDetailsDTO)
	{
		FeeDetails feeDetails = Helper.dtotoentity(feeDetailsDTO);
		
		feeDetailsRepo.save(feeDetails);
		
		return "FeeDetails Registration Successfully";
	}
	


}

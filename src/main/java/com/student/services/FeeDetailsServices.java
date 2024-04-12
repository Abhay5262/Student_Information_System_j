package com.student.services;

import org.springframework.stereotype.Service;

import com.student.proxies.FeeDetailsDTO;

@Service
public interface FeeDetailsServices {

	public FeeDetailsDTO getFeeDetails(Long id);

	public String addFeeDetails(FeeDetailsDTO feeDetailsDTO);

}

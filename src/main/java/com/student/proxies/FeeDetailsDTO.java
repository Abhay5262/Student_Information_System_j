package com.student.proxies;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeDetailsDTO {
	
	private long id;
	
	private String student_enrollmentNo;
	
	private double feeAmount;
	
	private Date dueDate;
	
	private String updatedBy; 

	private Date updatedDate;

}

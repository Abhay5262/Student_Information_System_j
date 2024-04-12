package com.student.proxies;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDetailsDTO {
	
	private long id;
	
	private String student_enrollmentNo;
	
	private String educationType;
	
	private String percentage;
	
	private boolean qualified;
	
	private String updatedBy;
	
	private Date updatedDate;

}

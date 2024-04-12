package com.student.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDetails {
	
	@Id
	private long id;
	
	private String student_enrollmentNo;
	
	private String educationType;
	
	private String percentage;
	
	private boolean qualified;
	
	private String updatedBy;
	
	private Date updatedDate;

}

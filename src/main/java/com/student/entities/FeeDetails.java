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
public class FeeDetails {
	
	@Id
	private long id;
	
	private String student_enrollmentNo;
	
	private double feeAmount;
	
	private Date dueDate;
	
	private String updatedBy; 

	private Date updatedDate;

}

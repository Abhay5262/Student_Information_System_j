package com.student.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormatException {
	
	private String exceptionMessage;
	private String exceptionCode;
	private String date;
}

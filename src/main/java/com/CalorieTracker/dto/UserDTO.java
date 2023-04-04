package com.CalorieTracker.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDTO {

	
	private String name;
	
	private String weight;
	
	private String height;
	
	private String gender;
	
	private LocalDate age;
	
}

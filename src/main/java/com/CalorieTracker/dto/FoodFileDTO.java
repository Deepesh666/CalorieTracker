package com.CalorieTracker.dto;

import lombok.Data;

@Data
public class FoodFileDTO {
	
	
	private Long id;

	private Long serialNumber;
	
	private String foodName;
	
	private String foodGroup;
	
	private Long calories;
	
	private Double fat;
	
	private Double protein;
	
	private Double carbohydrate;
	
	private String servingDescription;
	
}

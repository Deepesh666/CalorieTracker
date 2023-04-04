package com.CalorieTracker.dto;

import lombok.Data;

@Data
public class FoodUserByDateDTO {
	
	private Long userId;
	
	private Long foodGroupId;
	
	private Long foodFileId;

}

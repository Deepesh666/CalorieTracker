package com.CalorieTracker.service;


public interface FoodUserByDateService {

	String showDataForAddFood();
	
	String addFoodUserDataByDateTime(Long userId, Long foodId, Long foodGroupId);
	
}

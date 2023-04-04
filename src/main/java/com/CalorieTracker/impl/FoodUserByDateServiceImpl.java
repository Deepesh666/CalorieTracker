package com.CalorieTracker.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CalorieTracker.constants.UserFoodMetByDateConstants;
import com.CalorieTracker.model.FoodUserByDate;
import com.CalorieTracker.repository.FoodFileRepository;
import com.CalorieTracker.repository.FoodGroupRepository;
import com.CalorieTracker.repository.FoodUserByDateRepository;
import com.CalorieTracker.repository.UserRepository;
import com.CalorieTracker.service.FoodUserByDateService;

@Service
public class FoodUserByDateServiceImpl implements FoodUserByDateService{

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FoodUserByDateRepository foodUserByDateRepository;
	
	@Autowired
	FoodGroupRepository foodGroupRepository;
	
	@Autowired
	FoodFileRepository foodFileRepository;
	
	
	
	@Override
	public String addFoodUserDataByDateTime(Long userId, Long foodId, Long foodGroupId) {
		System.err.println("::: FoodUserByDateServiceImpl.addFoodUserDataByDateTime ::: ");
		String returndata = "";
		FoodUserByDate foodUserByDate = new FoodUserByDate();
		System.out.println("userId :::: " + userId);
		if(userId != null) {
			
			foodUserByDate.setConsumingDate(LocalDate.now());
			
			foodUserByDateRepository.save(foodUserByDate);
			
			
		returndata = UserFoodMetByDateConstants.FOOD_ADDED_SUCCESSFULLY_FOR_THE_SELECTED_USER.getValue();
		}else {
			returndata = UserFoodMetByDateConstants.API_FACING_ISSUE_WHILE_ADDING_FOOD.getValue();
		}
		return returndata;
	}



	@Override
	public String showDataForAddFood() {
		// TODO Auto-generated method stub
		return null;
	}

}

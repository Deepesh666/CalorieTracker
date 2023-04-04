package com.CalorieTracker.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CalorieTracker.bean.ResultDTO;
import com.CalorieTracker.constants.UserFoodMetByDateConstants;
import com.CalorieTracker.service.FoodUserByDateService;

@RestController
@RequestMapping("/api")
public class FoodUserByDateRestController {
	
	@Autowired
	FoodUserByDateService foodUserByDateService;

	
	@GetMapping("/addFoodDetailsByDate")
	ResponseEntity<?> addFoodDetails(@PathVariable Long userId, Long foodId, Long foodGroupId){
		System.err.println("::: FoodUserByDateRestController.addFoodDetails ::: ");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(null, foodUserByDateService.addFoodUserDataByDateTime(userId, foodId, foodGroupId) , true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		}catch (Exception e) {
			responsePacket = new ResultDTO<>(UserFoodMetByDateConstants.API_FACING_ISSUE_WHILE_ADDING_FOOD.getValue(), e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
}

package com.CalorieTracker.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CalorieTracker.bean.ResultDTO;
import com.CalorieTracker.constants.FoodGroupConstants;
import com.CalorieTracker.service.FoodGroupService;


@RestController
@RequestMapping("/api")
public class FoodGroupRestController {

	
	@Autowired
	FoodGroupService foodGroupService;
	
	
	@GetMapping("/viewAllFoodGrupData")
	ResponseEntity<?> findAllUsersData(){
		System.err.println("::: FoodGroupRestController.findAllUsersData ::: ");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(foodGroupService.allFoodGroupData(), FoodGroupConstants.FOOD_GROUP_DATA_FETCHED_SUCCESSFULLY.getValue(), true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		}catch (Exception e) {
			responsePacket = new ResultDTO<>(FoodGroupConstants.FACING_ISSUE_WHILE_WORKING_WITH_API.getValue(), e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/addFoodGroupData")
	ResponseEntity<?> addFoodGroupData(){
		System.err.println("::: FoodGroupRestController.addFoodGroupData ::: ");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(foodGroupService.addingFoodGroup(), FoodGroupConstants.FOOD_GROUP_DATA_ADDED_SUCCESSFULLY.getValue(), true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		}catch (Exception e) {
			responsePacket = new ResultDTO<>(FoodGroupConstants.FACING_ISSUE_WHILE_WORKING_WITH_API.getValue(), e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
}

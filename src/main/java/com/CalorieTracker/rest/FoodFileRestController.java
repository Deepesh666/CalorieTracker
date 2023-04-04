package com.CalorieTracker.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.CalorieTracker.bean.ResultDTO;
import com.CalorieTracker.constants.FoodFileConstants;
import com.CalorieTracker.service.FoodFileService;
import com.CalorieTracker.service.FoodGroupService;

@RestController
@RequestMapping("/api")
public class FoodFileRestController {

	@Autowired
	FoodFileService foodFileService;
	
	@Autowired
	FoodGroupService foodGroupService;
	
	@PostMapping("/readOrUpdateFoodFile")
	ResponseEntity<?> readOrUpdateFoodFileData(@RequestParam("file") MultipartFile multipartFile){
		System.err.println("::: FoodFileRestController.readOrUpdateFoodFile ::: ");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(null, foodFileService.SaveOrUpdateFoodFile(multipartFile) +","+ foodGroupService.addingFoodGroup(), true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		}catch (Exception e) {
			responsePacket = new ResultDTO<>(FoodFileConstants.FACING_ISSUE_IN_API_WHILE_PROCESSING.getValue(), e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/viewAllFoodFileData")
	ResponseEntity<?> findAllUsersData(){
		System.err.println("::: FoodFileRestController.readOrUpdateFoodFile ::: ");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(foodFileService.allFoodFileData(), FoodFileConstants.SUCCESSFULLY_FETCHED_ALL_THE_RECORD.getValue(), true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		}catch (Exception e) {
			responsePacket = new ResultDTO<>(FoodFileConstants.FACING_ISSUE_IN_API_WHILE_PROCESSING.getValue(), e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
}

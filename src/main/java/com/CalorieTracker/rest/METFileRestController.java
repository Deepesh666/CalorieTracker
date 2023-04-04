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
import com.CalorieTracker.constants.METFileConstants;
import com.CalorieTracker.service.METFileService;

@RestController
@RequestMapping("/api")
public class METFileRestController {
	
	@Autowired
	METFileService metFileService;

	@PostMapping("/readOrUpdateMETFile")
	ResponseEntity<?> readOrUpdateFoodFileData(@RequestParam("file") MultipartFile multipartFile){
		System.err.println("::: METFileRestController.readOrUpdateFoodFileData ::: ");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(null, metFileService.SaveOrUpdateMETFile(multipartFile) , true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		}catch (Exception e) {
			responsePacket = new ResultDTO<>(METFileConstants.FACING_ISSUE_IN_API_WHILE_PROCESSING.getValue(), e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/viewAllMetFileData")
	ResponseEntity<?> findAllUsersData(){
		System.err.println("::: METFileRestController.viewAllMetFileData ::: ");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(metFileService.allMetFileData(), METFileConstants.ALL_MET_FILE_DATA_FETCHED_SUCCESSFULLY.getValue(), true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		}catch (Exception e) {
			responsePacket = new ResultDTO<>(METFileConstants.FACING_ISSUE_IN_API_WHILE_PROCESSING.getValue(), e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
}

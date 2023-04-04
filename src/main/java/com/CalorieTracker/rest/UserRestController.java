package com.CalorieTracker.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CalorieTracker.bean.ResultDTO;
import com.CalorieTracker.constants.UserConstants;
import com.CalorieTracker.model.User;
import com.CalorieTracker.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	UserService userService;
	

	@PostMapping("/addUser")
	ResponseEntity<?> addUserDetails(@RequestBody User user){
		System.err.println("::: UserRestController.addUserDetails ::: ");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(null, userService.findUserIfExistOrAddUser(user), true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		}catch (Exception e) {
			responsePacket = new ResultDTO<>(UserConstants.API_FACING_SOME_ISSUE_DUE_TO_EMPLTY_DATA.getValue(), e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/viewAllUsers")
	ResponseEntity<?> findAllUsersData(){
		System.err.println("::: UserRestController.findAllUsersData ::: ");
		ResultDTO<?> responsePacket = null;
		try {
			responsePacket = new ResultDTO<>(userService.findAllUserDetails(), UserConstants.USER_RECORD_FETCHED_SUCCESSFULLY.getValue(), true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		}catch (Exception e) {
			responsePacket = new ResultDTO<>(UserConstants.API_FACING_SOME_ISSUE_DUE_TO_EMPLTY_DATA.getValue(), e.getMessage(), false);
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
}

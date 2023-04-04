package com.CalorieTracker.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CalorieTracker.repository.UserFoodMetByDateRepository;

@RestController
@RequestMapping("/api/UserFoodMetByDate")
public class UserFoodMetByDateRestController {

	
	@Autowired
	UserFoodMetByDateRepository userFoodMetByDateRepository;
	
	
	
	
}

package com.CalorieTracker.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CalorieTracker.dto.UserDTO;
import com.CalorieTracker.model.FoodFile;
import com.CalorieTracker.model.FoodGroup;
import com.CalorieTracker.model.METFile;
import com.CalorieTracker.model.User;
import com.CalorieTracker.service.RestService;
import com.CalorieTracker.service.UserService;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	RestService restService;
	
	
	@GetMapping(value = "/")
	public ModelAndView signUp() {
		System.err.println("::: UserController.signUp ::: ");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("sign-up");
		return modelAndView;
	}
	
	@PostMapping(value = "/saveUserInput")
	public String saveUserInput(@ModelAttribute UserDTO userDTO, RedirectAttributes redirect,
			 HttpSession session) {
		System.err.println("::: UserController.saveUserInput ::: ");
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(userDTO, User.class);
		restService.userInputData(user);
		return "redirect:/allUserData";
	}
	
	@GetMapping(value = "/allUserData")
	public ModelAndView allUserData() {
		System.err.println("::: UserController.allUserData ::: ");
		ModelAndView modelAndView = new ModelAndView();
		List<User> userList = null;
		List<FoodFile> foodFileList = null;
		List<METFile> metFileList = null;
		List<FoodGroup> foodGroupList = null;
		
		Gson gson = new Gson(); 
		
		String user = restService.allUserData();
		String foodGroup = restService.fetchFoodGrupData();
		String foodFile = restService.showAllFoodFileData();
		String metFile = restService.showAllMetFileData();
		
		user = restService.dataFormatter(user);
		foodGroup = restService.dataFormatter(foodGroup);
		foodFile = restService.dataFormatter(foodFile);
		metFile = restService.dataFormatter(metFile);
		
		User[] userArray = gson.fromJson(user, User[].class);
		FoodFile[] foodFileArray = gson.fromJson(foodFile, FoodFile[].class);
		FoodGroup[] foodGroupArray = gson.fromJson(foodGroup, FoodGroup[].class);
		METFile[] metFileArray = gson.fromJson(metFile, METFile[].class);

		
		userList = Arrays.asList(userArray);
		foodFileList = Arrays.asList(foodFileArray);
		foodGroupList = Arrays.asList(foodGroupArray);
		metFileList = Arrays.asList(metFileArray);
		
		
		modelAndView.addObject("userList", userList);
		modelAndView.addObject("foodFileList", foodFileList);
		modelAndView.addObject("foodGroupList", foodGroupList);
		modelAndView.addObject("metFileList", metFileList);
		
		
		if(StringUtils.isBlank(foodGroup)) {
			System.out.println(restService.addingFoodGroupData());
			restService.addingFoodGroupData();
		}
		
		
		modelAndView.setViewName("user-list");
		return modelAndView;
	}
	
}

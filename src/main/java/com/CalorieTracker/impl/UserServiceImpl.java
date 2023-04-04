package com.CalorieTracker.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CalorieTracker.constants.UserConstants;
import com.CalorieTracker.model.User;
import com.CalorieTracker.repository.UserRepository;
import com.CalorieTracker.service.UserService;



@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public String findUserIfExistOrAddUser(User user) {
		System.err.println("::: UserServiceImpl.findUserIfExistOrAddUser ::: ");
		System.out.println("user :::: "+ user);
		String returnData = "";
		User userData = userRepository.findByName(user.getName());
		if(userData != null && userData.getName().equalsIgnoreCase(user.getName())) {
			returnData = UserConstants.USER_ALREADY_EXIST.getValue();
		}else {
			int date = ageCalculator(LocalDate.parse(user.getAge()));
			user.setAge(String.valueOf(date));
			user.setBmr(calculateBMR(user));
			userRepository.saveAndFlush(user);
			returnData = UserConstants.USER_ADDED_SUCCESSFULLY.getValue();
		}
		return returnData;
	}

	@Override
	public int ageCalculator(LocalDate date) {
		System.err.println("::: UserServiceImpl.ageCalculator ::: ");
		int returnDate = 0;
		LocalDate dob = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
		LocalDate currentDate = LocalDate.now();
		Period period = Period.between(dob, currentDate);
		returnDate = period.getYears();
		return returnDate;
	}
	
	@Override
	public List<User> findAllUserDetails() {
		System.err.println("::: UserServiceImpl.findAllUserDetails ::: ");
		List<User> user = userRepository.findAll();
		return user;
	}

	@Override
	public Double calculateBMR(User user) {
		System.err.println("::: UserServiceImpl.calculateBMR ::: ");
		List<String> list = null;
		Double bmrValue = null;
		if(user.getGender().equalsIgnoreCase("Male")) {
			list = Arrays.asList(UserConstants.BMR_MEN_DEFAULT_VALUE.getValue().split("#"));

			bmrValue = Double.valueOf(list.get(0)) + (Double.valueOf(list.get(1)) * Double.valueOf(user.getWeight()))
						+ (Double.valueOf(list.get(2)) * Double.valueOf(user.getHeight())) 
						- (Double.valueOf(list.get(3)) * Double.valueOf(user.getAge()));
			System.out.println("bmrValue MEN" + list +" ,,,,, " + bmrValue);
		}else {
			list = Arrays.asList(UserConstants.BMR_WOMEN_DEFAULT_VALUE.getValue().split("#"));
			
			bmrValue = Double.valueOf(list.get(0)) + (Double.valueOf(list.get(1)) * Double.valueOf(user.getWeight()))
					+ (Double.valueOf(list.get(2)) * Double.valueOf(user.getHeight())) 
					- (Double.valueOf(list.get(3)) * Double.valueOf(user.getAge()));
			System.out.println("bmrValue WOMEN" + list +" ,,,,, " + bmrValue);
		}
		return bmrValue;
		
	}
	
}

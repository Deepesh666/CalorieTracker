package com.CalorieTracker.service;


import java.time.LocalDate;
import java.util.List;

import com.CalorieTracker.model.User;

public interface UserService {

	
	String findUserIfExistOrAddUser(User user);

	List<User> findAllUserDetails();
	
	public Double calculateBMR(User user);
	
	public int ageCalculator(LocalDate date);
}

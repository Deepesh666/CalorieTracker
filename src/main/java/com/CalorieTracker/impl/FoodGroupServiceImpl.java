package com.CalorieTracker.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.CalorieTracker.constants.FoodGroupConstants;
import com.CalorieTracker.model.FoodGroup;
import com.CalorieTracker.repository.FoodGroupRepository;
import com.CalorieTracker.service.FoodGroupService;

@Service
public class FoodGroupServiceImpl implements FoodGroupService {
	
	@Autowired
	FoodGroupRepository foodGroupRepository;

	@Override
	public String addingFoodGroup() {
		System.err.println("::: FoodGroupServiceImpl.addingFoodGroup ::: ");
		String returnData = "";
		List<String> data = Arrays.asList(FoodGroupConstants.FOOD_GROUP_DATA.getValue().split("#"));
		List<FoodGroup> fd = foodGroupRepository.findAll();
		returnData = FoodGroupConstants.FOOD_GROUP_DATA_ALREADY_EXIST.getValue();
		List<FoodGroup> foodGroup = new ArrayList<>();
		if(CollectionUtils.isEmpty(fd)) {
			Long count = (long) 1;
			for(String fg : data) {
				FoodGroup fgData = new FoodGroup();
				fgData.setId(count);
				fgData.setFoodGroupName(fg);
				foodGroup.add(fgData);
				count++;
			}
			foodGroupRepository.saveAll(foodGroup);
			returnData = FoodGroupConstants.FOOD_GROUP_DATA_ADDED_SUCCESSFULLY.getValue();
		}
		return returnData;
	}

	@Override
	public List<FoodGroup> allFoodGroupData() {
		System.err.println("::: FoodGroupServiceImpl.addingFoodGroup ::: ");
		List<FoodGroup> foodGroup = foodGroupRepository.findAll();
		return foodGroup;
	}
	
	
}

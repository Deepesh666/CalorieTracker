package com.CalorieTracker.constants;

public enum FoodGroupConstants {

	FOOD_GROUP_DATA_FETCHED_SUCCESSFULLY("FOOD_GROUP_DATA_FETCHED_SUCCESSFULLY", "food group data fetched successfully"),

	FACING_ISSUE_WHILE_WORKING_WITH_API("FACING_ISSUE_WHILE_WORKING_WITH_API", "facing issue in API"),
	
	FOOD_GROUP_DATA("FOOD_GROUP_DATA", "Breakfast#Lunch#Dinner"),

	FOOD_GROUP_DATA_ADDED_SUCCESSFULLY("FOOD_GROUP_DATA_ADDED_SUCCESSFULLY", "food group data added"),
	
	FOOD_GROUP_DATA_ALREADY_EXIST("FOOD_GROUP_DATA_ALREADY_EXIST", "food group data already exist");

	
	private final String key;
	private final String value;
	
	private FoodGroupConstants(String key, String value){
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
}

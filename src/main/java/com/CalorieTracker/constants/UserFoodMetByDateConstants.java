package com.CalorieTracker.constants;

public enum UserFoodMetByDateConstants {

	FOOD_ADDED_SUCCESSFULLY_FOR_THE_SELECTED_USER("FOOD_ADDED_SUCCESSFULLY_FOR_THE_SELECTED_USER()", "food added successfully for the selected user"),
	
	API_FACING_ISSUE_WHILE_ADDING_FOOD("API_FACING_ISSUE_WHILE_ADDING_FOOD", "we are facing issue while fetching data");
	
	
	private final String key;
	private final String value;
	
	private UserFoodMetByDateConstants(String key, String value){
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

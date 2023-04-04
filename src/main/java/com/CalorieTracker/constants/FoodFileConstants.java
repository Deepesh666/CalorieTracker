package com.CalorieTracker.constants;

public enum FoodFileConstants {

	FILE_FORMAT_IS_INCORRECT("FILE_FORMAT_IS_INCORRECT" , "file format is incorrect or empty"),
	
	FOOD_RECROD_BY_NAME_FETCHED_SUCCESSFULLY("FOOD_RECROD_BY_NAME_FETCHED_SUCCESSFULLY", "food by name fetched successfully"),
	
	SUCCESSFULLY_FETCHED_ALL_THE_RECORD("SUCCESSFULLY_FETCHED_ALL_THE_RECORD", "fetched all the data successfully"),
	
	NEW_UNMATCHED_FOOD_DATA_ADDED_FROM_FILE("NEW_UNMATCHED_FOOD_DATA_ADDED_FROM_FILE", "new unmatched data added from file remains are same"),
	
	FACING_ISSUE_IN_API_WHILE_PROCESSING("FACING_ISSUE_IN_API_WHILE_PROCESSING", "facing issue in api while processing"),
	
	FILE_UPLOADED_IN_DATABASE_SUCCESSFULLY("FILE_UPLOADED_IN_DATABASE_SUCCESSFULLY", "file uploaded in database successfully");
	
	
	private final String key;
	private final String value;
	
	private FoodFileConstants(String key, String value){
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

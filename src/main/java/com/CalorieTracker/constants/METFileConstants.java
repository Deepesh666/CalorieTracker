package com.CalorieTracker.constants;

public enum METFileConstants {

	ALL_MET_FILE_DATA_FETCHED_SUCCESSFULLY("ALL_MET_FILE_DATA_FETCHED_SUCCESSFULLY", "all met file data fetched successfully"),
	
	FILE_FORMAT_IS_INCORRECT("FILE_FORMAT_IS_INCORRECT" , "file format is incorrect or empty"),
	
	NEW_UNMATCHED_FOOD_DATA_ADDED_FROM_FILE("NEW_UNMATCHED_FOOD_DATA_ADDED_FROM_FILE", "new unmatched data added from file remains are same"),
	
	FACING_ISSUE_IN_API_WHILE_PROCESSING("FACING_ISSUE_IN_API_WHILE_PROCESSING", "facing issue in api while processing"),
	
	FILE_UPLOADED_IN_DATABASE_SUCCESSFULLY("FILE_UPLOADED_IN_DATABASE_SUCCESSFULLY", "file uploaded in database successfully");
	
	private final String key;
	private final String value;
	
	private METFileConstants(String key, String value){
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

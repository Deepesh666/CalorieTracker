package com.CalorieTracker.constants;

public enum UserConstants {

	
	USER_ALREADY_EXIST("USER_ALREADY_EXIST", "user already exist"),
	
	USER_DOES_NOT_EXIST("USER_DOES_NOT_EXIST", "user doesn't exist"),
	
	USER_ADDED_SUCCESSFULLY("USER_ADDED_SUCCESSFULLY", "user added successfully"),
	
	FORMULA_FOR_MEN_BMR("FORMULA_FOR_MEN_BMR", "66.4730 + (13.7516 x weight in kg) + (5.0033 BMR = 66.4730 + (13.7516 x weight in kg) + (5.0033x height in x height in cm) x height in cm) –(6.7550 x age in years"),
	
	FORMULA_FOR_WOMEN_BMR("FORMULA_FOR_WOMEN_BMR", "0955 + (9.5634 x weight in kg) + (1.849 BMR = 655.0955 + (9.5634 x weight in kg) + (1.8496 x height in cm) x height in cm) x height in cm) –(4.6756 x age in years) (4.6756 x age in years) (4.6756 x age in years) "),

	FORMULA_CALORIES_OUT_FOR_ACTIVITIES("FORMULA_CALORIES_OUT_FOR_ACTIVITIES", "ET Value * weigh MET Value * weigh MET Value * weight in kg * duration in hour"),
	
	BMR_MEN_DEFAULT_VALUE("MEN_DEFAULT_VALUE_FOR_BMR", "655.0955#13.7516#5.0033#6.7550"),
	
	BMR_WOMEN_DEFAULT_VALUE("MEN_DEFAULT_VALUE_FOR_BMR", "655.0955#9.5634#1.8496#4.6756"),
	
	API_FACING_SOME_ISSUE_DUE_TO_EMPLTY_DATA("API_FACING_SOME_ISSUE_DUE_TO_EMPLTY_DATA", "api having issue due to empty data"),
	
	USER_RECORD_FETCHED_SUCCESSFULLY("USER_RECORD_FETCHED_SUCCESSFULLY", "user record fetched successfully");
	
	
	
	
	
	private final String key;
	private final String value;
	
	private UserConstants(String key, String value){
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

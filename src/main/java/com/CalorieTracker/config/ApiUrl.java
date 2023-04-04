package com.CalorieTracker.config;

public class ApiUrl {

	public static String BASE_URL = "http://localhost:9001/calorietracker";
	public static String VERSION = "/api";

	//USER API
	
	public static String saveUserInput = BASE_URL + VERSION + "/addUser";
	
	public static String allUserData = BASE_URL + VERSION + "/viewAllUsers";
	
	//FOOD GROUP API
	
	public static String allFoodGrupData = BASE_URL + VERSION + "/viewAllFoodGrupData";
	
	public static String addFoodGroup = BASE_URL + VERSION + "/addFoodGroupData";
	
	//FOOD FILE API
	public static String readOrUpdateFood = BASE_URL + VERSION + "/readOrUpdateFoodFile";
	
	public static String allFoodFileData = BASE_URL + VERSION + "/viewAllFoodFileData";
	
	public static String findDataBySelectedFood = BASE_URL + VERSION + "/findDataBySelectedFood/{foodName}";
	
	//MET FILE API
	
	public static String readOrUpdateMET = BASE_URL + VERSION + "/readOrUpdateMETFile";
	
	public static String allMetFileData = BASE_URL + VERSION + "/viewAllMetFileData";
	
	public static String findDataBySpecificMotion = BASE_URL + VERSION + "/findDataBySpecificMotion/{specificMotion}";
	
}

package com.CalorieTracker.service;


import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CalorieTracker.config.ApiUrl;
import com.CalorieTracker.model.User;

@Service
public class RestService {

	public String dataFormatter(String data) {
		System.err.println("::: RestService.dataFormatter ::: ");
		data = data.substring(data.indexOf("["), data.indexOf("]")+1);
		return data;
	}
	
	
	//USER REST
	
	public Object userInputData(User user) {
		System.err.println("::: RestService.userInputData ::: ");
		String response = "";
		RestTemplate rest = new RestTemplate();
		response = rest.postForObject(ApiUrl.saveUserInput, user, String.class);
		return response;
	}

	public String allUserData() {
		System.err.println("::: RestService.allUserData ::: ");
		ResponseEntity<String> response = null;
		RestTemplate rest = new RestTemplate();
		response = rest.exchange(ApiUrl.allUserData, HttpMethod.GET, null, String.class);
		return response.getBody();
	}

	
	
	
	
	//FOOD GROUP REST
	
	public Object addingFoodGroupData() {
		System.err.println("::: RestService.addingFoodGroupData ::: ");
		String response = "";
		RestTemplate rest = new RestTemplate();
		response = rest.postForObject(ApiUrl.addFoodGroup, null, String.class);
		return response;
	}
	
	public String fetchFoodGrupData() {
		ResponseEntity<String> response = null;
		RestTemplate rest = new RestTemplate();
		response = rest.exchange(ApiUrl.allFoodGrupData, HttpMethod.GET, null, String.class);
		return response.getBody();
	}
	
	
	
	
	
	//FOOD FILE REST
	
	public Object addingFoodFile() {
		System.err.println("::: RestService.addingFoodFile ::: ");
		String response = "";
		RestTemplate rest = new RestTemplate();
		response = rest.postForObject(ApiUrl.readOrUpdateFood, null, String.class);
		return response;
	}
	
	public String showAllFoodFileData() {
		System.err.println("::: RestService.showAllFoodFileData ::: ");
		ResponseEntity<String> response = null;
		RestTemplate rest = new RestTemplate();
		response = rest.exchange(ApiUrl.allFoodFileData, HttpMethod.GET, null, String.class);
		return response.getBody();
	}

	
	
	
	//MET FILE REST
	
	public Object addMetFileData() {
		System.err.println("::: RestService.addMetFileData ::: ");
		String response = "";
		RestTemplate rest = new RestTemplate();
		response = rest.postForObject(ApiUrl.readOrUpdateMET, null, String.class);
		return response;
	}
	
	public String showAllMetFileData() {
		System.err.println("::: RestService.showAllMetFileData ::: ");
		ResponseEntity<String> response = null;
		RestTemplate rest = new RestTemplate();
		response = rest.exchange(ApiUrl.allMetFileData, HttpMethod.GET, null, String.class);
		return response.getBody();
	}
	
}

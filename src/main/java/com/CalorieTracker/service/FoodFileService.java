package com.CalorieTracker.service;


import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.CalorieTracker.model.FoodFile;

public interface FoodFileService {

	
	String SaveOrUpdateFoodFile(MultipartFile multipartFile);
	
	List<FoodFile> readFoodFileData(MultipartFile multipartFile) throws IOException;
	
	boolean verifyHasExcelFormat(MultipartFile multipartFile);
	
	List<FoodFile> allFoodFileData();
}

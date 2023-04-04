package com.CalorieTracker.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.CalorieTracker.model.METFile;

public interface METFileService {

	String SaveOrUpdateMETFile(MultipartFile multipartFile);

	List<METFile> readMETFileData(MultipartFile multipartFile) throws IOException;

	boolean verifyHasExcelFormat(MultipartFile multipartFile);
	
	List<METFile> allMetFileData();
	
	METFile findBySpecificMotion(String specificMotion);
}

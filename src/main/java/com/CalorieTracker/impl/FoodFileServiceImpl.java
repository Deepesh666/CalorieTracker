package com.CalorieTracker.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.CalorieTracker.constants.FoodFileConstants;
import com.CalorieTracker.model.FoodFile;
import com.CalorieTracker.repository.FoodFileRepository;
import com.CalorieTracker.service.FoodFileService;

@Service
public class FoodFileServiceImpl implements FoodFileService {
	
	@Autowired
	FoodFileRepository foodFileRepository;
	

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	 
	
	@Override
	public boolean verifyHasExcelFormat(MultipartFile multipartFile) {
		System.err.println("::: FoodFileServiceImpl.verifyHasExcelFormat ::: ");
		if (!TYPE.equals(multipartFile.getContentType())) {
			return false;
		}else {
		return true;
		}
	}
	
	@Override
	public List<FoodFile> readFoodFileData(MultipartFile multipartFile) throws IOException {
		System.err.println("::: FoodFileServiceImpl.readFoodFileData ::: ");
		if(verifyHasExcelFormat(multipartFile)) {
			XSSFWorkbook workbook = new XSSFWorkbook(multipartFile.getInputStream());
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			//collecting headers
			Row row = sheet.getRow(0);
			ArrayList<String> headerData = new ArrayList<>();
			for(Cell cell : row) {
				headerData.add(cell.getStringCellValue());
			}
			System.out.println("headerData :::: " + headerData);
			
			List<FoodFile> foodFiles = new ArrayList<>();
			Iterator<Row> rows = sheet.iterator();
			int rowNumber = 0;
			System.out.println("getPhysicalNumberOfRows :::: " + sheet.getPhysicalNumberOfRows());
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }
		        Iterator<Cell> cellsInRow = currentRow.iterator();
		        FoodFile foodFile = new FoodFile();
		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();
		          
		            switch (cellIdx) {
		            case 0:
		            	foodFile.setSerialNumber((long) currentCell.getNumericCellValue());
		              break;

		            case 1:
		            	foodFile.setFoodName(currentCell.getStringCellValue());
		              break;

		            case 2:
		            	foodFile.setFoodGroup(currentCell.getStringCellValue());
		              break;

		            case 3:
		            	foodFile.setCalories((long) currentCell.getNumericCellValue());
		              break;
		            case 4:
		            	foodFile.setFat((Double) currentCell.getNumericCellValue());
		              break;
		            case 5:
		            	foodFile.setProtein((Double) currentCell.getNumericCellValue());
		              break;
		            case 6:
		            	foodFile.setCarbohydrate((Double) currentCell.getNumericCellValue());
		              break;
		            case 7:
		            	foodFile.setServingDescription(currentCell.getStringCellValue());
		              break;
		            }

		            cellIdx++;
		          }
		          
		        foodFiles.add(foodFile);
		        }
		      System.out.println("foodFiles ::::: " + foodFiles.size());
		      workbook.close();
		        
		return foodFiles;
		}else {
			return null;
		}
	}

	@Override
	public String SaveOrUpdateFoodFile(MultipartFile multipartFile) {
		System.err.println("::: FoodFileServiceImpl.SaveOrUpdateFoodFile ::: ");
		String returnData = "";
		try {
			List<FoodFile> foodFile = readFoodFileData(multipartFile);
			if(!CollectionUtils.isEmpty(foodFile)) {
				foodFileRepository.saveAllAndFlush(foodFile);
				System.out.println("foodFileRepository.count() :::: " + foodFileRepository.count() +" ,,,,, "+ "foodFile ::::: " + foodFile.size());
			returnData = FoodFileConstants.FILE_UPLOADED_IN_DATABASE_SUCCESSFULLY.getValue();
		}else {
			returnData = FoodFileConstants.FILE_FORMAT_IS_INCORRECT.getValue();
			}
		}catch (Exception e) {
			returnData = FoodFileConstants.FACING_ISSUE_IN_API_WHILE_PROCESSING.getValue();
			e.printStackTrace();
				}
		return returnData;
		}

	@Override
	public List<FoodFile> allFoodFileData() {
		System.err.println("::: FoodFileServiceImpl.allFoodFileData ::: ");
		List<FoodFile> foodFile = foodFileRepository.findAll();
		return foodFile;
	}
	
}

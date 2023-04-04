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

import com.CalorieTracker.constants.METFileConstants;
import com.CalorieTracker.model.METFile;
import com.CalorieTracker.repository.METFileRepository;
import com.CalorieTracker.service.METFileService;

@Service
public class METFileServiceImpl implements METFileService {

	@Autowired
	METFileRepository metFileRepository;
	
public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	 
	
	@Override
	public boolean verifyHasExcelFormat(MultipartFile multipartFile) {
		System.err.println("::: METFileServiceImpl.verifyHasExcelFormat ::: ");
		if (!TYPE.equals(multipartFile.getContentType())) {
			return false;
		}else {
		return true;
		}
	}
	
	@Override
	public List<METFile> readMETFileData(MultipartFile multipartFile) throws IOException {
		System.err.println("::: METFileServiceImpl.readMETFileData ::: ");
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
			
			List<METFile> metFiles = new ArrayList<>();
			Iterator<Row> rows = sheet.iterator();
			int rowNumber = 0;
		      while (rows.hasNext()) {
		        Row currentRow = rows.next();

		        // skip header
		        if (rowNumber == 0) {
		          rowNumber++;
		          continue;
		        }
			
		        Iterator<Cell> cellsInRow = currentRow.iterator();
		        METFile metFile = new METFile();
		        int cellIdx = 0;
		        while (cellsInRow.hasNext()) {
		          Cell currentCell = cellsInRow.next();
		          
		            switch (cellIdx) {
		            case 0:
		            	metFile.setActivity(currentCell.getStringCellValue());
		              break;

		            case 1:
		            	metFile.setSpecificMotion(currentCell.getStringCellValue());
		              break;

		            case 2:
		            	metFile.setMet(currentCell.getNumericCellValue());
		              break;
		            }

		            cellIdx++;
		          }
		          
		        metFiles.add(metFile);
		        }
		      workbook.close();
		        
		return metFiles;
		}else {
			return null;
		}
	}

	@Override
	public String SaveOrUpdateMETFile(MultipartFile multipartFile) {
		System.err.println("::: METFileServiceImpl.SaveOrUpdateMETFile ::: ");
		String returnData = "";
		try {
			List<METFile> metFile = readMETFileData(multipartFile);
			if(!CollectionUtils.isEmpty(metFile)) {
				metFileRepository.saveAllAndFlush(metFile);
				System.out.println("metFileRepository.count() ::::::: " + metFileRepository.count() +" ,,,,,, " + "metFile ::::::: " + metFile.size());
			returnData = METFileConstants.FILE_UPLOADED_IN_DATABASE_SUCCESSFULLY.getValue();
		}else {
			returnData = METFileConstants.FILE_FORMAT_IS_INCORRECT.getValue();
			}
		}catch (Exception e) {
			returnData = METFileConstants.FACING_ISSUE_IN_API_WHILE_PROCESSING.getValue();
			e.printStackTrace();
				}
		return returnData;
		}

	@Override
	public List<METFile> allMetFileData() {
		System.err.println("::: METFileServiceImpl.allMetFileData ::: ");
		List<METFile> metFile = metFileRepository.findAll();
		return metFile;
	}

	
}

package com.springAPITest.proV.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class ExcelDubiousDemocracyParser {
	private static final Logger logger = LoggerFactory.getLogger(ExcelDubiousDemocracyParser.class);
	public static String retrieveDubiousData(String representativeName) throws IOException{
       try{
//    	   TODO: remove hardcoded filename
    	   	InputStream input = new ClassPathResource("2010-Dubious-Democracy-Data.xlsx").getInputStream();
	        String cellContent = representativeName;

	        int rownr=0, colnr = 0;
	        
	        HSSFWorkbook wb = new HSSFWorkbook(input);
	        HSSFSheet sheet = wb.getSheetAt(0);
	        
	        rownr = findRow(sheet, cellContent);
	        
	        return  output(sheet, rownr, colnr);
	      } 
       catch (final NullPointerException e){
    	   logger.info("unable to lookup candidate in excel", e.toString());	
       }
       return null;
	}

    private static String output(HSSFSheet sheet, int rownr, int colnr) {
        HSSFRow row = sheet.getRow(rownr);
        HSSFCell cell = row.getCell(colnr);

        System.out.println("Retrieved CID from excel file is: " + cell);      
        return cell.toString();
    }

    private static int findRow(HSSFSheet sheet, String cellContent) {
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().contains(cellContent)){
                		//equals(cellContent)) 
                    	return row.getRowNum();  
                    }
                }
            }
        }               
        return 0;
    }

}   

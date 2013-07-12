package com.springAPITest.proV.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class ExcelDubiousDemocracyParser {
	private static final Logger logger = LoggerFactory.getLogger(ExcelDubiousDemocracyParser.class);
	private String dubiousDemocracyFileName;
	
	public static String retrieveDubiousData(String representativeName) throws IOException{
       try{
//    	   TODO: remove hardcoded filename
    	   	InputStream input = new ClassPathResource("2010-Dubious-Democracy-Data.xlsx").getInputStream();
	        String cellContent = representativeName;
	        
	        //initialize rownumber
	        int rownr =0;
	        //column to lookup
	        int colnr = 22;
	        
	        XSSFWorkbook wb = new XSSFWorkbook(input);
	        XSSFSheet sheet = wb.getSheetAt(0);
	        
	        //find row number with representative name
	        rownr = findRow(sheet, cellContent);
	        
	        //return value at column, colnr and row with representatives name
	        return  output(sheet, rownr, colnr);
	      } 
       catch (final NullPointerException e){
    	   logger.info("unable to lookup candidate in excel", e.toString());	
       }
       return null;
	}

    private static String output(XSSFSheet sheet, int rownr, int colnr) {
        XSSFRow row = sheet.getRow(rownr);
        XSSFCell cell = row.getCell(colnr);

        System.out.println("Retrieved cell contents are: " + cell);      
        return cell.toString();
    }

    private static int findRow(XSSFSheet sheet, String cellContent) {
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

	public String getDubiousDemocracyFileName() {
		return dubiousDemocracyFileName;
	}

	public void setDubiousDemocracyFileName(String dubiousDemocracyFileName) {
		this.dubiousDemocracyFileName = dubiousDemocracyFileName;
	}

}   

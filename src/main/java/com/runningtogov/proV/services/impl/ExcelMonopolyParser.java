package com.runningtogov.proV.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class ExcelMonopolyParser {
	private static final Logger logger = LoggerFactory.getLogger(ExcelMonopolyParser.class);
	private static String monopolyFileName;	

	public static String lookUpCandidateParty(String representativeName) throws IOException{
		String candParty = vLookUpData(representativeName, 4,4);
		String Party = candParty.substring(0, candParty.indexOf("."));
		System.out.println("Candidate party"+Party);
		return Party;
	}
	
	public static String lookUpCandidateYearElected(String representativeName) throws IOException{
		String yearElected = vLookUpData(representativeName,3,4);
		System.out.println("year elected"+yearElected);
		return yearElected;
	}
	
	public static double lookUpCandidatePartisanship(String representativeName) throws IOException{
		String partisanship = vLookUpData(representativeName,15,4);
		double partisanshipDouble = Double.parseDouble(partisanship);
		return partisanshipDouble;
	}
		
	
	public static String vLookUpData(String cellContent, int colnr, int sheetNumber) throws IOException{
       try{
    	   InputStream input = new ClassPathResource(monopolyFileName).getInputStream();
	        //initialize rownumber
	        int rownr =0;
	        
	        XSSFWorkbook wb = new XSSFWorkbook(input);
	        XSSFSheet sheet = wb.getSheetAt(sheetNumber);
	        
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

	//used to return the contents of the cell at Sheet "sheet", row "rownr", and column "colnr"
    private static String output(XSSFSheet sheet, int rownr, int colnr) {
        XSSFRow row = sheet.getRow(rownr);
        XSSFCell cell = row.getCell(colnr);     
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

	/**
	 * @return the monopolyFileName
	 */
	public String getMonopolyFileName() {
		return monopolyFileName;
	}

	/**
	 * @param monopolyFileName the monopolyFileName to set
	 */
	public void setMonopolyFileName(String monopolyFileName) {
		this.monopolyFileName = monopolyFileName;
	}
    

}   

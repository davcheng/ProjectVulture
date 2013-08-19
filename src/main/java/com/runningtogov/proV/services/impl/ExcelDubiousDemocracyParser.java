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

public class ExcelDubiousDemocracyParser {
	private static final Logger logger = LoggerFactory.getLogger(ExcelDubiousDemocracyParser.class);
	private static String dubiousDemocracyFileName;	

	public static String lookUpCandidateFIPS(String representativeName) throws IOException{
		String stateAbbrv = vLookUpData(representativeName, 1);
		return fipsHashMap(stateAbbrv);
	}
	
	public static String lookUpCandidateState(String representativeName) throws IOException{
		String stateAbbrv = vLookUpData(representativeName, 1);
		return stateAbbrv;
	}

	public static String lookUpCandidateCongDistrict(String representativeName) throws IOException{
		String congDistrict = vLookUpData(representativeName, 13);
		//if congDistrict is AL (alone), then enter 00 for candidates congDistrict
		if (congDistrict.equals("AL")) {
			congDistrict = "00";
		}
		if (congDistrict.contains(".")){
			congDistrict = congDistrict.substring(0, congDistrict.indexOf("."));
			System.out.println("reformatted congdistrict "+ congDistrict);
		}
		
		return congDistrict;
	}
	
	public static Double lookUpCandidateWinningPct(String representativeName) throws IOException{
		String win = vLookUpData(representativeName, 22);
		double winPct = Double.parseDouble(win);
		return winPct;
	}
	
	public static String vLookUpData(String cellContent, int colnr) throws IOException{
       try{
    	   InputStream input = new ClassPathResource(dubiousDemocracyFileName).getInputStream();
	        //initialize rownumber
	        int rownr =0;
	        
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
    
    private static String fipsHashMap(String fips){
		Map<String, String> fipsMap = new HashMap<String, String>();
		fipsMap.put("AL", "01");	
		fipsMap.put("AK", "02");	
		fipsMap.put("AZ", "04");
		fipsMap.put("AR", "05");	
		fipsMap.put("CA", "06");
		fipsMap.put("CO", "08");	
		fipsMap.put("CT", "09");	
		fipsMap.put("DE", "10");
		fipsMap.put("DC", "11");	
		fipsMap.put("FL", "12");
		fipsMap.put("GA", "13");	
		fipsMap.put("HI", "15");	
		fipsMap.put("ID", "16");
		fipsMap.put("IL", "17");	
		fipsMap.put("IN", "18");
		fipsMap.put("IA", "19");	
		fipsMap.put("KS", "20");
		fipsMap.put("KY", "21");	
		fipsMap.put("LA", "22");
		fipsMap.put("ME", "23");	
		fipsMap.put("MD", "24");
		fipsMap.put("MA", "25");	
		fipsMap.put("MI", "26");
		fipsMap.put("MN", "27");	
		fipsMap.put("MS", "28");
		fipsMap.put("MO", "29");	
		fipsMap.put("MT", "30");
		fipsMap.put("NE", "31");	
		fipsMap.put("NV", "32");
		fipsMap.put("NH", "33");	
		fipsMap.put("NJ", "34");
		fipsMap.put("NM", "35");	
		fipsMap.put("NY", "36");
		fipsMap.put("NC", "37");	
		fipsMap.put("ND", "38");
		fipsMap.put("OH", "39");	
		fipsMap.put("OK", "40");
		fipsMap.put("OR", "41");	
		fipsMap.put("PA", "42");	
		fipsMap.put("RI", "44");
		fipsMap.put("SC", "45");	
		fipsMap.put("SD", "46");
		fipsMap.put("TN", "47");	
		fipsMap.put("TX", "48");
		fipsMap.put("UT", "49");	
		fipsMap.put("VT", "50");
		fipsMap.put("VA", "51");	
		fipsMap.put("WA", "53");	
		fipsMap.put("WV", "54");
		fipsMap.put("WI", "55");	
		fipsMap.put("WY", "56");
		
		String fipsCode = fipsMap.get(fips);
		System.out.println("FIPS TEST " + fipsCode);
		return fipsCode;
	
	}
	public String getDubiousDemocracyFileName() {
		return dubiousDemocracyFileName;
	}

	public void setDubiousDemocracyFileName(String dubiousDemocracyFileName) {
		this.dubiousDemocracyFileName = dubiousDemocracyFileName;
	}

}   

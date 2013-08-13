package com.runningtogov.proV.services.impl;

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


public class NameConverter {

	private static final Logger logger = LoggerFactory.getLogger(NameConverter.class);
	public static String convertToFirstLastName(String name) throws IOException{
       try{
    	   //Separate the names
    	   String newName;
    	   String lastName = name.substring(0, name.indexOf(","));
    	   String firstName = name.substring(name.indexOf(",")+2);

    	   //Check for a space indicating a middle Name
    	   //Check to see if the middle name already has the period if not add it
    	   if(firstName.trim().contains(" ") && !firstName.contains(".")) {
    	      firstName += ".";
    	   }

    	   newName = firstName + " " + lastName;

	        return  newName;
	      } 
       catch (final NullPointerException e){
    	   logger.info("unable to lookup candidate in excel", e.toString());	
       }
       return null;
	}
}   

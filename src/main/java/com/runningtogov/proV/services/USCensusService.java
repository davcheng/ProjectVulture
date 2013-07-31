package com.runningtogov.proV.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.JsonMappingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.runningtogov.proV.controllers.HomeController;


@JsonRootName(value = "response")
public class USCensusService {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static String usCensusApiKey;
	
	public static String retrievePctFamiliesInPoverty(String state, String district) throws JsonParseException, JsonMappingException, IOException{
		//TODO: spring inject data
		return retrieveUSCensusCongDistrictData("DP03_0119E", state, district);
	}
	
	public static String retrieveUSCensusCongDistrictData(String data, String state, String district) throws JsonParseException, JsonMappingException, IOException{
		//data source dictionary: http://www.census.gov/developers/data/acs_1yr_2011_cd113_var.xml
		
		RestTemplate restTemplate = new RestTemplate();
		try{
			//make rest call
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("dataObject", data);
			vars.put("apiKey", getUsCensusApiKey());
			vars.put("fips", state);
			vars.put("district", district);


		    String response = restTemplate.getForObject("http://api.census.gov/data/2011/acs1_cd113?key={apiKey}&get=NAME&for=congressional district:{district}&in=state:{fips}", String.class, vars);
		    System.out.println("USCensus Data " + response);
		    	
			    return response;
			} 
			catch (final NullPointerException e) {
				logger.info("Failed to map response to pojo", e.toString());
			}
		return null;

     }

	/**
	 * @return the usCensusApiKey
	 */
	public static String getUsCensusApiKey() {
		return usCensusApiKey;
	}

	/**
	 * @param usCensusApiKey the usCensusApiKey to set
	 */
	public void setUsCensusApiKey(String usCensusApiKey) {
		USCensusService.usCensusApiKey = usCensusApiKey;
		
	}

	

	
}

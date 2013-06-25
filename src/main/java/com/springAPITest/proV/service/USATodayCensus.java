package com.springAPITest.proV.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.springAPITest.proV.controllers.HomeController;
import com.springAPITest.proV.service.data.USATodayCensusResponse;

@JsonRootName(value = "response")
public class USATodayCensus {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	public static USATodayCensusResponse retrieveCensusData(String keypat, String sumlevid) throws JsonParseException, JsonMappingException, IOException{
		//TODO: spring inject
				String usCensusKey = "hwkd5vwbjky56vedmvbun4c7";
						
//		 				sumlevid
//						1 	National level
//						2 	State level
//						3 	County level
//						4,6 	City, town level

				RestTemplate restTemplate = new RestTemplate();
				try{
					
					//make rest call
					Map<String, String> vars = new HashMap<String, String>();
					vars.put("key", usCensusKey);
					vars.put("keypat", keypat);
				    vars.put("sumlevid", sumlevid);
				    //String response = restTemplate.getForObject("http://api.usatoday.com/open/census/loc?keypat={keypat}&keyname=FIPS&sumlevid={sumlevid}&api_key={key}", String.class, vars);
				    String response = restTemplate.getForObject("http://api.usatoday.com/open/census/loc?keypat=51059&keyname=FIPS&sumlevid=3&api_key={key}", String.class, vars);
					
				    System.out.println("USA TODAY: "+response);
				    
		    
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(response);
			
			try{
				Iterator<Map.Entry<String,JsonNode>> resps = rootNode.getFields();	

				//unwrap response
			    Map.Entry<String,JsonNode> requestWrapper = resps.next();	
			    System.out.println("request wrapper "+requestWrapper.toString());
			    Map.Entry<String,JsonNode> responseWrapper = resps.next();
			    
			    //gives response=[{...
			    System.out.println("response wrapper "+responseWrapper.toString());		
			    //gives [{...
			    System.out.println("response wrapper get value"+responseWrapper.getValue().toString());				    
			    
			   //Map [{... to list
			    List<USATodayCensusResponse> responseList = mapper.readValue(responseWrapper.getValue(), new TypeReference<List<USATodayCensusResponse>>() { });
			    
			    return responseList.get(0);
			} 
			catch (final NullPointerException e) {
				logger.info("Failed to map response to pojo", e.toString());
			}
		}
		catch (final RestClientException e) {
			logger.info("Failed to send REST request", e.toString());
        return null;
		}
		return null;
     }	

	
}

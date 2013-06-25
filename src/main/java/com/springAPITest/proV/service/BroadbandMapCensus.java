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
import com.springAPITest.proV.service.data.BroadbandMapCensusResponse;

@JsonRootName(value = "response")
public class BroadbandMapCensus {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	public static BroadbandMapCensusResponse retrieveCensusData() throws JsonParseException, JsonMappingException, IOException{
		//TODO: spring inject
		// source: http://www.broadbandmap.gov/developer/api/demographics-api-by-geography-type-and-geography-id
		//request looks like: {API Base}/demographic/{dataVersion}/{geographyType}/ids/{geographyIds}?format={format}&callback={functionName}
		
		String apiBase = "http://www.broadbandmap.gov/broadbandmap/";
		// geographyType can be: specify either one of the following geography type: 
		// county, censusplace, msa, usf, statesenate, statehouse, congdistrict, tribalnation
		String dataVersion = "jun2012";
		String geographyType = "congdistrict";
		String geographyIds = "0111101";
		String format = "json";
		
		RestTemplate restTemplate = new RestTemplate();
		try{
			//make rest call
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("apiBase", apiBase);
			vars.put("dataVersion", dataVersion);
			vars.put("geographyType", geographyType);
		    vars.put("geographyIds", geographyIds);
		    vars.put("format", format);
		    String response = restTemplate.getForObject("{apiBase}/demographic/{dataVersion}/{geographyType}/ids/{geographyIds}?format={format}", String.class, vars);
			

		    System.out.println("broadband map data: "+response);
		    
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(response);
			
			try{
				Iterator<Map.Entry<String,JsonNode>> resps = rootNode.getFields();	

				//unwrap response
			    Map.Entry<String,JsonNode> statusWrapper = resps.next();	
			    System.out.println("request wrapper "+statusWrapper.toString());
			    Map.Entry<String,JsonNode> responseTimeWrapper = resps.next();
			    System.out.println("response Time wrapper "+responseTimeWrapper.toString());
			    Map.Entry<String,JsonNode> messageWrapper = resps.next();
			    System.out.println("message wrapper "+messageWrapper.toString());
			    Map.Entry<String,JsonNode> resultsWrapper = resps.next();
			    //gives results=[{...
			    System.out.println("results wrapper "+resultsWrapper.toString());		

			   //Map [{... to list
			    List<BroadbandMapCensusResponse> resultsList = mapper.readValue(resultsWrapper.getValue(), new TypeReference<List<BroadbandMapCensusResponse>>() { });
			    System.out.println("MAPP RESULTS "+resultsList.get(0).getAgeBetween20to34());
			    return resultsList.get(0);
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

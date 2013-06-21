package com.springAPITest.proV.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
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

import com.springAPITest.proV.HomeController;
import com.springAPITest.proV.service.data.OpenSecretResponse;


@JsonRootName(value = "response")
public class OpenSecretService {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	public static OpenSecretResponse retrieveOpenSecretCandidateData(String CID) throws JsonParseException, JsonMappingException, IOException{
		//TODO: spring inject
		String openSecretApiKey = "f5924b9bb849071f8f2ba2738a370f2b";

		RestTemplate restTemplate = new RestTemplate();
		try{
			
			//make rest call
			Map<String, String> vars = new HashMap<String, String>();
			vars.put("CID", CID);
		    vars.put("apiKey", openSecretApiKey);
		    String response = restTemplate.getForObject("http://www.opensecrets.org/api/?method=candSummary&output=json&cid={CID}&cycle=2012&apikey={apiKey}&ouput=json", String.class, vars);
//			System.out.println(response);

			ObjectMapper mapper = new ObjectMapper();
	
			JsonNode rootNode = mapper.readTree(response); 
			try{
				Iterator<Map.Entry<String,JsonNode>> resps = rootNode.getFields();
					
				//unwrap response
			    Map.Entry<String,JsonNode> resp = resps.next();
				
			    //unwrap summary
			    Iterator<Map.Entry<String,JsonNode>> summary = resp.getValue().getFields();
			    Map.Entry<String,JsonNode> summ = summary.next();
			    System.out.println("field "+ summ.getValue());		    
			    
			    //unwrap @attributes
			    Iterator<Map.Entry<String,JsonNode>> att = summ.getValue().getFields();
			    Map.Entry<String,JsonNode> atts = att.next();
			    System.out.println("field "+ atts.getValue());
			    
			    //store values into response object
			    OpenSecretResponse responsePojo = mapper.readValue(atts.getValue(), new TypeReference<OpenSecretResponse>(){});
		
			    return responsePojo;
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

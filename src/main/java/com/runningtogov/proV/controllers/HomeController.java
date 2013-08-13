package com.runningtogov.proV.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.runningtogov.proV.forms.searchCandidateForm;
import com.runningtogov.proV.services.*;
import com.runningtogov.proV.services.impl.ExcelCIDParser;
import com.runningtogov.proV.services.impl.ExcelDubiousDemocracyParser;
import com.runningtogov.proV.services.impl.NameConverter;
import com.runningtogov.proV.services.responsedata.BroadbandMapCensusResponse;
import com.runningtogov.proV.services.responsedata.OpenSecretResponse;
import com.runningtogov.proV.services.responsedata.USATodayCensusResponse;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(){
		logger.info("Welcome home!");	
		return "home";
	}
	
	
	@Autowired
	private TwitterRestService twitterService;
	@Autowired
	private  TwitterTemplateCreator twitterCreator;

	//TODO: move to search controller
	// mental notes, the searchCandidateForm is populated with the value/name from the openSecret.jsp
  	@RequestMapping(value = "/search", method = RequestMethod.POST)
  	public String searchCandidate(@ModelAttribute searchCandidateForm searchName, 
  			 ModelMap model) throws JsonParseException, JsonMappingException, IOException {
  		
  		//BroadbandMap Census Data
  		System.out.println(NameConverter.convertToFirstLastName(searchName.getCand_name()));
  		String fips = "01";
  		String congDistrict = "01";
  		BroadbandMapCensusResponse broadbandResponse = BroadbandMapCensus.retrieveCensusData(fips, congDistrict);
		System.out.println("age 20-34 "+broadbandResponse.getAgeBetween20to34());
		System.out.println("education bachelor or greater "+ broadbandResponse.getEducationBachelorOrGreater());
		 
		//US Census Data
//		String a = USCensusService.retrieveUSCensusCongDistrictData("DP05_0033E", "51", "11");		
		

		//  
		//beginning of twitter  
		//  
	   Twitter twitterTemplate = twitterCreator.getTwitterTemplate();
	   
	   //search for user
	   List<TwitterProfile> userSearchList = twitterService.searchTwitterUsers(twitterTemplate, searchName.getCand_name()+" Representative");
	   Iterator<TwitterProfile> userSearchIterator = userSearchList.iterator();
	   TwitterProfile firstResult = userSearchIterator.next();
	   
	   model.addAttribute("twitter_screen_name", firstResult.getScreenName());		   
	   model.addAttribute("twitter_name", firstResult.getName());
	   model.addAttribute("friends_count", firstResult.getFriendsCount());
	   model.addAttribute("followers_count", firstResult.getFollowersCount());
	   model.addAttribute("profile_img_url", firstResult.getProfileImageUrl());
		   
	   
	   //search for tweets related to search topic
	   SearchResults result = twitterTemplate.searchOperations().search(firstResult.getScreenName());
	   List<Tweet> tweetResults = result.getTweets();
	   model.put("tweetResults", tweetResults);
	     
	   //print out tweets
//	   Iterator<Tweet> tweetIterator = tweetResults.iterator();
//	   System.out.println("list of tweets related to user");
//	   while (tweetIterator.hasNext()) {
//		   Tweet currentTweet = tweetIterator.next();
//		   System.out.println(currentTweet.getText());
//		   System.out.println(currentTweet.getCreatedAt());
//		}      
//
//	   System.out.println(result.getTweets());
			   
	  // 
	  //Open Secret Search 
	  //
	   
	  try{

		  String searchedName = searchName.getCand_name();
		  String retrievedCID = ExcelCIDParser.lookupCandidateCID(searchedName); 
		  System.out.println("name entered in search " + searchName.getCand_name());
		  
		  //look up candidate's CID
		  OpenSecretResponse candidateInfo = OpenSecretService.retrieveOpenSecretCandidateData(retrievedCID);

		  //reformat name from lastName, firstName => firstName lastName
		  String fNameLName = NameConverter.convertToFirstLastName(searchName.getCand_name());
		  
		  
		  //
		  //Dubious Democracy test
		  //
			String candidateStateFIPS = ExcelDubiousDemocracyParser.lookUpCandidateFIPS(fNameLName); 
			System.out.println("the retrieved candidate fips!!!!!!: "+ candidateStateFIPS);
			
			String candidateWinPct = ExcelDubiousDemocracyParser.lookUpCandidateWinningPct(fNameLName); 
			System.out.println("the retrieved winning pct!!!!!!: "+ candidateWinPct);
			
			String candidateCongDistrict = ExcelDubiousDemocracyParser.lookUpCandidateCongDistrict(fNameLName); 
			System.out.println("the cong district of candidate is "+ candidateCongDistrict);		
			// end test
			model.addAttribute("candWinPct", candidateWinPct);	
	 		System.out.println("name converted:"+NameConverter.convertToFirstLastName(searchName.getCand_name()));
			
	 		//
	  		//USA TODAY Census Data
			//
	 		USATodayCensusResponse usaTodayResponse = USATodayCensus.retrieveCensusData(candidateStateFIPS, candidateCongDistrict);

			   model.addAttribute("population", usaTodayResponse.getPop());
			   model.addAttribute("pct_white", usaTodayResponse.getPctWhite());		   
			   model.addAttribute("pct_asian", usaTodayResponse.getPctAsian());
			   model.addAttribute("pct_hisp", usaTodayResponse.getPctHisp());
			   model.addAttribute("diversity_index", usaTodayResponse.getUSATDiversityIndex());

			  System.out.println("the retrieved POPULATION is: "+usaTodayResponse.getPop());
			  System.out.println("the retrieved PERCENT ASIAN is: "+usaTodayResponse.getPctAsian());	
	  		
	 		
	 		
		  model.addAttribute("cid", candidateInfo.getCid());	
		  model.addAttribute("cand_name", candidateInfo.getCand_name());	
		  model.addAttribute("cash_on_hand", candidateInfo.getCash_on_hand());
	      model.addAttribute("total_cash", candidateInfo.getTotal());
	      model.addAttribute("spent_cash", candidateInfo.getSpent());
	      model.addAttribute("first_elected", candidateInfo.getFirst_elected());
	      model.addAttribute("party", candidateInfo.getParty());
	      model.addAttribute("debt", candidateInfo.getDebt());
			
			logger.info("candidate info is", candidateInfo);
	      return "result";
	  }
	  catch (final NullPointerException e) {
		  logger.info("Failed find candidate", e.toString());
		  model.addAttribute("error_msg", "Could not retrieve data on candidate");	
	  }	  
	  return "search";
  	
  	}
	
	//currently unused
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String openSecretCall(@ModelAttribute searchCandidateForm searchForm, 
			   ModelMap model)  throws JsonParseException, JsonMappingException, IOException{
		
	    model.addAttribute("error_msg", searchForm.getError_msg());
		logger.info("search form error message", searchForm.getError_msg());
		
		return "search";
		
	}
	
}

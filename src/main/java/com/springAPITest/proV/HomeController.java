package com.springAPITest.proV;

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

import com.springAPITest.proV.forms.searchCandidateForm;
import com.springAPITest.proV.service.*;
import com.springAPITest.proV.service.data.BroadbandMapCensusResponse;
import com.springAPITest.proV.service.data.OpenSecretResponse;
import com.springAPITest.proV.service.data.USATodayCensusResponse;
import com.springAPITest.proV.service.impl.ExcelCIDParser;


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
	public String home(Locale locale, Model model) throws JsonParseException, JsonMappingException, IOException {
		logger.info("Welcome home! The client locale is {}.", locale);

	
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postRequest(Locale locale, Model model) throws JsonParseException, JsonMappingException, IOException {
		logger.info("Welcome home! The client locale is {}.", locale);

	
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		
		String CID = "N00002097";
		OpenSecretResponse candidateInfo = OpenSecretService.retrieveOpenSecretCandidateData(CID);
		
		System.out.println("Test / POST"+candidateInfo.getCash_on_hand());
		
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("cash_on_hand", candidateInfo.getCash_on_hand());
		model.addAttribute("cand_name", candidateInfo.getCand_name());
		model.addAttribute("cid", candidateInfo.getCid());
		model.addAttribute("spent_cash", candidateInfo.getSpent());
		model.addAttribute("total_cash", candidateInfo.getTotal());
		model.addAttribute("first_elected", candidateInfo.getFirst_elected());
		model.addAttribute("party", candidateInfo.getParty());
		model.addAttribute("debt", candidateInfo.getDebt());
		
		logger.info("candidate info is", candidateInfo);
		
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
  	
		  BroadbandMapCensusResponse broadbandResponse = BroadbandMapCensus.retrieveCensusData();
		  System.out.println("age 20-34 "+broadbandResponse.getAgeBetween20to34());
		  System.out.println("education bachelor or greater "+ broadbandResponse.getEducationBachelorOrGreater());
		  
		  
  		
  		//USA TODAY Census Data
		  USATodayCensusResponse usaTodayResponse = USATodayCensus.retrieveCensusData("01", "3");

		   model.addAttribute("population", usaTodayResponse.getPop());
		   model.addAttribute("pct_white", usaTodayResponse.getPctWhite());		   
		   model.addAttribute("pct_asian", usaTodayResponse.getPctAsian());
		   model.addAttribute("pct_hisp", usaTodayResponse.getPctHisp());
		   model.addAttribute("diversity_index", usaTodayResponse.getUSATDiversityIndex());

		  System.out.println("the retrieved POPULATION is: "+usaTodayResponse.getPop());
		  System.out.println("the retrieved PERCENT ASIAN is: "+usaTodayResponse.getPctAsian());	
  		
		//  
		//beginning of twitter  
		//  
	   Twitter twitterTemplate = twitterCreator.getTwitterTemplate();
	   
	   //search for user
	   List<TwitterProfile> userSearchList = twitterService.searchTwitterUsers(twitterTemplate, searchName.getCand_name());
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
	     
	   Iterator<Tweet> tweetIterator = tweetResults.iterator();
	   System.out.println("list of tweets related to user");
	   while (tweetIterator.hasNext()) {
		   Tweet currentTweet = tweetIterator.next();
		   System.out.println(currentTweet.getText());
		   System.out.println(currentTweet.getCreatedAt());
		}      

	   System.out.println(result.getTweets());
			   
	    
	  try{

		  String retrievedCID = ExcelCIDParser.lookupCandidateCID(searchName.getCand_name()); 
		  
		  OpenSecretResponse candidateInfo = OpenSecretService.retrieveOpenSecretCandidateData(retrievedCID);
	  
		  System.out.println("the retrieved cid is: "+retrievedCID);
		  System.out.println("Test openSecret POST "+candidateInfo.getCash_on_hand()); 
		  
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
		
		System.out.println("openSecret get method");
	    model.addAttribute("error_msg", searchForm.getError_msg());
		logger.info("candidate info is", searchForm.getError_msg());
		
		return "home";
		
	}
	
}

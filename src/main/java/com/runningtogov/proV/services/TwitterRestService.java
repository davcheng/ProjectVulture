package com.runningtogov.proV.services;

//import java.util.logging.Logger;
//
//import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Service;

//import com.springAPITest.proV.service.data.TwitterAccessToken;
//import com.springAPITest.proV.service.data.TwitterOAuthToken;


@Service
public class TwitterRestService {

	   //private Logger logger = LoggerFactory.getLogger(getClass());
	   //
	   public TwitterProfile getUser(Twitter twitter, String userName) {
	      try {
	         TwitterProfile userProfile = twitter.userOperations().getUserProfile(userName);
	         return userProfile;
	      } catch (RuntimeException ex) {
	       //  logger.error("Unable to tweet" + tweetText, ex);
	      }
	      return null;
	   }

	   public List<TwitterProfile> getListOfCongressMembers(Twitter twitter, String screenName, String listSlug) {
		   try {
	    	  
	         List<TwitterProfile> userProfile = twitter.listOperations().getListMembers(screenName, listSlug);
	         System.out.println(userProfile.toString());
	         return userProfile;
	      } catch (RuntimeException ex) {
	       //  logger.error("Unable to tweet" + tweetText, ex);
	      }
	      return null;
	   }
	   
	   public SearchResults searchTwitter(Twitter twitter, String searchString) {
		   try {
	    	  
	         SearchResults response = twitter.searchOperations().search(searchString);
	         System.out.println(response.toString());
	         return response;
	      } catch (RuntimeException ex) {
	       //  logger.error("Unable to tweet" + tweetText, ex);
	      }
	      return null;
	   }
	   
	   public List<TwitterProfile> searchTwitterUsers(Twitter twitter, String searchString) {
		   try {
	    	  
	         List<TwitterProfile> response = twitter.userOperations().searchForUsers(searchString);
	         System.out.println(response.toString());
	         return response;
	      } catch (RuntimeException ex) {
	       //  logger.error("Unable to tweet" + tweetText, ex);
	      }
	      return null;
	   }
}


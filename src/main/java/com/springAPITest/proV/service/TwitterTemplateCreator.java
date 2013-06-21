package com.springAPITest.proV.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;

@Component
public class TwitterTemplateCreator {
   @Autowired
   private Environment env;

//resource 
//http://www.javacodegeeks.com/2013/04/spring-social-twitter-setup.html
   public Twitter getTwitterTemplate() {
	   String consumerKey="jaO0BJfotFSpxLz3MxNKw";
	   String consumerSecret="8hhjWJMgfXqP7MDbo6x7HMoFvibsTO7aLjtRtDi7h8";
	   String accessToken="224362324-Xe7f2NBzjrtkw0ds1fJi26V3tiTKOa8qeZBBD2p4";
	   String accessTokenSecret="0cmMWikFH5JDuSqy8E4Me300Lo5LdIJKJS9wnvbLk";  
	   
//      String consumerKey = env.getProperty(accountName + ".consumerKey");
//      String consumerSecret = env.getProperty(accountName + ".consumerSecret");
//      String accessToken = env.getProperty(accountName + ".accessToken");
//      String accessTokenSecret = env.getProperty(accountName + ".accessTokenSecret");

      //
      TwitterTemplate twitterTemplate =
         new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
      return twitterTemplate;
   }
}
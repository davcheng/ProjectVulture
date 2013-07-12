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
   
   private static String consumerKey="jaO0BJfotFSpxLz3MxNKw";
   private static String consumerSecret="8hhjWJMgfXqP7MDbo6x7HMoFvibsTO7aLjtRtDi7h8";
   private static String accessToken="224362324-Xe7f2NBzjrtkw0ds1fJi26V3tiTKOa8qeZBBD2p4";
   private static String accessTokenSecret="0cmMWikFH5JDuSqy8E4Me300Lo5LdIJKJS9wnvbLk";


//resource 
//http://www.javacodegeeks.com/2013/04/spring-social-twitter-setup.html
   public Twitter getTwitterTemplate() { 
	   
//      String consumerKey = env.getProperty(accountName + ".consumerKey");
//      String consumerSecret = env.getProperty(accountName + ".consumerSecret");
//      String accessToken = env.getProperty(accountName + ".accessToken");
//      String accessTokenSecret = env.getProperty(accountName + ".accessTokenSecret");

      //
      TwitterTemplate twitterTemplate =
         new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
      // new TwitterTemplate(getConsumerKey(), getConsumerSecret(), getAccessToken(), getAccessTokenSecret());
      return twitterTemplate;
   }
   
public String getConsumerKey() {
	return consumerKey;
}
public void setConsumerKey(String consumerKey) {
	this.consumerKey = consumerKey;
}
public String getConsumerSecret() {
	return consumerSecret;
}
public void setConsumerSecret(String consumerSecret) {
	this.consumerSecret = consumerSecret;
}
public String getAccessToken() {
	return accessToken;
}
public void setAccessToken(String accessToken) {
	this.accessToken = accessToken;
}
public String getAccessTokenSecret() {
	return accessTokenSecret;
}
public void setAccessTokenSecret(String accessTokenSecret) {
	this.accessTokenSecret = accessTokenSecret;
}
}
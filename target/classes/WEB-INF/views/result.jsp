<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<c:url value="/resources/css/resultStyle.css" var="url" />
<link rel="stylesheet" href="${url}" type="text/css" media="screen, projection">
<title>Search Results</title>
</head>
<body>
	<h1>Open Secret Data:</h1>
		<P><font color="red">${error_msg}</font></P>
		
		<P>Search Results for ${cid}.</P>
		<P>candidate name = ${cand_name}.</P>
		<P>cash on hand = ${cash_on_hand}.</P>
		<P>spent cash = ${spent_cash}.</P>
		<P>total cash = ${total_cash}.</P>
		<P>first elected = ${first_elected}.</P>
		<P>party = ${party}.</P>
		<P>debt = ${debt}.</P>

	<h1>USA Today Census Data:</h1>		
		<P>Population ${population}.</P>
		<P>Percent White = ${pct_white}.</P>
		<P>Percent Asian= ${pct_asian}.</P>
		<P>Percent Hispanic = ${pct_hisp}.</P>
		<P>USA Diversity Index = ${diversity_index}.</P>

	<h1>Twitter Data:</h1>
		<P>twitter screen name = ${twitter_screen_name}.</P>
		<P>twitter name = ${twitter_name}.</P>
		<P>number of followers = ${followers_count}.</P>
		<P>number of friends = ${friends_count}.</P>
		<P>image = ${profile_img_url}.</P>
		<img src= "${profile_img_url}" alt="picture"> 
	<h1>Relevant Tweets:</h1>
	<c:forEach items="${tweetResults}" var="tweet">
		<P>${tweet.text}<br>${tweet.createdAt}</P>
	</c:forEach>	

</body>
</html>

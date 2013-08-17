<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/loading.js"></script> --%>

<html>
<head>
<c:url value="/resources/css/resultStyle.css" var="url" />
<link rel="stylesheet" href="${url}" type="text/css" media="screen, projection">
<title>Search Results</title>
</head>

<body>
	<div id="wrapper">

		<h1>Search Results for</h1>
		<P>Candidate: ${cand_name}.</P>
		<P>State: ${state}.</P>
		<P>Congressional District: ${congDistrict}.</P>
		<P>Party: ${candidateParty}.</P>
		<P>Year Elected: ${yearElected}.</P>
				
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
	
		<h1>Dubious Democracy Data:</h1>
			<P>Candidate's Prior Winning Percentage ${candWinPct}.</P>
	
		<h1>Broadband Data:</h1>		
		    
			<P>Age Between 5 to 19 ${ageFiveToNineteen}.</P>
			<P>Age Greater Than 60= ${ageGreaterThanSixty}.</P>
			<P>Percent White = ${white}.</P>
			<P>Percent Asian= ${asian}.</P>
			<P>Percent Hispanic = ${hispanic}.</P>
			<P>Median Income = ${median_income}.</P>
			<P>Income Greater than 200k = ${incGreaterThanTwohundred}.</P>
			<P>Below Poverty = ${belowPoverty}.</P>
			
	
	
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
	
	</div>


</body>
</html>

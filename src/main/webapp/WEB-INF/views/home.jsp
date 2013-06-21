<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:forward page="search.jsp"></jsp:forward>
<html>
<head>
<title>Home</title>
</head>
<div style="background-image:/Users/awsmdavid/Desktop/grey background.png;padding:5px;width:150px;height:200px;border:1px solid black;">
<p>See the background image?</p>
</div>
<body>
	<h1>Open Secret!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<!-- <P>The info of the candidate is ${candidateInfo}.</P>-->

	<P>candidate name = ${cand_name}.</P>
	<P>cash on hand = ${cash_on_hand}.</P>
	<P>cid = ${cid}.</P>
	<P>spent cash = ${spent_cash}.</P>
	<P>total cash = ${total_cash}.</P>
	
</body>
</html>

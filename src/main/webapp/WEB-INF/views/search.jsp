<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>


<html lang="en">
	<head>
		<meta charset="utf-8" />
		<c:url value="/resources/css/searchStyle.css" var="url" />
		<c:url value="/resources/css/autoCompleteSearchStyle.css" var="autoCompleteUrl" />
		<link rel="stylesheet" href="${url}" type="text/css" media="screen, projection">
		<link rel="stylesheet" href="${autoCompleteUrl}" type="text/css">
		<title>Search</title>
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/loading.js"></script>
		
<!-- 		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->

	</head>
	<h2 id="header" class="center">Search by Candidate Name</h2>
		<body onload='document.search.cand_name.focus();' class="center">	
			<div id="loading" style="display:none">
				<div id="pleaseWait">
					Searching the Universe
				</div>
				<div id="spinner_container">
					<img id="spinner" src="${pageContext.request.contextPath}/resources/img/progress-wheel.gif" alt="" />
				</div>
			</div>
			<div id="search">	
				<P>
					<font color="red">${error_msg}</font>
				</P>
				
				<form id="inputField" name="search" method="POST" onsubmit="loadingBar();">
					<input id="searchField" type="text" name="cand_name" autocomplete="off" placeholder="ex. Connolly, Gerry" size=25 maxlength=25>
			    	<input type="submit" id="submit" value="Search"/>
				</form>
			</div>
		</body>
</html>

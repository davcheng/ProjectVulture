<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%-- <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/loading.js"></script> --%>

<html>
<head>
<c:url value="/resources/css/searchStyle.css" var="url" />
<link rel="stylesheet" href="${url}" type="text/css" media="screen, projection">
<title>Search</title>
</head>

<h2>Search by Candidate Name</h2>
<body onload='document.search.cand_name.focus();'>				
	<div class="center">	
		<P>
			<font color="red">${error_msg}</font>
		</P>
		
		<form name="search" id="search" method="POST">
			<input type="text" name="cand_name" placeholder="ex. Connolly, Gerry" size=25 maxlength=25>
	    	<input type="submit" value="Search"/>
		</form>
	</div>

</body>

</html>

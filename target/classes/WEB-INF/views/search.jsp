<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<c:url value="/resources/css/searchStyle.css" var="url" />
<link rel="stylesheet" href="${url}" type="text/css" media="screen, projection">
<title>Search</title>
</head>

<h2>Search by Candidate Name</h2>
<div class="center">
	<P>
		<font color="red">${error_msg}</font>
	</P>
	
	<form id="search" method="POST">
		<input type="text" name="cand_name" value="ex. Warner, Mark" size=25 maxlength=25>
    	<input type="submit" value="Search"/>
	</form>
</div>

</body>

</html>

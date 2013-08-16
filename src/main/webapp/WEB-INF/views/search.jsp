<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%-- <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/loading.js"></script> --%>

<html>
<head>
<c:url value="/resources/css/searchStyle.css" var="url" />
<link rel="stylesheet" href="${url}" type="text/css" media="screen, projection">
<title>Search</title>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script>
$(document).ready(function(){
  $("#submit").click(function(){
    $(search).hide();
    $(h2).hide(); 
    $(loading).show();

  });
});
</script>
</head>

<h2 id="h2" class="center">Search by Candidate Name</h2>
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
			
			<form name="search" method="POST" onsubmit="loadingBar();">
				<input type="text" name="cand_name" placeholder="ex. Connolly, Gerry" size=25 maxlength=25>
		    	<input type="submit" id="submit" value="Search"/>
			</form>
		</div>
	</body>
</html>

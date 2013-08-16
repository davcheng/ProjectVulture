<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%-- <script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/resources/js/loading.js"></script> --%>

<html>
	<head>
		<meta charset="utf-8" />
		<c:url value="/resources/css/searchStyle.css" var="url" />
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
		<link rel="stylesheet" href="${url}" type="text/css" media="screen, projection">
		<title>Search</title>
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		
		<script>
		$(document).ready(function(){
		  	$("#submit").click(function(){
			    $(search).hide();
			    $(header).hide(); 
			    $(loading).show();
			});
		  
		$(function() {
			var availableTags = [
			"ActionScript",
			"AppleScript",
			"Asp",
			"BASIC",
			"C",
			"C++",
			"Clojure",
			"COBOL",
			"ColdFusion",
			"Erlang",
			"Fortran",
			"Groovy",
			"Haskell",
			"Java",
			"JavaScript",
			"Lisp",
			"Perl",
			"PHP",
			"Python",
			"Ruby",
			"Scala",
			"Scheme"
			];
			$( "#tagsss").autocomplete({
				source: availableTags
			});
		});
		</script>
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
				
				<form name="search" method="POST" onsubmit="loadingBar();">
					<input id="tags" type="text" name="cand_name" autocomplete="off" placeholder="ex. Connolly, Gerry" size=25 maxlength=25>
			    	<input type="submit" id="submit" value="Search"/>
				</form>
			</div>
			
			
			<div class="ui-widget">
				<label for="tags">Tags: </label>
				<input id="tagsss" />
			</div>
		</body>
</html>

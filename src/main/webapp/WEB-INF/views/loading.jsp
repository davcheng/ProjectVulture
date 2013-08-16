<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
    <head>
    	<c:url value="/resources/css/psdLoginStyle.css" var="url" />
		<link rel="stylesheet" href="${url}" type="text/css">
    </head>
    <body>
    	Searching the Universe
		<div id="spinner_container">
			<img id="spinner" src="${pageContext.request.contextPath}/resources/img/progress-wheel.gif" alt="" />
		</div>
		
    </body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <jsp:forward page="search.jsp" /> --%>

<html>
<head>
<title>Home</title>
<c:url value="/resources/css/searchStyle.css" var="url" />
<link rel="stylesheet" href="${url}" type="text/css" media="screen, projection">
</head>

<body>

	<h2>Project Vulture</h2>
	<h2><A href="search">Enter</A></h2>
</body>
<body>
    <h3>Message : ${message}</h3>   
    <h3>Username : ${username}</h3>   
   
    <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
   
</body>
</html>

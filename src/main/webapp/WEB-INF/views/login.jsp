<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<c:url value="/resources/css/searchStyle.css" var="url" />
<link rel="stylesheet" href="${url}" type="text/css" media="screen, projection">
<title>Search</title>
</head>

<h2>Search by Candidate Name</h2>

    <body>
      <form action="/spring_security_check" method="POST">
        <label for="username">User Name:</label>
        <input id="username" name="j_username" type="text"/>
        <label for="password">Password:</label>
        <input id="password" name="j_password" type="password"/>
        <input type="submit" value="Log In"/>
      </form>
    </body>

</html>

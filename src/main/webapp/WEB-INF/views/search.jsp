<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<title>Search</title>
</head>
<body background="./Users/awsmdavid/Desktop/grey background.png">
<h2>Search Candidate</h2>
	<P><font color="red">${error_msg}</font></P>
<form id="search" method="POST">
<!--     <select id="cand_name" name="cand_name"> -->
<!--         <option value="N00002097">Mark Warner</option> -->
<!--         <option value="N00027493">Michelle Bachman</option> -->
<!--         <option value="Warner, Mark">Warner, Mark</option> -->
<!--         <option value="Smith, Diane">Diane Smith</option> -->
<!--     </select> -->
 <input type="text" name="cand_name" value="ex. Warner, Mark">

    <input type="submit" value="Submit"/>
</form>

</body>

</html>

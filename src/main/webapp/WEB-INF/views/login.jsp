<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
    <head>
    	<c:url value="/resources/css/psdLoginStyle.css" var="url" />
		<link rel="stylesheet" href="${url}" type="text/css">
    </head>
    <body onload='document.loginForm.j_username.focus();'>
	    <form name='loginForm' action="<c:url value='j_spring_security_check.html' />"
	        method='POST'>
	            <h1>
	            	<span>Login <font color="red"> ${error} </font> </span>
					
				</h1>
	            <div>
	                <input type="text" name="j_username" placeholder="User Id"/>
	                <input type="password" name="j_password" placeholder="Password"/>
	            </div>
	
	           <input type="submit" value="Sign In"/>
	    </form>
        <form>
			<input Type="button" VALUE="Need to Register?" ONCLICK="window.location.href='register'"> 
		</form>
    </body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>

<head>
	<meta charset="utf-8" />
	<title> Vulture Project </title>
	<c:url value="/resources/css/style.css" var="cssUrl" />
	<link rel="stylesheet" href="${cssUrl}" type="text/css">
	<meta http-equiv="X-UA-Compatible" content="IE=8">
	<meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0'/>
	<link rel="shortcut icon" href="img/favicon.ico">
	<!-- 57x57 older iPhone and Android devices -->
	<link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-precomposed.png">
	<!-- iPad 1 and 2 & iPad mini -->
	<link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
	<!-- iPhone 4, 4S, 5 and iPod Touch -->
	<link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">
	<!-- iPad 3rd gen -->
	<link rel="apple-touch-icon" sizes="144x144" href="img/apple-touch-icon-144x144.png"> 
</head>

<body>
<!-- <body onload='document.loginForm.emailInput.focus();'> -->
	<div class="body-header">		
		<div class="logo-and-tabs">
			<h1 class="logo">
				<img name="Vulture Project" role="title" src="${pageContext.request.contextPath}/resources/img/logo.png">
			</h1>
			<div id="login">
				<p><a href="${pageContext.request.contextPath}/login">Log in</a></p>
			</div>
			<div id="create-account">
				<p><a href="${pageContext.request.contextPath}/sign-up">Create Account</a></p>
			</div>
		</div>
	</div>

	<div class="main">

		<div id="formbox-login" class="formbox">
		<form name='loginForm' action="<c:url value='j_spring_security_check.html' />"
	        method='POST'>
					
			<h1>Log in to Vulture Project</h1>
			
			<h2 class="errorMsg">${error}</h2>
			
			<h2>Email</h2>
			<input id="emailInput" class="text" type="text" name="j_username" placeholder="type email here">
				
			<h2>Password</h2>
			<input id="passwordInput" class="text" type="text" name="j_password" placeholder="type password here">
			
			<ul class="checkbox-and-button">

				<li id="remember-me">
					<input id="form-login-remember" class="checkbox" type="checkbox" value="T" tabindex="10" name="remember" defaultvalue="T" autocomplete="off">
					<label for="form-login-remember"> Remember my email on this computer</label>
				<li id="log-in">
					<input class="btn btn-primary signup-submit" type="submit" value="Log in" tabindex="11">
	    		</li>
	    	
			</ul>
		</form>
		
		</div>	
	
		<div id="formbox-login-tips">
			<h2>Don't have an account?</h2>
			<a href="${pageContext.request.contextPath}/sign-up">Sign up now!</a>
			<h2 class="pwd">Forget your password?</h2>
			<a href="#">Recover it here.</a>	
		</div>

	</div>	

	<footer>
		<div class="copyright">
		<p>© 2013 Vulture Project, All Rights Reserved.</p>
		</div>
	</footer>

</body>

</html>
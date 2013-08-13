<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
    <head>
    	<c:url value="/resources/css/psdLoginStyle.css" var="url" />
		<link rel="stylesheet" href="${url}" type="text/css">
    </head>
    <body>
        <form>
            <h1><span>Sign up!</span></h1>
            <div class="col_left">
                <input type="text" class="ok" placeholder="User Id"/>
                <input type="email" class="borderleft" placeholder="Email"/>
            </div>
            <div class="col_right">
                <input type="password" class="ko  borderleft" placeholder="Password"/>
                <input type="email" class="" placeholder="Confirm your email"/>
            </div>
            
            <h2>Personal Details</h2>         
            
            <div class="col_left">
                <input type="text" placeholder="First Name"/>
                <input type="text" placeholder="Website"/>
            </div>
            <div class="col_right">
                <input type="text" class="" placeholder="Last Name"/>
                <input type="text" placeholder="Twitter Username"/>
            </div>
            
<!--             <select name="state" id="state"> -->
<!--                <option value="AK">AK</option> -->
<!--                <option value="AZ">AZ</option> -->
<!--                <option value="AR">AR</option> -->
<!--                <option value="CA">CO</option> -->
<!--                <option value="CO">CO</option> -->
<!--                <option value="CT">CT</option> -->
<!--                <option value="DE">DE</option> -->
<!--                <option value="DC">DC</option> -->
<!--                <option value="FL">FL</option> -->
<!--                <option value="GA">GA</option> -->
<!--                <option value="HI">HI</option>                -->
<!--                <option value="IA">IA</option> -->
<!--                <option value="ID">ID</option> -->
<!--                <option value="IL">IL</option> -->
<!--                <option value="IN">IN</option> -->
<!--                <option value="KS">KS</option> -->
<!--                <option value="KY">KY</option>                -->
<!--                <option value="LA">LA</option> -->
<!--                <option value="MA">MA</option> -->
<!--                <option value="MD">MD</option> -->
<!--                <option value="ME">ME</option> -->
<!--                <option value="MI">MI</option> -->
<!--                <option value="MN">MN</option>                -->
<!--                <option value="MS">MS</option>                -->
<!--                <option value="MO">MO</option> -->
<!--                <option value="MT">MT</option> -->
<!--                <option value="NE">NE</option> -->
<!--                <option value="NV">NV</option> -->
<!--                <option value="NH">NH</option> -->
<!--                <option value="NJ">NJ</option>  -->
<!--                <option value="NM">NM</option>                -->
<!--                <option value="NY">NY</option> -->
<!--                <option value="NC">NC</option> -->
<!--                <option value="ND">ND</option> -->
<!--                <option value="OH">OH</option> -->
<!--                <option value="OK">OK</option> -->
<!--                <option value="OR">OR</option> 	 -->
<!--                <option value="PA">PA</option> -->
<!--                <option value="RI">RI</option> -->
<!--                <option value="SC">SC</option> -->
<!--                <option value="SD">SD</option> -->
<!--                <option value="TN">TN</option>  -->
<!--                <option value="TX">TX</option>                -->
<!--                <option value="UT">UT</option> -->
<!--                <option value="VT">VT</option> -->
<!--                <option value="VA">VA</option> -->
<!--                <option value="WA">WA</option> -->
<!--                <option value="WV">WV</option> -->
<!--                <option value="WI">WI</option>  -->
<!--                <option value="WY">WY</option>                -->

<!--            </select> -->
           <input type="submit" value="Sign Up"/>
        </form>
        <form>
			<input Type="button" VALUE="Back to Login" ONCLICK="window.location.href='login'"> 
		</form>
    </body>
</html>

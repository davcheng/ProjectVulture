<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<c:url value="/resources/css/searchStyle.css" var="url" />
<link rel="stylesheet" href="${url}" type="text/css" media="screen, projection">
<title>Search</title>
</head>

<h2>Search by Candidate Name</h2>

 <h3>Login with Username and Password (Custom Page)</h3>

    <c:if test="${not empty error}">
        <div class="errorblock">
            Your login attempt was not successful, try again.<br /> Caused :
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
    </c:if>

    <form name='f' action="<c:url value='j_spring_security_check' />"
        method='POST'>

        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='j_username' value=''>
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='j_password' />
                </td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                    value="submit" />
                </td>
            </tr>
            <tr>
                <td colspan='2'><input name="reset" type="reset" />
                </td>
            </tr>
        </table>

    </form>
</body>

</html>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MED System</title>

    <link href="<c:url value="resources/bootstrap.min.css" />" rel="stylesheet">

    <link href="<c:url value="resources/signin.css" />" rel="stylesheet">
	
	<script src="resources/jquery-2.1.1.min.js"></script>
	
</head>

<body>
 

		
      <form class="form-signin" name='loginForm'
		  action="<c:url value='j_spring_security_check' />" method='POST'>
        <h2 class="form-signin-heading" id = "loginHeader">Please sign in</h2>
        <input type="text" class="form-control" name='username' placeholder="Email address" required autofocus>
        <input type="password" class="form-control" name='password' placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit" id = "signIn">Sign in</button>
 <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			
		<c:if test="${not empty error}">
			<div class="alert alert-danger" style="margin-top: 5px;;" role="alert">${error}</div>
		</c:if>
		
      </form>
     

    
    </body>
</html>
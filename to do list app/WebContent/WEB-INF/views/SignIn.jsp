<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignIn</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>

<div class="login">
<nav>
		<img src="./assets/logo.svg" alt="logo"/>
		<ul>
			<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
			<li><a href="${pageContext.request.contextPath}/signUp">Signup</a></li>
		</ul>
	</nav>
	<div class="welcome-back">WELCOME BACK</div>
<form action="${pageContext.request.contextPath}/login" method="post">
  <input type="text" placeholder="Username" id="username" name="username">  
  <input type="password" placeholder="Password" id="password" name="password">  
    <input type="submit" value="Sign In">
    <a href="#" class="forgot">forgot password?</a>
    </form>
</div>

</body>
</html>
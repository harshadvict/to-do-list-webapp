<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<div>
<form action="${pageContext.request.contextPath}/edit" method="post">
	<input type="text" name="title">
	<input type="date" name="lastdate">
	<select id="cars" name="status">
  		<option value="true">true</option>
  		<option value="false">false</option>
	</select>
	<input type="text" name="description">
	<button class="button" type="submit">Edit</button>
</form>
</div>
</body>
</html>
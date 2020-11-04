<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<p>To do list</p>
<div>
<form action="${pageContext.request.contextPath}/newTodo" method="post">
	<input type="text" name="title">
	<input type="date" name="lastdate">
	<select id="cars" name="status">
  		<option value="true">true</option>
  		<option value="false">false</option>
	</select>
	<input type="text" name="description">
	<button class="button" type="submit">Add New</button>
</form>
</div>

<div class="body-div2">

<c:forEach var="todo" items="${list}">
      <div class="article-card">
            <img src="./assets/java card image.svg" alt="">
            <div class="card-text">
                <h1 id="blog-title"><c:out value="${todo.getDescription()}"  /></h1>
                <p id="blog-description"><c:out value="${todo.getTitle()}" /></p>
                <p>Added On<b><c:out value="${todo.getAddedOn()}" /></b> </p>
                 <p>Last date <b><c:out value="${todo.getLastDate()}" /></b> </p>
            </div>
      	  <div class="card-buttons">
             <a href="edit?id=<c:out value='${todo.getId()}' />"><button type="button" id="edit">EDIT</button></a> 
             <span>|</span>
             <a href="delete?id=<c:out value='${todo.getId()}'/>"><button id="delete">DELETE</button></a>
            </div>
        </div>
 </c:forEach> 
</div>
</body>
</html>
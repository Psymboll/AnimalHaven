<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.hrmgroup.animalspring.entities.*,java.util.List,java.util.Set"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>


<html lang="en">
<head>
<meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


<title>AnimalHaven</title>
</head>
<body>
<!--  nb questo si può mettere nell'header -->
<div class ="row bg-warning text-white">
	<div class = "col-2">
	<a href="http://localhost:8080/AnimalSpring/index" style="text-align:right;padding-left:10px"> Home Page</a>
	
	</div>
	<div class = "col-8"></div>
	<div class = "col-2">
		<div class = "login container" style="text-align:left" >
		<c:if test='${user.isGuest() }'>
			<a href="http://localhost:8080/AnimalSpring/formlogin"> Login</a>
			<a href="http://localhost:8080/AnimalSpring/register"> Register</a>
		   </c:if> 
		
		<c:if test='${!user.isGuest() }'>
			<a href="http://localhost:8080/AnimalSpring/profile"><c:out value = "${user.loggeduser.username}"/>
			</a>
			<a href="http://localhost:8080/AnimalSpring/logout">Logout</a>
		</c:if>
	</div>
	</div>
</div>

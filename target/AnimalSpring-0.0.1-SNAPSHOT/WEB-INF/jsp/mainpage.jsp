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
<link  rel="stylesheet"href="AnimalDBStyle.css"/>

<title>AnimalHaven</title>
</head>
<body>
<!--  nb questo si può mettere nell'header -->
<div class ="row bg-warning text-white">
	<div class = "col-2">
	<a href="http://localhost:8080/AnimalDB/Index" style="text-align:right;padding-left:10px"> Home Page</a>
	
	</div>
	<div class = "col-8"></div>
	<div class = "col-2">
		<div class = "login container" style="text-align:left" >
		<c:if test='${user.isGuest() }'>
			<a href="http://localhost:8080/AnimalDB/Login"> Login</a>
			<a href="http://localhost:8080/AnimalDB/Login?command=formnewuser"> Register</a>
		   </c:if> 
		
		<c:if test='${!user.isGuest() }'>
			<a href="http://localhost:8080/AnimalDB/Profile"><c:out value = "${user.getUsername()}"/>
			</a>
			<a href="http://localhost:8080/AnimalDB/Login?command=logout">Logout</a>
		</c:if>
	</div>
	</div>
</div>


<div class="text-center">
<img class="img-fluid" alt="Responsive image" src="https://vistapointe.net/images/pets-4.jpg" style="height:500px"/>
</div>




<div class ="row">

<div class = "col"></div>
<div class = "col">
	<div class="mainpage title"><h1> Search our Website for many cute animals!</h1></div>
	
	<div id=searchBar style="padding-top:25px">
	
	<form action="Index">
		<select name="animaltype" id="selectanimal">
		  	  <option value="">Select a type of animal</option>
			  <option value="Cat">Cat</option>
			  <option value="Dog">Dog</option>
			  <option value="Rabbit">Rabbit</option>
			  <option value="Hamster">Hamster</option>
			  <option value="Turtle">Turtle</option>
			  <option value="Snake">Snake</option>
		 </select>
		 <input type = "hidden" name = "command" value = "searchanimal"/>
		<button type="submit" class="btn btn-warning"  value="send" disabled  id ="searchbutton">
			Search
		</button>
		</form>
		 
	<a href="http://localhost:8080/AnimalDB/Index?command=searchanimal">See the entire list of animals saved on our website </a>
	</div>

</div>
<div class = "col"></div>


</div>


<script>
	$(document).ready(function()
	{
		
		$('#selectanimal').change(function()
		{
			
			
			$('#searchbutton').prop
			(
					'disabled',
					!($('#selectanimal').val())
			)
			
		});
	})


</script>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.hrmgroup.animalspring.entities.*,java.util.List,java.util.Set"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    
<!DOCTYPE html>

<jsp:include page="header.jsp"/>

<div class="text-center">
<img class="img-fluid" alt="Responsive image" src="https://vistapointe.net/images/pets-4.jpg" style="height:500px"/>
</div>


<div class="searchcontainer">
	<div class ="row">
	
		<div class = "col"></div>
		<div class = "col">
			<div class="mainpage title"><h1> Search our Website for many cute animals!</h1></div>
				
				<div id=searchBar style="padding-top:25px">
				<div>
					<form action="search" method="post">
						<select name="animaltype" id="selectanimal">
						  	  <option  value="">Select a type of animal</option>
						  	  <c:forEach items="${animalTypes }" var="animalType">
						  	  <option value="${animalType }"> ${animalType } </option>
						  	  </c:forEach>
							  
						 </select>
					
						
						<button type="submit" class="btn btn-warning"  value="send" disabled  id ="searchbutton" style="padding-left:200 px">
							Search
						</button>
						</form>
					</div>
					<div class = "allsearch" style="padding-top:15px">
					 <form action="search" method="post">
					 	<input type="hidden" name="animaltype" value=""/>
						<button type="submit" class="btn btn-warning" >See the entire list of animals saved on our website </button>
					</form>
				</div>		
				
			
			</div>
		</div>
		<div class = "col"></div>
	
	</div class="row">
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
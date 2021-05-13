<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.hrmgroup.animalspring.entities.*,java.util.List,java.util.Set"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp"/>




<div class="container">
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6" style="padding: 50px 0px 50px 0px"> <h1>${profileOwner.username}</h1> </div>
		<div class="col-3"></div>
	</div>

	<div class = "row"> 
		
		<!--  never use table again!!! it doesn't center easily with other elements -->
		<div class="col-3">
		
		<div class="animalTitle" style="text-align:center"> <h3>${profileOwner.username}'s Animals</h3>  </div>
			
				<table class="table" >
					<thead>
						<tr>
							<th scope="row">Name:</th>
							<th scope="row"> Age:</th>
							<th scope="row"> Type:</th>
						
						</tr>
					<thead>
				<tbody>
					<c:forEach items="${ownedAnimals}" var ="animal">
						<tr>
							<td class="animalName"> ${animal.animalname } </td>				
							<td class="animalName">	${animal.animalage } </td>		
							<td class="animalName">${animal.animaltype} </td>			
						<tr>	 
					</c:forEach>
				</tbody>
				</table>
			
		</div>
		
		<!--  questa parte è da cambiare con legend -->
		
		<div class="col-9">
			<fieldset>
				<c:if test="${user.loggeduser.getId() == profileOwner.getId()}">
					<legend class="insertAnimalTitle" > Save a new Animal  </legend>
					
					
					<fieldset>
					
						<form:form action = "savenewanimal" method="post" modelAttribute="newanimal" >
						<div class="row g-3 align-items-center">
							<div class="col-4">
								<label for="insertname" class="col-form-label">Name of your animal</label>
							</div>	
							<div class="col-4">
								<form:input class="newanimalform form-control" id="insertname" path="animalname" type = "text"/>
							</div>	
							<div class="col-4">
								<span class="form-text">
									<form:errors path="animalname"  style="color:DarkRed"/>
								</span>
							</div>
						</div>
						<div class="row align-items-center g-3 ">
							<div class="col-4">
								<label for="insertage" class="col-form-label"  >Age of your animal</label>
							</div>	
							<div class="col-4">	
								<form:input class="newanimalform form-control" id="insertage" path = "animalage" type = "number"/>
							</div>
							<div class="col-4">
								<span class="form-text">	
									<form:errors path="animalage" style="color:DarkRed"/>
								</span>		
							</div>	
						</div>
					
						<div class="row g-3 align-items-center">
							<div class="col-4">
								<label for="selectanimal"class="newanimalform col-form-label" >Type of your animal  </label>
							</div>	
							<div class="col-4">	
							<!--  form-select from bootstrap doesn't style this for some reason -->
								<form:select path="animaltype" id="selectanimal" class="newanimalform form-select " items="${animalTypes }">
							
							  	<option selected>Select a type of animal</option>
							  
						     </form:select>
						    </div>
						    <div class="col-4">	
						    	<span class="form-text">	 
						     		<form:errors path="animaltype" style="color:DarkRed"/>
						     	</span>			
						    </div>	 
						</div>	
							<!--  ci sarà sicuramente un modo migliore di fare questo -->
							<form:hidden
							
							path = "owner.username"
							value = "${user.loggeduser.username}"/>
							<form:hidden
							
							path = "owner.email"
							value = "${user.loggeduser.email}"/>
							<form:hidden
							
							path = "owner.password"
							value = "${user.loggeduser.password}"/>
							<form:hidden
							
							path = "owner.id"
							value = "${user.loggeduser.id}"/>
							<div style = "padding-top:10 px">
								<button type="submit" class="btn btn-warning"  class="newanimalform"  value="send" id="newanimalbutton" >
									Send
								</button>
							</div>
							<form:errors path="owner.id"/>
							</form:form>
							</fieldset>
						
						
				
					
					
					
					</c:if>
				</fieldset>
				
			</div>
			
			
			
		
	
	</div>
</div>


<script>
/*
	$(document).ready(function()
	{
		
		$('.newanimalform').change(function()
		{
			
			console.log($('#selectanimal').val())
			$('#newanimalbutton').prop
			(
					'disabled',
					!($('#insertname').val() && $('#insertage').val() && $('#selectanimal').val())
			)
			
		});
	})
*/

</script>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


</body>
</html>
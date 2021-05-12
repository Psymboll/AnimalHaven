<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.hrmgroup.animalspring.entities.*,java.util.List,java.util.Set"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp"/>




<div class="container">
	<div class="row">
		<div class="col-4"></div>
		<div class="col-4" style="padding: 50px 0px 50px 0px"> <h1>${profileOwner.username}</h1> </div>
		<div class="col-4"></div>
	</div>
</div>
<div class = "row"> 
	<div class="col-2"></div>
	<div class="col-4">
	<div class="animalTitle" style="padding: 25px 25px 25px 0px"> <h2>${profileOwner.username}'s Animals</h2>  </div>

	<c:forEach items="${ownedAnimals}" var ="animal">
		<div class= animalList style="padding: 5px 0px 5px 0px">
		<div class="animalName"><h5> Name: </h5>  </div>
				
				${animal.animalname }
				
		<div class="animalName"><h5> Age: </h5>  </div>
				${animal.animalage }
				
		<div class="animalName"><h5> Type: </h5>  </div>			
				${animal.animaltype}
				
		</div> 
	</c:forEach>
	</div>
	
	<div class="col-4">
	<c:if test="${user.loggeduser.getId() == profileOwner.getId()}">
		<div class="insertAnimalTitle" style="padding: 25px 25px 25px 0px"> <h2>Save a new Animal</h2>  </div>
	</c:if>
	<c:if test="${user.loggeduser.getId() == profileOwner.getId()}">
		<form:form action = "savenewanimal" method="post" modelAttribute="newanimal" >
		
		<div  style ="padding-bottom: 5px"  >Name of your animal</div>
		<form:input
		class="newanimalform"
		id="insertname"
		path="animalname"
		type = "text"
		/>
		
		<div  style ="padding-bottom: 5px" >Age of your animal</div>
		<form:input
		class="newanimalform" 
		id="insertage"
		path = "animalage"
		type = "number"
		/>
		
		
	
		
			<div id="selecttype" style ="padding-bottom: 5px" class="newanimalform" >Type of your animal  </div>
			<form:select path="animaltype" id="selectanimal" class="newanimalform">
			  <option value="">Select a type of animal</option>
			  <option value="Cat">Cat</option>
			  <option value="Dog">Dog</option>
			  <option value="Rabbit">Rabbit</option>
			  <option value="Hamster">Hamster</option>
			  <option value="Turtle">Turtle</option>
			  <option value="Snake">Snake</option>
		     </form:select>
			
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
				<button type="submit" class="btn btn-warning"  class="newanimalform" disabled value="send" id="newanimalbutton" >
					Send
				</button>
			</div>
			</form:form>
			
		
		

	
		</c:if>
		</div>
		
		
		<div class="col-2"></div>
	

</div>


<script>
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


</script>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


</body>
</html>
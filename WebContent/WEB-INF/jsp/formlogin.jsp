<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.hrmgroup.animalspring.entities.*,java.util.List,java.util.Set"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<jsp:include page="header.jsp"/>



<div class="login container">
	<div class="row">
	<div class=col-3></div>
		<div class=col-6>
			<form:form action="login" method = "post" modelAttribute="logginguser" >
				<div class="row g-3 align-items-center" style = "padding-top:25px">
					<div class=col-6>
						<label for="emailinput" class="col-form-label">Email</label>
					</div>
					<div class="col-6">	
						<form:input class="loginform form-control" id="emailinput" path="email" type = "email"/>
					</div>
				
					
				
				</div>	
				<div class="row g-3 align-items-center">
					<div class=col-6>
						<label for="passwordinput" class="col-form-label">Password</label>
					</div>
					
					<div class="col-6">
						<form:input class="loginform form-control" id="passwordinput" path = "password" type = "password"/>
					</div>
				</div>
				<div class="col-6" style ="padding-top: 5px">
						<button id="loginbutton" type="submit" class="btn btn-warning " disabled value="Login" > Login </button>
				</div>
				
				<form:errors  class="form-text" path="" style="color:DarkRed"/>
			</form:form>
		</div>
			
				
			
		
		<div class=col-3></div>
	</div>
</div>
<script>
	$(document).ready(function()
	{
		
		$('.loginform').change(function()
		{
			console.log("it's working")
			$('#loginbutton').prop
			(
					'disabled',
					!($('#emailinput').val() && $('#passwordinput').val())
			)
			
		});
	})


</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>
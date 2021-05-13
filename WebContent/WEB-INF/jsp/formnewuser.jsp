<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.hrmgroup.animalspring.entities.*,java.util.List,java.util.Set"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp"/>




<div class = "formregister container" style="padding-top:25px" >
	<div class = "row">
	<div class = "col-2"></div>
	<!--  da sistemare il discorso delle col, studia bootstrap -->
	<div class = "col-8">
		<form:form action = "saveuser" method = "post" modelAttribute="newuser" >
		
			<fieldset> <!--  fieldset pare non funzionare -->
			<legend>  Register now  </legend>
			<div class="row g-3 align-items-center">
				<div class="col-4">	
					<label for="usernameinput"class="col-form-label" > Username </label>
				</div>
				<div class="col-4">		
					<form:input id="userinput" class="registerform form-control" path="username"/>
				</div>
				<div class="col-4">	
					
					<form:errors path="username"  style="color:DarkRed"/>
					
				</div>	
				
			</div>
			
			<div class="row g-3 align-items-center">
				<div class="col-4">	
					<label for="emailinput" class="col-form-label">Email</label>
				</div>
				<div class="col-4">		
					<form:input class="registerform form-control" id="emailinput" path = "email" />
				</div>	
				<div class="col-4">		
					<form:errors path="email"  style="color:DarkRed"/>
				</div>	
					
				</div>	
				
			<div class="row g-3 align-items-center">
				<div class="col-4">	
					<label for="password1input" class="col-form-label">Password </label>
				</div>
				<div class="col-4">	
					<form:password class="registerform form-control" id="password1input" path="password"/>
				</div>
				<div class="col-4">		
					<form:errors path="password"  style="color:DarkRed"/>
				</div>
				
			</div>
			<div class="row g-3 align-items-center">
				<div class="col-4">		
					<label for="password2input" class="col-form-label">Repeat Password </label>
				</div>
				<div class="col-4">	
				<input class="registerform form-control" id="password2input" name="password2"/>
				</div>
				<div class="col-4">	</div>
			</div>
				<br>
				<div class="row">
				<div class="col-4" style="padding-bottom:5px">
				
					<button type="submit" class="btn btn-warning text-white" id="registerbutton" value="register now" > Register Now </button>
					
				</div>
					
				</div>


			</fieldset>
		</form:form>	
	</div>
	<div class = "col-2"> </div>
	
	</div>
	</div>


<script>

	$(document).ready(function()
	{
		
		$('.registerform').change(function()
		{
			
			$('#registerbutton').prop
			(
					'disabled',
					(!($('#emailinput').val() && $('#password1input').val() && $('#password2input').val() && $('#userinput').val()))
						&&($('#password1input').val() === $('#password2input').val())
			)
			
		});
	})


</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
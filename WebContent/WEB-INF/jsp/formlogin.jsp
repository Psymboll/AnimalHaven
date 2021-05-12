<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.hrmgroup.animalspring.entities.*,java.util.List,java.util.Set"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>



<div class="login container">
	<div class="row">
	<div class=col></div>
		<div class=col>
		<form action="login" method = "post" >
			<div class = "col-2" style="padding-top:5px">Email</div>
			<div class="col-2">
			<input
			class="loginform"
			id="emailinput"
			name = "email"
			type = "email"/>
			</div>
			<div class = "col-2" style="padding-top:5px">Password </div>
			<div class="col-2">
			<input
			class="loginform"
			id="passwordinput"
			name = "password"
			type = "password"/>
			</div>
			
			<div class="col-2" style ="padding-top: 5px">
				<button id="loginbutton" type="submit" class="btn btn-warning " disabled value="Login" > Login </button>
			</div>
			
			
			
		</form>
		</div>
		<div class=col></div>
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
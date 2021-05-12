<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.hrmgroup.animalspring.entities.*,java.util.List,java.util.Set"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="header.jsp"/>


<div class = " register title" style="text-align:center;padding:100px 0px 100 px 0 px"><h2> Use this form to register </h2> </div>

<div class = "formregister container" style="padding-top:25px" >
	<div class = "row">
	<div class = "col-4"></div>
	<div class = "col-4">
		<form:form action = "register" method = "post" modelAttribute="newuser">
		<div class="col-2"> Username </div>
	
		<div class="col-2" style="padding-bottom:5px">
		<form:input
		id="userinput"
		class="registerform"
		path="username"
		/>
		</div>
		<div class="col-2">Email</div>
		<div class="col-2" style="padding-bottom:5px">
		<form:input
		class="registerform"
		id="emailinput"
		path = "email"
		/>
		</div>
		
		
		
		<div class="col-2">Password </div>
		<div class="col-2" style="padding-bottom:5px">
		<form:input
		class="registerform"
		id="password1input"
		path="password"
		type="password"
				/>
		
		</div>
		<div class="col-2">Repeat Password </div>
		<div class="col-2" style="padding-bottom:5px">
		<input
		class="registerform"
		id="password2input"
		name = "password2"
		type = "password"
		/>
		</div>
		
		
		<div class="col-2" style="padding-bottom:5px">
		
			<button type="submit" class="btn btn-warning text-white" disabled id="registerbutton" value="register now" >
			Register Now
			
			</button>
		</div>



		</form:form>
	</div>
	<div class = "col-4"></div>
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


</body>
</html>
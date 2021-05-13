<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.hrmgroup.animalspring.entities.*,java.util.List,java.util.Set"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>



<div class="container">
	<div class = "row"> 
		<div class="col-2"></div>
		<div class="col-8">
		
		<h2> Here are the Animals you wanted</h2>
		<br>
			<table class = "table">
				
					
					<!-- head of the table -->
					<thead>
					<tr>
						<th scope="col"><h5>Name:</h5> </th>
						 
								
						<th scope="col"><h5> Age:</h5> </th>		
								
						  
						<th scope="col"><h5>Type: </h5>  </th>	
								
						 
						<th scope="col"><h5> Owned By: </h5></th>
						<th scope="col"></th>	
					</tr>   
				</thead>
					
				<tbody>
				<c:forEach items="${animals}" var ="animal">
						<tr>
							<td> ${animal.animalname }</td>
							<td> ${animal.animalage }</td>	
							
							<td> ${animal.animaltype}</td>
							
							<td> ${animal.owner.username }</td>
							
							<td>
							<!--  forse da cambiare in un link -->
								<form action="profile/${animal.owner.id}" method = "post">
									
									<button type="submit" class="btn btn-warning"  value="Go to Profile" >
									Go to Profile
							
									</button>
							
								
								</form>
							 
							 </td>
						</tr>
					</c:forEach>		
				</tbody>
					
				
			</table>
		</div>
		<div class="col-2"></div>
		</div>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>
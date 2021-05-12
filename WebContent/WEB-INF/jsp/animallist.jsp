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
		<c:forEach items="${animals}" var ="animal">
			<div class= animalList style="padding: 5px 0px 5px 0px">
			<div class="titles row">
			<div class="col-3"><h5>Name:</h5> </div>
			 
					
			<div class="col-3"><h5> Age:</h5> </div>		
					
			  
			<div class="col-3"><h5>Type: </h5>  </div>	
					
			 
			<div class="col-3"><h5> Owned By: </h5></div>	
			   
			</div>
			<div class="animal row">
			
				
				<div class="col-3"> ${animal.animalname }</div>
				<div class="col-3"> ${animal.animalage }</div>	
				
				<div class="col-3"> ${animal.animaltype}</div>
				
				<div class="col-3"> ${animal.owner.username }
					<form action="profile" method = "post">
					<input  name ="userid" type="hidden" value="${animal.owner.id }"/>
					<button type="submit" class="btn btn-warning"  value="Go to Profile" >
					Go to Profile
			
					</button>
				
					
					</form>
				 
				 </div>
					
			</div>		
			</div> 
		</c:forEach>
		</div>
		<div class="col-2"></div>
		</div>
	</div>

</body>
</html>
<%@ taglib uri  ="http://java.sun.com/jsp/jstl/core" prefix  ="c" %>

<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

	<title>List Sales Representatives</title>
	
	<link type = "text/css"
				  rel = "stylesheet"
				  href = "${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id = "wrapper">
		
		<div id = "header">
		
			<h2>CRM Customer Relationship Manager : SALES REPS</h2>
		
		</div>
	
	</div>
	
	<div id = "container">
	
		<div id="content">
		
			<input type = "button" value = "Add Sales Rep"
				onclick = "window.location.href = 'showFormForAdd'; return false;"
				class = "add-button"
				/>
			|
			<input type = "button" value = "Customers"
				onclick = "window.location.href = 'viewAllCustomers'; return false;"
				class = "add-button"
				/>
				
			<br><br>
				
			<form:form action = "search" method = "GET">
			
				Search sales representative: <input type = "text" name = "theSearchName"/>
				
					<input type = "submit" value = "Search" class = "add-button"/>
					
					<input type = "button" value = "Clear search"
				onclick = "window.location.href = 'list'; return false;"
				class = "add-button"
				/>
			
			</form:form>
			
				<table>
				
					<tr>
					
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					
					</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var = "tempSalesRep" items = "${salesReps}">
				
					<c:url var = "updateLink" value = "/salesRep/showFormForUpdate">
					
						<c:param name ="salesRepId" value = "${tempSalesRep.id}"/>
					
					</c:url>
					
					<c:url var = "deleteLink" value = "/salesRep/delete">
					
						<c:param name ="salesRepId" value = "${tempSalesRep.id}"/>
					
					</c:url>
					
					<c:url var = "assignedCustomersLink" value = "/salesRep/listAssignedCustomers">
					
						<c:param name ="salesRepId" value = "${tempSalesRep.id}"/>
					
					</c:url>
				
					<tr>
					
						<td> ${tempSalesRep.firstName} </td>
						<td> ${tempSalesRep.lastName} </td>
						<td> ${tempSalesRep.email} </td>
						
						<td>
							
							<a href = "${updateLink}">Update</a>
							|
							<a href = "${deleteLink}"
							   onclick = "if (!(confirm('Delete sales representative?'))) return false">Delete</a>
							|
							<a href = "${assignedCustomersLink}">Assigned customers</a>
						
						</td>
						
					
					</tr>
				
				</c:forEach>
						
			</table>
		
		
		</div>
	
	</div>

</body>

</html>
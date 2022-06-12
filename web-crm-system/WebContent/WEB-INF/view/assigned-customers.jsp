<%@ taglib uri  ="http://java.sun.com/jsp/jstl/core" prefix  ="c" %>

<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

	<title>List Assigned Customers</title>
	
	<link type = "text/css"
				  rel = "stylesheet"
				  href = "${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id = "wrapper">
		
		<div id = "header">
		
			<h2>CRM Customer Relationship Manager : Assigned Customers</h2>
		
		</div>
	
	</div>
	
	<div id = "container">
	
		<div id="content">
		
			<input type = "button" value = "Assign Customer"
				onclick = "window.location.href = 'showFormForAsign'; return false;"
				class = "add-button"
				/>
				
			<br><br>
			
				<table>
				
					<tr>
					
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					
					</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var = "tempCustomer" items = "${customers}">
					
					<tr>
					
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						
						<td>

						</td>
						
					
					</tr>
				
				</c:forEach>
						
			</table>
		
		
		</div>
		
		<div style = "clear; both;"></div>
		
		<p>
		
			<a href = "${pageContext.request.contextPath}/salesRep/list">Back to sales reps</a>
		
		</p>
	
	</div>

</body>

</html>
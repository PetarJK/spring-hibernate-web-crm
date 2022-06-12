<%@ taglib uri  ="http://java.sun.com/jsp/jstl/core" prefix  ="c" %>

<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

	<title>List Customers</title>
	
	<link type = "text/css"
				  rel = "stylesheet"
				  href = "${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id = "wrapper">
		
		<div id = "header">
		
			<h2>CRM Customer Relationship Manager : Customers</h2>
		
		</div>
	
	</div>
	
	<div id = "container">
	
		<div id="content">
				
			<br><br>
			
				<table>
				
					<tr>
					
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					
					</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var = "tempCustomer" items = "${customers}">
				
					<c:url var = "assignLink" value = "/salesRep/assignCustomer">
					
						<c:param name ="customerId" value = "${tempCustomer.id}"/>
						
					</c:url>
					
					<c:url var = "unassignCustomerLink" value = "/salesRep/unassignCustomer">
					
						<c:param name ="customerId" value = "${tempCustomer.id}"/>
					
					</c:url>
					
					<tr>
					
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						
						<td>
							
							
							<a href = "${assignLink}"
								onclick = "if (!(confirm('Asign customer?'))) return false">Assign</a>
							|	
							<a href = "${unassignCustomerLink}"
								onclick = "if (!(confirm('Unassign customer?'))) return false">Unassign</a>
							
							
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
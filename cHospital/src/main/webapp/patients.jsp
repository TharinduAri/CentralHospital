<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Patient Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="icon" href="images/admin_panel_fav.png" type="image/png">
	
<style>
body {
	background-color: #f8f9fa;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

.container {
	margin-right: 100px; /* Remove margin */
	padding: 0 20px;
	box-sizing: border-box;
	width: 100%;
	/* Ensure the container covers the full width of the page */
}

.card {
	margin-bottom: 20px;
}

h2 {
	padding: 50px 0 0 10px;
}

table {
	width: 100%; /* Table will take full width of its container */
	max-width: none; /* Remove any maximum width */
	border-collapse: collapse;
	border-spacing: 0;
}

th, td {
	padding: 10px;
	text-align: left;
	border-bottom: 1px solid #dee2e6;
	cursor: pointer;
}

thead {
	background-color: #343a40;
	color: #fff;
}

tbody tr:nth-child(even) {
	background-color: #f2f2f2;
}

tbody tr:hover {
	background-color: #e2e6ea;
}

td.birthdate {
	white-space: nowrap;
	width: 120px;
}

.action-buttons button {
	margin-right: 5px;
}
</style>


</head>
<body>

	<jsp:include page="adminHeader.jsp" />

	<h2>Patient List</h2>
	<table class="table" id="patientTable">
		<thead>
			<tr>
				<th>User ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Address</th>
				<th>Gender</th>
				<th class="birthdate">Date of Birth</th>
				<th class="streetAdd">Street Address</th>
				<th>City</th>
				<th>State</th>
				<th>Postal Code</th>
				<th>Phone Number</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${patients}" var="patient">
				<tr>
					<td>${patient.getUserId()}</td>
					<td>${patient.getFirstName()}</td>
					<td>${patient.getLastName()}</td>
					<td>${patient.getEmail()}</td>
					<td>${patient.getGender()}</td>
					<td class="birthdate">${patient.getBirthDate()}</td>
					<td class="streetAdd">${patient.getStreetAddress()}</td>
					<td>${patient.getCity()}</td>
					<td>${patient.getState()}</td>
					<td>${patient.getPostalCode()}</td>
					<td>${patient.getPhone()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

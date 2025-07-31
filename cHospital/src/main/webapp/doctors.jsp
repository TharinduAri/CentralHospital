<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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

        .top {
            display: flex;
            justify-content: space-between; /* Aligns items to each end of the flex container */
        	align-items:center;
        }

        #addDoc {
            height:50%;
        }
    </style>

</head>
<body>

<jsp:include page="adminHeader.jsp"/>
<div class="top">
    <h2>Doctor List</h2>
    <a href="addDoctor.jsp"><button class="btn btn-primary" id="addDoc">Add a doctor</button></a>
</div>

<% if (request.getAttribute("message") != null) { %>
    <div class="alert alert-success" role="alert">
        <%= request.getAttribute("message") %>
    </div>
<% } %>

<!-- Display error message if available -->
<% if (request.getAttribute("error") != null) { %>
    <div class="alert alert-danger" role="alert">
        <%= request.getAttribute("error") %>
    </div>
<% } %>

<table class="table" id="doctorTable">
    <!-- Table headers remain the same -->
    <thead>
    <tr>
        <th>User ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email Address</th>
        <th>Gender</th>
        <th class="birthdate">Date of Birth</th>
        <th>Street Address</th>
        <th>City</th>
        <th>State</th>
        <th>Postal Code</th>
        <th>Phone Number</th>
        <th>Specialization</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <!-- Table body rows remain the same -->
    <c:forEach items="${doctors}" var="doctor">
        <tr>
            <td>${doctor.getUserId()}</td>
            <td>${doctor.getFirstName()}</td>
            <td>${doctor.getLastName()}</td>
            <td>${doctor.getEmail()}</td>
            <td>${doctor.getGender()}</td>
            <td class="birthdate">${doctor.getBirthDate()}</td>
            <td>${doctor.getStreetAddress()}</td>
            <td>${doctor.getCity()}</td>
            <td>${doctor.getState()}</td>
            <td>${doctor.getPostalCode()}</td>
            <td>${doctor.getPhone()}</td>
            <td>${doctor.getSpecialization()}</td>
            <td class="action-buttons">
                <button class="btn btn-primary" onclick="editDoctor(
                        '${doctor.getUserId()}',
                        '${doctor.getFirstName()}',
                        '${doctor.getLastName()}',
                        '${doctor.getEmail()}',
                        '${doctor.getGender()}',
                        '${doctor.getBirthDate()}',
                        '${doctor.getStreetAddress()}',
                        '${doctor.getCity()}',
                        '${doctor.getState()}',
                        '${doctor.getPostalCode()}',
                        '${doctor.getPhone()}',
                        '${doctor.getSpecialization()}'
                )">Edit</button>
            </td>
            <td class="action-buttons">
                <button class="btn btn-danger" data-toggle="modal" data-target="#deleteModal${doctor.getUserId()}">Delete</button>
                <!-- Delete Modal -->
                <div class="modal fade" id="deleteModal${doctor.getUserId()}" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="deleteModalLabel">Confirm Delete</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Are you sure you want to delete this user? This action cannot be undone.
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                <button type="button" class="btn btn-danger" onclick="deleteDoctor(${doctor.getUserId()})">Delete</button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script>
    function deleteDoctor(userId) {
        window.location.href = "DeleteDoctorServlet?userId=" + userId;
    }

    function editDoctor(userId, firstName, lastName, email, gender, birthDate, streetAddress, city, state, postalCode, phone, specialization) {
        window.location.href = "editDoctor.jsp" +
            "?userId=" + userId +
            "&firstName=" + encodeURIComponent(firstName) +
            "&lastName=" + encodeURIComponent(lastName) +
            "&email=" + encodeURIComponent(email) +
            "&gender=" + encodeURIComponent(gender) +
            "&birthDate=" + encodeURIComponent(birthDate) +
            "&streetAddress=" + encodeURIComponent(streetAddress) +
            "&city=" + encodeURIComponent(city) +
            "&state=" + encodeURIComponent(state) +
            "&postalCode=" + encodeURIComponent(postalCode) +
            "&phone=" + encodeURIComponent(phone) +
            "&specialization=" + encodeURIComponent(specialization);
    }
</script>

</body>
</html>

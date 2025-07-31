<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Doctor</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="adminHeader.jsp"/>
    <div class="container mt-5">
        <h2>Edit Doctor</h2>
        
        <!-- Display success message if available -->
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
        
        <form action="updateDoctor" method="post">
            <input type="hidden" name="userId" value="${param.userId}">
            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" class="form-control" id="firstName" name="firstName" value="${param.firstName}">
            </div>
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" class="form-control" id="lastName" name="lastName" value="${param.lastName}">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${param.email}">
            </div>
            <div class="form-group">
                <label for="gender">Gender:</label>
                <input type="text" class="form-control" id="gender" name="gender" value="${param.gender}">
            </div>
            <div class="form-group">
                <label for="birthDate">Birth Date:</label>
                <input type="text" class="form-control" id="birthDate" name="birthDate" value="${param.birthDate}">
            </div>
            <div class="form-group">
                <label for="streetAddress">Street Address:</label>
                <input type="text" class="form-control" id="streetAddress" name="streetAddress" value="${param.streetAddress}">
            </div>
            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" class="form-control" id="city" name="city" value="${param.city}">
            </div>
            <div class="form-group">
                <label for="state">State:</label>
                <input type="text" class="form-control" id="state" name="state" value="${param.state}">
            </div>
            <div class="form-group">
                <label for="postalCode">Postal Code:</label>
                <input type="number" class="form-control" id="postalCode" name="postalCode" value="${param.postalCode}">
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${param.phone}">
            </div>
            <div class="form-group">
                <label for="specialization">Specialization:</label>
                <input type="text" class="form-control" id="specialization" name="specialization" value="${param.specialization}">
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

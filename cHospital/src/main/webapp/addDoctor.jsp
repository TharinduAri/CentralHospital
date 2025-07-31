
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Central Admin | Add a Doctor</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="icon" href="images/admin_panel_fav.png" type="image/png">
    
</head>
<body>
<jsp:include page="adminHeader.jsp"/>
    <div class="container mt-5">
        <h2>Add Doctor</h2>
        
        <!-- Display success message if available -->
        <% if (request.getAttribute("message") != null) { %>
            <div class="alert alert-success" role="alert">
                <%= request.getAttribute("message") %>
            </div>
        <% } %>
        
        <!-- Display error message if available -->
        <div id="errorMessage" class="alert alert-danger" role="alert" style="display: none;"></div>
        
        <form id="addDoctorForm" action="RegisterDoctorServlet" method="post">
            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" class="form-control" id="firstName" name="firstName" >
            </div>
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" class="form-control" id="lastName" name="lastName" >
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" >
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" >
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" >
            </div>
            <div class="form-group">
                <label>Gender:</label><br>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="male" name="gender" value="male" checked>
                    <label class="form-check-label" for="male">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="female" name="gender" value="female">
                    <label class="form-check-label" for="female">Female</label>
                </div>
            </div>
            <div class="form-group">
                <label for="birthDate">Birth Date:</label>
                <input type="date" class="form-control" id="birthDate" name="birthdate" required>
            </div>
            <div class="form-group">
                <label for="streetAddress">Street Address:</label>
                <input type="text" class="form-control" id="streetAddress" name="streetAddress" >
            </div>
            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" class="form-control" id="city" name="city" >
            </div>
            <div class="form-group">
                <label for="state">State:</label>
                <input type="text" class="form-control" id="state" name="state" >
            </div>
            <div class="form-group">
                <label for="postalCode">Postal Code:</label>
                <input type="number" class="form-control" id="postalCode" name="postalCode" oninput="this.value = this.value.replace(/[^0-9]/g, '');"  >
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" class="form-control" id="phone" name="phone" oninput="this.value = this.value.replace(/[^0-9+]/g, '');" maxlength="14" >
            </div>
            <div class="form-group">
                <label for="specialization">Specialization:</label>
                <input type="text" class="form-control" id="specialization" name="specialization" value="${param.specialization}" required>
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            const form = document.getElementById('addDoctorForm');
            const errorMessage = document.getElementById('errorMessage');
            const confirmPassword = document.getElementById('confirmPassword');
            const password = document.getElementById('password');

            confirmPassword.addEventListener('input', function() {
                const passwordValue = password.value;
                const confirmPasswordValue = confirmPassword.value;

                if (passwordValue !== confirmPasswordValue) {
                    errorMessage.textContent = 'Passwords do not match';
                    errorMessage.style.display = 'block';
                } else {
                    errorMessage.style.display = 'none';
                }
            });

            form.addEventListener('submit', function(event) {
                const firstName = document.getElementById('firstName').value.trim();
                const email = document.getElementById('email').value.trim();
                const passwordValue = password.value.trim();
                const confirmPasswordValue = confirmPassword.value.trim();

                if (!firstName || !email || !passwordValue || !confirmPasswordValue) {
                    errorMessage.textContent = !firstName ? 'First Name is required' :
                        !email ? 'Email is required' :
                        !passwordValue ? 'Password is required' :
                        'Confirm Password is required';
                    errorMessage.style.display = 'block';
                    event.preventDefault();
                } else if (passwordValue !== confirmPasswordValue) {
                    errorMessage.textContent = 'Passwords do not match';
                    errorMessage.style.display = 'block';
                    event.preventDefault();
                } else {
                    errorMessage.style.display = 'none';
                }
            });
        });
    </script>
</body>
</html>

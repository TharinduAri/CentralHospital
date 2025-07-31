<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Central Hospitals | Register</title>
<link rel="stylesheet" href="css/test.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="icon" href="images/faviconLogin.png" type="image/png">
<style>
body {
    background-image: url("images/stethoscope-copy-space.jpg");
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
}

.error-message {
    display: none; /* Hide error message by default */
}

#regTxt h1 {
    margin-top: 100px;
    font-weight: bold;
    font-size: 60px;
}

#regTxt p {
    font-size: 30px;
}
</style>
</head>
<body>

    <jsp:include page="header.jsp" />
    <div class="container my-5">
        <div class="row">
            <div class="col-md-6 mb-4" id="regTxt">
                <h1>Welcome</h1>
                <p>Register At Central Hospitals</p>
            </div>
            <div class="col-md-6">
                <div class="register-form">
                    <form action="RegisterPatientServlet" method="post">
                        <c:if test="${not empty errorMessage}">
                            <div class="alert alert-danger" role="alert">
                                ${errorMessage}
                            </div>
                        </c:if>
                        <c:if test="${not empty message}">
                            <div class="alert alert-success" role="alert">
                                ${message}
                            </div>
                        </c:if>
                        <div class="form-group">
                            <label for="firstName">First Name</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name">
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name">
                        </div>
                        <div class="form-group">
                            <label for="birthdate">Birth date</label>
                            <input type="date" class="form-control" id="birthdate" name="birthdate">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone Number</label>
                            <input type="tel" class="form-control" id="phone" name="phone" placeholder="Phone Number">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword">Confirm Password</label>
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password">
                        </div>
                        <div class="form-group">
                            <label>Gender</label>
                            <div class="form-check">
                                <input type="radio" class="form-check-input" id="male" name="gender" value="male">
                                <label class="form-check-label" for="male">Male</label>
                            </div>
                            <div class="form-check">
                                <input type="radio" class="form-check-input" id="female" name="gender" value="female">
                                <label class="form-check-label" for="female">Female</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="streetAddress">Street Address</label>
                            <input type="text" class="form-control" id="streetAddress" name="streetAddress" placeholder="Street Address">
                        </div>
                        <div class="form-group">
                            <label for="city">City</label>
                            <input type="text" class="form-control" id="city" name="city" placeholder="City">
                        </div>
                        <div class="form-group">
                            <label for="state">State</label>
                            <input type="text" class="form-control" id="state" name="state" placeholder="State">
                        </div>
                        <div class="form-group">
                            <label for="postalCode">Postal Code</label>
                            <input type="text" class="form-control" id="postalCode" name="postalCode" placeholder="Postal Code">
                        </div>
                        <button type="submit" class="btn btn-primary">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>

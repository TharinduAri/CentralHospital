<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Central Hospitals | Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/test.css">
<link rel="icon" href="images/faviconLogin.png" type="image/png">

<style>
body {
	background-image: url("images/stethoscope-copy-space.jpg");
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}

#regTxt h1 {
	margin-top: 90px;
	font-weight: bold;
	font-size: 60px;
}

#regTxt p {
	font-size: 30px;
}
#loginForm{
	margin-top:40px;
	margin-bottom:378px;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="container my-5">
		<div class="row">
			<div class="col-md-6 mb-4" id=regTxt>
				<h1>Welcome</h1>
				<p>Login To Central Hospitals</p>
			</div>
			<div class="col-md-6" id="loginForm">
				<div class="register-form">
					<form action="newlogin" method="post"
						onsubmit="return validateForm()">
						<div class="form-group">
							<label for="email">Email</label> <input type="email"
								class="form-control" id="email" placeholder="Email"
								name="email"> <small id="emailError"
								class="form-text text-danger"></small>
						</div>

						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" id="password" placeholder="Password"
								name="password"> <small id="pwError"
								class="form-text text-danger"></small>
						</div>

						<c:choose>
							<c:when test="${not empty param.error}">
								<div class="alert alert-danger" role="alert">
									<c:choose>
										<c:when test="${param.error == '1'}">
                                        Invalid email or password
                                    </c:when>
										<c:when test="${param.error == '3'}">
                                        Unknown error occurred
                                    </c:when>
									</c:choose>
								</div>
							</c:when>
						</c:choose>

						<button type="submit" class="btn btn-primary btn-block">Login</button>
					</form>
					<div class="form-group form-check">
						<br> <label class="form-check-label" for="existing-account">Do
							not have an account?</label>
					</div>
					<button type="button" class="btn btn-primary btn-block"
						onclick="window.location.href='patientRegister.jsp'">Register</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
		function validateForm() {
			var email = document.getElementById("email").value;
			var password = document.getElementById("password").value;
			var passwordError = document.getElementById("pwError"); // Fixed the ID here
			var emailError = document.getElementById("emailError");
			var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

			if (email.trim() === "") {
				emailError.textContent = "Email cannot be empty";
				return false;
			} else if (!emailRegex.test(email)) {
				emailError.textContent = "Invalid email format";
				return false;
			} else if (password.trim() === "") {
				passwordError.textContent = "Password cannot be empty"; // Fixed the variable name here
				return false;
			} else {
				emailError.textContent = "";
				passwordError.textContent = "";
				return true;
			}
		}
	</script>
</body>
</html>

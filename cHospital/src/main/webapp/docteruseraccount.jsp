<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Doctor Account</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <!-- Add your custom CSS file -->
  <link rel="stylesheet" href="css/userAccount.css">
  <style>
    body {
      background-image: url("images/peakp.jpg");
      background-size: cover;       
      background-repeat: no-repeat;
    }
  </style>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="index.jsp">Central Hospitals Doctor Account</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <% if (session.getAttribute("user") != null) { %>
                        <form id="logoutForm" action="logout" method="post">
                            <button type="submit" class="btn btn-link nav-link">LogOut</button>
                        </form>
                    <% } else { %>
                        <a class="nav-link" href="PatientLogin.jsp">Login</a>
                    <% } %>
                </li>
            </ul>
        </div>
    </nav>
</header>

<div class="container mt-4">
  <div class="row">
    <div class="col-md-12 main-content">
      <div class="row mb-4">
        <div class="col-md-6 text-right">
         
        </div>
      </div>
      <h2 class="mb-4">Recent Appointments</h2>
      <table class="table table-striped">
        <thead>
          <tr>
            <th>Appointment Date</th>
            <th>Appointment Time</th>
            <th>Status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
           <c:forEach items="${appointments}" var="appointment">
            <tr>
                <td>${appointment.getDate()}</td>
                <td>${appointment.getTime()}</td>
                <td>${appointment.getStatus()}</td>
                
            
                
                <td class="action-buttons">
                
                <form action="ApproveAppointmentByDoctorServlet"  method="post">
                <input type="hidden" id="patientId" name="appointmentId" value="${appointment.getAppointmentId()}" readonly>
                    <button type="submit" class="btn btn-primary" >Approve</button>
 							
 					</form>
 					<br>
 					  <form action="DeclineAppointmentByDoctorServlet" method="post">
                        <input type="hidden" name="appointmentId" value="${appointment.getAppointmentId()}">
                        <button type="submit" class="btn btn-danger">Decline</button>
                    </form>
                </td>
                
       			
            </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>

<!-- Scripts -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    document.getElementById('logoutForm').addEventListener('submit', function(e) {
        if (!confirm('Are you sure you want to logout?')) {
            e.preventDefault(); // prevent form submission
        }
    });
</script>
</body>
</html>

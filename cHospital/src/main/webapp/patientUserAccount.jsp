
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Account</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/userAccount.css">
  <link rel="icon" href="images/faviconLogin.png" type="image/png">
</head>
<body>



<jsp:include page="header.jsp"/>

<div class="container-fluid">
  <div class="row">
    <div class="col-md-3 bg-dark text-white sidebar">
      <div class="text-center">
        <h3 class="mt-3">${patient.firstName} ${patient.lastName}</h3>
        <button class="btn btn-update">Update Details</button>
      </div>
    </div>
    <div class="col-md-9 main-content">
      <h2>Your Details</h2>
      <div class="row">
        <div class="col-md-6">
          <p><strong>Full Name:</strong> ${patient.getFirstName()} ${patient.getLastName()}</p>
          <p><strong>Email:</strong> ${patient.email}</p>
          <p><strong>Phone:</strong> ${patient.getPhone()}</p>
          <p><strong>Gender:</strong> ${patient.getGender()}</p>
        </div>
      </div>
      <h2>Recent Appointments</h2>
      <table class="table table-striped">
        <thead>
          <tr>
            <th>Doctor Name</th>
            <th>Appointment Date</th>
            <th>Appointment Time</th>
            <th>Appointment Status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          <!-- Iterate over appointments and generate table rows -->
          <c:forEach var="appointment" items="${appointments}">
            <tr>
              <td>${appointment.docname}</td>
              <td>${appointment.date}</td>
              <td>${appointment.time}</td>
              <td>${appointment.status}</td>
              <td>
                <form action="deleteAppointmentbyPatient" method="post" onsubmit="return confirmDeletion()">
                  <input type="hidden" name="appointmentID" value="${appointment.appointmentId}">
                  <button type="submit" class="btn btn-danger btn-sm">Delete Appointment</button>
                </form>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="updateModalLabel">Update Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="UpdatePatientServlet" method="post">
          <div class="form-group">
            <input type="hidden" id="userId" name="id" value="${sessionScope.userId}">
          </div>
          <div class="form-group">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" value="${patient.getFirstName()}">
          </div>
          <div class="form-group">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" id="lastName" name="lastName" value="${patient.getLastName()}">
          </div>
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${patient.getEmail()}">
          </div>
          <div class="form-group">
            <label for="phone">Phone</label>
            <input type="tel" class="form-control" id="phone" name="phone" value="${patient.getPhone()}">
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" value="" required placeholder="New password or Current Password">
          </div>
          <div class="form-group">
            <label for="gender">Gender</label>
            <select class="form-control" id="gender" name="gender">
              <option value="male" ${patient.getGender() == 'male' ? 'selected' : ''}>Male</option>
              <option value="female" ${patient.getGender() == 'female' ? 'selected' : ''}>Female</option>
            </select>
          </div>
          <div class="form-group">
            <label for="dob">Date of Birth</label>
            <input type="date" class="form-control" id="dob" name="dob" value="${patient.getBirthDate()}">
          </div>
          <div class="form-group">
            <label for="streetAddress">Street Address</label>
            <input type="text" class="form-control" id="streetAddress" name="streetAddress" value="${patient.getStreetAddress()}">
          </div>
          <div class="form-group">
            <label for="city">City</label>
            <input type="text" class="form-control" id="city" name="city" value="${patient.getCity()}">
          </div>
          <div class="form-group">
            <label for="state">State</label>
            <input type="text" class="form-control" id="state" name="state" value="${patient.getState()}">
          </div>
          <div class="form-group">
            <label for="postalCode">Postal Code</label>
            <input type="text" class="form-control" id="postalCode" name="postalCode" value="${patient.getPostalCode()}">
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="submit" class="btn btn-primary">Save Changes</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
  $(document).ready(function() {
    $('.btn-update').click(function() {
      $('#updateModal').modal('show');
    });
  });

  function confirmDeletion() {
    return confirm("Are you sure you want to delete this appointment?");
  }
</script>
</body>
</html>

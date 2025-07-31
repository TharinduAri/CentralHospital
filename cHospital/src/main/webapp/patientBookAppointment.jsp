<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Appointment - Central Hospitals</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/test.css">
<link rel="icon" href="images/addFavicon (2).png" type="image/png">

<style>
body {
	background-image: url("images/");
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}

.doctor-card {
	margin-bottom: 20px; /* Adjust the margin as needed */
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />

	<main>
		<section class="container my-5">
			<h1 class="text-center mb-4">Book an Appointment</h1>
			<!-- Display message if available -->
			<c:if test="${not empty message}">
				<div
					class="alert ${message == 'Appointment booked successfully!' ? 'alert-success' : 'alert-danger'}"
					role="alert">${message}</div>
			</c:if>
			<div class="row">
				<c:forEach items="${doctors}" var="doctor">
					<div class="col-md-4">
						<div class="card doctor-card">
							<div class="card-body" id="cardBody">
								<h5 class="card-title">${doctor.getFirstName()}
									${doctor.getLastName()}</h5>
								<p class="card-text">Specialization:
									${doctor.getSpecialization()}</p>
								<button class="btn btn-primary btn-block book-appointment-btn"
									data-doctor="${doctor.getFirstName()} ${doctor.getLastName()}"
									data-doctor-id="${doctor.getUserId()}">Book
									Appointment</button>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
	</main>

	<!-- Booking Modal -->
	<div class="modal fade" id="bookingModal" tabindex="-1" role="dialog"
		aria-labelledby="bookingModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="bookingModalLabel">Book
						Appointment</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="appointmentForm" action="BookAppointmentServlet"
						method="get">
						<div class="form-group">
							<label for="doctorName">Doctor:</label> <input type="text"
								class="form-control" id="doctorName" name="doctorName" readonly>
						</div>
						<!-- Hidden input fields for patient ID and doctor ID -->
						<input type="hidden" id="patientId" name="patientId"
							value="<%=session.getAttribute("userId")%>"> <input
							type="hidden" id="doctorId" name="doctorId">

						<div class="form-group">
							<label for="appointmentDate">Date:</label> <input type="date"
								class="form-control" id="appointmentDate" name="appointmentDate"
								required>
						</div>
						<div class="form-group">
							<label for="appointmentTime">Time:</label> <input type="time"
								class="form-control" id="appointmentTime" name="appointmentTime"
								required>
						</div>



						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Cancel</button>
							<button type="submit" class="btn btn-primary"
								id="bookAppointmentBtn">Book Appointment</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			// Book Appointment button click event
			$('.book-appointment-btn').click(function() {
				var doctorName = $(this).data('doctor');
				var doctorId = $(this).data('doctor-id');
				$('#doctorName').val(doctorName);
				$('#doctorId').val(doctorId);
				$('#bookingModal').modal('show');
			});

			$('#appointmentForm').submit(function() {
				$('#bookAppointmentBtn').prop('disabled', true);
			});
		});
	</script>

	<footer>
		<!-- Footer code remains the same -->
	</footer>
</body>
</html>

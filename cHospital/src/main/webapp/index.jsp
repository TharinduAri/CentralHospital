<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Central Hospitals</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/test.css">
    <link rel="icon" href="images/faviconHome.png" type="image/png">
</head>
<body>

<jsp:include page="header.jsp"/>

<main>
    <section class="jumbotron jumbotron-fluid" style="background-color: #2c8dab;">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1 class="display-4">Central Hospitals</h1>
                    <p class="lead">Personal care for your healthy living</p>
                    <p>Central Hospitals is a premier healthcare institution committed to providing exceptional medical care and fostering a culture of compassion and healing. With a legacy spanning over three decades, our hospital has been at the forefront of medical innovation and patient-centered care</p>
                    <button id="bookNowBtn" class="btn btn-primary btn-lg">Book Now</button>
                </div>
                <div class="col-md-6">
                    <img src="images/doctor.jpg" alt="Dr. Mendozo Care" class="img-fluid">
                </div>
            </div>
        </div>
    </section>

    <section class="container my-5">
        <div class="row">
            <div class="col-md-12">
                <h2>About Central Hospitals</h2>
                <p>Central Hospitals is a leading health care provider dedicated to delivering exceptional medical services and personalized care to our patients. With a team of highly skilled doctors, nurses, and support staff, we strive to provide a compassionate and healing environment for all.</p>
                <p>Our state-of-the-art facilities are equipped with the latest technologies, ensuring that our patients receive the best possible treatment and care. We offer a wide range of services, including emergency care, surgical procedures, diagnostic imaging, and specialized clinics for various medical conditions.</p>
                <p>At Central Hospitals, we believe in putting our patients first. We are committed to providing a safe, welcoming, and comfortable environment where you can feel at ease during your treatment and recovery.</p>
            </div>
        </div>
    </section>

</main>
<jsp:include page="footer.jsp"/>

<script>
    window.onload = function() {
        var isLoggedIn = <%= session.getAttribute("user") != null %>;
        var bookNowBtn = document.getElementById("bookNowBtn");

        if (isLoggedIn) {
            bookNowBtn.textContent = "Book Now";
            bookNowBtn.onclick = function() {
                window.location.href = "ShowDoctorsInPatients";
            };
        } else {
            bookNowBtn.textContent = "Login";
            bookNowBtn.onclick = function() {
                window.location.href = "PatientLogin.jsp";
            };
        }
    };
</script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

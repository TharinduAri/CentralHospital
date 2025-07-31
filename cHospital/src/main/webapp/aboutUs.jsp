<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="common-header.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us | Central Hospitals</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/test.css">
</head>
<style>
	body{
		background-image:url("images/minimalistic-science-banner-with-stethoscope.jpg");
		background-repeat: no-repeat,repeat;
		background-size: cover;
	}
	p{
		font-size: 20px;
	}
	.container .row .col-md-12 {
        background-color: rgba(255, 255, 255, 0.6); /* Add opacity to make the text readable */
        padding: 20px; /* Add some padding for readability */
        backdrop-filter: blur(10px); /* Add background blur only to this element */
        -webkit-backdrop-filter: blur(10px); /* For older webkit browsers */
    }
</style>
<body>

<jsp:include page="header.jsp"/>

<main class="container my-5">
    <div class="row">
        <div class="col-md-12">
            <h2 class="text-center mb-4">About Central Hospitals</h2>
			<p>
				Central Hospitals is a premier healthcare institution committed to providing exceptional medical care and fostering a culture of compassion and healing. With a 
				legacy spanning over three decades, our hospital has been at the forefront of medical innovation and patient-centered care.
			</p>
			<p>
				At Central Hospitals, we understand that each patient is unique, and we tailor our approach to meet individual needs. Our team of highly skilled physicians, nurses, 
				and support staff is dedicated to delivering personalized treatment with the utmost professionalism and empathy.
			</p>
			<p>
				Our state-of-the-art facilities are equipped with cutting-edge technology, allowing us to offer a wide range of medical services, from routine check-ups to complex 
				surgical procedures. Whether you're seeking treatment for a common illness or managing a chronic condition, Central Hospitals is your trusted partner in health.
			</p>
			<p>
				But beyond medical expertise, what truly sets Central Hospitals apart is our commitment to putting patients first. We believe in building lasting relationships with 
				our patients based on trust, respect, and open communication. From the moment you step through our doors, you'll experience a warm and welcoming environment designed to 
				ease your worries and promote healing.
			</p>
			<p>
				Our hospital isn't just a place for treatment it's a community where patients and their families find support, encouragement, and hope. We believe in empowering our patients 
				to take control of their health through education, prevention, and access to resources.
			</p>
			<p>
				At Central Hospitals, we're more than just healthcare providers; we're partners in your wellness journey. Whether you're seeking routine care, facing a medical challenge, or 
				simply looking for guidance on living a healthier life, you can trust Central Hospitals to be by your side every step of the way.
			</p>
			<p>
				Welcome to Central Hospitals. where compassionate care meets medical excellence.
			</p>
        </div>
    </div>
</main>

<jsp:include page="footer.jsp"/>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

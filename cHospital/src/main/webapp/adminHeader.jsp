<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .navbar-brand {
            font-size:30px;   
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="GetUserCountServlet"> Admin Dashboard </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="GetUserCountServlet">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ShowPatientsServlet">Patients</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="ShowDoctorsServlet">Doctors</a>
                </li>
                <li class="nav-item">
                    <!-- Form for logout -->
                    <form action="logout" method="post">
                        <button type="submit" class="btn btn-link nav-link" onclick="confirmLogout()">Logout</button>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- JavaScript function for confirmation dialog -->
<script>
    function confirmLogout() {
        // Display confirmation dialog
        var confirmLogout = confirm("Are you sure you want to logout?");
        if (!confirmLogout) {
            // If user cancels, prevent form submission
            event.preventDefault();
        }
    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

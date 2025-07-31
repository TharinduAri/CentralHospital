<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="index.jsp">Central Hospitals</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="aboutUs.jsp">About</a>
                </li>
                <li class="nav-item">
                <% if (session.getAttribute("user") != null){ %>
                    <a class="nav-link" href="ShowDoctorsInPatients">Book Appointment</a>
                <%}else{ %>
                	<a class="nav-link" href="PatientLogin.jsp?message=You Must Login Before Continue">Book Appointment</a>
                </li>
                <%} %>
                
                <li class="nav-item">
                <% if (session.getAttribute("user")!= null){ %>
                    <a class="nav-link" href="Review.jsp">Review</a>
      			<%}else{ %> 
                	<a class="nav-link" href="ShowReviewServlet">Review</a>
				</li>
				<%} %>
                <li class="nav-item dropdown">
                    <% if (session.getAttribute("user") != null) { %>
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            My Account
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="userAccount">My Account</a>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
                        </div>
                    <% } else { %>
                        <a class="nav-link" href="PatientLogin.jsp">Login</a>
                    <% } %>
                </li>
            </ul>
        </div>
    </nav>
</header>

<!-- Logout Modal -->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="logoutModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="logoutModalLabel">Logout Confirmation</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure you want to logout?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" id="confirmLogout">Logout</button>
            </div>
        </div>
    </div>
</div>

<!-- Logout Form -->
<form id="logoutForm" action="logout" method="post" style="display: none;">
    <button type="submit" id="logoutButton"></button>
</form>


<script>
    document.getElementById('confirmLogout').addEventListener('click', function() {
        document.getElementById('logoutButton').click();
    });

    $('#logoutModal').on('hidden.bs.modal', function (e) {
        // Check if the user is logged in
        if (<%= session.getAttribute("user") != null %>) {
            // If logged in, keep "My Account" in the dropdown
            $('.dropdown-toggle').html('My Account');
        } else {
            // If not logged in, change dropdown to "Login"
            $('.dropdown-toggle').html('Login');
        }
    });
</script>


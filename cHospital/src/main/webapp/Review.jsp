<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add a Review - Central Hospitals</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/test.css">
    <link rel="stylesheet" href="css/Review.css">
    
    <style>
     
    body {
      background-image: url("images/stethoscope-copy-space.jpg");
      background-size: cover; 
      background-position: center;
      background-repeat: no-repeat;
    }
  </style>
    
</head>
<body>
    <jsp:include page="header.jsp"/>

    <main>
        <section class="container my-5">
            <h1 class="text-center mb-4">Add a Review</h1>
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-body">
                            <form action="AddReviewServlet" method="post">
                                <input type="hidden" id="userId" name="userId" value="<c:choose><c:when test='${not empty sessionScope.userId}'><c:out value='${sessionScope.userId}'/></c:when><c:otherwise>0</c:otherwise></c:choose>">
                                <div class="form-group">
                                    <label for="userName">Your Name:</label>
                                    <input type="text" class="form-control" id="userName" name="userName" required>
                                </div>
                                <div class="form-group">
                                    <label for="reviewText">Review:</label>
                                    <textarea class="form-control" id="reviewText" name="reviewText" rows="5" required></textarea>
                                </div>
                                <button type="submit" class="btn btn-primary btn-block">Submit Review</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <div class="text-center">
            <a href="ShowReviewServlet" class="btn btn-secondary">View Reviews</a>
        </div>
    </main>
	<jsp:include page="footer.jsp"></jsp:include>
    

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

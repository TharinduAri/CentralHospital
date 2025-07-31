<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Show Reviews</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
     
    body {
      background-image: url("images/revBack.png");
      background-size: cover; 
      background-position: center;
      background-repeat: no-repeat;
    }
  </style>
    
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
    <div class="container mt-5">
        <h1 class="mb-4">Reviews</h1>
        <%-- Display reviews --%>
        <c:if test="${not empty reviews}">
            <c:forEach items="${reviews}" var="review">
                <div class="card mb-3">
                    <div class="card-body">
                        <h5 class="card-title">User: ${review.userName}</h5>
                        <p class="card-text">Review: ${review.reviewText}</p>

                        <c:if test="${review.userId == sessionScope.userId}">
                            <form action="DeleteReviewServlet" method="post" style="display: inline;">
                                <input type="hidden" name="reviewId" value="${review.reviewId}">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                            <form action="UpdateReviewServlet" method="post" style="display: inline;">
                                <input type="hidden" name="reviewId" value="${review.reviewId}">
                                <input type="text" name="newReviewText" placeholder="New review text" required style="width: 900px;">
                              
                                <button type="submit" class="btn btn-warning">Update</button>
                            </form>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </c:if>
	

    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>


package net.controller;

import net.dao.AddReviewDao;
import net.model.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddReviewServlet")
public class AddReviewServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AddReviewDao addReviewDao;

    @Override
    public void init() {
        addReviewDao = new AddReviewDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String reviewText = request.getParameter("reviewText");

        // Create a new review object
        Review review = new Review(userId, userName, reviewText);

        // Use the DAO to add the review
        boolean isReviewAdded = addReviewDao.addReview(review);

        // Redirect or forward based on the result
        if (isReviewAdded) {
           // request.setAttribute("message", "Review added successfully!");
            // Here you can choose where to redirect after adding the review
            // For example:
            request.getRequestDispatcher("ShowReviewServlet").forward(request, response);
        } else {
            request.setAttribute("message", "Failed to add review.");
           // request.getRequestDispatcher("/reviewError.jsp?error=true").forward(request, response);
        }
    }

    }


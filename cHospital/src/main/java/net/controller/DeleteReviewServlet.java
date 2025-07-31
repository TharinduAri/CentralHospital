package net.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import net.dao.DeleteReviewDao;

@WebServlet("/DeleteReviewServlet")
public class DeleteReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the reviewId parameter from the request
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));

        // Initialize the DAO
        DeleteReviewDao reviewDao = new DeleteReviewDao();

        // Delete the review
        boolean success = reviewDao.deleteReview(reviewId);

        // Redirect to appropriate page based on success or failure
        String redirectURL = "ShowReviewServlet";
        if (success) {
            // Set message attribute for successful deletion
            request.getSession().setAttribute("reviewmessage", "Review deleted successfully!");
        } else {
            // Set error attribute for failed deletion
            request.getSession().setAttribute("error", "Failed to delete review. Please try again.");
        }

        // Redirect to avoid form resubmission
        response.sendRedirect(redirectURL);
    }
}

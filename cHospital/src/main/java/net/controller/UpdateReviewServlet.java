// UpdateReviewServlet.java
package net.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import net.dao.UpdateReviewDao;

@WebServlet("/UpdateReviewServlet")
public class UpdateReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reviewIdStr = request.getParameter("reviewId");
        String newReviewText = request.getParameter("newReviewText");

        if (reviewIdStr == null || newReviewText == null || newReviewText.isEmpty()) {
            // Invalid parameters, display error message
            request.getSession().setAttribute("error", "Invalid parameters. Please try again.");
            response.sendRedirect("ShowReviewServlet");
            return;
        }

        int reviewId = Integer.parseInt(reviewIdStr);
        
        UpdateReviewDao updateReviewDao = new UpdateReviewDao();

        try {
            boolean success = updateReviewDao.updateReview(reviewId, newReviewText);
            if (success) {
                request.getSession().setAttribute("message", "Review updated successfully!");
            } else {
                request.getSession().setAttribute("error", "Failed to update review. Please try again.");
            }
        } catch (Exception e) {
            request.getSession().setAttribute("error", "An error occurred while updating the review. Please try again.");
        }

        response.sendRedirect("ShowReviewServlet");
    }
}

package net.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dao.ShowReviewDao;
import net.model.Review;

@WebServlet("/ShowReviewServlet")
public class ShowReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve reviews from DAO
        ShowReviewDao showReviewDao = new ShowReviewDao();
        List<Review> reviews = showReviewDao.getAllReviews();

        // Forward the reviews to the JSP for display
        request.setAttribute("reviews", reviews);
        request.getRequestDispatcher("/showReviews.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

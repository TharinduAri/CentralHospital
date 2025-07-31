package net.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import net.dao.DeleteDoctorDao;

@WebServlet("/DeleteDoctorServlet")
public class DeleteDoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int doctorId = Integer.parseInt(request.getParameter("userId"));
        DeleteDoctorDao doctorDAO = new DeleteDoctorDao();
        boolean success = doctorDAO.deleteDoctor(doctorId);

        if (success) {
            request.setAttribute("message", "Doctor deleted successfully!");
//            response.sendRedirect("ShowDoctorsServlet");
            request.getRequestDispatcher("ShowDoctorsServlet").forward(request, response);

        } else {
            request.setAttribute("error", "Failed to delete doctor. Please try again.");
            request.getRequestDispatcher("ShowDoctorsServlet").forward(request, response);
        }

    }
}

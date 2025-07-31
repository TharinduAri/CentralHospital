package net.controller;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.*;

@WebServlet("/deleteAppointmentbyPatient")
public class DeleteAppointmentByPatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Extract appointment ID from the request parameters
        int appointmentId = Integer.parseInt(request.getParameter("appointmentID"));

        // Delete appointment using DAO
        DeleteAppointmentDao deleteAppointmentDAO = new DeleteAppointmentDao();
        boolean deleted = deleteAppointmentDAO.deleteAppointmentById(appointmentId);

        // Redirect back to user account page
        if (deleted) {
            response.sendRedirect("userAccount");
        } else {
            // Handle deletion failure, maybe display an error message
            // For simplicity, redirecting back to user account page
            response.sendRedirect("userAccount.jsp?error=deletefailed");
        }
    }
}

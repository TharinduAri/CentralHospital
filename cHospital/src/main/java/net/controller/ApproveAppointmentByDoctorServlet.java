package net.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.ApproveAppointmentDao;

@WebServlet("/ApproveAppointmentByDoctorServlet")
public class ApproveAppointmentByDoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ApproveAppointmentByDoctorServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String appointmentIdStr = request.getParameter("appointmentId");
        if (appointmentIdStr == null || appointmentIdStr.isEmpty()) {
            response.getWriter().write("Appointment ID is missing.");
            return;
        }

        try {
            int appointmentId = Integer.parseInt(appointmentIdStr);

            // Approve the appointment using ApproveAppointmentDao
            ApproveAppointmentDao approveAppointmentDao = new ApproveAppointmentDao();
            boolean isApproved = approveAppointmentDao.approveAppointment(appointmentId);

            // Respond back to the client based on the result
            if (isApproved) {
            	 response.sendRedirect("DoctorAppointmentsServlet");
            } else {
                response.getWriter().write("Failed to approve appointment.");
            }
        } catch (NumberFormatException e) {
            response.getWriter().write("Invalid appointment ID format.");
        }
    }
}

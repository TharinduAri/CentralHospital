package net.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.DeclineAppointmentByDoctorDao;

@WebServlet("/DeclineAppointmentByDoctorServlet")
public class DeclineAppointmentByDoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeclineAppointmentByDoctorServlet() {
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

            // Decline the appointment using DeclineAppointmentDao
            DeclineAppointmentByDoctorDao declineAppointmentDao = new DeclineAppointmentByDoctorDao();
            boolean isDeclined = declineAppointmentDao.declineAppointment(appointmentId);

            // Respond back to the client based on the result
            if (isDeclined) {
                response.sendRedirect("DoctorAppointmentsServlet"); // Redirect to DoctorAppointmentsServlet
            } else {
            	response.sendRedirect("DoctorAppointmentsServlet?error");
            }
        } catch (NumberFormatException e) {
            response.getWriter().write("Invalid appointment ID format.");
        }
    }
}

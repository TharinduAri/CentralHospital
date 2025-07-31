package net.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.dao.AppointmentDAO;
import net.model.Appointment;

@WebServlet("/DoctorAppointmentsServlet")
public class DoctorAppointmentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession();
    	String userId = (String) session.getAttribute("userId");
    	
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        try {
            List<Appointment> appointments = appointmentDAO.listAllAppointments(userId);
            request.setAttribute("appointments", appointments);
            request.getRequestDispatcher("/docteruseraccount.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error retrieving appointments", e);
        }
    }
}

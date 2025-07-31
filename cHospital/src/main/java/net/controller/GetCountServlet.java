package net.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.GetCountDao;

@WebServlet("/GetUserCountServlet")
public class GetCountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	GetCountDao getcount = new GetCountDao();
    	
        int patientCount = getcount.getPatientCount();
        int appointmentCount = getcount.getAppointmentCount();
        int doctorCount = getcount.getDoctorCount();
        
        // Set the user count as an attribute
        request.setAttribute("patientCount", patientCount);
        request.setAttribute("appointmentCount", appointmentCount);
        request.setAttribute("doctorCount", doctorCount);
        // Forward to your JSP page
        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
    }
}

package net.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.ShowDoctorsDao;
import net.model.Doctor;

/**
 * Servlet implementation class ShowDoctorsInPatientsServlet
 */
@WebServlet("/ShowDoctorsInPatients")
public class ShowDoctorsInPatientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Doctor> doctors = ShowDoctorsDao.getAllDoctorsWithDetails();
        request.setAttribute("doctors", doctors);
        request.getRequestDispatcher("patientBookAppointment.jsp").forward(request, response);
    }
	
}

package net.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dao.ShowPatientDao;
import net.model.Patient;

@WebServlet("/ShowPatientsServlet")
public class ShowPatientsServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Patient> patients = ShowPatientDao.getAllPatientsWithDetails();
        request.setAttribute("patients", patients);
        request.getRequestDispatcher("patients.jsp").forward(request, response);
    }
}



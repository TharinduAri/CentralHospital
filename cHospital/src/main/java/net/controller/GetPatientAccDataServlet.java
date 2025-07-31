package net.controller;

import net.dao.ShowPatientDao;
import net.dao.ShowAppointmentDao;
import net.model.Patient;
import net.model.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/userAccount")
public class GetPatientAccDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ShowPatientDao showPatientDao;
    private ShowAppointmentDao showAppointmentDao;

    @Override
    public void init() {
        showPatientDao = new ShowPatientDao();
        showAppointmentDao = new ShowAppointmentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");
        String userIdStr = (String) session.getAttribute("userId");

        if (email == null || userIdStr == null) {
            response.sendRedirect("PatientLogin.jsp"); // Redirect to login if user is not logged in
            return;
        }

        // Convert userId to Integer
        Integer userId;
        try {
            userId = Integer.parseInt(userIdStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("PatientLogin.jsp"); // Redirect to login if userId is invalid
            return;
        }

        // Retrieve patient information
        Patient patient = showPatientDao.getPatientByEmail(email);
        request.setAttribute("patient", patient);

        // Retrieve appointments
        List<Appointment> appointments = showAppointmentDao.getAppointmentsByUserId(userId);
        request.setAttribute("appointments", appointments);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/patientUserAccount.jsp").forward(request, response);
    }
}

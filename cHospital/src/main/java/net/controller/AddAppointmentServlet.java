
package net.controller;

import net.dao.AddAppointmentDao;
import net.model.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookAppointmentServlet")
public class AddAppointmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AddAppointmentDao addAppointmentDao;

    @Override
    public void init() {
        addAppointmentDao = new AddAppointmentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        int patientId = Integer.parseInt(request.getParameter("patientId"));
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        String date = request.getParameter("appointmentDate");
        String time = request.getParameter("appointmentTime");
        String doctorName = request.getParameter("doctorName");
        String status = request.getParameter("status");

        // Create a new appointment object
        Appointment appointment = new Appointment(doctorId, patientId, doctorId, date, time, doctorName, status);

        // Use the DAO to add the appointment
        boolean isAppointmentAdded = addAppointmentDao.addAppointment(appointment);

        // Redirect or forward based on the result
        if (isAppointmentAdded) {
            request.setAttribute("message", "Appointment booked successfully!");
        } else {
            request.setAttribute("message", "Failed to book appointment.");
        }
        request.getRequestDispatcher("ShowDoctorsInPatients").forward(request, response);
    }
}


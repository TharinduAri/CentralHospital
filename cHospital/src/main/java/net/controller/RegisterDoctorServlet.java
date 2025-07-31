package net.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.AddDoctorDao;
import net.model.Doctor;

@WebServlet("/RegisterDoctorServlet")
public class RegisterDoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve user data from the form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("birthdate");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String streetAddress = request.getParameter("streetAddress");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalCode = request.getParameter("postalCode");
        String specialization = request.getParameter("specialization");
  

        // Create a doctor object
        Doctor doctor = new Doctor(email, firstName, lastName, dob, phone, password, gender, streetAddress,
                city, state, postalCode,specialization);
        // Insert the doctor into the database
        AddDoctorDao doctorDAO = new AddDoctorDao();
        boolean success = doctorDAO.registerDoctor(doctor);

        if (success) {
            response.sendRedirect("ShowDoctorsServlet");
        } else {
            request.setAttribute("errorMessage", "Failed to register doctor. Please try again.");
            request.getRequestDispatcher("ShowDoctorsServlet").forward(request, response);
        }
    }
}

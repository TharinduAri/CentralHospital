package net.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.RegisterPatientDao;
import net.model.Patient;

@WebServlet("/RegisterPatientServlet")
public class RegisterPatientServlet extends HttpServlet {
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
        String confirmPassword = request.getParameter("confirmPassword");        
        String gender = request.getParameter("gender");
        String streetAddress = request.getParameter("streetAddress");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalCode = request.getParameter("postalCode");

        
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match.");
            request.getRequestDispatcher("patientRegister.jsp").forward(request, response);
            return;
        }
        
        // Create a patient object
        Patient patient = new Patient(email, firstName, lastName, dob, phone, password, gender, streetAddress,
                city, state, postalCode);

        // Insert the patient into the database
        RegisterPatientDao patientDAO = new RegisterPatientDao();

        // Check if the email already exists
        if (patientDAO.isEmailRegistered(email)) {
            request.setAttribute("errorMessage", "This email is already being used by another user.");
            request.getRequestDispatcher("patientRegister.jsp").forward(request, response);
        } else {
            boolean success = patientDAO.registerPatient(patient);

            if (success) {
                response.sendRedirect("PatientLogin.jsp");
            } else {
                request.setAttribute("errorMessage", "Failed to Create Account. Please try again.");
                request.getRequestDispatcher("patientRegister.jsp").forward(request, response);
            }
        }
    }
}

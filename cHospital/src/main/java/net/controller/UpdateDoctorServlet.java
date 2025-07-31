package net.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.dao.UpdateDoctorDao;
import net.exception.DoctorUpdateException;
import net.model.Doctor;

@WebServlet("/updateDoctor")
public class UpdateDoctorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve form parameters
            int userId = Integer.parseInt(request.getParameter("userId"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String birthDate = request.getParameter("birthDate");
            String streetAddress = request.getParameter("streetAddress");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String postalCode = request.getParameter("postalCode");
            String phone = request.getParameter("phone");
            String specialization = request.getParameter("specialization");
            
            // Create Doctor object
            Doctor doctor = new Doctor(userId, email, firstName, lastName, null, gender, birthDate, phone, streetAddress, city, state, postalCode, specialization);
            
            // Update doctor in the database
            UpdateDoctorDao updateDoctorDao = new UpdateDoctorDao();
            boolean updated = updateDoctorDao.updateDoctor(doctor);
            
            // Check if update was successful
            if (updated) {
                // If successful, set success message and redirect to doctor.jsp
                request.setAttribute("message", "Doctor updated successfully!");
                request.getRequestDispatcher("ShowDoctorsServlet").forward(request, response);
            } else {
                // If failed, set error message and redirect to editDoctor.jsp
                request.setAttribute("error", "Failed to update doctor. Please try again.");
                request.getRequestDispatcher("editDoctor.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            // If there's an error parsing userId
            request.setAttribute("error", "Invalid user ID format. Please try again.");
            request.getRequestDispatcher("editDoctor.jsp").forward(request, response);
        } catch (DoctorUpdateException e) {
            // If there's an error during doctor update
            request.setAttribute("error", "Doctor update failed: " + e.getMessage());
            request.getRequestDispatcher("editDoctor.jsp").forward(request, response);
        }
    }
}

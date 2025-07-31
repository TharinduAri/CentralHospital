package net.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.UpdatePatientDao;

@WebServlet("/UpdatePatientServlet")
public class UpdatePatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String streetAddress = request.getParameter("streetAddress");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postalCode = request.getParameter("postalCode");

        UpdatePatientDao dao = new UpdatePatientDao();
        boolean updateSuccessful = dao.updatePatient(userId, email, firstName, lastName, password, gender, dob, phone, streetAddress, city, state, postalCode);

        if (updateSuccessful) {
            response.sendRedirect("userAccount"); // redirect to a page showing patient details
        } else {
            response.sendRedirect("patientDetails.jsp?error"); // redirect to an error page
        }
    }
}

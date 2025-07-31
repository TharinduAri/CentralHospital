package net.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.dao.UserDao;

import java.io.IOException;

@WebServlet("/newlogin")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserDao userDao = new UserDao();
        String role = userDao.getUserRole(email, password);
        String userId = userDao.getUserId(email, password);
        
        if (role != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", email); // Storing email in session
            session.setAttribute("role", role); // Storing role in session
            session.setAttribute("userId", userId);
            
            // Redirect based on role
            if (role.equals(UserDao.ROLE_ADMIN)) {
                response.sendRedirect("GetUserCountServlet");
            } else if (role.equals(UserDao.ROLE_DOCTOR)) {
                response.sendRedirect("DoctorAppointmentsServlet");
            } else if (role.equals(UserDao.ROLE_PATIENT)) {
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("PatientLogin.jsp?error=3");
            }
        } else {
            response.sendRedirect("PatientLogin.jsp?error=1"); // Invalid credentials
        }
    }
}

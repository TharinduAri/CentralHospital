package net.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.model.Doctor;

public class ShowDoctorsDao {


    // Method to get all patients from the database with their addresses and phone numbers
    public static List<Doctor> getAllDoctorsWithDetails() {
        List<Doctor> doctors = new ArrayList<>();

        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement()) {
        	String sql = "SELECT u.userId, u.email, u.firstName, u.lastName, u.role, u.password, u.gender, u.dateOfBirth, " +
                    "up.phone, " +
                    "ua.street_address, ua.city, ua.state, ua.postal_code, " +
                    "d.specialization " + 
                    "FROM user u " +
                    "LEFT JOIN user_phone up ON u.userId = up.userId " +
                    "LEFT JOIN user_address ua ON u.userId = ua.userId " +
                    "LEFT JOIN doctor d ON u.userId = d.doctorId " +
                    "WHERE u.role = 'doctor'";

            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                // Retrieve user details
                int userId = rs.getInt("userId");
                String email = rs.getString("email");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String dateOfBirth = rs.getString("dateOfBirth");
                
//              Retrieve phone number
                String phone = rs.getString("phone");
               
//              Retrieve address details
                String streetAddress = rs.getString("street_address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String postalCode = rs.getString("postal_code");
                String specialization=rs.getString("specialization");
//

//

                //Create Patient object
                Doctor doctor = new Doctor(userId, email, firstName, lastName, password, gender, dateOfBirth,phone, streetAddress, city, state, postalCode,specialization);
//                Patient patient = new Patient(userId, email);
                doctors.add(doctor);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }
}

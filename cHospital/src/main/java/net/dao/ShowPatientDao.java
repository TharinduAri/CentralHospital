package net.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.model.Patient;

public class ShowPatientDao {

    // Method to get all patients from the database with their addresses and phone numbers
    public static List<Patient> getAllPatientsWithDetails() {
        List<Patient> patients = new ArrayList<>();

        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement()) {
        	String sql = "SELECT u.userId, u.email, u.firstName, u.lastName, u.role,u.password, u.gender, u.dateOfBirth, " +
                    "up.phone, " +
                    "ua.street_address, ua.city, ua.state, ua.postal_code, " +
                    "p.appointmentStatus " +
                    "FROM user u " +
                    "LEFT JOIN user_phone up ON u.userId = up.userId " +
                    "LEFT JOIN user_address ua ON u.userId = ua.userId " +
                    "LEFT JOIN patient p ON u.userId = p.patientId " +
                    "WHERE u.role = 'patient'";
//        	String sql = "select * from user";

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
               
//                // Retrieve address details
                String streetAddress = rs.getString("street_address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String postalCode = rs.getString("postal_code");
//
//                // Retrieve phone number
                String phone = rs.getString("phone");
//
//                // Retrieve appointment status
                String appointmentStatus = rs.getString("appointmentStatus");

                // Create Patient object
                Patient patient = new Patient(userId, email, firstName, lastName, password, gender, dateOfBirth,phone, streetAddress, city, state, postalCode, appointmentStatus);
//                Patient patient = new Patient(userId, email);
                patients.add(patient);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
    
    // Method to get patient details based on email
    public Patient getPatientByEmail(String email) {
        Patient patient = null;

        String sql = "SELECT u.userId, u.email, u.firstName, u.lastName, u.password, u.gender, u.dateOfBirth, " +
                     "up.phone, " +
                     "ua.street_address, ua.city, ua.state, ua.postal_code, " +
                     "p.appointmentStatus " +
                     "FROM user u " +
                     "LEFT JOIN user_phone up ON u.userId = up.userId " +
                     "LEFT JOIN user_address ua ON u.userId = ua.userId " +
                     "LEFT JOIN patient p ON u.userId = p.patientId " +
                     "WHERE u.email = ? AND u.role = 'patient'";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            // Check if a patient with the provided email exists
            if (rs.next()) {
                // Retrieve patient details
                int userId = rs.getInt("userId");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String password = rs.getString("password");
                String gender = rs.getString("gender");
                String dateOfBirth = rs.getString("dateOfBirth");
                String phone = rs.getString("phone");
                String streetAddress = rs.getString("street_address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String postalCode = rs.getString("postal_code");
                String appointmentStatus = rs.getString("appointmentStatus");
                // Create a Patient object
                patient = new Patient(userId, email, firstName, lastName, password, gender, dateOfBirth, phone,
                        streetAddress, city, state, postalCode, appointmentStatus);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patient;
    }
    
//    Method to get patient Count
    public static int getPatientCount() {
        int patientCount = 0;

        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT COUNT(*) AS patientCount FROM user WHERE role = 'patient'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                patientCount = rs.getInt("patientCount");
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patientCount;
    }
}

package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePatientDao {

    // Method to update patient details
    public boolean updatePatient(int userId, String email, String firstName, String lastName, String password, 
                                 String gender, String dob, String phone, String streetAddress, 
                                 String city, String state, String postalCode) {
        boolean rowUpdated = false;
        String sql = "UPDATE user SET email = ?, firstName = ?, lastName = ?, password = ?, gender = ?, dateOfBirth = ? WHERE userId = ?";
        String sqlPhone = "UPDATE user_phone SET phone = ? WHERE userId = ?";
        String sqlAddress = "UPDATE user_address SET street_address = ?, city = ?, state = ?, postal_code = ? WHERE userId = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             PreparedStatement stmtPhone = conn.prepareStatement(sqlPhone);
             PreparedStatement stmtAddress = conn.prepareStatement(sqlAddress)) {

            // Update user table
            stmt.setString(1, email);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, password);
            stmt.setString(5, gender);
            stmt.setString(6, dob);
            stmt.setInt(7, userId);
            int rowsAffected = stmt.executeUpdate();

            // Update user_phone table
            stmtPhone.setString(1, phone);
            stmtPhone.setInt(2, userId);
            rowsAffected += stmtPhone.executeUpdate();

            // Update user_address table
            stmtAddress.setString(1, streetAddress);
            stmtAddress.setString(2, city);
            stmtAddress.setString(3, state);
            stmtAddress.setString(4, postalCode);
            stmtAddress.setInt(5, userId);
            rowsAffected += stmtAddress.executeUpdate();

            rowUpdated = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}

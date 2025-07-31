package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.model.Patient;

public class RegisterPatientDao {

    public boolean registerPatient(Patient patient) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionManager.getConnection();
            String query = "INSERT INTO user (email, firstName, lastName, password, role, gender, dateOfBirth) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, patient.getEmail());
            preparedStatement.setString(2, patient.getFirstName());
            preparedStatement.setString(3, patient.getLastName());
            preparedStatement.setString(4, patient.getPassword());
            preparedStatement.setString(5, "patient"); // Default role is patient
            preparedStatement.setString(6, patient.getGender());
            preparedStatement.setString(7, patient.getBirthDate());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // Get the auto-generated userId
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    int userId = resultSet.getInt(1);
                    // Insert address and phone with userId
                    insertAddress(connection, patient, userId);
                    insertPhone(connection, patient, userId);
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void insertAddress(Connection connection, Patient patient, int userId) throws SQLException {
        String query = "INSERT INTO user_address (userId, street_address, city, state, postal_code) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, userId);
        preparedStatement.setString(2, patient.getStreetAddress());
        preparedStatement.setString(3, patient.getCity());
        preparedStatement.setString(4, patient.getState());
        preparedStatement.setString(5, patient.getPostalCode());
        preparedStatement.executeUpdate();
        preparedStatement.close(); // Close the statement
    }

    private void insertPhone(Connection connection, Patient patient, int userId) throws SQLException {
        String query = "INSERT INTO user_phone (userId, phone) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, userId);
        preparedStatement.setString(2, patient.getPhone());
        preparedStatement.executeUpdate();
        preparedStatement.close(); // Close the statement
    }

    public boolean isEmailRegistered(String email) {
        String query = "SELECT 1 FROM user WHERE email = ?";
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

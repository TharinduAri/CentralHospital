package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.model.Doctor;

public class AddDoctorDao {
	public boolean registerDoctor(Doctor doctor) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionManager.getConnection();
            String query = "INSERT INTO user (email, firstName, lastName, password, role, gender, dateOfBirth) VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, doctor.getEmail());
            preparedStatement.setString(2, doctor.getFirstName());
            preparedStatement.setString(3, doctor.getLastName());
            preparedStatement.setString(4, doctor.getPassword());
            preparedStatement.setString(5, "doctor"); // Default role is doctor
            preparedStatement.setString(6, doctor.getGender());
            preparedStatement.setString(7, doctor.getBirthDate());
            System.out.println(doctor.getSpecialization());
            
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0) {
            	resultSet = preparedStatement.getGeneratedKeys();
            	if (resultSet.next()) {
                    int userId = resultSet.getInt(1);
                    // Insert address and phone with userId
                    insertAddress(connection, doctor, userId);
                    insertPhone(connection, doctor, userId);
                    insertSpecialization(connection, doctor, userId);
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
	
	private void insertAddress(Connection connection, Doctor doctor, int userId) throws SQLException {
        String query = "INSERT INTO user_address (userId, street_address, city, state, postal_code) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, userId);
        preparedStatement.setString(2, doctor.getStreetAddress());
        preparedStatement.setString(3, doctor.getCity());
        preparedStatement.setString(4, doctor.getState());
        preparedStatement.setString(5, doctor.getPostalCode());
        preparedStatement.executeUpdate();
        preparedStatement.close(); // Close the statement
    }
    private void insertPhone(Connection connection, Doctor doctor, int userId) throws SQLException {
        String query = "INSERT INTO user_phone (userId, phone) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, userId);
        preparedStatement.setString(2, doctor.getPhone());
        preparedStatement.executeUpdate();
        preparedStatement.close(); // Close the statement
    }
    private void insertSpecialization(Connection connection, Doctor doctor, int userId) throws SQLException {
        String query = "INSERT INTO doctor (doctorId, specialization) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, userId);
        preparedStatement.setString(2, doctor.getSpecialization());
        preparedStatement.executeUpdate();
        preparedStatement.close(); // Close the statement
    }
}

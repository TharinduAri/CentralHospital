package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.exception.DoctorUpdateException;
import net.model.Doctor;

public class UpdateDoctorDao {

    // SQL query to update doctor information
    private static final String UPDATE_DOCTOR_SQL = "UPDATE user u " +
                                                     "LEFT JOIN doctor d ON u.userId = d.doctorId " +
                                                     "LEFT JOIN user_address a ON u.userId = a.userId " +
                                                     "LEFT JOIN user_phone p ON u.userId = p.userId " +
                                                     "SET u.firstName = ?, u.lastName = ?, u.email = ?, u.gender = ?, u.dateOfBirth = ?, " +
                                                     "a.street_address = ?, a.city = ?, a.state = ?, a.postal_code = ?, " +
                                                     "p.phone = ?, d.specialization = ? " +
                                                     "WHERE u.userId = ?";

    // Method to update doctor information in the database
    public boolean updateDoctor(Doctor doctor) throws DoctorUpdateException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOCTOR_SQL)) {
            preparedStatement.setString(1, doctor.getFirstName());
            preparedStatement.setString(2, doctor.getLastName());
            preparedStatement.setString(3, doctor.getEmail());
            preparedStatement.setString(4, doctor.getGender());
            preparedStatement.setString(5, doctor.getBirthDate());
            preparedStatement.setString(6, doctor.getStreetAddress());
            preparedStatement.setString(7, doctor.getCity());
            preparedStatement.setString(8, doctor.getState());
            preparedStatement.setString(9, doctor.getPostalCode());
            preparedStatement.setString(10, doctor.getPhone());
            preparedStatement.setString(11, doctor.getSpecialization());
            preparedStatement.setInt(12, doctor.getUserId());

            // Execute the update operation
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                throw new DoctorUpdateException("Failed to update doctor.");
            }
        } catch (SQLException e) {
            throw new DoctorUpdateException("Error updating doctor: " + e.getMessage());
        }
    }
}

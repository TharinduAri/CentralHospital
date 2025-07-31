package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDoctorDao {

    private static final String DELETE_DOCTOR_SQL = "DELETE u, d, a, p FROM user u " +
                                                     "LEFT JOIN doctor d ON u.userId = d.doctorId " +
                                                     "LEFT JOIN user_address a ON u.userId = a.userId " +
                                                     "LEFT JOIN user_phone p ON u.userId = p.userId " +
                                                     "WHERE u.userId = ?";

    public DeleteDoctorDao() {}

    public boolean deleteDoctor(int doctorId) {
        boolean rowDeleted = false;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DOCTOR_SQL)) {
            preparedStatement.setInt(1, doctorId);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}

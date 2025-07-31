package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeclineAppointmentByDoctorDao {

    private static final String DELETE_APPOINTMENT_SQL = "DELETE FROM appointment WHERE appointmentId = ?";

    public boolean declineAppointment(int appointmentId) {
        boolean rowDeleted = false;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_APPOINTMENT_SQL)) {
            preparedStatement.setInt(1, appointmentId);

            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}

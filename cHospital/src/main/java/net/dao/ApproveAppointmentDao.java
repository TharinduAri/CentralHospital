package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApproveAppointmentDao {

    private static final String UPDATE_APPOINTMENT_STATUS_SQL = "UPDATE appointment SET status = ? WHERE appointmentId = ?";

    public boolean approveAppointment(int appointmentId) {
        boolean rowUpdated = false;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_APPOINTMENT_STATUS_SQL)) {
            preparedStatement.setString(1, "approved");
            preparedStatement.setInt(2, appointmentId);

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}

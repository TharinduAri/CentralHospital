package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAppointmentDao {

    public boolean deleteAppointmentById(int appointmentId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean deleted = false;

        try {
            conn = ConnectionManager.getConnection();
            String sql = "DELETE FROM appointment WHERE appointmentId = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, appointmentId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                deleted = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle or log exception
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(); // Handle or log exception
            }
        }

        return deleted;
    }

    // You can add more methods here if needed
}

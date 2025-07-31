package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.model.Appointment;

public class AddAppointmentDao {

    public boolean addAppointment(Appointment appointment) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionManager.getConnection(); // Get the connection from ConnectionManager class
            String sql = "INSERT INTO appointment (userid, doctorid, date, time, docname, status) VALUES (?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, appointment.getUserId());
            pstmt.setInt(2, appointment.getDoctorId());
            pstmt.setString(3, appointment.getDate());
            pstmt.setString(4, appointment.getTime());
            pstmt.setString(5, appointment.getDocname());
            pstmt.setString(6, "Pending");
            
            

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(pstmt, conn);
        }

        return status;
    }

    // Method to close resources
    private void closeResources(PreparedStatement pstmt, Connection conn) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

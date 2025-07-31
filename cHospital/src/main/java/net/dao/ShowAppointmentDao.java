package net.dao;

import net.model.Appointment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowAppointmentDao {

    // Method to get appointments by userId
    public List<Appointment> getAppointmentsByUserId(int userId) {
        List<Appointment> appointments = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getConnection(); // Assuming you have a ConnectionManager class
            String sql = "SELECT appointmentId, userid, doctorid, date, time, docname, status FROM appointment WHERE userid = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int appointmentId = rs.getInt("appointmentId");
                int doctorId = rs.getInt("doctorid");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String docname = rs.getString("docname");
                String status = rs.getString("status");

                Appointment appointment = new Appointment(appointmentId, userId, doctorId, date, time, docname, status);
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, pstmt, conn);
        }

        return appointments;
    }

    // Method to close resources
    private void closeResources(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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

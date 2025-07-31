package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.model.Appointment;

public class AppointmentDAO {
    private Connection jdbcConnection;

    protected void connect() throws SQLException {
        jdbcConnection = ConnectionManager.getConnection();
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO appointment (appointmentId, userId, doctorId, date, time, docname, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, appointment.getAppointmentId());
        statement.setInt(2, appointment.getUserId());
        statement.setInt(3, appointment.getDoctorId());
        statement.setString(4, appointment.getDate());
        statement.setString(5, appointment.getTime());
        statement.setString(6, appointment.getDocname());
        statement.setString(7, appointment.getStatus());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    
    
    
    public List<Appointment> listAllAppointments(String userId) throws SQLException {
    	String sql = "SELECT * FROM appointment WHERE doctorId = ?";
        List<Appointment> appointments = new ArrayList<>();

      

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1,userId);
        ResultSet resultSet = statement.executeQuery();
       

        while (resultSet.next()) {
            int appointmentId = resultSet.getInt("appointmentId");

            int doctorId = resultSet.getInt("doctorId");
            String date = resultSet.getString("date");
            String time = resultSet.getString("time");
            String docname = resultSet.getString("Docname");
            String status = resultSet.getString("Status");

            Appointment appointment = new Appointment(appointmentId, doctorId, date, time, docname, status);
            appointments.add(appointment);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return appointments;
    }

}

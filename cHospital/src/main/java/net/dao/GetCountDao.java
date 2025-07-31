package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCountDao { 
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet resultSet=null;
	
    public int getPatientCount() {
        int count = 0;

        try {
            connection = ConnectionManager.getConnection();
            String query = "SELECT COUNT(*) AS user_count FROM user WHERE role='patient'";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("user_count");
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
        return count;
    }
    
    
    public int getAppointmentCount() {
    	int count=0;
    	try {
    		connection = ConnectionManager.getConnection();
    		String query = "SELECT COUNT(*) as appointment_count FROM appointment ";
    		preparedStatement = connection.prepareStatement(query);
    		resultSet = preparedStatement.executeQuery();
    		
    		if(resultSet.next()) {
    			count=resultSet.getInt("appointment_count");
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		try {
    			if(resultSet != null) resultSet.close();
    			if(preparedStatement != null) preparedStatement.close();
    			if(connection != null) connection.close();
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	return count;
    }
    
    public int getDoctorCount() {
    	int count=0;
    	try {
    		connection = ConnectionManager.getConnection();
    		String query = "SELECT COUNT(*) as doctor_count FROM user WHERE role='doctor' ";
    		preparedStatement = connection.prepareStatement(query);
    		resultSet = preparedStatement.executeQuery();
    		
    		if(resultSet.next()) {
    			count=resultSet.getInt("doctor_count");
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		try {
    			if(resultSet != null) resultSet.close();
    			if(preparedStatement != null) preparedStatement.close();
    			if(connection != null) connection.close();
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	return count;
    }
}

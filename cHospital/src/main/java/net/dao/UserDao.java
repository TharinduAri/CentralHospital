package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    
    // SQL queries
    private static final String SELECT_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM user WHERE email = ? AND password = ?";
    
    // Define roles
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_DOCTOR = "doctor";
    public static final String ROLE_PATIENT = "patient";
    public static final String ROLE_RECEPTIONIST = "receptionist";
    
    // Get user role by email and password
    public String getUserRole(String email, String password) {
        String role = null;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL_AND_PASSWORD)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                role = resultSet.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
    
    // Get user ID by email and password
    public String getUserId(String email, String password) {
        String userId = null;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL_AND_PASSWORD)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userId = resultSet.getString("userId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    //  if needed to get all users
    /*
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("userId");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");
                String firstName = resultSet.getString("firstName");
                User user = new User(id, email, role, firstName);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    */
}

package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteReviewDao {

    private static final String DELETE_REVIEW_SQL = "DELETE FROM review WHERE reviewId = ?";

    public boolean deleteReview(int reviewId) {
        boolean rowDeleted = false;
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_REVIEW_SQL)) {
            preparedStatement.setInt(1, reviewId);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}


// UpdateReviewDao.java
package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateReviewDao {

    private static final String UPDATE_REVIEW_SQL = "UPDATE review SET reviewText = ? WHERE reviewId = ?";

    public boolean updateReview(int reviewId, String newReviewText) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REVIEW_SQL)) {
            preparedStatement.setString(1, newReviewText);
            preparedStatement.setInt(2, reviewId);
            return preparedStatement.executeUpdate() > 0;
        }
    }
}

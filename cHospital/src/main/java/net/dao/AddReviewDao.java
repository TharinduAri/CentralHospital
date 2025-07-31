package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.model.Review;

public class AddReviewDao {

    public boolean addReview(Review review) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionManager.getConnection(); // Get the connection from ConnectionManager class
            String sql = "INSERT INTO review (userId, userName, reviewText) VALUES (?, ?, ?)";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, review.getUserId());
            pstmt.setString(2, review.getUserName());
            pstmt.setString(3, review.getReviewText());

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

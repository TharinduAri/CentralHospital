package net.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.model.Review;

public class ShowReviewDao {
    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getConnection();
            String sql = "SELECT * FROM review";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int reviewId = rs.getInt("reviewId");
                int userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String reviewText = rs.getString("reviewText");

                Review review = new Review(reviewId, userId, userName, reviewText);
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return reviews;
    }
}

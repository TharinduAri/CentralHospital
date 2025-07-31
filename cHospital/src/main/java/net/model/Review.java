package net.model;

public class Review {
	
			int reviewId;
			int userId;
			String userName;
			String reviewText;
			
			
			public Review(int reviewId, int userId, String userName, String reviewText) {
				super();
				this.reviewId = reviewId;
				this.userId = userId;
				this.userName = userName;
				this.reviewText = reviewText;
			}


			public Review(int userId, String userName, String reviewText) {

				this.userId = userId;
				this.userName = userName;
				this.reviewText = reviewText;
			}


			public int getReviewId() {
				return reviewId;
			}


			public void setReviewId(int reviewId) {
				this.reviewId = reviewId;
			}


			public int getUserId() {
				return userId;
			}


			public void setUserId(int userId) {
				this.userId = userId;
			}


			public String getUserName() {
				return userName;
			}


			public void setUserName(String userName) {
				this.userName = userName;
			}


			public String getReviewText() {
				return reviewText;
			}


			public void setReviewText(String reviewText) {
				this.reviewText = reviewText;
			}
			
			

}
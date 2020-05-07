package com.example.hotelmanagement.hotels.model;

public class Review {
	
	private String userName;
	private int ratings;
	private boolean approved;
	
	
	public Review() {
		
	}
	public Review(String userName, int ratings, boolean approved) {
		super();
		this.userName = userName;
		this.ratings = ratings;
		this.approved = approved;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	@Override
	public String toString() {
		return "Review [userName=" + userName + ", ratings=" + ratings + ", approved=" + approved + "]";
	}
	
	
}

package com.example.hotelmanagement.hotels.resource;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;

public class HotelFilterBean {

	private @HeaderParam("sessionId") String sessionId;
	private @CookieParam("cookie") String cookievalue;
	
	private @PathParam("countryId") String country;
	private @MatrixParam("price") int price;
	private @MatrixParam("ratings") int ratings;
	
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getCookievalue() {
		return cookievalue;
	}
	public void setCookievalue(String cookievalue) {
		this.cookievalue = cookievalue;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	
}

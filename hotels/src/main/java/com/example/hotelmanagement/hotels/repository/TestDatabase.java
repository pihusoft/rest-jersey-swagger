package com.example.hotelmanagement.hotels.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.hotelmanagement.hotels.model.Hotel;
import com.example.hotelmanagement.hotels.model.Review;

public class TestDatabase {
		
	private static Map<String, Hotel> hotels = new HashMap<>();
	private static Map<String, Review> reviews = new HashMap<>();
	
	
	public static Map<String, Hotel> getHotels() {
		return hotels;
	}
	public static Map<String, Review> getReviews() {
		return reviews;
	}
	
	
}

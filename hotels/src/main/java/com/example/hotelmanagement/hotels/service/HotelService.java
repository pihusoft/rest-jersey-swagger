package com.example.hotelmanagement.hotels.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.hotelmanagement.hotels.model.Address;
import com.example.hotelmanagement.hotels.model.Hotel;
import com.example.hotelmanagement.hotels.model.Review;
import com.example.hotelmanagement.hotels.repository.TestDatabase;

public class HotelService {
	
	private Map<String, Hotel> hotels = TestDatabase.getHotels();
	public static HotelService obj = new HotelService();
	public static HotelService getHotelService() {
		if(obj == null) {
			return new HotelService();
		}
		else {
			return obj;
		}
	}
	
	private HotelService() {

		Hotel marriot = new Hotel(
				"Marriot",
				150,
				new Address("Bangalore", "India"),
				Arrays.asList(
						new Review("Jack",8,false),
						new Review("Anna",7,true)
						)
				);
		Hotel sevenska = new Hotel(
				"SevenSka",
				90,
				new Address("Bangalore", "India"),
				Arrays.asList(
						new Review("James",6,false)
						)
				);
		Hotel ibis = new Hotel(
				"Ibis",
				100,
				new Address("Delhi", "India"),
				Arrays.asList()
				);
		
		addHotel(marriot);
		addHotel(sevenska);
		addHotel(ibis);
	}

	public List<Hotel> getAllHotels(){
		return new ArrayList<Hotel>(hotels.values());
	}
	
	public List<Hotel> getAllHotelsByPrice(int maxPrice){
		List<Hotel> hotel = new ArrayList<Hotel>(hotels.values());
		return hotel.stream().filter(h -> h.getPricePerNight() <= maxPrice).collect(Collectors.toList());
	}
	
	public List<Hotel> getAllHotelsOfCountryByPrice(String country,int maxPrice){
		List<Hotel> hotel = new ArrayList<Hotel>(hotels.values());
		return hotel.stream()
				    .filter(h -> (h.getPricePerNight() <= maxPrice) && (h.getAddress().getCountry().equalsIgnoreCase(country)))
				    .collect(Collectors.toList());
	}
	
	public Hotel getHotelById(String id) {
		return hotels.get(id);
	}
	
	public Hotel addHotel(Hotel hotel) {
		hotel.setId(UUID.randomUUID().toString());
		hotels.put(hotel.getId(),hotel);
		return hotel;
	}
	
	public Hotel updateHotel(Hotel hotel) {
		hotels.put(hotel.getId(),hotel);
		return hotel;
	}
	
	public void deleteHotel(String id) {
		hotels.remove(id);
	}

	public List<Hotel> recommendedHotels(String country, int price, int ratings) {
		List<Hotel> hotel = new ArrayList<Hotel>(hotels.values());
		return hotel.stream()
			    .filter(h -> (h.getPricePerNight() <= price) && (h.getAddress().getCountry().equalsIgnoreCase(country))
			    		&& (h.getReviews().stream().anyMatch(review -> (review.getRatings() >= ratings) && (review.isApproved()))))
			    .collect(Collectors.toList());
	}
	
	

}

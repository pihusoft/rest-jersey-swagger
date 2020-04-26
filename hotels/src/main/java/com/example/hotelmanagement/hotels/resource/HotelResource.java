package com.example.hotelmanagement.hotels.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.hotelmanagement.hotels.model.Hotel;
import com.example.hotelmanagement.hotels.service.HotelService;

@Path("/hotels")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HotelResource {
	
		HotelService hotelService = HotelService.getHotelService();
				
//	   	@GET
//	    public List<Hotel> getAll() {
//	        return hotelService.getAllHotels();
//	    }
		
	   	@GET
	    public List<Hotel> getAll(@QueryParam("price") int price,@QueryParam("country") String country) {
	   		
	   		if(price > 0 && country==null) {
	   			return hotelService.getAllHotelsByPrice(price);
	   		}
	   		else if(price > 0 && country!=null) {
	   			return hotelService.getAllHotelsOfCountryByPrice(country, price);
	   		}
	   		
	        return hotelService.getAllHotels();
	    }
		
//	   	@GET
//	   	@Path("country/{countryId}")
//	   	public List<Hotel> recommendedHotels(@PathParam("countryId") String country,@MatrixParam("price") int price, @MatrixParam("ratings") int ratings){
//	   		return hotelService.recommendedHotels(country,price,ratings);
//	   	}
	   	
	   	@GET
	   	@Path("country/{countryId}")
	   	public List<Hotel> recommendedHotels(@BeanParam HotelFilterBean hotelFilterBean){
	   		return hotelService.recommendedHotels(hotelFilterBean.getCountry(),hotelFilterBean.getPrice(),hotelFilterBean.getRatings());
	   	}
	   	
	   	@GET
	   	@Path("/{hotelId}") 
	   	public Hotel getHotel(@PathParam("hotelId") String id) {
	   		return hotelService.getHotelById(id);
	   	}
	   	
	   	@POST
	   	public Hotel add(Hotel hotel) {
	   		return hotelService.addHotel(hotel);
	   	}
	   	
	   	@PUT
	   	@Path("/{hotelId}")
	   	public Hotel update(@PathParam("hotelId") String id, Hotel hotel) {
	   		hotel.setId(id);
	   		return hotelService.updateHotel(hotel);
	   	}
	   	
	   	@DELETE
	   	@Path("/{hotelId}")
	   	public void deleteHotel(@PathParam("hotelId") String id) {
	   		hotelService.deleteHotel(id);	   		
	   	}
}

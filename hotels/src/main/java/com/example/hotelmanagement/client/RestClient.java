package com.example.hotelmanagement.client;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.hotelmanagement.hotels.model.Address;
import com.example.hotelmanagement.hotels.model.Hotel;
import com.example.hotelmanagement.hotels.model.Review;

public class RestClient {

	public static void main(String[] args) {
		
		
		//Rest request for getting all the hotels 
		System.out.println("Rest request for getting all the hotels filter by price\n");
		Client client = ClientBuilder.newClient();
	    WebTarget target = client.target("http://localhost:8670/hotels/webapi/hotels/");
	    
	    Builder builder = target.request(MediaType.APPLICATION_JSON);
	    Response response = builder.get();
		List<Hotel> hotels = response.readEntity(List.class); 
	    System.out.println(hotels.get(2));
	    
	    System.out.println("\n*************************\n");
	    /*Rest request for getting all the hotels filter by price 
	     */    
	    
	    Response response2 = target.queryParam("price", 100)
	    		.request(MediaType.APPLICATION_JSON)
	    		.get();
	    System.out.println("Rest request for getting all the hotels filter by price\n");
	    System.out.println(response2.readEntity(List.class).get(0));
	    
	    
	    System.out.println("\n*************************\n");
	    /*Rest request for getting all the hotels filter by price and country
	     */
	    
	    Response response3 = target.queryParam("price", 200)
	    		.queryParam("country", "USA")
	    		.request(MediaType.APPLICATION_JSON)
	    		.get();
	    System.out.println("Rest request for getting all the hotels filter by price and country");
	    System.out.println(response3.readEntity(List.class).get(0));
	    
	    
	    System.out.println("\n*************************\n");
	    /*Rest request for adding a hotel entity -- POST request
	     */
	    
	    Hotel Oterra = new Hotel(
				"Oterra",
				150,
				new Address("Bangalore", "India"),
				Arrays.asList(
						new Review("Jack",8,false),
						new Review("Anna",7,true)
						)
				);
	    
	    Response postResponse = target.request()
	    		.post(Entity.json(Oterra));
	    System.out.println("Rest response for POST request");
	    System.out.println(postResponse.getStatus());
	    System.out.println(postResponse.readEntity(Hotel.class));
	    
	    
	    WebTarget singleHotelTarget = target.path("{hotelId}");
	    
	    System.out.println("\n*************************\n");
	    /*Rest request for updating a hotel entity -- PUT request
	     */
	    
	    Hotel ibis = new Hotel(
				"Ibis",
				80,
				new Address("Delhi", "India"),
				Arrays.asList()
				);
	    
	    Response putResponse = singleHotelTarget
	    		//.path("bf9bb8d7-6bd4-4271-94d4-1234a8c45ae1")
	    		.resolveTemplate("hotelId", "814a0b9b-ad0d-4845-ac42-945f055417ba")
	    		.request()
	    		.put(Entity.json(ibis));
	    System.out.println("Rest response for PUT request");
	    System.out.println("Status :" + putResponse.getStatus() + "\n" + putResponse.readEntity(Hotel.class));
	    
	    
	    System.out.println("\n*************************\n");
	    /*Rest request for deleting a hotel entity -- DELETE request
	     */
	    
	    
	    Response deleteResponse = singleHotelTarget
	    		//.path("bf9bb8d7-6bd4-4271-94d4-1234a8c45ae1")
	    		.resolveTemplate("hotelId", "893d54fa-995a-469c-9c78-e45c0d785879")
	    		.request()
	    		.delete();
	    System.out.println("Rest response for DELETE request");
	    System.out.println("Status :" + deleteResponse.getStatus());
	    
	}

}

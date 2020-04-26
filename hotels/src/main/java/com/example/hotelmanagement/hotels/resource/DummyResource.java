package com.example.hotelmanagement.hotels.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dummy")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DummyResource{

//	@GET
//	@Path("/demoParams")
//	public String getDemoParams(@HeaderParam("sessionId") String sessionId, 
//								@CookieParam("cookie") String cookievalue) {
//		return "Header Param :" +sessionId + " CookieParam :" + cookievalue;
//	}
	
	@GET
	@Path("/demoParams")
	public String getDemoParams(@BeanParam HotelFilterBean hotelFilterBean) {
		return "Header Param :" +hotelFilterBean.getSessionId() + " CookieParam :" + hotelFilterBean.getCookievalue();
	}
	
	@POST
	@Path("/demoForm")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String demoFormParams(@FormParam("FirstName") String firstName, @FormParam("LastName") String lastName) {
		return "FirstName:" + firstName + " LastName:" +lastName;
	}
}

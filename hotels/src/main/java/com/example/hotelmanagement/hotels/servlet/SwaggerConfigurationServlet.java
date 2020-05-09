package com.example.hotelmanagement.hotels.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;



public class SwaggerConfigurationServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setBasePath("hotels/webapi");
		beanConfig.setHost("localhost:8999");
		beanConfig.setTitle("Swagger for API");
		beanConfig.setPrettyPrint(true);
		beanConfig.setSchemes(new String[] {"http"});
		beanConfig.setVersion("1.0");
		beanConfig.setResourcePackage("com.example.hotelmanagement.hotels.resource");
		beanConfig.setScan(true);
	}
	

}

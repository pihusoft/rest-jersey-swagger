package com.example.hotelmanagement.client;

import java.io.File;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

public class FileUploadClient {

	public static void main(String[] args) throws Exception {
		
        // set file upload parameters
        String url = "http://localhost:8670/hotels/webapi/files/upload";
        File filePath = new File("C:\\ASSIGNMENT.pdf");
 
        // invoke file upload service using above parameters
        String response = uploadFile(url, filePath);
        System.out.println(response);
    }
 
   
	
    public static String uploadFile(String url, File filePath)  throws Exception {

        String responseMessage = null;
 
        try{
            // invoke service after setting necessary parameters
            ClientConfig clientConfig = new ClientConfig();
            clientConfig.register(MultiPartFeature.class);
            
            Client client =  ClientBuilder.newClient(clientConfig);
            WebTarget target = client.target(url);
 
            // set file upload values
            FileDataBodyPart fileDataBodyPart = new FileDataBodyPart("file", filePath);
            FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
            formDataMultiPart.bodyPart(fileDataBodyPart);
            
            
            Response response =  target.request().post(Entity.entity(formDataMultiPart, MediaType.MULTIPART_FORM_DATA));

            responseMessage = response.readEntity(String.class);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return responseMessage;
        
    }

}

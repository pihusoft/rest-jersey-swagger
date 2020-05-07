package com.example.hotelmanagement.client;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

public class FileDownloadClient {

	public static void main(String[] args) throws Exception {
		
		String url = "http://localhost:8670/hotels/webapi/files/download/pdf";
		
        String response = downloadFile(url);
        System.out.println(response);
    }
 
    public static String downloadFile(String url) throws Exception {
 
    	String responseMessage = null;
        try{
            // invoke service after setting necessary parameters
            ClientConfig clientConfig = new ClientConfig();
            clientConfig.register(MultiPartFeature.class);
            Client client =  ClientBuilder.newClient(clientConfig);
            client.property("accept", "application/pdf");
            WebTarget target = client.target(url);
 
            Response response = target.request().get();
 
            System.out.println("Status : " + response.getStatus());
            
            // read response string
            InputStream inputStream = response.readEntity(InputStream.class);
            String File_Path = "C:\\ASSIGNMENT.pdf";
            OutputStream outputStream = new FileOutputStream(File_Path);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
          
            responseMessage = "downloaded successfully at " + File_Path;
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
   
        return responseMessage;
    }

	

}

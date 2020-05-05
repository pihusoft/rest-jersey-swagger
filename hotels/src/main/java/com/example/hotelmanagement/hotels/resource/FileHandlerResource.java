package com.example.hotelmanagement.hotels.resource;

import java.io.File;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.example.hotelmanagement.hotels.service.FileHandlerService;

@Path("/files")  
public class FileHandlerResource {  
	
	FileHandlerService fileHandlerService = FileHandlerService.getFileHandlerService();
	
    @POST  
    @Path("/upload")  
    @Consumes(MediaType.MULTIPART_FORM_DATA)  
    public Response uploadFile(  
            @FormDataParam("file") InputStream inputStream,  
            @FormDataParam("file") FormDataContentDisposition fileDetail) {  
            String fileLocation = "C:\\" + fileDetail.getFileName();  
     
            fileHandlerService.uploadFile(inputStream,fileLocation);
            String output = "File successfully uploaded to : " + fileLocation;  
            
            return Response.status(200).entity(output).build();  
    }  
    
    @GET
    @Path("download/pdf")
    @Produces("application/pdf")
    public Response downloadPdfFile() {  
        String FILE_PATH = "C:\\ASSIGNMENT.pdf";  
        File file = new File(FILE_PATH);  
        
        return Response.ok((Object)file)
        		.header("Content-Disposition","attachment; filename=\"ASSIGNMENT.pdf\"")
        		.build();
    }  
    
    @GET
    @Path("download/csv")
    @Produces("text/csv")
    //@Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadCSVFile() {  
        String FILE_PATH = "C:\\dummy.xls";  
        File file = new File(FILE_PATH);  
        
        return Response.ok((Object)file).header("Content-Disposition","attachment; filename=\"dummy.xls\"").build();
    }  
    
    @GET
    @Path("download/image")
    @Produces("image/png")
    public Response downloadImageFile() {  
        String FILE_PATH = "C:\\Image.png";  
        File file = new File(FILE_PATH);  
        
        return Response.ok((Object)file)
        		.header("Content-Disposition","attachment; filename=\"Image.png\"")
        		.build();
    }    
    
     
  }  
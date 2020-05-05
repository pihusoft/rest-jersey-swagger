package com.example.hotelmanagement.hotels.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileHandlerService {

	public static FileHandlerService obj = new FileHandlerService();
	public static FileHandlerService getFileHandlerService() {
		if(obj == null) {
			return new FileHandlerService();
		}
		else {
			return obj;
		}
	}
	public void uploadFile(InputStream inputStream, String fileLocation) {
		try {  
				FileOutputStream out = new FileOutputStream(new File(fileLocation));  
				int read = 0;  
				byte[] bytes = new byte[1024];  
				out = new FileOutputStream(new File(fileLocation));  
				while ((read = inputStream.read(bytes)) != -1) {  
					out.write(bytes, 0, read);  
				}  
				out.flush();  
				out.close();  
			} catch (IOException e) {e.printStackTrace();}  
	}
}

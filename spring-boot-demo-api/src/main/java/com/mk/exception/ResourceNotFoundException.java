package com.mk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	
	
	public ResourceNotFoundException (String message,Long id) {
		
		
		super("Given id is not present in DB: "+id);
	}
//	@Override
//	public String getMessage() {
//		
//		String message= "Given id is not present"
//		
//		return super.getMessage();
//	}

}

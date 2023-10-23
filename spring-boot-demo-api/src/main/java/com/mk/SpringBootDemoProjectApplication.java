package com.mk;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoProjectApplication.class, args);
	}
//	
//	@Bean
//	  public ModelMapper modelMapper() {
//	    return new ModelMapper();
//	  }

	
	@Bean
	public ModelMapper modelMaper() {
		
		ModelMapper mapper = new ModelMapper();
		
		return mapper;
	}
	
}

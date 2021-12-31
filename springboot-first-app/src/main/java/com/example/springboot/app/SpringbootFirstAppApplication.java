package com.example.springboot.app;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springboot.app.controller.Controller;
import com.example.springboot.app.model.Contact;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
//@ComponentScan({"com.example.springboot.*"})
public class SpringbootFirstAppApplication {

	public static void main(String[] args) {
		SpringApplication.run( SpringbootFirstAppApplication.class, args );
	}
	
	@Bean
	CommandLineRunner runner( Controller controller ) {
		
		return args -> {
			
			final ObjectMapper mapper = new ObjectMapper();
			final TypeReference<Contact> typeReference = new TypeReference<Contact>() {};
			final InputStream inputStream = TypeReference.class.getResourceAsStream( "/json/contacts.json" );
			
			try {
				final Contact contact = mapper.readValue( inputStream, typeReference );
				
				controller.addContact( contact );			//FIXME: Save a contact from file for H2 DB testing
				System.out.println( "Contact saved" );
			}
			catch( IOException e ) {
				e.printStackTrace();
				System.out.println( "Unable to save contact" );
			}
			
		};
	}

}

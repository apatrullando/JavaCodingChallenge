package com.example.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.app.dao.NameRepository;
import com.example.springboot.app.model.CallContact;
import com.example.springboot.app.model.Contact;

@RestController
@RequestMapping("/assessment")
@Transactional
public class Controller {
	
	@Autowired
	private NameRepository nameRepository;
	
	@GetMapping
	public String welcome() {
		return "Welcome";
	}
	
	//GET - List all contacts
	@GetMapping( value = "/contacts", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Contact> getContacts() {
		final Iterable<Contact> contacts = nameRepository.findAll();
		final List<Contact> nameList = new ArrayList<>();
		contacts.forEach( n -> nameList.add( n ) );
		return nameList;
	}
	
	//GET - Get a specific contact
	@GetMapping( value = "/contacts/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Contact getById( @PathVariable( "id" ) final Long id) {
		final Contact contact = nameRepository.findById( id );
		return contact;
	}
	
	//GET - List all contacts
	@GetMapping( value = "/contacts/call-list", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<CallContact> getCallList() {
		final Iterable<Contact> contacts = nameRepository.findAll();
		final List<Contact> nameList = new ArrayList<>();
		contacts.forEach( n -> nameList.add( n ) );
		return ContactProcessor.getCallContactList( nameList );
	}
	
	//POST - Create new contact
	@RequestMapping( value = "/contacts", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public Contact addContact( @RequestBody final Contact contact ) {
		nameRepository.save( contact );
		return contact;
	}
	
	//DELETE - Delete a contact
	@RequestMapping( value = "/contacts/{id}", method = RequestMethod.DELETE )
	public void deleteContact( @PathVariable( "id" ) final Long id) {
		nameRepository.deleteById( id );
	}
	
	//PUT - Update a contact
	@RequestMapping( value = "/contacts/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE )
	public Contact updateContact( @PathVariable( "id" ) final Long id,
			                      @RequestBody final Contact newContact ) {
		final Contact existingContact = nameRepository.findById( id );
		if( existingContact != null ) {
			ContactUpdater.update( existingContact, newContact );
		}
		return existingContact;
	}
}

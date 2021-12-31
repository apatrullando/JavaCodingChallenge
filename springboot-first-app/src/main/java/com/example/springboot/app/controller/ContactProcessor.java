package com.example.springboot.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.springboot.app.model.CallContact;
import com.example.springboot.app.model.Contact;

public final class ContactProcessor {
	
	final static List<CallContact> getCallContactList( final List<Contact> contacts ){
		
		return contacts.stream().filter( c -> "HOME".equals( c.getPhone().getType().toUpperCase() ) )
				                .map( c -> { final CallContact callContact = new CallContact();
				                             callContact.setPhone( c.getPhone().getNumber() );
				                             callContact.setName( c.getName() );
				                             return callContact; } )
				                .collect( Collectors.toList() );
	}

}

package com.example.springboot.app.controller;

import com.example.springboot.app.model.Contact;

public final class ContactUpdater {
	
	public static void update( final Contact oldContact, final Contact newContact ) {
		
		oldContact.getAddress().setCity(newContact.getAddress().getCity());
		oldContact.getAddress().setState(newContact.getAddress().getState());
		oldContact.getAddress().setStreet(newContact.getAddress().getStreet());
		oldContact.getAddress().setZip(newContact.getAddress().getZip());
		
		oldContact.setEmail(newContact.getEmail());
		
		oldContact.getName().setFirst(newContact.getName().getFirst());
		oldContact.getName().setLast(newContact.getName().getLast());
		oldContact.getName().setMiddle(newContact.getName().getMiddle());
		
		oldContact.getPhone().setNumber(newContact.getPhone().getNumber());
		oldContact.getPhone().setType(newContact.getPhone().getType());
	}
}

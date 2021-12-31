package com.example.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.app.model.Contact;

@Repository
public interface NameRepository extends CrudRepository<Contact,Integer>{
	
	public Contact findById( final Long id );
	
	public void deleteById( final Long id );
	
}

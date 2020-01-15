package com.websystique.springboot.service;

import java.util.List;
import com.websystique.springboot.model.Persons;

public interface PersonService {

	List<Persons> findAllPersons();
	
	Persons findById(Long id);
	
	Persons findByRfc(String rfc);
	
	boolean savePerson(Persons person);
	
	boolean isPersonExist(Persons person);
	
	boolean deletePersonById(Persons person);
}

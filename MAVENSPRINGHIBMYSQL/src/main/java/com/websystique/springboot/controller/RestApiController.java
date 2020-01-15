package com.websystique.springboot.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.websystique.springboot.model.Persons;
import com.websystique.springboot.service.PersonService;
import com.websystique.springboot.util.CustomErrorType;
import com.websystique.springboot.util.CustomSuccessType;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/person/", method = RequestMethod.GET)
	public ResponseEntity<List<Persons>> listAllPerson() {
		List<Persons> persons = personService.findAllPersons();
		if (persons.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Persons>>(persons, HttpStatus.OK);
	}

	@RequestMapping(value = "/person/{id_person}", method = RequestMethod.GET)
	public ResponseEntity<?> getPerson(@PathVariable("id_person") long id_person) {
		logger.info("Start the search, with id -> {}", id_person);
		Persons person = personService.findById(id_person);
		if (person == null) {
			logger.error("Person with id {} not located.", id_person);
			return new ResponseEntity(new CustomErrorType("Person with ID: " + id_person + " not located "),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Persons>(person, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/search/{rfc}", method = RequestMethod.GET)
	public ResponseEntity<?> getPersonRfc(@PathVariable("rfc") String rfc) {
		logger.info("Start the search, with rfc -> {}", rfc);
		Persons person = personService.findByRfc(rfc);
		if (person == null) {
			logger.error("Person with id {} not located.", rfc);
			return new ResponseEntity(new CustomErrorType("Person with RFC: " + rfc + " not located "),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Persons>(person, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/person/", method = RequestMethod.POST)
	public ResponseEntity<?> createPerson(@RequestBody Persons person, UriComponentsBuilder ucBuilder) {
		logger.info("Inicia registro de persona. ", (person.getName_person() + ' ' + person.getApat_person()  + ' ' + person.getAmat_person()));
		logger.info("Inician validaciones de RFC. ");
		if (personService.isPersonExist(person)) {
			logger.error("No es posible la alta actualmente ya existe una persona con el mismo RFC. ", person.getRfc());
			return new ResponseEntity(new CustomErrorType(
					"No es posible registrar, se encontro el RFC: " + person.getRfc() + " ya ligado a una persona."),
					HttpStatus.CONFLICT);
		}
		logger.info("Finalizan las validaciones de RFC. ");
		logger.info("Inicia el guardado de la persona en la BD. ");
		if (personService.savePerson(person)) {
			logger.error("Se realizo el registro correctamente. ", person.getRfc());
			return new ResponseEntity(new CustomSuccessType("Registro exitoso."), HttpStatus.CREATED);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/person/{id}").buildAndExpand(person.getId_person()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	

//	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
//		logger.info("Updating User with id {}", id);
//		User currentUser = userService.findById(id);
//
//		if (currentUser == null) {
//			logger.error("Unable to update. User with id {} not found.", id);
//			return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
//			HttpStatus.NOT_FOUND);
//		}
//
//			currentUser.setName(user.getName());
//			currentUser.setAge(user.getAge());
//			currentUser.setPhone(user.getPhone());
//
//			userService.updateUser(currentUser);
//			return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//		}

		@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
			logger.info("Fetching & Deleting Person with id {}", id);

			Persons person = personService.findById(id);
			if (person == null) {
				logger.error("Unable to delete. User with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("Unable to delete. Person with id " + id + " not found."),
						HttpStatus.NOT_FOUND);
			}
			
			if (personService.deletePersonById(person)) {
				logger.error("Se ha eliminado ha " + person.getName_person() + " , correctamente.");
				return new ResponseEntity(new CustomSuccessType("Eliminación exitosa."), HttpStatus.CREATED);
			}
			return new ResponseEntity<Persons>(HttpStatus.NO_CONTENT);
		}
	
	
}

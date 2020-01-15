package com.websystique.springboot.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.websystique.springboot.model.Persons;
import com.websystique.springboot.repositories.PersonRepository;
import javax.persistence.Query;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private PersonRepository personRepository;

	@Override
	public boolean savePerson(Persons person) {
		try {
			String insert = "INSERT INTO test.app_personas(name_person,apat_person,amat_person, phone, email, genero, RFC) VALUES(:name , :apat , :amat , :tel , :mail , :sexo , :rfc)";
			Query qry = entityManager.createNativeQuery(insert);
			qry.setParameter("name", person.getName_person());
			qry.setParameter("apat", person.getApat_person());
			qry.setParameter("amat", person.getAmat_person());
			qry.setParameter("tel", person.getPhone());
			qry.setParameter("mail", person.getEmail());
			qry.setParameter("sexo", person.getGenero());
			qry.setParameter("rfc", person.getRfc());
			
			qry.executeUpdate();
			return true;
			
		} catch(Exception e) {
			System.out.println("Ocurrio un error al guardar en la BD.");
			e.printStackTrace();
			return false;
		}
		//personRepository.save(person);
	}

	@Override
	public List<Persons> findAllPersons() {
		ArrayList<Persons> list = new ArrayList<Persons>();
		String query = "SELECT id_person,name_person,apat_person,amat_person, phone, email, CASE WHEN genero = 1 THEN \"Masculino\" WHEN genero = 2 THEN \"Femenino\" END As Sexo, \r\n"
				+ " RFC FROM test.app_personas";
		Query qry = entityManager.createNativeQuery(query);
		List<Object[]> wrapper = qry.getResultList();
		if (wrapper.size() > 0) {
			for (Object[] arr : wrapper) {
				Persons persona = new Persons();
				persona.setId_person(((BigInteger) arr[0]).longValue());
				persona.setName_person((String) arr[1]);
				persona.setApat_person((String) arr[2]);
				persona.setAmat_person((String) arr[3]);
				persona.setPhone((String) arr[4]);
				persona.setEmail((String) arr[5]);
				persona.setGenero((String) arr[6]);
				persona.setRfc((String) arr[7]);
				list.add(persona);
			}
		} else {
			list = null;
		}
		return list;
		// return personRepository.findAll();
	}

	@Override
	public Persons findById(Long id) {
		Persons person = new Persons();
		String query = "SELECT id_person, name_person, apat_person,amat_person, phone, email, CASE WHEN genero = 1 THEN \"Masculino\" WHEN genero = 2 THEN \"Femenino\" END As Sexo, \r\n"
				+ " RFC FROM test.app_personas WHERE id_person = :id ";
		Query qry = entityManager.createNativeQuery(query);
		qry.setParameter("id", id);
		List<Object[]> wrapper = qry.getResultList();
		if (wrapper.size() > 0) {
			for (Object[] arr : wrapper) {
				person.setId_person(((BigInteger) arr[0]).longValue());
				person.setName_person((String) arr[1]);
				person.setApat_person((String) arr[2]);
				person.setAmat_person((String) arr[3]);
				person.setPhone((String) arr[4]);
				person.setEmail((String) arr[5]);
				person.setGenero((String) arr[6]);
				person.setRfc((String) arr[7]);
			}
		} else {
			person = null;
		}
		return person;
		// return personRepository.findOne(id);
	}
	
	@Override
	public Persons findByRfc(String rfc) {
		Persons person = new Persons();
		String query = "SELECT id_person, name_person, apat_person,amat_person, phone, email, CASE WHEN genero = 1 THEN \"Masculino\" WHEN genero = 2 THEN \"Femenino\" END As Sexo, \r\n"
				+ " RFC FROM test.app_personas WHERE RFC = :rfc ";
		Query qry = entityManager.createNativeQuery(query);
		qry.setParameter("rfc", rfc);
		List<Object[]> wrapper = qry.getResultList();
		if (wrapper.size() > 0) {
			for (Object[] arr : wrapper) {
				person.setId_person(((BigInteger) arr[0]).longValue());
				person.setName_person((String) arr[1]);
				person.setApat_person((String) arr[2]);
				person.setAmat_person((String) arr[3]);
				person.setPhone((String) arr[4]);
				person.setEmail((String) arr[5]);
				person.setGenero((String) arr[6]);
				person.setRfc((String) arr[7]);
			}
		} else {
			person = null;
		}
		return person;
	}

	@Override
	public boolean isPersonExist(Persons person) {
		boolean existe = false;
		String query = "SELECT COUNT(*) AS EXISTE FROM test.app_personas WHERE RFC = :rfc";
		Query qry = entityManager.createNativeQuery(query);
		qry.setParameter("rfc", person.getRfc());
		qry.setMaxResults(1);
		BigInteger re = (BigInteger) qry.getSingleResult();
		if (re.intValue() > 0) {
			existe = true;
		}
		return existe;
		// return findByName(person.getRfc()) != null;
	}
	
	@Override
	public boolean deletePersonById(Persons person) {
		try {
			String delete = "DELETE FROM test.app_personas WHERE id_person = :id";
			Query qry = entityManager.createNativeQuery(delete);
			qry.setParameter("id", person.getId_person());
			qry.executeUpdate();
			return true;
		} catch(Exception e) {
			System.out.println("Ocurrio un error al intentar eliminar a: " + person.getName_person());
			e.printStackTrace();
			return false;
		}
		//personRepository.save(person);
	}
	
	
}

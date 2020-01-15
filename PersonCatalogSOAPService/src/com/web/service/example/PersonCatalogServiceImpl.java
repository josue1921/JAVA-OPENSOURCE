package com.web.service.example;

import java.util.*;

public class PersonCatalogServiceImpl {

	private static List<Person> personCatalog;
	
	public PersonCatalogServiceImpl() { 
		initializePersonCatalog();
	}
	
	public Person searchbyId(int id) throws Exception {
		for (Person p : personCatalog) if (p.getId() == id) return p;
		throw new Exception("No person found with id " + id);
	}
	
	public Person[] getAllPerson() {
		Person[] persons = new Person[personCatalog.size()];
		int i = 0;
	        
	    for (Person p : personCatalog) {
	    	persons[i] = p;
	        i++;
	    }
	return persons;
	}
	
	public void insertProduct(Person person) {
        personCatalog.add(person);
    }
	
	private void initializePersonCatalog() {
		if (personCatalog == null) {
        	personCatalog = new ArrayList();
        	personCatalog.add(new Person(1,"Barry","Hogan","Harrell","1-749-330-2408","at.libero@eget.com",1,"SACE940922"));
        	personCatalog.add(new Person(2,"Magee","Christian","Sims","1-857-476-0720","Quisque.fringilla@tristiqueac.ca",2,"SACE940922"));
        	personCatalog.add(new Person(3,"Anthony","Shaw","Mcdaniel","923-7387","non.justo@enim.com",1,"SACE940922"));
        	personCatalog.add(new Person(4,"Burke","Slater","Gordon","1-146-380-3942","in.sodales.elit@tinciduntvehicularisus.edu",2,"SACE940922"));
        	personCatalog.add(new Person(5,"Lev","Hudson","Pacheco","1-280-458-7002","sit.amet@habitantmorbi.co.uk",2,"SACE940922"));
        	personCatalog.add(new Person(6,"Stephen","Hammond","Burns","325-8644","est@acmattis.net",1,"SACE940922"));
        	personCatalog.add(new Person(7,"August","Dorsey","Forbes","1-927-420-3248","nisl@aliquetsem.edu",2,"SACE940922"));
        	personCatalog.add(new Person(8,"Herman","Howell","Delgado","1-575-394-9658","eget.nisi.dictum@enimcommodohendrerit.org",2,"SACE940922"));
        	personCatalog.add(new Person(9,"Clinton","Pierce","Ferguson","1-897-169-6388","volutpat.nunc.sit@tortorInteger.co.uk",2,"SACE940922"));
        	personCatalog.add(new Person(10,"Zachery","Mayer","Ingram","1-163-737-5979","magna.Phasellus.dolor@convallisligulaDonec.net",2,"SACE940922"));
        	personCatalog.add(new Person(11,"Deacon","Golden","Estrada","1-776-975-6801","eleifend@magnaCras.com",1,"SACE940922"));
        }
    }
}

package com.websystique.springboot.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="APP_PERSONAS")
public class Persons implements Serializable {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_person;
	
	@NotEmpty
	@Column(name="NAME_PERSON", nullable=false)
	private String name_person;
	
	@Column(name="APAT_PERSON", nullable=false)
    private String apat_person;
    
    @Column(name="AMAT_PERSON", nullable=false)
    private String amat_person;
    
    @Column(name="PHONE", nullable=false)
    private String phone;
    
    @Column(name="EMAIL", nullable=false)
    private String email;
    
    @Column(name="GENERO", nullable=false)
    private String genero;
    
    @Column(name="RFC", nullable=false)
    private String rfc;

	
    /** Getter and setter **/
    
    public Long getId_person() {
		return id_person;
	}

	public void setId_person(Long id_person) {
		this.id_person = id_person;
	}

	public String getName_person() {
		return name_person;
	}

	public void setName_person(String name_person) {
		this.name_person = name_person;
	}

	public String getApat_person() {
		return apat_person;
	}

	public void setApat_person(String apat_person) {
		this.apat_person = apat_person;
	}

	public String getAmat_person() {
		return amat_person;
	}

	public void setAmat_person(String amat_person) {
		this.amat_person = amat_person;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}    
}

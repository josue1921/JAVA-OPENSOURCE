package com.mx.sytcom.app.bean;

public class Persona {
	
	private int id;
	private String name;
	private String apat;
	private String amat;
	private String phone;
	private String mail;
	private String gender;
	private String rfc;
	
	public Persona()
    {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApat() {
		return apat;
	}

	public void setApat(String apat) {
		this.apat = apat;
	}

	public String getAmat() {
		return amat;
	}

	public void setAmat(String amat) {
		this.amat = amat;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
}

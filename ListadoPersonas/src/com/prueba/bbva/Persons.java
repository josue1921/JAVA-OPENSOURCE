package com.prueba.bbva;

public class Persons {
	protected int id;
	protected String nombre;
	protected String apellidoP;
	protected String apellidoM;
	protected String telefono;
	protected String correo;
	protected String genero;
	protected String rfc;
	
	public Persons() {
	}
	
	public Persons(int id) {
		this.id = id;
	}
	
	public Persons(int id, String nombre, String apellidoP, String apellidoM, String telefono, String correo, String genero , String rfc) {
        this(nombre, apellidoP, apellidoM, telefono, correo, genero , rfc);
        this.id = id;
    }
     
    public Persons(String nombre, String apellidoP, String apellidoM, String telefono, String correo, String genero , String rfc) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.telefono = telefono;
        this.correo = correo;
        this.genero = genero;
        this.rfc = rfc;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		genero = genero;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		rfc = rfc;
	}
}

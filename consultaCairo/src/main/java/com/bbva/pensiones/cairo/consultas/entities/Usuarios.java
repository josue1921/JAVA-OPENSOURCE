package com.bbva.pensiones.cairo.consultas.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Usuarios", schema = "dbo", catalog="DBPROSPECT")
public class Usuarios {

	@Id
	@GeneratedValue
	@Column(name = "Num_Promotor", unique = true, nullable = false)
	private String Num_Promotor;

	@Column(name = "ApPaterno")
	private String apPaterno;

	@Column(name = "ApMaterno")
	private String apMaterno;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Password")
	private String password;

	@Column(name = "PasswordAnt")
	private String passwordAnt;

	@Column(name = "FhInicio")
	private Date fhInicio;

	@Column(name = "FhFin")
	private Date fhFin;

	@Column(name = "FhUltimo_Ingreso")
	private Date fhUltimo_Ingreso;

	@Column(name = "Num_Intentos")
	private Integer numIntentos;

	public Usuarios() {

	}

	public String getNum_Promotor() {
		return Num_Promotor;
	}

	public void setNum_Promotor(String num_Promotor) {
		Num_Promotor = num_Promotor;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAnt() {
		return passwordAnt;
	}

	public void setPasswordAnt(String passwordAnt) {
		this.passwordAnt = passwordAnt;
	}

	public Date getFhInicio() {
		return fhInicio;
	}

	public void setFhInicio(Date fhInicio) {
		this.fhInicio = fhInicio;
	}

	public Date getFhFin() {
		return fhFin;
	}

	public void setFhFin(Date fhFin) {
		this.fhFin = fhFin;
	}

	public Date getFhUltimo_Ingreso() {
		return fhUltimo_Ingreso;
	}

	public void setFhUltimo_Ingreso(Date fhUltimo_Ingreso) {
		this.fhUltimo_Ingreso = fhUltimo_Ingreso;
	}

	public Integer getNumIntentos() {
		return numIntentos;
	}

	public void setNumIntentos(Integer numIntentos) {
		this.numIntentos = numIntentos;
	}

	@Transient
	public String getNombreCompletoUser() {
		return (nombre + " " + apPaterno + " " + apMaterno);
	}
}

package com.bbva.pensiones.cairo.consultas.dto;

import java.io.Serializable;
import java.util.Date;

public class PolizasDTO implements Serializable {
	
	private static final long serialVersionUID = 4998247904433456883L;
	
	// Atributess -
	private Integer IDPoliza;
	private String folPoliza;
	private String nombreCompletoAseg;
	private String idOferta;
	private String folOferta;
	private String numResolucion;
	private String staPolizaStr;
	private String curp;
	private String rfc;
	private String numSegSocial;
	private Date fechaNacto;
	private String edad; // Edad calculado por BD
	private String abv_Sexo;	
	private String domicilio;
	private String telefono;
	private String codPostal; // codPostal -> getPostal
	private String asento;	// codPostal -> getNomAsento -> getAsento
	private String nomAsento;	// codPostal -> getNomAsento
	private String municipio; // codPostal -> getMunicipio -> getMunicipio
	private String estado; // codPostal -> getMunicipio -> getEstado -> getEstado
	private String ciudad; // codPostal -> getCiudad -> getCiudad
	private String edo_civil; // Edo_Civil
	private Integer semanasCot; // getSemanasCot()
	private Date fechaIniDer;
	private Date fechaIniVig;
	private Date fechaEmision;
	private Date fechaIniVigInc04;
	private Date fechaABase;
	private Double salarioRT; // getSalarioRT()
	private Double salarioIV;
	private Double montoConstTotal;
	private Double montoConstBasico;
	private Double montoConstInc04;
	private Double cuantiaBaseFC;
	private Double pensionMensualFC;
	private Double pagosVTotal;
	private Double pagosVinc04;
	private String idEjecutivo;
	private String folEjecutivo;
	private String nombreCompletoEjec;
	private String umf;
	private String subdeleg;
	private String deleg;
	private Double pjeAyuda;
	private Double pjeValuacion;
	private Double porcComision;
	private Double montoConstBAU;
	private String tpoRegimen;
	private String modalidadRPRV;
	private String email;
	private Date fechaInicioPago;
	private String ID_InstitucionSS;
	private String mortalidadCV;
	private String incremento11;
	private Date fechaCancelacion;
	private String aguinaldoND;
	private Integer anioReval;
	private Double cuantiaBase;
	private Double cuantiaBaseID;
	private Date fechaSystem;

	// Camp´s aditionals optional´s
	/*	private String lugarNacto;
	 *	
	 */
	
	private String abv_Empresa;
	private String institucionSS;
	private String cve_Ramo;
	private String cve_Pension;
	private String abv_Riesgo;
	private String sta_Poliza;
	private Integer ID_Empresa;
	
	// Getter and Setter --
	public Integer getIDPoliza() {
		return IDPoliza;
	}

	public void setIDPoliza(Integer iDPoliza) {
		IDPoliza = iDPoliza;
	}
	
	public String getFolPoliza() {
		return folPoliza;
	}

	public void setFolPoliza(String folPoliza) {
		this.folPoliza = folPoliza;
	}

	public String getNombreCompletoAseg() {
		return nombreCompletoAseg;
	}

	public void setNombreCompletoAseg(String nombreCompletoAseg) {
		this.nombreCompletoAseg = nombreCompletoAseg;
	}

	public String getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(String idOferta) {
		this.idOferta = idOferta;
	}

	public String getFolOferta() {
		return folOferta;
	}

	public void setFolOferta(String folOferta) {
		this.folOferta = folOferta;
	}

	public String getNumResolucion() {
		return numResolucion;
	}

	public void setNumResolucion(String numResolucion) {
		this.numResolucion = numResolucion;
	}

	public String getStaPolizaStr() {
		return staPolizaStr;
	}

	public void setStaPolizaStr(String staPolizaStr) {
		this.staPolizaStr = staPolizaStr;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Date getFechaNacto() {
		return fechaNacto;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	public String getEdad() {
		return edad;
	}

	public void setFechaNacto(Date fechaNacto) {
		this.fechaNacto = fechaNacto;
	}

	public String getAbv_Sexo() {
		return abv_Sexo;
	}

	public void setAbv_Sexo(String abvSexo) {
		abv_Sexo = abvSexo;
	}

	public String getNumSegSocial() {
		return numSegSocial;
	}

	public void setNumSegSocial(String numSegSocial) {
		this.numSegSocial = numSegSocial;
	}

	public String getEdo_civil() {
		return edo_civil;
	}

	public void setEdo_civil(String edoCivil) {
		edo_civil = edoCivil;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNomAsento() {
		return nomAsento;
	}

	public void setNomAsento(String nomAsento) {
		this.nomAsento = nomAsento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getSemanasCot() {
		return semanasCot;
	}

	public void setSemanasCot(Integer semanasCot) {
		this.semanasCot = semanasCot;
	}

	public Double getSalarioRT() {
		return salarioRT;
	}

	public void setSalarioRT(Double salarioRT) {
		this.salarioRT = salarioRT;
	}

	public Double getSalarioIV() {
		return salarioIV;
	}

	public void setSalarioIV(Double salarioIV) {
		this.salarioIV = salarioIV;
	}

	public Double getPensionMensualFC() {
		return pensionMensualFC;
	}

	public void setPensionMensualFC(Double pensionMensualFC) {
		this.pensionMensualFC = pensionMensualFC;
	}

	public Double getCuantiaBase() {
		return cuantiaBase;
	}

	public void setCuantiaBase(Double cuantiaBase) {
		this.cuantiaBase = cuantiaBase;
	}

	public Double getMontoConstTotal() {
		return montoConstTotal;
	}

	public void setMontoConstTotal(Double montoConstTotal) {
		this.montoConstTotal = montoConstTotal;
	}

	public Double getMontoConstBasico() {
		return montoConstBasico;
	}

	public void setMontoConstBasico(Double montoConstBasico) {
		this.montoConstBasico = montoConstBasico;
	}

	public Double getMontoConstBAU() {
		return montoConstBAU;
	}

	public void setMontoConstBAU(Double montoConstBAU) {
		this.montoConstBAU = montoConstBAU;
	}

	public Double getPagosVTotal() {
		return pagosVTotal;
	}

	public void setPagosVTotal(Double pagosVTotal) {
		this.pagosVTotal = pagosVTotal;
	}

	public Double getPagosVinc04() {
		return pagosVinc04;
	}

	public void setPagosVinc04(Double pagosVinc04) {
		this.pagosVinc04 = pagosVinc04;
	}

	public String getUmf() {
		return umf;
	}

	public void setUmf(String umf) {
		this.umf = umf;
	}

	public String getSubdeleg() {
		return subdeleg;
	}

	public void setSubdeleg(String subdeleg) {
		this.subdeleg = subdeleg;
	}

	public String getDeleg() {
		return deleg;
	}

	public void setDeleg(String deleg) {
		this.deleg = deleg;
	}

	public Double getPjeValuacion() {
		return pjeValuacion;
	}

	public void setPjeValuacion(Double pjeValuacion) {
		this.pjeValuacion = pjeValuacion;
	}

	public Double getPjeAyuda() {
		return pjeAyuda;
	}

	public void setPjeAyuda(Double pjeAyuda) {
		this.pjeAyuda = pjeAyuda;
	}

	public String getFolEjecutivo() {
		return folEjecutivo;
	}

	public void setFolEjecutivo(String folEjecutivo) {
		this.folEjecutivo = folEjecutivo;
	}

	public String getNombreCompletoEjec() {
		return nombreCompletoEjec;
	}

	public void setNombreCompletoEjec(String nombreCompletoEjec) {
		this.nombreCompletoEjec = nombreCompletoEjec;
	}

	public Double getPorcComision() {
		return porcComision;
	}

	public void setPorcComision(Double porcComision) {
		this.porcComision = porcComision;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaIniDer() {
		return fechaIniDer;
	}

	public void setFechaIniDer(Date fechaIniDer) {
		this.fechaIniDer = fechaIniDer;
	}

	public Date getFechaIniVig() {
		return fechaIniVig;
	}

	public void setFechaIniVig(Date fechaIniVig) {
		this.fechaIniVig = fechaIniVig;
	}

	public Date getFechaIniVigInc04() {
		return fechaIniVigInc04;
	}

	public void setFechaIniVigInc04(Date fechaIniVigInc04) {
		this.fechaIniVigInc04 = fechaIniVigInc04;
	}

	public Date getFechaSystem() {
		return fechaSystem;
	}

	public void setFechaSystem(Date fechaSystem) {
		this.fechaSystem = fechaSystem;
	}

	public Date getFechaInicioPago() {
		return fechaInicioPago;
	}

	public void setFechaInicioPago(Date fechaInicioPago) {
		this.fechaInicioPago = fechaInicioPago;
	}
	
	public String getID_InstitucionSS() {
		return ID_InstitucionSS;
	}

	public void setiD_InstitucionSS(String ID_InstitucionSS) {
		this.ID_InstitucionSS = ID_InstitucionSS;
	}
	
	public String getModalidadRPRV() {
		return modalidadRPRV;
	}
	
	public void setModalidadRPRV(String modalidadRPRV) {
		this.modalidadRPRV = modalidadRPRV;
	}

	public String getAbv_Empresa() {
		return abv_Empresa;
	}

	public void setAbv_Empresa(String abvEmpresa) {
		abv_Empresa = abvEmpresa;
	}

	public String getInstitucionSS() {
		return institucionSS;
	}

	public void setInstitucionSS(String institucionSS) {
		this.institucionSS = institucionSS;
	}

	public String getCve_Ramo() {
		return cve_Ramo;
	}

	public void setCve_Ramo(String cveRamo) {
		cve_Ramo = cveRamo;
	}

	public String getCve_Pension() {
		return cve_Pension;
	}

	public void setCve_Pension(String cvePension) {
		cve_Pension = cvePension;
	}

	public String getAbv_Riesgo() {
		return abv_Riesgo;
	}

	public void setAbv_Riesgo(String abvRiesgo) {
		abv_Riesgo = abvRiesgo;
	}

	public String getSta_Poliza() {
		return sta_Poliza;
	}

	public void setSta_Poliza(String staPoliza) {
		sta_Poliza = staPoliza;
	}

	public String getMortalidadCV() {
		return mortalidadCV;
	}

	public void setMortalidadCV(String mortalidadCV) {
		this.mortalidadCV = mortalidadCV;
	}

	public String getIncremento11() {
		return incremento11;
	}

	public void setIncremento11(String incremento11) {
		this.incremento11 = incremento11;
	}
	
	public String getTpoRegimen() {
		return tpoRegimen;
	}

	public void setTpoRegimen(String tpoRegimen) {
		this.tpoRegimen = tpoRegimen;
	}

	public String getAsento() {
		return asento;
	}

	public void setAsento(String asento) {
		this.asento = asento;
	}

	public Integer getAnioReval() {
		return anioReval;
	}

	public void setAnioReval(Integer anioReval) {
		this.anioReval = anioReval;
	}

	public Date getFechaABase() {
		return fechaABase;
	}

	public void setFechaABase(Date fechaABase) {
		this.fechaABase = fechaABase;
	}

	public Integer getID_Empresa() {
		return ID_Empresa;
	}

	public void setID_Empresa(Integer iDEmpresa) {
		ID_Empresa = iDEmpresa;
	}


}

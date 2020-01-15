package com.mx.sytcom.app.response;

import com.mx.sytcom.app.bean.Persona;
import com.mx.sytcom.app.bean.ErrorType;

public class PersonaResponse {

	private Persona persona;
    private ErrorType resultInfo;
    
    public PersonaResponse()
    {
    }

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public ErrorType getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(ErrorType resultInfo) {
		this.resultInfo = resultInfo;
	}
}

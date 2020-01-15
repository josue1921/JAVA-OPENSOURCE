package com.mx.sytcom.app;

import com.mx.sytcom.app.request.PersonaRequest;
import com.mx.sytcom.app.response.PersonaResponse;

public interface wsAppSytcom {

	public abstract PersonaResponse consultaPersona(PersonaRequest personrequest);
	
}

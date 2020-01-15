package com.mx.sytcom.app;

import java.util.*;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import org.apache.log4j.Logger;
import com.mx.sytcom.app.bean.ErrorType;
import com.mx.sytcom.app.bo.PersonaBO;
import com.mx.sytcom.app.request.PersonaRequest;
import com.mx.sytcom.app.response.PersonaResponse;
import com.mx.sytcom.app.util.Utils;

public class wsAppSytcomImpl implements wsAppSytcom {

	public wsAppSytcomImpl() {
	}

	public PersonaResponse consultaPersona(PersonaRequest request) {
		MessageContext mc = wsc.getMessageContext();
		Properties prop = new Properties();
		boolean valida = false;
		try {
			java.io.InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(input);
			valida = prop.getProperty("valida").equalsIgnoreCase("S");
		} catch (Exception e) {
			e.printStackTrace();
			PersonaResponse response = new PersonaResponse();
			ErrorType resultInfo = new ErrorType();
			resultInfo.setErrorCode("2");
			resultInfo.setErrorDesc("No se pudo leer la configuraci\363n del servicio.");
			response.setResultInfo(resultInfo);
			return response;
		}
		log.info((new StringBuilder("consultaEmpleado Valida Seguridad:")).append(valida).toString());
		List userList = null;
		List passList = null;
		String user = "";
		String pass = "";
		if (valida) {
			Map requestHeader = (Map) mc.get("javax.xml.ws.http.request.headers");
			userList = (List) requestHeader.get("username");
			passList = (List) requestHeader.get("password");
		} else {
			userList = new ArrayList();
			passList = new ArrayList();
			user = prop.getProperty("usere");
			pass = prop.getProperty("passe");
		}
		if (passList != null && userList != null) {
			Utils util = new Utils();
			if (valida) {
				user = (String) userList.get(0);
				pass = (String) passList.get(0);
			}
			log.info((new StringBuilder("Encode:")).append(user).append("/").append(pass).toString());
			user = util.decode(user);
			pass = util.decode(pass);
			log.info((new StringBuilder("Decode:")).append(user).append("/").append(pass).toString());
			if (user.equals(prop.getProperty("user")) && pass.equals(prop.getProperty("pass"))) {
				log.info("Usuario y Contrasena validos");
				PersonaBO personabo = new PersonaBO();
				return personabo.consultarPersona(request.getRfc());
			} else {
				log.info("Usuario y Contrasena invalidos");
				PersonaResponse response = new PersonaResponse();
				ErrorType resultInfo = new ErrorType();
				resultInfo.setErrorCode("2");
				resultInfo.setErrorDesc("No tiene permisos para consultar el metodo.");
				response.setResultInfo(resultInfo);
				return response;
			}
		} else {
			PersonaResponse response = new PersonaResponse();
			ErrorType resultInfo = new ErrorType();
			resultInfo.setErrorCode("2");
			resultInfo.setErrorDesc("No tiene permisos para consultar el metodo.");
			log.info("No presenta headers");
			response.setResultInfo(resultInfo);
			return response;
		}
	}

	static final Logger log = Logger.getLogger("com/mx/sytcom/app/wsAppSytcomImpl");
	private WebServiceContext wsc;
}

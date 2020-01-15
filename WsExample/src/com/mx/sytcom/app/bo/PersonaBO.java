package com.mx.sytcom.app.bo;

import com.mx.sytcom.app.bean.Persona;
import com.mx.sytcom.app.dao.impl.ServicioPersonaImp;
import com.mx.sytcom.app.response.PersonaResponse;
import com.mx.sytcom.app.bean.ErrorType;

public class PersonaBO {

	public PersonaBO()
    {
    }
	
	public PersonaResponse consultarPersona(String rfc)
    {
        ServicioPersonaImp dao;
        PersonaResponse response;
        ErrorType resultInfo;
        dao = new ServicioPersonaImp();
        response = new PersonaResponse();
        resultInfo = new ErrorType();
        resultInfo = validaParametros(rfc);
        if(resultInfo.getErrorCode() != null && !resultInfo.getErrorCode().equals("0"))
        {
            response.setResultInfo(resultInfo);
            return response;
        }
        try
        {
            Persona persona = dao.consultarPersona(rfc);
            if(persona != null)
            {
                response.setPersona(persona);
                resultInfo.setErrorCode("0");
                resultInfo.setErrorCode("Operacion Exitosa");
                response.setResultInfo(resultInfo);
            } else
            {
                resultInfo.setErrorCode("1");
                resultInfo.setErrorDesc("Error al ejecutar la consulta.");
                response.setResultInfo(resultInfo);
            }
        }
        catch(Exception e)
        {
            resultInfo.setErrorCode("1");
            resultInfo.setErrorCode("Error al consultar empleado");
            response.setResultInfo(resultInfo);
        }
        return response;
    }
	
	public ErrorType validaParametros(String rfc)
    {
        ErrorType resultInfo = new ErrorType();
        if(rfc == null || rfc.equals("?") || rfc.equals(""))
        {
            resultInfo.setErrorCode("1");
            resultInfo.setErrorDesc("Debe ingresar el rfc.");
        }
        return resultInfo;
    }
}

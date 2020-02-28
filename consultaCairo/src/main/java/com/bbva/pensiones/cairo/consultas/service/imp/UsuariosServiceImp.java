package com.bbva.pensiones.cairo.consultas.service.imp;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.pensiones.cairo.consultas.dao.UsuariosDAO;
import com.bbva.pensiones.cairo.consultas.entities.Usuarios;
import com.bbva.pensiones.cairo.consultas.service.UsuariosService;

@WebService
@Component
public class UsuariosServiceImp implements UsuariosService{
	
	@Autowired
	private UsuariosDAO usuariosDAO;

	@WebMethod(operationName = "getUsuarios")
	public List<Usuarios> getUsuarios() {
		return usuariosDAO.getUsuarios();	
	}
	
}

package com.bbva.pensiones.cairo.consultas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbva.pensiones.cairo.consultas.entities.Usuarios;
import com.bbva.pensiones.cairo.consultas.service.UsuariosService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping({"/cairoWeb"})
public class ConsultaUsuariosController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@RequestMapping(value = "/users")
	public ResponseEntity<List<Usuarios>> getUsuarios(){
		List<Usuarios> listUsers = null;
		try {
			listUsers = usuariosService.getUsuarios();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().body(listUsers);
	}
}

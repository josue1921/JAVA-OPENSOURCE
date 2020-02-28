package com.bbva.pensiones.cairo.consultas.service.imp;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.pensiones.cairo.consultas.dao.ConsultaPolizasDAO;
import com.bbva.pensiones.cairo.consultas.dao.UsuariosDAO;
import com.bbva.pensiones.cairo.consultas.dto.DatosPolizaDTO;
import com.bbva.pensiones.cairo.consultas.dto.PolizasDTO;
import com.bbva.pensiones.cairo.consultas.service.ConsultaPolizasService;
import com.bbva.pensiones.cairo.consultas.service.UsuariosService;

@WebService
@Component
public class ConsultaPolizasServiceImp implements ConsultaPolizasService{

	@Autowired
	private ConsultaPolizasDAO consultaPolizasDAO;
	
	@WebMethod(operationName = "consultaPoliza")
	public List<PolizasDTO> consultaPoliza(DatosPolizaDTO datosBusquedaPoliza){
		return this.consultaPolizasDAO.consultaPolizas(datosBusquedaPoliza);
	}
}

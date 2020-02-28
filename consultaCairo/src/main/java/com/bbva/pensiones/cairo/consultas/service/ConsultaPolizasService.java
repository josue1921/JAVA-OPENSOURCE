package com.bbva.pensiones.cairo.consultas.service;

import java.util.List;

import com.bbva.pensiones.cairo.consultas.dto.DatosPolizaDTO;
import com.bbva.pensiones.cairo.consultas.dto.PolizasDTO;

public interface ConsultaPolizasService {
	
	public List<PolizasDTO> consultaPoliza(DatosPolizaDTO datosBusquedaPoliza);

}

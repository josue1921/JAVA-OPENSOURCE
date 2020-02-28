package com.bbva.pensiones.cairo.consultas.dao;

import java.util.List;

import com.bbva.pensiones.cairo.consultas.dto.DatosPolizaDTO;
import com.bbva.pensiones.cairo.consultas.dto.PolizasDTO;

public interface ConsultaPolizasDAO {
	
	public List<PolizasDTO> consultaPolizas(DatosPolizaDTO datosBusquedaPoliza);
	
}

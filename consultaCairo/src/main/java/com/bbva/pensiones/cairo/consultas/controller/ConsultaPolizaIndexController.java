package com.bbva.pensiones.cairo.consultas.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbva.pensiones.cairo.CairoUtils;
import com.bbva.pensiones.cairo.consultas.dto.DatosPolizaDTO;
import com.bbva.pensiones.cairo.consultas.dto.PolizasDTO;
import com.bbva.pensiones.cairo.consultas.service.ConsultaPolizasService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping({ "/cairoWeb" })
public class ConsultaPolizaIndexController {

	private List<PolizasDTO> polizas;

	@Autowired
	private ConsultaPolizasService consultaPolizasService;

	//@RequestMapping(value = "/polizas/{polizaBus},{nombreBus},{nssBus},{ofertaBus},{resolucionBus},{filter}")
	//public ResponseEntity<List<PolizasDTO>> consultaPolizas(@PathVariable("polizaBus")String idPol, @PathVariable("nombreBus")String nameBus,  @PathVariable("nssBus")String nssBus,  @PathVariable("ofertaBus")String ofert,  @PathVariable("resolucionBus")String resolucion, @PathVariable("filter")String filtro)
	@RequestMapping(value = "/polizas/{polizaBus}")
	public ResponseEntity<List<PolizasDTO>> consultaPolizas(@PathVariable("polizaBus")String idPol)

	{
		LinkedHashMap<Object, Object> serviceResponse = new LinkedHashMap<Object, Object>();
		List<PolizasDTO> listPolizas = null;
		
    	try{
    		DatosPolizaDTO datosConsulta = new DatosPolizaDTO();
			datosConsulta.setPoliza(idPol);
			datosConsulta.setNombre("");
			datosConsulta.setNss("");
			datosConsulta.setOferta("");
			datosConsulta.setResolucion("");
			datosConsulta.setFiltro("");
			if(CairoUtils.isNullOrEmpty(datosConsulta.getPoliza())&&
				CairoUtils.isNullOrEmpty(datosConsulta.getNombre())&&
				CairoUtils.isNullOrEmpty(datosConsulta.getNss())&&
				CairoUtils.isNullOrEmpty(datosConsulta.getOferta())&&
				CairoUtils.isNullOrEmpty(datosConsulta.getResolucion())){
					
			}else{
				
	    		polizas = consultaPolizasService.consultaPoliza(datosConsulta);
	    		if(polizas.size()>0){
	    			listPolizas = polizas;
	    		}else{
	    			listPolizas = null;
	    		}

    		}
			
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}	
    	
    	return ResponseEntity.ok().body(listPolizas);
	}
}

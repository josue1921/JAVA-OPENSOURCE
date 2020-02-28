package com.bbva.pensiones.cairo.consultas.dao.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbva.pensiones.cairo.consultas.dao.ConsultaPolizasDAO;
import com.bbva.pensiones.cairo.consultas.dto.DatosPolizaDTO;
import com.bbva.pensiones.cairo.consultas.dto.PolizasDTO;


@Service("consultaPolizasDAO")
@Transactional
public class ConsultaPolizasDAOImp implements ConsultaPolizasDAO{
	
	@Autowired
	private SessionFactory sessionFactory ;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<PolizasDTO> consultaPolizas(DatosPolizaDTO datosBusquedaPoliza){
		
		
		List<PolizasDTO> listPolizas = new ArrayList<PolizasDTO>();
		PolizasDTO polizaDTO;
		
		
		try {
			Session session = sessionFactory.getCurrentSession();
			//List<String> idEmpresas = (List<String>) session.getAttribute("idEmpresas");
			List<String> idEmpresas;
			
			String sql = " USE DBCAIRO; ";
			sql += "SELECT Polizas.Fol_Poliza, Polizas.Nom_Aseg+' '+Polizas.ApP_Aseg+' '+Polizas.ApM_Aseg Asegurado,Emp_Ofertas.Fol_Oferta,Resolucion=isnull((select Num_Resolucion from Resoluciones where ID_Oferta = Polizas.ID_Oferta),Polizas.Num_Resolucion), " +
				" cast(Polizas.ID_StaPoliza as char(2))+' - '+Cat_StaPolizas.Sta_Poliza StaPoliza, Polizas.CURP, datediff(yy,Polizas.Fecha_Nacto,getdate()) Edad, Cat_Sexos.Abv_Sexo, Polizas.Num_SegSocial, " +
				" cast(isnull(Polizas.ID_EdoCivil,0) as char(2))+' - '+cast(Cat_EdoCivil.Edo_Civil as char(14)) EdoCivil,Polizas.RFC,Polizas.Domicilio, Cat_CodPostales.Nom_Asento,Cat_Estados.Estado, " +
				" Cat_Municipios.Municipio,Cat_CodPostales.Cod_Postal,Resoluciones.Email,Telefono=dbo.EliminaCerosIzquierda(REPLACE(Polizas.Telefono, '-', '')), Polizas.Semanas_Cot,Polizas.Salario_RT, " +
				" Polizas.Salario_IV,isnull(Polizas.Pension_MensualFC,0) Pension_MensualFC, Polizas.Cuantia_Base,Polizas.Monto_ConstTotal,Polizas.Monto_ConstBasico,Polizas.Monto_ConstBAU, " +
				" Polizas.Pagos_VTotal,Polizas.Pagos_VInc04,Polizas.UMF, Polizas.Subdeleg, Polizas.Deleg, Polizas.Pje_Valuacion,Polizas.Pje_Ayuda,Ejecutivos.Fol_Ejecutivo, " +
				" Ejecutivos.ApP_Ejec+' '+Ejecutivos.ApM_Ejec+' '+Ejecutivos.Nom_Ejec Nom_Ejec, Ofertas.Porc_Comision,Polizas.Fecha_Nacto,Polizas.Fecha_Emision,Polizas.Fecha_IniDer,Polizas.Fecha_IniVig, " +
				" Polizas.Fecha_IniVigInc04, Polizas.Fecha_System,Ofertas.Fecha_InicioPago,Cat_Asentos.Asento, Polizas.Tpo_Regimen, " +
				" Polizas.ID_Oferta, Ofertas.Modalidad_RP_RV, Polizas.ID_InstitucionSS, MortalidadCV =ISNULL(Ofertas.MortalidadCV,0), Ofertas.Incremento_11, " +
				" Empresas.Abv_Empresa,Cat_InstitucionSS.InstitucionSS,Cat_Ramos.Cve_Ramo,Cat_Pensiones.Cve_Pension,Cat_Riesgos.Abv_Riesgo,Cat_StaPolizas.Sta_Poliza, Polizas.AnioReval, Polizas.Fecha_ABase, Polizas.ID_Poliza, Polizas.ID_Empresa, Cat_Ciudades.Ciudad, " +
				// Campos adicionales..
				" cast(Polizas.ID_Sexo as char(2))+' - '+Cat_Sexos.Sexo Sexo,Polizas.ID_CP,Cat_CodPostales.ID_Asento, " +
				" cast(Polizas.ID_Ramo as char(2))+' - '+cast(Cat_Ramos.Ramo as char(20)) Ramo, " + 
				" cast(Polizas.ID_Pension as char(2))+' - '+cast(Cat_Pensiones.Pension as char(20)) Pension, " + 
				" Polizas.Monto_ConstInc04,Polizas.Cuantia_BaseFC,Polizas.ID_Ejecutivo,Comision = round(Polizas.Monto_ConstTotal * Ofertas.Porc_Comision / 100.00, 2), " + 
				" Polizas.Fecha_Cancelacion, Polizas.Aguinaldo_ND, Polizas.ApM_Aseg, Polizas.ApP_Aseg,Polizas.Cuantia_BaseID  " +
				" FROM Polizas, Emp_Ofertas,Cat_StaPolizas, Cat_Sexos,Cat_CodPostales,Cat_Municipios,Cat_Estados, Cat_Ramos , Cat_Pensiones, Ejecutivos, " + 
				" Cat_Ciudades,Cat_Asentos, Cat_EdoCivil, Ofertas ,Resoluciones, Empresas, Cat_InstitucionSS, Cat_Riesgos " +  
				" WHERE Emp_Ofertas.ID_Oferta = Polizas.ID_Oferta and Ofertas.ID_Oferta = Polizas.ID_Oferta and Emp_Ofertas.ID_Empresa = Polizas.ID_Empresa and Cat_StaPolizas.ID_StaPoliza = Polizas.ID_StaPoliza " +
				" and Cat_Sexos.ID_Sexo = Polizas.ID_Sexo and Cat_CodPostales.ID_CP = Polizas.ID_CP and Cat_Asentos.ID_Asento = Cat_CodPostales.ID_Asento " +
				" and Cat_Municipios.ID_Municipio = Cat_CodPostales.ID_Municipio and Cat_Ciudades.ID_Ciudad = Cat_CodPostales.ID_Ciudad and Cat_Estados.ID_Estado = Cat_Municipios.ID_Estado " +
				" and Cat_Ramos.ID_Ramo = Polizas.ID_Ramo and Cat_Pensiones.ID_Pension = Polizas.ID_Pension and Ejecutivos.ID_Ejecutivo = Polizas.ID_Ejecutivo " +
				" and Polizas.ID_Empresa = Empresas.ID_Empresa And Polizas.ID_InstitucionSS = Cat_InstitucionSS.ID_InstitucionSS And Polizas.ID_Riesgo = Cat_Riesgos.ID_Riesgo" +
				" and Cat_EdoCivil.ID_EdoCivil =* Polizas.ID_EdoCivil and Resoluciones.Num_SegSocial=*Polizas.Num_SegSocial and Resoluciones.ID_Oferta=*Polizas.ID_Oferta and ";
			
			sql += 	" Polizas.ID_Empresa in (1,2) ";
			/*for (int i = 0; i < idEmpresas.size(); i++) {
				if(i==0){
					sql+=idEmpresas.get(i);
				}else{
					sql+=","+idEmpresas.get(i);
				}
			}
			sql+= ") ";*/
		
			if(!datosBusquedaPoliza.getPoliza().equals("")){
				sql+= " And Polizas.Fol_Poliza = :FolPoliza";
			}
			if(!datosBusquedaPoliza.getNss().equals("")){
				sql+= " And Polizas.Num_SegSocial = :NSS";
			}
			if(!datosBusquedaPoliza.getNombre().equals("")){
				if(datosBusquedaPoliza.getFiltro().equals("A"))
					sql+= " And (Polizas.Nom_Aseg +' '+ Polizas.ApP_Aseg+' '+Polizas.ApM_Aseg) like :Nombre";
				else if(datosBusquedaPoliza.getFiltro().equals("T"))
					sql+= " And Polizas.ID_Poliza in (select ID_Poliza from DBCAIRO.dbo.Titulares where Nom_Titular+' '+ApP_Titular+' '+ApM_Titular like :Nombre) ";
				else if(datosBusquedaPoliza.getFiltro().equals("B"))
					sql+= " And Polizas.ID_Poliza in (select ID_Poliza from DBCAIRO.dbo.Pol_Benefs where Nom_Benef+' '+ApP_Benef+' '+ApM_Benef like :Nombre) ";
			}
			if(!datosBusquedaPoliza.getOferta().equals("")){
				sql+= " And Polizas.ID_Oferta in (select ID_Oferta from DBCAIRO.dbo.Emp_Ofertas where Fol_Oferta = :Oferta )";
			}
			if(!datosBusquedaPoliza.getResolucion().equals("")){
				sql+= " And Polizas.Num_Resolucion = :NumResolucion";
			}
			
			// Query query = entityManager.createNativeQuery(sql, Polizas.class);
			Query query = session.createNativeQuery(sql);
			
			if(datosBusquedaPoliza!=null && !datosBusquedaPoliza.getPoliza().equals("")) query.setParameter("FolPoliza", datosBusquedaPoliza.getPoliza());
			if(!datosBusquedaPoliza.getNss().equals(""))query.setParameter("NSS", datosBusquedaPoliza.getNss());
			if(!datosBusquedaPoliza.getNombre().equals(""))query.setParameter("Nombre", "%"+datosBusquedaPoliza.getNombre().toUpperCase()+"%");
			if(!datosBusquedaPoliza.getOferta().equals(""))query.setParameter("Oferta", datosBusquedaPoliza.getOferta());
			if(!datosBusquedaPoliza.getResolucion().equals(""))query.setParameter("NumResolucion", datosBusquedaPoliza.getResolucion());
		
			
			List<Object[]> wrapper = query.getResultList();
			for (Object[] arr : wrapper) {
				polizaDTO = new PolizasDTO();
				polizaDTO.setFolPoliza((String) (arr[0]).toString());
				polizaDTO.setNombreCompletoAseg((String) arr[1]);
				polizaDTO.setFolOferta((String) (arr[2]).toString());
				polizaDTO.setNumResolucion((String) arr[3]);
				polizaDTO.setStaPolizaStr((String) arr[4]);
				polizaDTO.setCurp((String) arr[5]);
				polizaDTO.setEdad((String) (arr[6]).toString());
				polizaDTO.setAbv_Sexo((String) arr[7]);
				polizaDTO.setNumSegSocial((String) arr[8]);
				polizaDTO.setEdo_civil((String) arr[9]);
				polizaDTO.setRfc((String) arr[10]);
				polizaDTO.setDomicilio((String) arr[11]);
				polizaDTO.setNomAsento((String) arr[12]);
				polizaDTO.setEstado((String) arr[13]);
				polizaDTO.setMunicipio((String) arr[14]);
				polizaDTO.setCodPostal((String) arr[15]);
				polizaDTO.setEmail((String) arr[16]);
				polizaDTO.setTelefono((String) arr[17]);				
				polizaDTO.setSemanasCot((Integer) arr[18]);
				polizaDTO.setSalarioRT(((BigDecimal)(arr[19]) != null) ? ((BigDecimal) (arr[19])).doubleValue() : null);
				polizaDTO.setSalarioIV(((BigDecimal)(arr[20]) != null) ? ((BigDecimal) (arr[20])).doubleValue() : null);
				polizaDTO.setPensionMensualFC(((BigDecimal)(arr[21]) != null) ? ((BigDecimal) (arr[21])).doubleValue() : null);
				polizaDTO.setCuantiaBase(((BigDecimal)(arr[22]) != null) ? ((BigDecimal) (arr[22])).doubleValue() : null);
				polizaDTO.setMontoConstTotal(((BigDecimal)(arr[23]) != null) ? ((BigDecimal) (arr[23])).doubleValue() : null);
				polizaDTO.setMontoConstBasico(((BigDecimal)(arr[24]) != null) ? ((BigDecimal) (arr[24])).doubleValue() : null);
				polizaDTO.setMontoConstBAU( ((BigDecimal)(arr[25]) != null) ? ((BigDecimal) (arr[25])).doubleValue() : null);
				polizaDTO.setPagosVTotal(((BigDecimal)(arr[26]) != null) ? ((BigDecimal) (arr[26])).doubleValue() : null);
				polizaDTO.setPagosVinc04(((BigDecimal)(arr[27]) != null) ? ((BigDecimal) (arr[27])).doubleValue() : null);
				polizaDTO.setUmf((String) arr[28]);
				polizaDTO.setSubdeleg((String) arr[29]);
				polizaDTO.setDeleg((String) arr[30]);
				polizaDTO.setPjeValuacion(((BigDecimal)(arr[31]) != null) ? ((BigDecimal) (arr[31])).doubleValue() : null);
				polizaDTO.setPjeAyuda(((BigDecimal)(arr[32]) != null) ? ((BigDecimal) (arr[32])).doubleValue() : null);
				polizaDTO.setFolEjecutivo((String) arr[33]);
				polizaDTO.setNombreCompletoEjec((String) arr[34]);
				polizaDTO.setPorcComision(((BigDecimal)(arr[35]) != null) ? ((BigDecimal) (arr[35])).doubleValue() : null);
				//polizaDTO.setMontoConstTotal(((BigDecimal) (arr[i++])).doubleValue());
				polizaDTO.setFechaNacto(((Date) arr[36]) != null ? (Date) arr[36] : null );
				polizaDTO.setFechaEmision(((Date) arr[37]) != null ? (Date) arr[37] : null );
				polizaDTO.setFechaIniDer(((Date) arr[38]) != null ? (Date) arr[38] : null );
				polizaDTO.setFechaIniVig(((Date) arr[39]) != null ? (Date) arr[39] : null );
				polizaDTO.setFechaIniVigInc04(((Date) arr[40]) != null ? (Date) arr[40] : null );
				polizaDTO.setFechaSystem(((Date) arr[41]) != null ? (Date) arr[41] : null );
				polizaDTO.setFechaInicioPago(((Date) arr[42]) != null ? (Date) arr[42] : null );
				polizaDTO.setAsento((String) arr[43]);
				polizaDTO.setTpoRegimen(String.valueOf((Character) arr[44]));
				polizaDTO.setIdOferta(((Integer) arr[45]) != null ? String.valueOf((Integer) arr[45]) : null);
				polizaDTO.setModalidadRPRV((String) arr[46]);
				polizaDTO.setiD_InstitucionSS(((Byte) arr[47]) != null ? String.valueOf((Byte) arr[47]): null);
				polizaDTO.setMortalidadCV((String) arr[48]);
				polizaDTO.setIncremento11((Character) arr[49] != null ? String.valueOf((Character) arr[49]) : null);
				// Adicionales..
				polizaDTO.setAbv_Empresa((String) arr[50]);
				polizaDTO.setInstitucionSS((String) arr[51]);
				polizaDTO.setCve_Ramo((String) arr[52]);
				polizaDTO.setCve_Pension((String) arr[53]);
				polizaDTO.setAbv_Riesgo((String) arr[54]);
				polizaDTO.setSta_Poliza((String) arr[55]);
				polizaDTO.setAnioReval((Integer) arr[56]);
				polizaDTO.setFechaABase(((Date) arr[57]) != null ? (Date) arr[57] : null );
				polizaDTO.setIDPoliza((Integer) arr[58]);
				polizaDTO.setID_Empresa(new Integer((Short) arr[59]));
				polizaDTO.setCiudad((String) arr[60]);
				listPolizas.add(polizaDTO);
			}
			return listPolizas;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

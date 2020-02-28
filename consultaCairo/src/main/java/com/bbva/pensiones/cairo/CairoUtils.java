package com.bbva.pensiones.cairo;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public class CairoUtils {


	public static Boolean isNullOrEmpty(String str){
		return (str == null || StringUtils.isEmpty(str))?true:false;
	}
	
	public static String valStr(Double var){
		return (var==null)?"":var.toString();
	}
	
	public static String valStr(Integer var){
		return (var==null)?"":var.toString();
	}
	
	protected String valStr(Long var){
		return (var==null)?"":var.toString();
	}
	
	public static String formatFecha(Date fecha){
		if(fecha==null) return "";
		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
		return SDF.format(fecha);
	}
	
	public static String formatFecha(Date fecha, String format){
		if(fecha==null) return "";
		SimpleDateFormat SDF = new SimpleDateFormat(format);
		return SDF.format(fecha);
	}
	
	public static Date convertirFecha(String str) throws ParseException{
		if(str==null) return null;
		SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
		return SDF.parse(str);
	}
	
	public static String formatFechaList(String str) throws ParseException{
		if(str==null) return "";
		if(str.equals(""))return str;
		SimpleDateFormat SDF1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat SDF2 = new SimpleDateFormat("dd/MM/yyyy");
		return SDF2.format(SDF1.parse(str.substring(0,10)));
	}
	
	public static Date convertirFecha(String str, String format) throws ParseException{
		if(str==null) return null;
		SimpleDateFormat SDF = new SimpleDateFormat(format);
		return SDF.parse(str);
	}
	
	public static String formatDecimal (Double number){
		if(number == null) return "";
		DecimalFormat df = new DecimalFormat("###,###.##");
		return df.format(number);
	}
	
	public static String formatDecimal (Double number, String format){
		if(number == null) return "";
		try{
			DecimalFormat df = new DecimalFormat(format);
			return df.format(number);
		}catch (Exception e){
			return "FORMATO PARA NÚMEROS INVALIDO";
		}
	}
	
	public static String fDinero (Double number){
		if(number == null) return "$0.00";
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		return "$"+df.format(number);
	}
	
	public static String fDinero (Integer number){
		if(number == null) return "";
		DecimalFormat df = new DecimalFormat("###,###,##0.00");
		return "$"+df.format(number);
	}
	
	public static String porcent(Double number){
		if(number ==null) return "";
		if(number.equals(0.0d)) return "0%";
		DecimalFormat df = new DecimalFormat("#0.####'%'");
		return df.format(number);
	}
	
	public static String subStr(String cadena, String tam){
		return cadena.substring(0,Integer.valueOf(tam));
	}
	
	public static String fechaLocalized(Date fecha){
		if(fecha==null) return "";
		SimpleDateFormat SDF = new SimpleDateFormat("dd MMMM yyyy");
		return SDF.format(fecha);
	}
	
	public static Date modificarMes(Date date, int amount) throws ParseException{
		if(date == null) return convertirFecha("01/10/2001");
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.MONTH, amount);
	    return calendar.getTime();
	}
	
	public static Date primerDMes(Date date){
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.DAY_OF_MONTH, 1);

	    return calendar.getTime();
	}
	
	public static Date ultimoDMes(Date date){
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.DAY_OF_MONTH, calendar.getMaximum(Calendar.DAY_OF_MONTH));

	    return calendar.getTime();
	}
		
	public static String[] getVentana(String key){
		try{
			Map<String,String[]> m = new HashMap<String, String[]>();
			m.put("loggin", new String[]{"/zul/login.zul",""});
			m.put("administradorBtn", new String[]{"/zul/administrador.zul","administradorWin"}); 
			m.put("cambioEmpresaTbBtn", new String[]{"/zul/consultaPoliza/windows/cambio_Empresa.zul","cambioEmpresaWin"});
			
			//Consulta Poliza
			m.put("consultaPBtn", new String[]{"/zul/consultaPoliza/consultaCairo.zul","consultaCairoWin"}); 
			m.put("titularesTbBtn",new String[]{"/zul/consultaPoliza/windows/mostrar_Titulares.zul","mostrarTitularesWin"});
			m.put("beneficiariosTbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_Beneficiarios.zul","mostrarBenefsWin"});
			m.put("recibosTbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_Recibos.zul","mostrarRecibosWin"});
			m.put("prestamosTbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_Prestamos.zul","mostrarPrestamosWin"}); 
			m.put("prestamosBBVATbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_PrestamosBBVA.zul","mostrarPrestamosBbvaWin"}); 
			m.put("prestamosPBTbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_PrestamosPenBBVA.zul","mostrarPrestamosPenBbvaWin"}); 
			m.put("pagosTbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_Pagos.zul","mostrarPagosWin"}); 
			m.put("prestamosISSSTETbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_PresISSSTE.zul","mostrarPresISSSTEWin"}); 
			m.put("beneficiosAdTbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_BeneficiosAdic.zul","mostrarBeneficiosAdicWin"}); 
			m.put("ROPCTbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_ROPC.zul","mostrarROPCWin"}); 
			m.put("gastosFunTbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_GastosFun.zul","mostrarFunerariosWin"}); 
			m.put("endososTbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_Endosos.zul","mostrarEndososWin"}); 
			m.put("encuestasTbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_Encuestas.zul","mostrarEncuestasWin"}); 
			m.put("reservasTbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_Reservas.zul","mostrarReservasWin"}); 
			m.put("descuentosTbBtn", new String[]{"/zul/consultaPoliza/windows/mostrar_Descuentos.zul","mostrarDescuentosWin"});
			m.put("imprimirProgPag", new String[]{"/zul/consultaPoliza/windows/reporteRenProPag.zul","reportePagosWin"});
			
			//Endoso
			m.put("reactivacionH16Btn", new String[]{"/zul/endosos/reactivacionH16.zul","reactivaHijos16Win"}); 
			m.put("reactivacionH18Btn", new String[]{"/zul/endosos/reactivacionH18.zul","reactivaHijos18Win"}); 
			
			return m.get(key);
		}catch (Exception e) {
			return new String[]{"",""};
		}
		}
	

}

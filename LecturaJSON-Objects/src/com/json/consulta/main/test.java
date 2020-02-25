package com.json.consulta.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.json.consulta.dao.DataShip;
import com.json.consulta.dao.Scholarship;
import com.json.consulta.dto.ScholarshipDataDTO;

public class test {
	
	private static boolean dataShipB = false;
	private static boolean scholarShipB = false;
	
	private static List<DataShip> datas;
	private static List<Scholarship> dataPrincipal;

	private static int CANT_DATOS = 5; 
	
	public static void main(String[] args) {
		
		Scholarship scholar = new Scholarship();
		
		if (startData()) {
				for(int i=0; i < CANT_DATOS; i++) {
					scholar.setId(i);
					scholar.setDataDireccion(datas);
				}
		}
		
		if (executeProcess()) {
			for(int i = 0; i < CANT_DATOS; i++) {
				
			}
			
		}
		
	}

	public static boolean startData() {
		DataShip dataShip = new DataShip();
		
		try {
			dataShip.setColDireccion("Villa Seca");
			dataShip.setNumDireccion("120");
			dataShip.setCalleDireccion("Aldama");
			dataShip.setCodigoPDireccion("52089");
			dataShip.setMunicipioDireccion("Otzolotepec");
			
			datas.add(dataShip);
			dataShipB = true;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dataShipB;
	}

	public static boolean executeProcess() {
		ScholarshipDataDTO scholarshipDataDTO = new ScholarshipDataDTO();
		
		try {
			scholarshipDataDTO.setReasonId("1234");
			scholarshipDataDTO.setReasonAdditionalInformation("1234");
			scholarshipDataDTO.setReasonSubreasonId("1234");
			scholarshipDataDTO.setDocumentId("1234");
			scholarshipDataDTO.setBusinessAgentId("1234");
			
			dataPrincipal.addAll((Collection<? extends Scholarship>) scholarshipDataDTO);
			scholarShipB = true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scholarShipB;
	}

	// Start method Getter and Setter....

	public boolean isDataShipB() {
		return dataShipB;
	}

	public void setDataShipB(boolean dataShipB) {
		this.dataShipB = dataShipB;
	}

	public boolean isScholarShipB() {
		return scholarShipB;
	}

	public void setScholarShipB(boolean scholarShipB) {
		this.scholarShipB = scholarShipB;
	}

	public List<DataShip> getDatas() {
		return datas;
	}

	public void setDatas(List<DataShip> datas) {
		this.datas = datas;
	}

	public static int getCANT_DATOS() {
		return CANT_DATOS;
	}

	public static void setCANT_DATOS(int cANT_DATOS) {
		CANT_DATOS = cANT_DATOS;
	}

	public static List<Scholarship> getDataPrincipal() {
		return dataPrincipal;
	}

	public static void setDataPrincipal(List<Scholarship> dataPrincipal) {
		test.dataPrincipal = dataPrincipal;
	}
	
}

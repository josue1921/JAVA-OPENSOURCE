package com.json.consulta.dao;

import java.util.List;

public class Scholarship {
	
	private int id;
	private List<DataShip> dataDireccion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<DataShip> getDataDireccion() {
		return dataDireccion;
	}

	public void setDataDireccion(List<DataShip> dataDireccion) {
		this.dataDireccion = dataDireccion;
	}
}

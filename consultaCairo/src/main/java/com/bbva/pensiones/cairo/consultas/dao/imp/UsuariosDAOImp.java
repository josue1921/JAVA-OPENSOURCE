package com.bbva.pensiones.cairo.consultas.dao.imp;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbva.pensiones.cairo.consultas.dao.UsuariosDAO;
import com.bbva.pensiones.cairo.consultas.entities.Usuarios;

@Service("usuariosDAO")
@Transactional
public class UsuariosDAOImp  implements UsuariosDAO {

	@Autowired
	private SessionFactory sessionFactory ;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuarios> getUsuarios() {
		List<Usuarios> list = null;
		
		try {
			 list = sessionFactory.getCurrentSession().createQuery("from Usuarios").list();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
}

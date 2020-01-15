package com.mx.sytcom.app.dao.impl;

import com.mx.sytcom.app.bean.Persona;
import com.mx.sytcom.app.dao.ServicioPersona;
import com.mx.sytcom.app.factory.MyBatisConnectionFactory;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ServicioPersonaImp implements ServicioPersona {

	public ServicioPersonaImp() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public Persona consultarPersona(String rfc)
    {
        SqlSession session;
        Map params;
        session = sqlSessionFactory.openSession();
        params = new HashMap();
        Persona persona1;
        params.put("rfc", rfc);
        Persona persona = (Persona)session.selectOne("Persona.consultaPersona", params);
        if(persona == null) {
        		persona1 = persona;
        		session.close();
        }
        return persona;
    }

	private SqlSessionFactory sqlSessionFactory;
}

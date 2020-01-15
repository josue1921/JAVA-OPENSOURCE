package com.mx.sytcom.app.test;

import com.mx.sytcom.app.util.Utils;
import java.io.PrintStream;
import org.apache.ibatis.session.SqlSessionFactory;

public class PersonaTest {

	public PersonaTest()
    {
    }
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static void main(String args[]) {
        String usuario = "temmComedor";
        String pass = "bRUpu&ez!XE2";
        Utils util = new Utils();
        String strencode = util.encode(usuario);
        System.out.println(strencode);
        System.out.println(util.decode(strencode));
        strencode = util.encode(pass);
        System.out.println(strencode);
        System.out.println(util.decode(strencode));
    }
	
}

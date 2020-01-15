package com.service.temm.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class HelloWsexample {
	private String message = new String("Hola, ");
	
	public void Hello() {}
    
    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}
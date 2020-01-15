package com.mx.sytcom.app;

import javax.xml.ws.Endpoint;

public class wsAppSytcomPublisher {
	
	public wsAppSytcomPublisher()
	{
	}
	
	public static void main(String args[])
    {
        Endpoint.publish("http://localhost:7001/WsAppSytcom", new wsAppSytcomImpl());
    }
}

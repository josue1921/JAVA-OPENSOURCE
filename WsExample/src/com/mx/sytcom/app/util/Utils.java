package com.mx.sytcom.app.util;

import org.apache.commons.codec.binary.Base64;

public class Utils {
	
	public Utils()
    {
    }
	
	public String encode(String cadena)
    {
        byte authEncBytes[] = Base64.encodeBase64(cadena.getBytes());
        String authStringEnc = new String(authEncBytes);
        return authStringEnc;
    }

    public String decode(String cadena)
    {
        byte authEnc[] = Base64.decodeBase64(cadena.getBytes());
        String decodeSt = new String(authEnc);
        return decodeSt;
    }
}

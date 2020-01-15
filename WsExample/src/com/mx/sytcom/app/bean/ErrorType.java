package com.mx.sytcom.app.bean;

public class ErrorType {
	public ErrorType()
    {
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorDesc()
    {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc)
    {
        this.errorDesc = errorDesc;
    }

    private String errorCode;
    private String errorDesc;
}

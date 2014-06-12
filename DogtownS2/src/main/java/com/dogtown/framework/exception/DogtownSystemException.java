package com.dogtown.framework.exception;

public class DogtownSystemException extends Exception 
{
	private static final long serialVersionUID = -8377006665850805218L;

	public DogtownSystemException(String message) 
	{
		super(message);
	}
	
	public DogtownSystemException(Throwable throwable) 
	{
		super(throwable);
	}
	
	public DogtownSystemException(String message, Throwable throwable) 
	{
		super(message, throwable);
	}
}

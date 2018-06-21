package com.murder.mystery.service.server.exception;


public class ErrorException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ErrorException(Integer responseCode){
		this(responseCode, "");
	}
	
	/**
	 * @param responseCode
	 * @param message
	 */
	public ErrorException(Integer responseCode, String message){
		this(responseCode, message, new Object[]{ message });
	}
	
	/**
	 * 
	 * @param responseCode
	 * @param message
	 * @param values
	 */
	public ErrorException(Integer responseCode, String message, Object... values){
		super(message, null,  responseCode, values);
	}
	
	
}

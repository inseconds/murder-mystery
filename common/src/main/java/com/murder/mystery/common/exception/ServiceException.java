package com.murder.mystery.common.exception;


public class ServiceException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ServiceException(Integer responseCode){
		this(responseCode, "");
	}
	
	/**
	 * @param responseCode
	 * @param message
	 */
	public ServiceException(Integer responseCode, String message){
		this(responseCode, message, new Object[]{ message });
	}
	
	/**
	 * 
	 * @param responseCode
	 * @param message
	 * @param values
	 */
	public ServiceException(Integer responseCode, String message, Object... values){
		super(message, null,  responseCode, values);
	}
	
	
}

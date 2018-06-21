package com.murder.mystery.service.server.response;

import com.alibaba.fastjson.annotation.JSONField;

public class ErrorResponse extends Response {
	
	private static final long serialVersionUID = 1L;
	
	private String exceptionCode;

	@JSONField(serialize=false)
	private Throwable cause;
	
	public ErrorResponse(Integer code) {
		super(code);
	}
	
	public ErrorResponse(Integer code, String exceptionCode) {
		super(code);
		this.setExceptionCode(exceptionCode);
	}
	
	public ErrorResponse(Integer code, String exceptionCode, String resultMessage) {
		super(code, resultMessage);
		this.exceptionCode = exceptionCode;
	}
	
	public ErrorResponse(Integer code, Throwable cause) {
		super(code);
		this.setCause(cause);
	}
	
	public ErrorResponse(Integer code, String exceptionCode, String resultMessage, Throwable cause) {
		super(code, resultMessage);
		this.setCause(cause);
		this.exceptionCode = exceptionCode;
	}
	
	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	
	
	
	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public Throwable getCause() {
		return this.cause;
	}
}

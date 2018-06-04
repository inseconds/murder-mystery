package com.murder.mystery.common.response;

import java.io.Serializable;

public class Response implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String resultMessage;
	
	public Response(){}
	
	public Response(Integer code) {
		this(code, "");
	}
	
	public Response(Integer code, String resultMessage) {
		this.setCode(code);
		this.setResultMessage(resultMessage);
	}
	
	public void setCode(Integer code){
		this.code = code;
	}
	
	public Integer getCode() {
		return this.code;
	}
	
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	public String getResultMessage() {
		return this.resultMessage;
	}
}

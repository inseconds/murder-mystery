package com.murder.mystery.server.exception;

/**
 * @author saber.wang
 * @version 1.0
 * 异常基类
 * */
public abstract class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private Object[] values; //格式化资源文件字符串信息
	
	private Integer responseCode; //异常客户端返回代码
	
	public BaseException(String message, Throwable cause,  Integer responseCode, Object[] values) {
		super(message, cause);
		this.setValues(values);
		this.setResponseCode(responseCode);
	}
	
	public Object[] getValues() {
		return this.values;
	}
	
	public void setValues(Object[] values) {
		this.values = values;
	}
	
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	
	public Integer getResponseCode() {
		return this.responseCode;
	}
	
}

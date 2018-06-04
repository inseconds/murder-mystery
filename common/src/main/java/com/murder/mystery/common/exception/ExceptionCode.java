package com.murder.mystery.common.exception;

/**
 * @author saber.wang
 * @version 1.0
 * */
public final class ExceptionCode {
	public static final String INTERNAL_SERVER_ERROR = "internal_server_error"; //服务器内部错误
	public static final String NOT_FOUND = "not_founded";
	public static final String VALIDATION_ERROR = "validation_error";
	public static final String AUTHENTICATION_FAIL = "authentication_fail";//认证失败，比如observer用户名或密码不匹配等
	public static final String ENTITY_BY_KEY_NOT_EXIST = "entity_by_key_not_exist";
	public static final String SERVICE_NOT_IMPLEMENT = "service_not_implement";
	public static final String SERVICE_INVOKE_EXCEPTION = "service_invoke_exception";
	public static final String CONCURRENCY_FAIL="concurrency_fail";
	public static final String STATUS_ERROR="status_error";
	public static final String CUSTOM_ERROR="custom_error";
}

package com.murder.mystery.service.server.response;

/**
 * 鍖呭惈鍝嶅簲缂栧彿銆佸搷搴旀枃锟�?
 *
 */
public enum EnumResponseCode {
	
	success(200), //成功
	not_founded(404), //资源不存在
	internal_server_error(500), //系统异常   
	
	validation_error(600), //检验异常
	authentication_fail(601), //认证失败
	status_error(602),//状态不合法
	entity_by_key_not_exist(604), //检查对象不存在
	entity_by_key_already_exist(605), //对象已存在
	
	service_not_implement(700), //服务未实现
	service_invoke_exception(701), //服务调用异常
	concurrency_fail(1002),//并发异常
	custom_error(9999),//自定义
	;
	
	private EnumResponseCode(int value) {
		this.value = value;
	}

	private int value;

	public int getValue() {
		return this.value;
	}
}

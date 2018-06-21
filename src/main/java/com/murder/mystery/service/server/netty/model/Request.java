package com.murder.mystery.service.server.netty.model;
/**
 * 消息对象
 * @author -琴兽-
 *
 */
public class Request {
	
	/**
	 * 模块号
	 */
	private short module;
	
	/**
	 * 命令号
	 */
	private short cmd;
	
	/**
	 * 数据
	 */
	private String data;
	
	public static Request valueOf(short module, short cmd, String data){
		Request request = new Request();
		request.setModule(module);
		request.setCmd(cmd);
		request.setData(data);
		return request;
	}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public short getModule() {
		return module;
	}

	public void setModule(short module) {
		this.module = module;
	}

	public short getCmd() {
		return cmd;
	}

	public void setCmd(short cmd) {
		this.cmd = cmd;
	}
}

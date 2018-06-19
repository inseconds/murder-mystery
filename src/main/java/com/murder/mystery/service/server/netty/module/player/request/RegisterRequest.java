package com.murder.mystery.service.server.netty.module.player.request;


/**
 * 注册请求
 * @author -琴兽-
 *
 */
public class RegisterRequest{
	
	/**
	 * 用户名
	 */
	private String playerName;
	
	/**
	 * 密码
	 */
	private String passward;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}
	
}

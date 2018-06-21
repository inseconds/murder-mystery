package com.murder.mystery.service.server.netty.module.player;
/**
 * 玩家模块
 * @author -琴兽-
 *
 */
public interface PlayerCmd {
	
	/**
	 * 创建并登录帐号
	 */
	short REGISTER_AND_LOGIN = 1;

	/**
	 * 登录帐号
	 */
	short LOGIN = 2;
}
                                                  
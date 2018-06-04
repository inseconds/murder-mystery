package com.murder.mystery.server.module.player.service;

import com.murder.mystery.common.core.session.Session;
import com.murder.mystery.common.module.player.response.PlayerResponse;

/**
 * 玩家服务
 * @author -琴兽-
 *
 */
public interface PlayerService {
	
	
	/**
	 * 登录注册用户
	 * @param playerName
	 * @param passward
	 * @return
	 */
	PlayerResponse registerAndLogin(Session session, String playerName, String passward);
	
	
	/**
	 * 登录
	 * @param playerName
	 * @param passward
	 * @return
	 */
	PlayerResponse login(Session session, String playerName, String passward);

}

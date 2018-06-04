package com.murder.mystery.server.module.player.handler;

import com.murder.mystery.common.annotion.SocketCommand;
import com.murder.mystery.common.annotion.SocketModule;
import com.murder.mystery.common.core.model.Result;
import com.murder.mystery.common.core.session.Session;
import com.murder.mystery.common.module.ModuleId;
import com.murder.mystery.common.module.player.PlayerCmd;
import com.murder.mystery.common.module.player.request.LoginRequest;
import com.murder.mystery.common.module.player.request.RegisterRequest;
import com.murder.mystery.common.module.player.response.PlayerResponse;

/**
 * 玩家模块
 * @author -琴兽-
 *
 */
@SocketModule(module = ModuleId.PLAYER)
public interface PlayerHandler {
	
	
	/**
	 * 创建并登录帐号
	 * @param session
	 * @param data {@link RegisterRequest}
	 * @return
	 */
	@SocketCommand(cmd = PlayerCmd.REGISTER_AND_LOGIN)
	public Result<PlayerResponse> registerAndLogin(Session session, byte[] data);
	

	/**
	 * 登录帐号
	 * @param session
	 * @param data {@link LoginRequest}
	 * @return
	 */
	@SocketCommand(cmd = PlayerCmd.LOGIN)
	public Result<PlayerResponse> login(Session session, byte[] data);

}

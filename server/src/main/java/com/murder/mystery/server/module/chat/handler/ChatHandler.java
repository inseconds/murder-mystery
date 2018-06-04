package com.murder.mystery.server.module.chat.handler;
import com.murder.mystery.common.annotion.SocketCommand;
import com.murder.mystery.common.annotion.SocketModule;
import com.murder.mystery.common.core.model.Result;
import com.murder.mystery.common.module.ModuleId;
import com.murder.mystery.common.module.chat.ChatCmd;
import com.murder.mystery.common.module.chat.request.PrivateChatRequest;
import com.murder.mystery.common.module.chat.request.PublicChatRequest;

/**
 * 聊天
 * @author -琴兽-
 *
 */
@SocketModule(module = ModuleId.CHAT)
public interface ChatHandler {
	
	
	/**
	 * 广播消息
	 * @param playerId
	 * @param data {@link PublicChatRequest}
	 * @return
	 */
	@SocketCommand(cmd = ChatCmd.PUBLIC_CHAT)
	Result<?> publicChat(long playerId, byte[] data);
	
	
	
	/**
	 * 私人消息
	 * @param playerId
	 * @param data {@link PrivateChatRequest}
	 * @return
	 */
	@SocketCommand(cmd = ChatCmd.PRIVATE_CHAT)
	Result<?> privateChat(long playerId, byte[] data);
}

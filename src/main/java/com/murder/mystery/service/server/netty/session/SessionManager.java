package com.murder.mystery.service.server.netty.session;

import com.google.common.collect.Sets;
import com.murder.mystery.service.server.response.DataResponse;
import com.murder.mystery.service.server.response.ResponseCode;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 会话管理者
 * @author -琴兽-
 *
 */
public class SessionManager {

	/**
	 * 在线会话
	 */
	private static final ConcurrentHashMap<Integer, Session> onlineSessions = new ConcurrentHashMap<>();

	private static final Set<Integer> matchSet = Sets.newConcurrentHashSet();

	/**
	 * 加入
	 * @param playerId
	 * @param session
	 * @return
	 */
	public static boolean putSession(Integer playerId, Session session){
		if(!onlineSessions.containsKey(playerId)){
			matchSet.add(playerId);
			boolean success = onlineSessions.putIfAbsent(playerId, session)== null? true : false;
			return success;
		}
		return false;
	}

	public static Session getPlayerSession(Integer playerId){
		Session session = onlineSessions.get(playerId);
		return session == null && session.isConnected() ? session : null;
	}
	
	/**
	 * 移除
	 * @param playerId
	 */
	public static Session removeSession(Integer playerId){
		matchSet.remove(playerId);
		return onlineSessions.remove(playerId);
	}
	
	/**
	 * 发送消息[自定义协议]
	 * @param <T>
	 * @param playerId
	 * @param message
	 */
	public static <T extends Serializable> void sendMessage(Integer playerId, T message){
		Session session = onlineSessions.get(playerId);
		if (session != null && session.isConnected()) {
			DataResponse response = new DataResponse();
			response.setCode(ResponseCode.SUCCESS);
			response.setData(message);
			session.write(response);
		}
	}
	
	/**
	 * 是否在线
	 * @param playerId
	 * @return
	 */
	public static boolean isOnlinePlayer(Integer playerId){
		return onlineSessions.containsKey(playerId);
	}
	
	/**
	 * 获取所有在线玩家
	 * @return
	 */
	public static Set<Integer> getOnlinePlayers() {
		return Collections.unmodifiableSet(onlineSessions.keySet());
	}

	public static Set<Integer> getMatchSet() {
		return matchSet;
	}
}

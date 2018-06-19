package com.murder.mystery.service.server.netty.module.player.response;


/**
 * 玩家信息
 * @author -琴兽-
 *
 */
public class PlayerResponse{
	
	
	/**
	 * id
	 */
	private long playerId;
	
	/**
	 * 用户名
	 */
	private String playerName;
	
	/**
	 * 等级
	 */
	private int level;
	
	/**
	 * 经验值
	 */
	private int exp;
	
	
	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
}

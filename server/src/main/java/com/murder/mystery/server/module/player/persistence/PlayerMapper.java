package com.murder.mystery.server.module.player.persistence;

import com.murder.mystery.server.module.player.entity.Player;
import org.apache.ibatis.annotations.Param;

/**
 * Created by jgsoft on 2018/6/6.
 */
public interface PlayerMapper {

    /**
     * 获取玩家通过id
     * @param playerId 玩家id
     * @return
     */
    Player getPlayerById(@Param("playerId") long playerId);


    /**
     * 获取玩家通过玩家名
     * @param playerName 玩家名称
     * @return
     */
    Player getPlayerByName(@Param("playerName") String playerName);


    /**
     * 创建玩家
     * @param player 玩家信息
     * @return
     */
    Player createPlayer(Player player);

}

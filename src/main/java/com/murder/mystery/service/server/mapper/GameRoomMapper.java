package com.murder.mystery.service.server.mapper;

import com.murder.mystery.service.server.domain.GameRoom;
import com.murder.mystery.service.server.domain.GameRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface GameRoomMapper {
    int countByExample(GameRoomExample example);

    int deleteByExample(GameRoomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GameRoom record);

    int insertSelective(GameRoom record);

    List<GameRoom> selectByExampleWithRowbounds(GameRoomExample example, RowBounds rowBounds);

    List<GameRoom> selectByExample(GameRoomExample example);

    GameRoom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GameRoom record, @Param("example") GameRoomExample example);

    int updateByExample(@Param("record") GameRoom record, @Param("example") GameRoomExample example);

    int updateByPrimaryKeySelective(GameRoom record);

    int updateByPrimaryKey(GameRoom record);
}
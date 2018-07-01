package com.murder.mystery.service.server.mapper;

import com.murder.mystery.service.server.domain.GameUser;
import com.murder.mystery.service.server.domain.GameUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface GameUserMapper {
    int countByExample(GameUserExample example);

    int deleteByExample(GameUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GameUser record);

    int insertSelective(GameUser record);

    List<GameUser> selectByExampleWithRowbounds(GameUserExample example, RowBounds rowBounds);

    List<GameUser> selectByExample(GameUserExample example);

    GameUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GameUser record, @Param("example") GameUserExample example);

    int updateByExample(@Param("record") GameUser record, @Param("example") GameUserExample example);

    int updateByPrimaryKeySelective(GameUser record);

    int updateByPrimaryKey(GameUser record);
}
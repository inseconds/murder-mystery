package com.murder.mystery.service.server.mapper;

import com.murder.mystery.service.server.domain.Character;
import com.murder.mystery.service.server.domain.CharacterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CharacterMapper {
    int countByExample(CharacterExample example);

    int deleteByExample(CharacterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Character record);

    int insertSelective(Character record);

    List<Character> selectByExampleWithRowbounds(CharacterExample example, RowBounds rowBounds);

    List<Character> selectByExample(CharacterExample example);

    Character selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Character record, @Param("example") CharacterExample example);

    int updateByExample(@Param("record") Character record, @Param("example") CharacterExample example);

    int updateByPrimaryKeySelective(Character record);

    int updateByPrimaryKey(Character record);
}
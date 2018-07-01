package com.murder.mystery.service.server.mapper;

import com.murder.mystery.service.server.domain.GameUserEvidence;
import com.murder.mystery.service.server.domain.GameUserEvidenceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface GameUserEvidenceMapper {
    int countByExample(GameUserEvidenceExample example);

    int deleteByExample(GameUserEvidenceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GameUserEvidence record);

    int insertSelective(GameUserEvidence record);

    List<GameUserEvidence> selectByExampleWithRowbounds(GameUserEvidenceExample example, RowBounds rowBounds);

    List<GameUserEvidence> selectByExample(GameUserEvidenceExample example);

    GameUserEvidence selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GameUserEvidence record, @Param("example") GameUserEvidenceExample example);

    int updateByExample(@Param("record") GameUserEvidence record, @Param("example") GameUserEvidenceExample example);

    int updateByPrimaryKeySelective(GameUserEvidence record);

    int updateByPrimaryKey(GameUserEvidence record);
}
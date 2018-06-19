package com.murder.mystery.service.server.mapper;

import com.murder.mystery.service.server.domain.Drama;
import com.murder.mystery.service.server.domain.DramaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DramaMapper {
    int countByExample(DramaExample example);

    int deleteByExample(DramaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Drama record);

    int insertSelective(Drama record);

    List<Drama> selectByExampleWithBLOBsWithRowbounds(DramaExample example, RowBounds rowBounds);

    List<Drama> selectByExampleWithBLOBs(DramaExample example);

    List<Drama> selectByExampleWithRowbounds(DramaExample example, RowBounds rowBounds);

    List<Drama> selectByExample(DramaExample example);

    Drama selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Drama record, @Param("example") DramaExample example);

    int updateByExampleWithBLOBs(@Param("record") Drama record, @Param("example") DramaExample example);

    int updateByExample(@Param("record") Drama record, @Param("example") DramaExample example);

    int updateByPrimaryKeySelective(Drama record);

    int updateByPrimaryKeyWithBLOBs(Drama record);

    int updateByPrimaryKey(Drama record);
}
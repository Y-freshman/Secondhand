package com.schoolTao.dao;

import com.schoolTao.dto.RemainDTO;
import com.schoolTao.pojo.Remain;
import com.schoolTao.pojo.RemainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemainMapper {
    long countByExample(RemainExample example);

    int deleteByExample(RemainExample example);

    int deleteByPrimaryKey(Integer remainId);

    int insert(Remain record);

    int insertSelective(Remain record);

    List<Remain> selectByExample(RemainExample example);
    
    List<RemainDTO> selectAndUser(Integer receicverId);
    
    List<RemainDTO> selectAndUserSub(Integer remianLastId);

    Remain selectByPrimaryKey(Integer remainId);

    int updateByExampleSelective(@Param("record") Remain record, @Param("example") RemainExample example);

    int updateByExample(@Param("record") Remain record, @Param("example") RemainExample example);

    int updateByPrimaryKeySelective(Remain record);

    int updateByPrimaryKey(Remain record);

	List<Remain> getRemains(@Param("page")Integer page, @Param("limit")Integer limit);
}
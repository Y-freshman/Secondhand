package com.schoolTao.dao;

import com.schoolTao.pojo.Key;
import com.schoolTao.pojo.KeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeyMapper {
    long countByExample(KeyExample example);

    int deleteByExample(KeyExample example);

    int deleteByPrimaryKey(Integer keyId);

    int insert(Key record);

    int insertSelective(Key record);

    List<Key> selectByExample(KeyExample example);

    Key selectByPrimaryKey(Integer keyId);

    int updateByExampleSelective(@Param("record") Key record, @Param("example") KeyExample example);

    int updateByExample(@Param("record") Key record, @Param("example") KeyExample example);

    int updateByPrimaryKeySelective(Key record);

    int updateByPrimaryKey(Key record);

	List<Key> getKeys(@Param("page")Integer page, @Param("limit")Integer limit);
}
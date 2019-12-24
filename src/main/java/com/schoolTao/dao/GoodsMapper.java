package com.schoolTao.dao;

import com.schoolTao.dto.Console;
import com.schoolTao.pojo.Goods;
import com.schoolTao.pojo.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);
    
    List<Goods> selectByMayLike(GoodsExample example);
    
    List<Goods> selectByView(GoodsExample example);
    
    List<Console> selectByView3();
    
    List<Goods> selectByType(Goods record);
    
    List<Goods> selectByView2(GoodsExample example);
    
    List<Goods> selectByType2(Goods record);
    
    List<Goods> selectByName(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

	int incView(Integer goodsId);

	List<Goods> selectByUserId(Integer userId);

	List<Goods> getGoods(@Param("goodsType")String goodsType,@Param("page")Integer page, @Param("limit")Integer limit);
}
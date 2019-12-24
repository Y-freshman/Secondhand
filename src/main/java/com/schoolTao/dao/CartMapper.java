package com.schoolTao.dao;

import com.schoolTao.dto.CartDTO;
import com.schoolTao.pojo.Cart;
import com.schoolTao.pojo.CartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {
    long countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(Integer cartId);
    
    int deleteRows(List<Long> cartId);

    int insert(Cart record);

    int insertSelective(Cart record);

    List<Cart> selectByExample(CartExample example);
    
    List<CartDTO> selectByUserIdAndGoods(Integer userId);

    Cart selectByPrimaryKey(Integer cartId);

    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}
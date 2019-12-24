package com.schoolTao.dao;

import com.schoolTao.dto.Console;
import com.schoolTao.dto.OrderDTO;
import com.schoolTao.pojo.Order;
import com.schoolTao.pojo.OrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);
    
    List<OrderDTO> selectAndGoods(Integer userId);

    Order selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    int updateConfirm(Integer orderId);

	List<OrderDTO> selectAndGoodsNeed(@Param("userId")Integer userId, @Param("orderState")String orderState);

	int addOrders(List<Order> gdsList);
	
	int addOrder(Order order);

	List<Console> selectByView3();

	List<Order> getOrders(@Param("page")Integer page, @Param("limit")Integer limit);
}
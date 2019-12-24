package com.schoolTao.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolTao.dao.OrderMapper;
import com.schoolTao.dto.OrderDTO;
import com.schoolTao.pojo.Order;
import com.schoolTao.pojo.OrderExample;

@Service
public class OrderService {

	@Autowired
	OrderMapper orderMapper;

	/**
	 * 查询所有订单
	 * @param userId
	 * @return
	 */
	public List<OrderDTO> getAll(Integer userId) {
		return orderMapper.selectAndGoods(userId);
	}

	/**
	 * 查询待收货以及待付款
	 * @param userId
	 * @param orderState
	 * @return
	 */
	public List<OrderDTO> getAllNeed(Integer userId, String orderState) {
		// TODO Auto-generated method stub
		return orderMapper.selectAndGoodsNeed(userId, orderState);
	}

	/**
	 * 确认收货
	 * @param orderId
	 */
	public void confirm(Integer orderId) {
		// TODO Auto-generated method stub
		orderMapper.updateConfirm(orderId);
	}

	public void addOrders(List<Order> gdsList) {
		// TODO Auto-generated method stub
		orderMapper.addOrders(gdsList);
	}

	/**
	 * 添加订单
	 * @param order
	 */
	public void addorder(Order order) {
		// TODO Auto-generated method stub
		orderMapper.addOrder(order);
	}

	/**
	 * 分页查询订单
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<Order> getOrders(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return orderMapper.getOrders(page,limit);
	}

	/**
	 * 统计订单数量
	 * @return
	 */
	public Long countOrders() {
		// TODO Auto-generated method stub
		return orderMapper.countByExample(null);
	}

	public void deleteOrder(Integer orderId) {
		// TODO Auto-generated method stub
		orderMapper.deleteByPrimaryKey(orderId);
	}

	public void deleteOrders(List<Integer> oidList) {
		// TODO Auto-generated method stub
		for(int i=0; i<oidList.size(); i++){
			orderMapper.deleteByPrimaryKey(oidList.get(i));
		}
	}
	
}

package com.schoolTao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolTao.dao.GoodsMapper;
import com.schoolTao.dao.NeedMapper;
import com.schoolTao.dao.OrderMapper;
import com.schoolTao.dao.UserMapper;
import com.schoolTao.dto.Console;
import com.schoolTao.pojo.Goods;
import com.schoolTao.pojo.GoodsExample;

@Service
public class GoodsService {
	@Autowired
	GoodsMapper goodsMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	OrderMapper orderMapper;
	
	@Autowired
	NeedMapper needMapper;

	/**
	 * 根据id获取商品信息
	 * @param goodsId
	 * @return
	 */
	public Goods getOne(Integer goodsId) {
		// TODO Auto-generated method stub
		return goodsMapper.selectByPrimaryKey(goodsId);
	}
	
	/**
	 * 获取控制台商品信息
	 * @param 
	 * @return
	 */
	public List<Console> getConsole1() {
		// TODO Auto-generated method stub
		return goodsMapper.selectByView3();
	}
	
	/**
	 * 获取控制台用户信息
	 * @param 
	 * @return
	 */
	public List<Console> getConsole2() {
		// TODO Auto-generated method stub
		return userMapper.selectByView3();
	}
	
	/**
	 * 获取控制台订单信息
	 * @param 
	 * @return
	 */
	public List<Console> getConsole3() {
		// TODO Auto-generated method stub
		return orderMapper.selectByView3();
	}
	
	/**
	 * 获取控制台求购信息
	 * @param 
	 * @return
	 */
	public List<Console> getConsole4() {
		// TODO Auto-generated method stub
		return needMapper.selectByView3();
	}
	
	/**
	 * 根据type获取商品信息
	 * @param goodsId
	 * @return
	 */
	public List<Goods> getType(Goods type) {
		// TODO Auto-generated method stub
		return goodsMapper.selectByType(type);
	}
	
	/**
	 * 获取一种商品全部信息
	 * @param 
	 * @return
	 */
	public List<Goods> getTypePage(Goods type) {
		// TODO Auto-generated method stub
		return goodsMapper.selectByType2(type);
	}
	
	/**
	 * 根据name获取商品信息
	 * @param goodsId
	 * @return
	 */
	public List<Goods> getName(Goods type) {
		// TODO Auto-generated method stub
		return goodsMapper.selectByName(type);
	}
	
	/**
	 * 获取热门商品信息
	 * @param 
	 * @return
	 */
	public List<Goods> getHot() {
		// TODO Auto-generated method stub
		return goodsMapper.selectByView(null);
	}

	/**
	 * 商品浏览量加一
	 * @param goodsId
	 */
	public void incView(Integer goodsId) {
		// TODO Auto-generated method stub
		goodsMapper.incView(goodsId);
	}
	
	/**
	 * 我要发布
	 * @param goods
	 */
	public void InsertGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.insertSelective(goods);
	}
	
	/**
	 * 猜你喜欢
	 * @return
	 */
	public List<Goods> maylike() {
		return goodsMapper.selectByMayLike(null);
	}

	public List<Goods> selectMygoods(Integer userId) {
		return goodsMapper.selectByUserId(userId);
	}

	public void deleteGoods(Integer goodsId) {
		goodsMapper.deleteByPrimaryKey(goodsId);
	}


	/**
	 * 根据类型查询商品（分页）
	 * @param goodsType
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<Goods> getGoods(String goodsType,Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoods(goodsType,page,limit);
	}

	/**
	 * 统计某种类型商品数量
	 * @param goodsType
	 * @return
	 */
	public Long countGoods(String goodsType) {
		// TODO Auto-generated method stub
		GoodsExample goodsExample = new GoodsExample();
		goodsExample.createCriteria().andGoodsTypeEqualTo(goodsType);
		goodsExample.createCriteria().andGoodsTypeEqualTo(goodsType);
		return goodsMapper.countByExample(goodsExample);
	}

	/**
	 * 删除某商品
	 * @param goodsId
	 */
	public void deleteGood(Integer goodsId) {
		// TODO Auto-generated method stub
		goodsMapper.deleteByPrimaryKey(goodsId);
	}

	/**
	 * 批量删除商品
	 * @param gidLst
	 */
	public void batchDelGoods(List<Integer> gidLst) {
		// TODO Auto-generated method stub
		for(int i=0; i<gidLst.size(); i++){
			goodsMapper.deleteByPrimaryKey(gidLst.get(i));
		}
	}

}

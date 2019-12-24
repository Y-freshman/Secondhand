package com.schoolTao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoolTao.dto.CartDTO;
import com.schoolTao.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;
	
	/**
	 * 查询当前购物车商品
	 * @param data
	 * @return
	 */
	@PostMapping("/select.do")
	@ResponseBody
	public List<CartDTO> getAll(@RequestBody Map<String, Object> data){
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartDTO> list = cartService.getAll(Integer.parseInt(data.get("userId").toString()));
		return list;
	}
	
	/**
	 * 删除购物车内某商品
	 * @param data
	 */
	@PostMapping("/delete.do")
	@ResponseBody
	public void delete(@RequestBody Map<String, Object> data){
		Integer cartId = Integer.parseInt(data.get("cartId").toString());
		cartService.delete(cartId);
	}
	
	/**
	 * 批量删除购物车内容
	 * @param data
	 */
	@PostMapping("/deleteRows.do")
	@ResponseBody
	public void deleteRows(@RequestBody Map<String, Object> data){
		List<Long>cartId = (List<Long>) data.get("cartId");
		cartService.deleteRows(cartId);
	}
	
}

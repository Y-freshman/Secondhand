package com.schoolTao.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoolTao.pojo.Key;
import com.schoolTao.pojo.Remain;
import com.schoolTao.service.KeyService;

@Controller
@RequestMapping("/key")
public class KeyController {
	@Autowired
	KeyService keyService;
	
	/**
	 * 搜索商品 / 将搜索的关键字存入到搜索表中
	 * @param data 需要查询的商品条件
	 * @return 该条件商品信息
	 * @throws ParseException 
	 */
	@PostMapping("/keys.do")
	@ResponseBody
	public Map<String, Object> search(@RequestBody Map<String,String> data) throws ParseException{
		Map<String, Object>map = new HashMap<String, Object>();
		Integer userId = Integer.parseInt(data.get("userId"));
		String search = data.get("search");
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
		Date datetime = dateFormat.parse(dateFormat.format( now )); 
		Key key = new Key();
		key.setUserId(userId);
		key.setKeyContent(search);
		key.setKeyTime(datetime);
		keyService.insertKey(key);
		return map;
	}
	
	/**
	 * 分页查询留言以及总数
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/getkeys.do")
	@ResponseBody
	public Map<String, Object> getkeys(@RequestParam(value="page")Integer page,
			@RequestParam(value="limit")Integer limit){
		Map<String, Object> map = new HashMap<String, Object>();
		page = (page-1) * limit;
		List<Key> list = keyService.getkeys(page,limit);
		Long countItem = keyService.countKey();
		System.out.println(countItem);
		System.out.println(list);
		map.put("data", list);
		map.put("total", countItem);
		map.put("code", 0);
		return map;
	}
	
	/**
	 * 删除某条搜索
	 * @param data
	 * @return
	 */
	@RequestMapping("/deletekey.do")
	@ResponseBody
	public Map<String, Object> deletekey(@RequestBody Map<String,String> data){
		Map<String, Object>map = new HashMap<String, Object>();
		Integer keyId = Integer.parseInt(data.get("keyId"));
		keyService.deletekey(keyId);
		map.put("code", 0);
		return map;
	}
	
	/**
	 * 批量删除搜索关键字
	 * @param data
	 * @return
	 */
	@RequestMapping("/deletekeys.do")
	@ResponseBody
	public Map<String, Object> deletekeys(@RequestBody Map<String,Object> data){
		Map<String, Object>map = new HashMap<String, Object>();
		List<Integer>list = (List<Integer>) data.get("keyLists");
		keyService.deleteKeys(list );
		map.put("code", 0);
		return map;
	}
	
}

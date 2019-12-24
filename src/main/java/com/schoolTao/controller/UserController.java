package com.schoolTao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoolTao.pojo.User;
import com.schoolTao.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/index")
	public String get(){
		return "index";
	}
	
	/**
	 * 获取所有用户（分页）
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/getUser.do")
	@ResponseBody
	public Map<String, Object> getUser(@RequestParam(value="page")Integer page,
			@RequestParam(value="limit")Integer limit){
		Map<String, Object>map = new HashMap<String, Object>();
		page = (page-1) * limit;
		List<User> list = userService.getUser(page,limit);
		Long countItem = userService.countUser();
		map.put("data", list);
		map.put("total", countItem);
		map.put("code", 0);
		return map;
	}
	
	/**
	 * 删除某个用户
	 * @param data
	 * @return
	 */
	@PostMapping("/deleteUser.do")
	@ResponseBody
	public Map<String, Object> deleteUser(@RequestBody Map<String,String> data){
		Map<String, Object>map = new HashMap<String, Object>();
		Integer userId = Integer.parseInt(data.get("idsStr"));
		System.out.println(userId);
		userService.deleteUser(userId);
		map.put("code", 0);
		return map;
	}
	
	/**
	 * 批量删除用户
	 * @param data
	 * @return
	 */
	@PostMapping("/batchDelUser.do")
	@ResponseBody
	public Map<String, Object> batchDelUser(@RequestBody Map<String,Object> data){
		Map<String, Object>map = new HashMap<String, Object>();
		List<Integer>uidLst = (List<Integer>) data.get("userLists");
		userService.batchDelUser(uidLst);
		map.put("code", 0);
		return map;
	}
	
}

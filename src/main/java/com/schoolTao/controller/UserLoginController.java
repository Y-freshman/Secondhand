package com.schoolTao.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoolTao.pojo.Goods;
import com.schoolTao.pojo.User;
import com.schoolTao.service.GoodsService;
import com.schoolTao.service.UserService;
import com.schoolTao.utils.BCryptPasswordEncoder;

/**
 * @author freshman
 *
 */
@Controller
@RequestMapping("/user")
public class UserLoginController {
	
	@Autowired
	UserService userService;
	@Autowired
	GoodsService goodservice;
	/**
	 * 登录
	 * @param data
	 * @return
	 */
	
	@PostMapping("/logins.do")
	@ResponseBody
	public Map<String,Object> loginUser(@RequestBody Map<String,Object> data){
		Map<String,Object> map = new HashMap();
		String root = data.get("root").toString();
		String password = data.get("password").toString();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User user = userService.loginUser(root);
		if(user == null){
			map.put("code", 500);
			return map;
		}
		if (!encoder.matches(password,user.getUserPassword())) {
            map.put("code", 500);
			return map;
        }else{
        	map.put("user", user);
        	map.put("code", 200);
    		return map;
        }
	}
	
	@PostMapping("/loginAdmin.do")
	@ResponseBody
	public Map<String,Object> loginAdmin(@RequestBody Map<String,Object> data){
		Map<String,Object> map = new HashMap();
		String root = data.get("root").toString();
		String password = data.get("password").toString();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		System.out.println(root);
		System.out.println(password);
		
		User user = userService.loginUser(root);
		if(user == null){
			System.out.println(111);
			map.put("code", 500);
			return map;
		}
		if (!encoder.matches(password,user.getUserPassword())) {
			System.out.println(222);
			map.put("code", 500);
			return map;
		}else{
			if(user.getUserVip().equals("2")){
				map.put("code", 200);
				System.out.println(user.getUserVip());
				System.out.println(map);
				return map;
			}
			System.out.println(333);
			System.out.println(user.getUserVip());
			map.put("code", 500);
			return map;
		}
	}
	
	/**
	 * 密码重置
	 */
	@PostMapping("/resets.do")
	@ResponseBody
	public Map<String,Object> resetUser(@RequestBody Map<String,Object> data){
		Map<String,Object> map = new HashMap();
		String root = data.get("root").toString();
		String pass = data.get("pass").toString();
		String value = data.get("value").toString();
		String answer = data.get("answer").toString();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    String encodedPassword = encoder.encode(pass);
	    
	    User user = new User();
		user.setUserName(root);
		user.setUserPassword(encodedPassword);
		user.setUserMibao(value);
		user.setUserAnswer(answer);
	    String code = userService.resetUser(user);
        map.put("user", user); 
        map.put("code", code);
    	return map;
	}
	
	
	/**
	 * 注册
	 * @param data
	 * @return
	 * @throws ParseException 
	 */
	
	@PostMapping("/registers.do")
	@ResponseBody
	public Map<String,Object> registerUser(@RequestBody Map<String,Object> data) throws ParseException{
		Map<String,Object> map = new HashMap();
		String root = data.get("root").toString();
		String pass = data.get("pass").toString();
		String value = data.get("value").toString();
		String answer = data.get("answer").toString();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    String encodedPassword = encoder.encode(pass);
		
	    User user1 = userService.loginUser(root);
		if(user1 != null){
			System.out.println(666);
			map.put("code", 600);
			return map;
		}
	    
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
		Date datetime = dateFormat.parse(dateFormat.format( now )); 
	    
		User user = new User();
		user.setUserName(root);
		user.setUserPassword(encodedPassword);
		user.setUserMibao(value);
		user.setUserAnswer(answer);
		user.setUserSex("0");
		user.setUserVip("0");
		user.setUserAvater("https://www.freshman.top/images/24.jpg");
		user.setUserRegisterTime(datetime);
		
		userService.registerUser(user);
		map.put("user", user);
		map.put("code", 200);
		System.out.println(user);
		return map;
	}
	
	/**
	 * 个人中心获取用户信息
	 * @param data
	 * @return
	 */
	@PostMapping("/users.do")
	@ResponseBody
	public Map<String,Object> users(@RequestBody Map<String,Object> data){
		Map<String, Object>map = new HashMap<String, Object>();
		User user = userService.users(Integer.parseInt((String) data.get("userId")));
		map.put("user", user);
		return map;
	}
	/**
	 * 修改个人信息
	 * @param data
	 * @return
	 */
	@PostMapping("/selfs.do")
	@ResponseBody
	public Map<String,Object> selfs(@RequestBody Map<String,Object> data){
		Map<String, Object>map = new HashMap<String, Object>();
		Integer userId = Integer.parseInt(data.get("userId").toString());
		Integer puandan = (Integer) data.get("panduan");
		String userName = data.get("userName").toString();
		String userAvater = data.get("userAvater").toString();
		String userSex = data.get("userSex").toString();
		String userIntro = data.get("userIntro").toString();
		if(puandan == 1){
			User user1 = userService.loginUser(userName);
				if(user1 != null){
					System.out.println(666);
					map.put("code", 500);
					return map;
				}
		}
	    User user = new User();
	    user.setUserId(userId);
		user.setUserName(userName);
		user.setUserAvater(userAvater);
		user.setUserSex(userSex);
		user.setUserIntro(userIntro);
	    userService.selfUser(user);
        map.put("user", user); 
    	return map;
	}
	/**
	 * 升级VIP
	 * @param data
	 * @return
	 */
	@PostMapping("/vips.do")
	@ResponseBody
	public Map<String,Object> VIP(@RequestBody Map<String,Object> data){
		Map<String, Object>map = new HashMap<String, Object>();
		Integer userId = Integer.parseInt(data.get("userId").toString());
		User user = new User();
		user.setUserId(userId);
		user.setUserVip("1");
		userService.selfUser(user);
		map.put("user", user); 
		return map;
	}
}

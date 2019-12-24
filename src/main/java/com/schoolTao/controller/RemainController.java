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

import com.schoolTao.dto.RemainDTO;
import com.schoolTao.pojo.Order;
import com.schoolTao.pojo.Remain;
import com.schoolTao.service.RemainService;

@Controller
@RequestMapping("/remain")
public class RemainController {

	@Autowired
	RemainService remainService;
	
	/**
	 * 查询所有主留言
	 * @param data
	 * @return
	 */
	@PostMapping("selectMain.do")
	@ResponseBody
	public Map<String, Object>getAllMain(@RequestBody Map<String, String> data){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer receiverId = Integer.parseInt(data.get("receiverId"));
		List<RemainDTO>list = remainService.getAll(receiverId);
		map.put("remains", list);
		return map;
	}
	
	/**
	 * 查询某个主留言的所有子留言
	 * @param data
	 * @return
	 */
	@PostMapping("selectSub.do")
	@ResponseBody
	public Map<String, Object>getMainSub(@RequestBody Map<String, Object> data){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer lastId = (Integer) data.get("lastId");
		List<RemainDTO>list = remainService.getMainSub(lastId);
		map.put("remains", list);
		return map;
	}
	
	/**
	 * 删除某个主留言或者主留言中的某个子留言
	 * @param data
	 * @return
	 */
	@PostMapping("/deleteItem.do")
	@ResponseBody
	public Map<String, Object>deleteSubItem(@RequestBody Map<String, Object> data){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer remainId = (Integer) data.get("remainId");
		remainService.deleteItem(remainId);
		map.put("code", 200);
		return map;
	}
	
	/**
	 * 添加留言
	 * @param data
	 * @return
	 * @throws ParseException
	 */
	@PostMapping("/addItem.do")
	@ResponseBody
	public Map<String, Object>addItem(@RequestBody Map<String, String> data) throws ParseException{
		Map<String, Object> map = new HashMap<String, Object>();
		Remain remain = new Remain();
		Integer receiverId = Integer.parseInt(data.get("receiverId"));
		Integer remainerId = Integer.parseInt(data.get("remainerId"));
		Integer remianLastId = Integer.parseInt(data.get("remianLastId"));
		String remainContent = data.get("remainContent");
		Date addTime = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
		remain.setRemainTime(dateFormat.parse(dateFormat.format(addTime)));
		remain.setUserId(remainerId);
		remain.setRemainToId(receiverId);
		remain.setRemianLastId(remianLastId);
		remain.setRemainContent(remainContent);
		remainService.addItem(remain);
		map.put("code", 200);
		return map;
	}
	
	/**
	 * 分页查询留言以及总数
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/getRemains.do")
	@ResponseBody
	public Map<String, Object> getRemains(@RequestParam(value="page")Integer page,
			@RequestParam(value="limit")Integer limit){
		Map<String, Object>map = new HashMap<String, Object>();
		page = (page-1) * limit;
		List<Remain> list = remainService.getRemains(page,limit);
		Long countItem = remainService.countRemain();
		map.put("data", list);
		map.put("total", countItem);
		map.put("code", 0);
		return map;
	}
	
	/**
	 * 删除某条留言
	 * @param data
	 * @return
	 */
	@RequestMapping("/deleteRemain.do")
	@ResponseBody
	public Map<String, Object> deleteOrder(@RequestBody Map<String,String> data){
		Map<String, Object>map = new HashMap<String, Object>();
		Integer remainId = Integer.parseInt(data.get("remainId"));
		remainService.deleteRemain(remainId );
		map.put("code", 0);
		return map;
	}
	
	/**
	 * 批量删除留言
	 * @param data
	 * @return
	 */
	@RequestMapping("/deleteRemains.do")
	@ResponseBody
	public Map<String, Object> deleteOrders(@RequestBody Map<String,Object> data){
		Map<String, Object>map = new HashMap<String, Object>();
		List<Integer>list = (List<Integer>) data.get("remainLists");
		remainService.deleteRemains(list );
		map.put("code", 0);
		return map;
	}
	
}

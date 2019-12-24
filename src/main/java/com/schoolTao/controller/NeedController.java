package com.schoolTao.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.schoolTao.pojo.Comment;
import com.schoolTao.pojo.Need;
import com.schoolTao.service.NeedService;

@Controller
@RequestMapping("/need" )
public class NeedController {
	
	@Autowired
	NeedService needService;
	
			//插入求购
			@RequestMapping(value = "/insert.do")
			@ResponseBody
			public  Map<String, Object> insert(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String> Data ) throws IOException, ParseException{
						request.setCharacterEncoding("utf-8");
						response.setContentType("application/json;charset=utf-8");
						String needContent = Data.get("needContent");
						String needPics = Data.get("needPics");
						int userId = Integer.parseInt(Data.get("userId"));
						Date needTime  = new Date();
						SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
				        Need need = new Need();
				        need.setNeedContent(needContent);
				        need.setNeedPics(needPics);
				        need.setUserId(userId);
				        need.setNeedCommentNum(0);
				        need.setNeedViewNum(0);
				        need.setNeedTime(dateFormat.parse(dateFormat.format(needTime)));
				        int i = needService.InsertNeed(need);
						Map<String, Object>map = new HashMap<String, Object>();
						map.put("i",i);
						return map;
			}
			//更新浏览量
			@RequestMapping(value = "/update.do")
			@ResponseBody
			public  Map<String, Object> update(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String> Data ) throws IOException, ParseException{
				request.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				int needId = Integer.parseInt(Data.get("needId"));
				needService.UpdateNeed(needId);
				Map<String, Object>map = new HashMap<String, Object>();
				map.put("i",1);
				return map;
			}
			//查询求购
			@RequestMapping(value = "/select.do")
			@ResponseBody
			public  Map<String, Object> select(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String> Data ) throws IOException, ParseException{
				request.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				int type = Integer.parseInt(Data.get("type"));
				List<Need> needlist = needService.SelectNeed(type);
				Map<String, Object>map = new HashMap<String, Object>();
				map.put("list",needlist);
				
				System.out.println(needlist);
				System.out.println(8888);
				
				
				return map;
			}
			
			/**
			 * 查找用户自己的求购
			 * @param request
			 * @param response
			 * @param Data
			 * @return
			 * @throws IOException
			 * @throws ParseException
			 */
			@RequestMapping(value = "/selectUser.do")
			@ResponseBody
			public  Map<String, Object> selectUser(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String> Data ) throws IOException, ParseException{
				request.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				Integer type = Integer.parseInt(Data.get("type"));
				Integer userId = Integer.parseInt(Data.get("userId"));
				List<Need> needlist = needService.userSelectNeed(type,userId);
				Map<String, Object>map = new HashMap<String, Object>();
				map.put("list",needlist);
				
				System.out.println(type);
				System.out.println(userId);
				System.out.println(needlist);
				System.out.println(8888);
				
				
				return map;
			}
			
			/**
			 * 查找用户自己的求购
			 * @param request
			 * @param response
			 * @param Data
			 * @return
			 * @throws IOException
			 * @throws ParseException
			 */
			@RequestMapping(value = "/deleteNeed.do")
			@ResponseBody
			public  Map<String, Object> deleteNeed(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String> Data ) throws IOException, ParseException{
				request.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				Integer needId = Integer.parseInt(Data.get("needId"));
			    needService.deleteNeed(needId);
				Map<String, Object>map = new HashMap<String, Object>();
				map.put("code",200);
				System.out.println(needId);
				System.out.println(8888);
				return map;
			}
		
			
			//获取所有求购
			@RequestMapping(value = "/getNeed.do")
			@ResponseBody
			public  Map<String, Object> needContent(@RequestParam(value="page")Integer page,@RequestParam(value="limit")Integer limit) {
				Map<String, Object>map = new HashMap<String, Object>();
				page = (page-1) * limit;
				List<Need> list = needService.getNeed(page,limit);
				Long countItem = needService.countNeed();
				map.put("data", list);
				map.put("total", countItem);
				map.put("code", 0);
				return map;
			}
			
			/**
			 * 删除某个求购
			 * @param data
			 * @return
			 */
			@PostMapping("/deleteNeed.do")
			@ResponseBody
			public Map<String, Object> deleteNeed(@RequestBody Map<String,String> data){
				Map<String, Object>map = new HashMap<String, Object>();
				Integer needId = Integer.parseInt(data.get("idsStr"));
				needService.deleteNeed(needId);
				map.put("code", 0);
				return map;
			}
			
			/**
			 * 批量删除求购
			 * @param data
			 * @return
			 */
			@PostMapping("/batchDelNeed.do")
			@ResponseBody
			public Map<String, Object> batchDelNeed(@RequestBody Map<String,Object> data){
				Map<String, Object>map = new HashMap<String, Object>();
				List<Integer>nidLst = (List<Integer>) data.get("needLists");
				needService.batchDelNeed(nidLst);
				map.put("code", 0);
				return map;
			}
}

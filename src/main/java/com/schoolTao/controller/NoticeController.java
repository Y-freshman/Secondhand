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

import com.schoolTao.pojo.Notice;
import com.schoolTao.pojo.Notice;
import com.schoolTao.service.NoticeService;

@Controller
@RequestMapping("/notice" )
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
			//插入通知
			@RequestMapping(value = "/insert.do")
			@ResponseBody
			public  Map<String, Object> insert(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String> Data ) throws IOException, ParseException{
						request.setCharacterEncoding("utf-8");
						response.setContentType("application/json;charset=utf-8");
						String noticeContent = Data.get("noticeContent");
						Date noticeTime  = new Date();
						SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
				        Notice notice = new Notice();
				        notice.setNoticeContent(noticeContent);
				        notice.setNoticeType("0");
				        notice.setNoticeTime(dateFormat.parse(dateFormat.format(noticeTime)));
				        int i = noticeService.InsertNotice(notice);
						Map<String, Object>map = new HashMap<String, Object>();
						map.put("i",i);
						return map;
			}
			
			//查询公告
			@RequestMapping(value = "/selectGg.do")
			@ResponseBody
			public  Map<String, Object> select(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String> Data ) throws IOException, ParseException{
				request.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				List<Notice> noticelist = noticeService.SelectNotice();
				Map<String, Object>map = new HashMap<String, Object>();
				map.put("list",noticelist);
				return map;
			}
			//获取所有公告
			@RequestMapping(value = "/getNotice.do")
			@ResponseBody
			public  Map<String, Object> noticeContent(@RequestParam(value="page")Integer page,@RequestParam(value="limit")Integer limit) {
				Map<String, Object>map = new HashMap<String, Object>();
				page = (page-1) * limit;
				List<Notice> list = noticeService.getNotice(page,limit);
				Long countItem = noticeService.countNotice();
				map.put("data", list);
				map.put("total", countItem);
				map.put("code", 0);
				return map;
			}
			
			/**
			 * 删除某个公告
			 * @param data
			 * @renotice
			 */
			@PostMapping("/deleteNotice.do")
			@ResponseBody
			public Map<String, Object> deleteNotice(@RequestBody Map<String,String> data){
				Map<String, Object>map = new HashMap<String, Object>();
				Integer noticeId = Integer.parseInt(data.get("idsStr"));
				noticeService.deleteNotice(noticeId);
				map.put("code", 0);
				return map;
			}
			
			/**
			 * 批量删除公告
			 * @param data
			 * @renotice
			 */
			@PostMapping("/batchDelNotice.do")
			@ResponseBody
			public Map<String, Object> batchDelNotice(@RequestBody Map<String,Object> data){
				Map<String, Object>map = new HashMap<String, Object>();
				List<Integer>nidLst = (List<Integer>) data.get("noticeLists");
				noticeService.batchDelNotice(nidLst);
				map.put("code", 0);
				return map;
			}
}

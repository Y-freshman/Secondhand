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

import com.schoolTao.dao.NeedMapper;
import com.schoolTao.pojo.Comment;
import com.schoolTao.pojo.User;
import com.schoolTao.service.CommentService;
import com.schoolTao.service.CommentService;

@Controller
@RequestMapping("/comment" )
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	
			//插入评论
			@RequestMapping(value = "/insert.do")
			@ResponseBody
			public  Map<String, Object> insert(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String> Data ) throws IOException, ParseException{
						request.setCharacterEncoding("utf-8");
						response.setContentType("application/json;charset=utf-8");
						String commentContent = Data.get("commentContent");
						int userId = Integer.parseInt(Data.get("userId"));
						int needId = Integer.parseInt(Data.get("needId"));
						Date commentTime  = new Date();
						SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
				        Comment comment = new Comment();
				        comment.setCommentContent(commentContent);
				        comment.setCommentLikeNum(0);
				        comment.setNeedId(needId);
				        comment.setUserId(userId);
				        comment.setCommentTime(dateFormat.parse(dateFormat.format(commentTime)));
				        int i = commentService.InsertComment(comment,needId);
						Map<String, Object>map = new HashMap<String, Object>();
						map.put("i",i);
						return map;
			}
			//评论点赞
			@RequestMapping(value = "/update.do")
			@ResponseBody
			public  Map<String, Object> update(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String> Data ) throws IOException, ParseException{
				request.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				int commentId = Integer.parseInt(Data.get("commentId"));
				commentService.UpdateComment(commentId);
				Map<String, Object>map = new HashMap<String, Object>();
				map.put("i",1);
				return map;
			}
			//查询评论
			@RequestMapping(value = "/select.do")
			@ResponseBody
			public  Map<String, Object> select(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String> Data ) throws IOException, ParseException{
				request.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				int needId = Integer.parseInt(Data.get("needId"));
				List<Comment> commentlist = commentService.SelectComment(needId);
				Map<String, Object>map = new HashMap<String, Object>();
				map.put("list",commentlist);
				return map;
			}
			
			//获取所有评论
			@RequestMapping(value = "/getComment.do")
			@ResponseBody
			public  Map<String, Object> commentContent(@RequestParam(value="page")Integer page,@RequestParam(value="limit")Integer limit) {
				Map<String, Object>map = new HashMap<String, Object>();
				page = (page-1) * limit;
				List<Comment> list = commentService.getComment(page,limit);
				Long countItem = commentService.countComment();
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
			@PostMapping("/deleteComment.do")
			@ResponseBody
			public Map<String, Object> deleteComment(@RequestBody Map<String,String> data){
				Map<String, Object>map = new HashMap<String, Object>();
				Integer commentId = Integer.parseInt(data.get("idsStr"));
				commentService.deleteComment(commentId);
				map.put("code", 0);
				return map;
			}
			
			/**
			 * 批量删除求购
			 * @param data
			 * @return
			 */
			@PostMapping("/batchDelComment.do")
			@ResponseBody
			public Map<String, Object> batchDelComment(@RequestBody Map<String,Object> data){
				Map<String, Object>map = new HashMap<String, Object>();
				List<Integer>cidLst = (List<Integer>) data.get("commentLists");
				commentService.batchDelComment(cidLst);
				map.put("code", 0);
				return map;
			}
}

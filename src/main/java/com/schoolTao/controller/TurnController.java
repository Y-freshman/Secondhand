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

import com.schoolTao.pojo.Need;
import com.schoolTao.pojo.Turn;
import com.schoolTao.service.TurnService;

@Controller
@RequestMapping("/turn" )
public class TurnController {
	
	@Autowired
	TurnService turnService;
	
			//插入轮播图
			@RequestMapping(value = "/insert.do")
			@ResponseBody
			public  Map<String, Object> insert(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String> Data ) throws IOException, ParseException{
						request.setCharacterEncoding("utf-8");
						response.setContentType("application/json;charset=utf-8");
						String turnPic = Data.get("turnPic");
						int goodsId = Integer.parseInt(Data.get("goodsId"));
						Date turnTime  = new Date();
						SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
				        Turn turn = new Turn();
				        turn.setGoodsId(goodsId);
				        turn.setTurnPic(turnPic);
				        turn.setTurnTime(dateFormat.parse(dateFormat.format(turnTime)));
				        int i = turnService.InsertTurn(turn);
						Map<String, Object>map = new HashMap<String, Object>();
						map.put("i",i);
						return map;
			}
			
			//查询轮播图
			@RequestMapping(value = "/select.do")
			@ResponseBody
			public  Map<String, Object> select(HttpServletRequest request,HttpServletResponse response,@RequestBody Map<String,String> Data ) throws IOException, ParseException{
				request.setCharacterEncoding("utf-8");
				response.setContentType("application/json;charset=utf-8");
				List<Turn> turnlist = turnService.SelectTurn();
				Map<String, Object>map = new HashMap<String, Object>();
				map.put("list",turnlist);
				return map;
			}
			
			//获取所有轮播图
			@RequestMapping(value = "/getTurn.do")
			@ResponseBody
			public  Map<String, Object> turnContent(@RequestParam(value="page")Integer page,@RequestParam(value="limit")Integer limit) {
				Map<String, Object>map = new HashMap<String, Object>();
				page = (page-1) * limit;
				List<Turn> list = turnService.getTurn(page,limit);
				Long countItem = turnService.countTurn();
				map.put("data", list);
				map.put("total", countItem);
				map.put("code", 0);
				return map;
			}
			
			/**
			 * 删除某个轮播图
			 * @param data
			 * @return
			 */
			@PostMapping("/deleteTurn.do")
			@ResponseBody
			public Map<String, Object> deleteTurn(@RequestBody Map<String,String> data){
				Map<String, Object>map = new HashMap<String, Object>();
				Integer turnId = Integer.parseInt(data.get("idsStr"));
				turnService.deleteTurn(turnId);
				map.put("code", 0);
				return map;
			}
			
			/**
			 * 批量删除轮播图
			 * @param data
			 * @return
			 */
			@PostMapping("/batchDelTurn.do")
			@ResponseBody
			public Map<String, Object> batchDelTurn(@RequestBody Map<String,Object> data){
				Map<String, Object>map = new HashMap<String, Object>();
				List<Integer>nidLst = (List<Integer>) data.get("turnLists");
				turnService.batchDelTurn(nidLst);
				map.put("code", 0);
				return map;
			}
}

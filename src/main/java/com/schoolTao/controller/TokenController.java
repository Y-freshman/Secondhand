package com.schoolTao.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.schoolTao.utils.QiniuUtil;

@Controller
public class TokenController {
	

		@RequestMapping(value = "/token.do")
		@ResponseBody
		public Map<String, Object> token(HttpServletRequest request, HttpServletResponse response,@RequestBody Map<String,String> dreamData) throws Exception {
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String fileName=dreamData.get("fileName");
			
			String key = new Date().getTime()+fileName;
			//System.out.println(key);
			Map<String, Object>map = new HashMap<String, Object>();
			String token = QiniuUtil.getToken(key); 	// 生成普通上传的Token
			map.put("token", token);
			map.put("key", key);
			return map;
			
		}
		

}

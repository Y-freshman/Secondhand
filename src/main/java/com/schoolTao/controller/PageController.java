package com.schoolTao.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
		//链接
		@RequestMapping("/login.do")
		public String tiaozhuan1()throws IOException{
			return "login";
		}
		//链接
		@RequestMapping("/reset.do")
		public String tiaozhuan2()throws IOException{
			return "reset";
		}
		//链接
		@RequestMapping("/register.do")
		public String tiaozhuan3()throws IOException{
			return "register";
		}
		//链接
		@RequestMapping("/fabuqiugou.do")
		public String tiaozhuan4()throws IOException{
			return "fabuqiugou";
		}
		//链接
		@RequestMapping("/purchaseCar.do")
		public String tiaozhuan5()throws IOException{
			return "purchaseCar";
		}
		//链接
		@RequestMapping("/publishGoods.do")
		public String tiaozhuan6()throws IOException{
			return "publishGoods";
		}
		//链接
		@RequestMapping("/personalCenter.do")
		public String tiaozhuan7()throws IOException{
			return "personalCenter";
		}
		//链接
		@RequestMapping("/messageRm.do")
		public String tiaozhuan8()throws IOException{
			return "messageRm";
		}
		//链接
		@RequestMapping("/orderForm.do")
		public String tiaozhuan9()throws IOException{
			return "orderForm";
		}
		//链接
		@RequestMapping("/qiugou.do")
		public String tiaozhuan10()throws IOException{
			return "qiugou";
		}
		//链接
		@RequestMapping("/search.do")
		public String tiaozhuan11()throws IOException{
			return "search";
		}
		//链接
		@RequestMapping("/selfInfo.do")
		public String tiaozhuan12()throws IOException{
			return "selfInfo";
		}
		
		//链接
		@RequestMapping("/gdsDetail.do")
		public String tiaozhuan13()throws IOException{
			return "goodsDetail";
		}
		
		//链接
		@RequestMapping("/typePage.do")
		public String tiaozhuan14()throws IOException{
			return "typePage";
		}
		
		//链接
		@RequestMapping("/myqiugou.do")
		public String tiaozhuan15()throws IOException{
			return "myqiugou";
		}
		
		//链接
		@RequestMapping("/mygoods.do")
		public String tiaozhuan16()throws IOException{
			return "mygoods";
		}
		
		
}

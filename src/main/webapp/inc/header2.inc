<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="shouye_db">
﻿<el-row :gutter="20" class="shouye_db" >
			   <el-col :span="6" :offset="1">
			  	<el-link v-if="username != '' " type="success" href="/home/personalCenter.do">欢迎您：{{username}}</el-link>  &emsp;&emsp; </el-link  v-if="username != '' " >
			  	<el-link v-if="username == '' " type="success" href="/home/login.do">[请登录]</el-link>
			  </el-col>
			  <el-col :span="3" :offset="7">
			  	<el-link v-if="username != '' " icon="el-icon-shopping-bag-1" href="/home/orderForm.do">我的订单</el-link>
			  	<el-link v-if="username == '' " icon="el-icon-shopping-bag-1" href="/home/login.do">我的订单</el-link>
			  </el-col>
			  <el-col :span="4">
			  	<el-link >在线客服/35135435</el-link>
			  </el-col>
			  <el-col :span="3">
			  	<el-link  v-if="username != '' "  icon="el-icon-shopping-cart-full" href="/home/purchaseCar.do">购物车({{cartNums}})</el-link>
			  	<el-link  v-if="username == '' "  icon="el-icon-shopping-cart-full" href="/home/login.do">购物车</el-link>
			  </el-col>
		</el-row>
		<el-container>
		  <el-header height="auto" >
		  	<el-row type="flex" >
			  <el-col :span="12">
	  			<el-image src="img/icon_1.png" class="shouye_tubiao"  lazy></el-image>
	  			<span class="shouye_tubiao2" title="返回首页" @click="goSy2()" >
	  				校园二手淘<br>schooltao.com
	  			</span>
			  </el-col>
			  <el-col :span="12">
				<div class="grid-content ">
				  	<div style="margin-top: 15px;">
					  <el-input placeholder="请输入你想要的商品"  class="input-with-select" v-model="input">
					    <el-button slot="append"  @click="search()" type="primary"  icon="el-icon-search" style="background-color: #409EFF; color: white;">搜索</el-button>
					  </el-input>
					</div>
				</div>
			  </el-col>
			</el-row>
		  	
		  </el-header>
		</el-container>
  </div>
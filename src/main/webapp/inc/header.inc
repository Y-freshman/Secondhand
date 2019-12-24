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
	  			<span class="shouye_tubiao2" >
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
		  	<el-row type="flex" justify="center" style="margin-bottom:0">
			  <el-col :span="3" :offset="1">
	  				<el-dropdown :hide-on-click="false" trigger="click" >
					  <span class="el-dropdown-link shouye_fl" style="box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)">
					   <i class="el-icon-s-grid"></i>全部分类
					  </span>
					  <el-dropdown-menu slot="dropdown" style="width:150px;text-align: center;background-color: rgba(0,0,0,0.5);">
					    <el-dropdown-item onclick="typePage('电子数码')">电子数码</el-dropdown-item>
					    <el-dropdown-item onclick="typePage('服装首饰')" divided>服装首饰</el-dropdown-item>
					    <el-dropdown-item onclick="typePage('酒水零食')" divided>酒水零食</el-dropdown-item>
					    <el-dropdown-item onclick="typePage('文具图书')" divided>文具图书</el-dropdown-item>
					    <el-dropdown-item onclick="typePage('生鲜食材')" divided>生鲜食材</el-dropdown-item>
					    <el-dropdown-item onclick="typePage('体育健身')" divided>体育健身</el-dropdown-item>
					    <el-dropdown-item onclick="typePage('卫生洁具')" divided>卫生洁具</el-dropdown-item>
					    <el-dropdown-item onclick="typePage('妇女婴幼')" divided>妇女婴幼</el-dropdown-item>
					    <el-dropdown-item onclick="typePage('办公家居')" divided>办公家居</el-dropdown-item>
					  </el-dropdown-menu>
					</el-dropdown>
			  </el-col>
			  <el-col :span="5" :offset="1">
	  			<el-tabs v-model="value">
				    <el-tab-pane name="sy">
					   <span slot="label"  @click="goSy()"><el-link href="/home/index.jsp"> <i class="el-icon-s-home"></i>首页</el-link></span>
					</el-tab-pane>
				    <el-tab-pane name="qg">
					   <span slot="label" @click="goQg()"><el-link href="/home/qiugou.do"><i class="el-icon-s-flag"></i> 求购</el-link></span>
					</el-tab-pane>
				    
				  </el-tabs>
			  </el-col>
			  <el-col :span="14" style="font-size:14px;margin-top:10px">
				   <el-carousel style="float:right;width:300px;color:#666;"height="30px" direction="vertical" :autoplay="true"  indicator-position="none">
				    <el-carousel-item  v-for="(item,index) in notice" v-bind:key="item.noticeId">
				      <el-link  @click="alert(index)"><span class="truncate" style="width:300px">{{item.noticeContent}}</span></el-link>
				    </el-carousel-item>
				   </el-carousel>
				   <span style="float:right;color:#999;"><i class="el-icon-bell"></i>通告：</span>
			  </el-col>
			  
			</el-row>
		  </el-header>
		</el-container>
		<el-dialog
		  title="公告 "
		  :visible.sync="dialogVisible"
		  width="30%"
		  >
		  <span style="line-height: 25px;">&emsp;&emsp;{{noticeXq.noticeContent}}</span>
		  <span slot="footer" class="dialog-footer">
		  	<span style="float:left;margin-top: 15px;color: #666;font-size: 14px;">[ {{noticeXq.noticeTime|date}} ]</span>
		    <el-button @click="dialogVisible = false">取 消</el-button>
		    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
		  </span>
		</el-dialog>
  </div>
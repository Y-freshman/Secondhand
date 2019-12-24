<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
<link rel="shortcut icon" href="img/icon_3.png" type="image/png" />
<link rel="stylesheet" href="css/element.css">
<link rel="stylesheet" href="css/fonts/element-icons.woff">
<link rel="stylesheet" href="css/goodsDetail.css">
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<%@include file="/inc/header2.inc"%>
	<div id="goodsDetail">
		<div class="gd_main">
			<el-container>
			  <el-container>
			    <el-aside width="480px">	
					<el-image :src="goods.goodsPics[0]" fit="contain"  style="width:400px;height:330px;margin-top: 10px;"></el-image>
					<el-row>
					  <el-col :span="6" v-for="(item,index) in goods.goodsPics" v-bind:key="index" ><div class="grid-content bg-purple">
					  	<div class="demo-image__preview"  >
			  				<el-image  :src="item"  :preview-src-list="goods.goodsPics"></el-image>
			  			</div>
					  	
					  </div></el-col>
					  
					</el-row>
				</el-aside>
			    <el-container>
			      <el-main style="padding-top:0">
					<p><b style="font-size: 18px">{{goods.goodsName}}</b></p>
					<div class="gd_price">
						<p><span class="gd_detail_item">物品价格:</span>
							<span class="gd_detail_price">￥{{goods.goodsNewPrice}}</span>
							<s>￥{{goods.goodsOldPrice}}</s></p>
						<p><span class="gd_detail_item">物品现状:</span>
							<span class="gd_detail_status item_info">{{goods.goodsFresh|xinxian}}</span></p>
						<p><span class="gd_detail_item">可交易地点:</span>
							<span class="gd_detail_address item_info">无</span></p>
						<p><span class="gd_detail_item">上架时间:</span>
							<span class="gd_detail_time item_info">{{goods.goodsTime|date}}</span></p>
						<p><span class="gd_detail_item">联系人:</span>
							<span class="gd_detail_people item_info">{{goods.goodsUserName}}（{{goods.goodsUserPhone}}）</span></p>
						<template>
						  <span class="gd_detail_item">商品货存:&emsp;&emsp;&emsp;&emsp;</span>
						  <!-- <el-input-number @change="handleChange" controls-position="right" :min="1" :max="goods.goodsNum" label="描述文字"></el-input-number> -->
						  <span style="color: #3a8ee6;font-weight: 600;font-size: 16px;">{{goods.goodsNum}}</span>
						</template>
						<el-row style="margin-top:40px">
						  <el-button type="danger" icon="el-icon-wallet"  style="font-size: 16px;" @click="buynow()">
						  	立即购买
						  </el-button>
						  <el-popover
							  placement="top"
							  width="300"
							  v-model="visible">
							  <p>购买数量：<el-input-number v-model="num" @change="handleChange" :min="1" :max="goods.goodsNum" label="描述文字"></el-input-number></p>
							  <div style="text-align: right; margin: 0">
							    <el-button size="mini" type="text" @click="visible = false">取消</el-button>
							    <el-button type="primary" size="mini" @click="cart()">确定</el-button>
							  </div>
							  <el-button slot="reference" type="primary" icon="el-icon-shopping-cart-full" style="font-size: 16px;">加入购物车</el-button>
						  </el-popover>
						  <el-dialog title="金额结算" :visible.sync="dialogFormVisible" width="40%">
					    	  <img src="img/erweima.jpg"  style="width: 200px;display: block;margin: 0 auto;"/>
							  <div slot="footer" class="dialog-footer">
							    <el-button @click="monenyCancel">取 消</el-button>
							    <el-button type="primary" @click="moneyConfirm">确 定</el-button>
							  </div>
						  </el-dialog>
						</el-row>
					</div>
				  </el-main>
			    </el-container>
			  </el-container>
			</el-container>
		</div>
		<%@include file="/inc/footer.inc"%>
	</div>
</body>
<script src="js/vue.js"></script>
<script src="js/element.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/goodsDetail.js"></script>
<script src="js/header.js"></script>
</html>
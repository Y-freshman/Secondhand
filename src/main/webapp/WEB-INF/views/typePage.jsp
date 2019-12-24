<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0, user-scalable=no">
<title>校园二手淘</title>
<link rel="shortcut icon" href="/home/img/icon_3.png" type="image/png" />
<link rel="stylesheet" href="/home/css/element.css">
<link rel="stylesheet" href="/home/css/index.css">
<link rel="stylesheet" href="/home/css/typePage.css">
</head>
<body>
	<%@include file="/inc/header2.inc"%>
	<div id="typePage">
		<el-container>
		  <el-main style="background: linear-gradient(to bottom, #fff , #eee);min-height:400px;padding-top: 0px;">
		  	
		  	<el-row :gutter="20" >
			  <el-col :span="10"  style="text-align:left">
			  	<span class="bt" ><span @click="back" style="cursor: pointer;">首页</span> > {{name}}</span>
			  </el-col>
			</el-row>
		  	<el-row :gutter="20" >
			  <el-col :span="24"  >
			  	 <el-col :span="8" >
			  		<el-card style="margin-bottom:20px" v-for="(item,index) in items1" v-bind:key="item.goodsId">
				  	<div style="float: left;height: 130px" class="hot_top">
				  		<div style="float: left;width:40%">
				  			<el-image :src="item.goodsPics[0]"  fit="contain" style="height:130px;" lazy></el-image>
				  		</div>
				  		<div style="float: left;margin-left: 5px;width:50%">
				  			<div style="height: 98px;margin-top: 3px">
				  				<el-link class="truncate3 " @click="toGoods(item.goodsId)">{{item.goodsName}}</el-link>
				  			</div>
				  			<div><b style="color: #673AB7;float: right;">￥{{item.goodsNewPrice}}.00</b>
				  			<span  style="color: #999;font-size: 13px;margin-top: 5px;float: left;">
				  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i><span style="font-size: 12px">加至购物车</span></el-link></span>
				  			</div>
				  		</div>
				  	</div>
				   </el-card>
			    </el-col>
			  	 <el-col :span="8" >
			  		<el-card style="margin-bottom:20px" v-for="(item,index) in items2" v-bind:key="item.goodsId">
				  	<div style="float: left;height: 130px" class="hot_top">
				  		<div style="float: left;width:40%">
				  			<el-image :src="item.goodsPics[0]"  fit="contain" style="height:130px;" lazy></el-image>
				  		</div>
				  		<div style="float: left;margin-left: 5px;width:50%">
				  			<div style="height: 98px;margin-top: 3px">
				  				<el-link class="truncate3 " @click="toGoods(item.goodsId)">{{item.goodsName}}</el-link>
				  			</div>
				  			<div><b style="color: #673AB7;float: right;">￥{{item.goodsNewPrice}}.00</b>
				  			<span  style="color: #999;font-size: 13px;margin-top: 5px;float: left;">
				  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i><span style="font-size: 12px">加至购物车</span></el-link></span>
				  			</div>
				  		</div>
				  	</div>
				   </el-card>
			    </el-col>
			  	 <el-col :span="8" >
			  		<el-card style="margin-bottom:20px" v-for="(item,index) in items3" v-bind:key="item.goodsId">
				  	<div style="float: left;height: 130px" class="hot_top">
				  		<div style="float: left;width:40%">
				  			<el-image :src="item.goodsPics[0]"  fit="contain" style="height:130px;" lazy></el-image>
				  		</div>
				  		<div style="float: left;margin-left: 5px;width:50%">
				  			<div style="height: 98px;margin-top: 3px">
				  				<el-link class="truncate3 " @click="toGoods(item.goodsId)">{{item.goodsName}}</el-link>
				  			</div>
				  			<div><b style="color: #673AB7;float: right;">￥{{item.goodsNewPrice}}.00</b>
				  			<span  style="color: #999;font-size: 13px;margin-top: 5px;float: left;">
				  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i><span style="font-size: 12px">加至购物车</span></el-link></span>
				  			</div>
				  		</div>
				  	</div>
				   </el-card>
			    </el-col>
			  </el-col>
			</el-row>
		  	
		  </el-main>
		</el-container>
	<%@include file="/inc/footer.inc"%>
	</div>
</body>
<script src="/home/js/vue.js"></script>
<script src="/home/js/element.js"></script>
<script src="/home/js/jquery.min.js"></script>
<script src="/home/js/typePage.js"></script>
<script src="/home/js/header.js"></script>
</html>
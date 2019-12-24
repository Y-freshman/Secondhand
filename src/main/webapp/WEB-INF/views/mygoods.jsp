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
<link rel="stylesheet" href="/home/css/mygoods.css">
</head>
<body>
	<%@include file="/inc/header2.inc"%>
	<div id="mygoods">
		<el-container>
		  <el-main style="background: linear-gradient(to bottom, #fff , #eee);">
		  	<el-row :gutter="20" >
			  <el-col :span="24"  >
			  	<el-tabs type="border-card">
				  <el-tab-pane >
				    <span slot="label"  @click="type(0)">全部 {{qb}}<i class="el-icon-download"></i> </span>
				  </el-tab-pane>
				  <el-tab-pane>
				    <span slot="label" @click="type(1)">电子数码 {{dzsm}} </span>
				  </el-tab-pane>
				  <el-tab-pane>
				    <span slot="label" @click="type(2)">服装首饰 {{fzss}} </span>
				  </el-tab-pane>
				  <el-tab-pane>
				    <span slot="label" @click="type(3)">酒水零食 {{jsls}} </span>
				  </el-tab-pane>
				  <el-tab-pane>
				    <span slot="label" @click="type(4)">文具图书 {{wjts}} </span>
				  </el-tab-pane>
				  <el-tab-pane>
				    <span slot="label" @click="type(5)">生鲜食材 {{sxsc}} </span>
				  </el-tab-pane>
				  <el-tab-pane>
				    <span slot="label" @click="type(6)">体育健身 {{tyjs}} </span>
				  </el-tab-pane>
				  <el-tab-pane>
				    <span slot="label" @click="type(7)">卫生洁具 {{wsjj}} </span>
				  </el-tab-pane>
				  <el-tab-pane>
				    <span slot="label" @click="type(8)">妇女婴幼 {{fnyy}} </span>
				  </el-tab-pane>
				  <el-tab-pane>
				    <span slot="label" @click="type(9)">办公家居 {{bgjj}} </span>
				  </el-tab-pane>
				</el-tabs>
			  </el-col>
			</el-row>
		  	<el-row :gutter="20"  v-if="qb == 0" style="margin-top:40px">
			  <el-col :span="4"  :offset="10">
			  	<el-image src="img/kong.png"  fit="contain" style="width:100%;" lazy></el-image>
			  </el-col>
			</el-row>
		  	<el-row :gutter="20"  v-loading="loading" style="min-height:100px">
			 <el-col :span="22" :offset="1">
			  <el-col :span="5" :offset="2">
			  		<el-card v-for="item in items1" v-bind:key="item.goodsId" style="margin-bottom:20px">
					  	<div style="float: left;height: 200px">
					  		<div >
					  			<el-image :src="item.goodsPics[0]"  fit="contain" style="height:130px;" lazy></el-image>
					  		</div>
					  		<div style="margin-top: 10px;height:70px;">
					  			<div style="height: 40px;overflow: hidden;margin-bottom: 5px;">
					  				<el-link class="truncate2" @click="toGoods(item.goodsId)">{{item.goodsName}}</el-link>
					  			</div>
					  			<div><b style="color: #673AB7;float: left;">￥{{item.goodsNewPrice}}.00</b>
					  			<span style="color: #999;font-size: 13px;float: right;margin-top: 5px;margin-left: -5px">
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-delete"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
		  		<el-col :span="5" >
			  		<el-card v-for="item in items2" v-bind:key="item.goodsId" style="margin-bottom:20px">
					  	<div style="float: left;height: 200px">
					  		<div >
					  			<el-image :src="item.goodsPics[0]"  fit="contain" style="height:130px;" lazy></el-image>
					  		</div>
					  		<div style="margin-top: 10px;height:70px;">
					  			<div style="height: 40px;overflow: hidden;margin-bottom: 5px;">
					  				<el-link class="truncate2" @click="toGoods(item.goodsId)">{{item.goodsName}}</el-link>
					  			</div>
					  			<div><b style="color: #673AB7;float: left;">￥{{item.goodsNewPrice}}.00</b>
					  			<span style="color: #999;font-size: 13px;float: right;margin-top: 5px;margin-left: -5px">
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-delete"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
		  		<el-col :span="5" >
			  		<el-card v-for="item in items3" v-bind:key="item.goodsId" style="margin-bottom:20px">
					  	<div style="float: left;height: 200px">
					  		<div >
					  			<el-image :src="item.goodsPics[0]"  fit="contain" style="height:130px;" lazy></el-image>
					  		</div>
					  		<div style="margin-top: 10px;height:70px;">
					  			<div style="height: 40px;overflow: hidden;margin-bottom: 5px;">
					  				<el-link class="truncate2" @click="toGoods(item.goodsId)">{{item.goodsName}}</el-link>
					  			</div>
					  			<div><b style="color: #673AB7;float: left;">￥{{item.goodsNewPrice}}.00</b>
					  			<span style="color: #999;font-size: 13px;float: right;margin-top: 5px;margin-left: -5px">
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-delete"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
		  		<el-col :span="5" >
			  		<el-card v-for="item in items4" v-bind:key="item.goodsId" style="margin-bottom:20px">
					  	<div style="float: left;height: 200px">
					  		<div >
					  			<el-image :src="item.goodsPics[0]"  fit="contain" style="height:130px;" lazy></el-image>
					  		</div>
					  		<div style="margin-top: 10px;height:70px;">
					  			<div style="height: 40px;overflow: hidden;margin-bottom: 5px;">
					  				<el-link class="truncate2" @click="toGoods(item.goodsId)">{{item.goodsName}}</el-link>
					  			</div>
					  			<div><b style="color: #673AB7;float: left;">￥{{item.goodsNewPrice}}.00</b>
					  			<span style="color: #999;font-size: 13px;float: right;margin-top: 5px;margin-left: -5px">
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-delete"></i></el-link>
					  			</span></div>
					  			
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
<script src="/home/js/mygoods.js"></script>
<script src="/home/js/header.js"></script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
<link rel="shortcut icon" href="/home/img/icon_3.png" type="image/png" />
<link rel="stylesheet" href="/home/css/element.css">
<link rel="stylesheet" href="/home/css/fonts/element-icons.woff">
<link rel="stylesheet" href="/home/css/purchaseCar.css">
<link rel="stylesheet" href="/home/css/index.css">
</head>
<body>
	<%@include file="/inc/header2.inc"%>
	<div id="purchaseCar" style="min-height:400px">
		<template >
		  <el-table ref="multipleTable" 
		  :data="tableData" 
		  tooltip-effect="dark" 
		  border 
		  style="width: 100%;border:1px solid rgb(72, 115, 172);"
		   @selection-change="handleSelectionChange">
		    <el-table-column type="selection" width="45" style="border:1px solid rgb(72, 115, 172);"> </el-table-column>
		    <el-table-column label="商品信息" width="550">
		    	<template slot-scope="scope">
			        <el-row>
					  <el-col :span="8"><div class="grid-content">
					  	<img :src="scope.row.goodsPics[0]" class="head_pic"/>
					  </div></el-col>
					  <el-col :span="8"><div class="grid-content" style="margin-left: -20px;margin-top: 10px;">
					  	<el-link :underline="false" target="_blank" @click="toDetail(scope.row.goodsId)">
					  		{{ scope.row.goodsName }}
					  	</el-link>
					  </div></el-col>
					  <el-col :span="8"><div class="grid-content size" style="margin-left: 20px;margin-top:3px;">
					  	<!-- <i class="el-icon-edit" @click="gdMdfySize" class="gd_mdfy_size"></i> -->
					  	<p style="margin-top: 0px;"><s>￥{{ scope.row.goodsOldPrice }}</s></p>
					  	<p style="margin-top: -10px;">{{ scope.row.goodsFresh|xinxian }}</p>
					  	<p style="margin-top: -10px;">{{ scope.row.goodsState|state }}</p>
					  </div></el-col>
					</el-row>
			    </template>
		    </el-table-column>
		    <el-table-column label="卖家" width="151"> 
	    		<template slot-scope="scope">
	    			<el-link type="primary">
		        	{{ scope.row.goodsUserName }}
		        	</el-link>
    			</template>
		    </el-table-column>
		    <el-table-column label="数量" width="40">
		    	<template slot-scope="scope">
		        	<span class="purchaseCar_num">{{ scope.row.cartGoodsNum }}</span>
    			</template>
		    </el-table-column>
		    <el-table-column label="金额" width="121">
		    	<template slot-scope="scope">
		        	<span class="purchaseCar_sum">￥{{ scope.row.goodsNewPrice }}</span>
    			</template>
		    </el-table-column>
		    <el-table-column label="操作" width="111" show-overflow-tooltip> 
		    	<template slot-scope="scope">
			        <el-button @click.native.prevent="deleteRow(scope.$index,scope.row.cartId)"
			          type="text" size="small">
			          <el-link type="danger">删除</el-link>
			        </el-button>
      			</template>
		    </el-table-column>
		  </el-table>
		  <div style="margin-top: 20px" class="purchase_submit">
		  	<el-col :span="12">
			    <el-button type="primary" @click="toggleSelection(tableData)">切换选中</el-button>
			    <el-button type="warning" @click="deleteRows">删除所选项</el-button>
		    </el-col>
		    <el-col :span="12"  style="text-align:right;color: #555;font-size: 16px;font-weight: 600;">
		    	<el-col :span="8" style="padding-top: 8px;">
		    		<span>已选择商品&ensp;
		    		<span class="gd_num">{{num1}}</span>&ensp;件
		    	&emsp;&emsp;&emsp;</span>
		    	</el-col>
		    	<el-col :span="8" style="padding-top: 8px;">
		    		合计： <span style="font-size:20px;font-weight:600;color:#f56c6b;">
		    		￥<span class="sum_price">{{num2}}</span>&ensp;
		    		</span>
		    	</el-col>
		    	<el-col :span="8">
		    		<el-button type="danger" @click="firstConfirm">&emsp;结算&emsp;</el-button>
		    	</el-col>
		    	<el-dialog title="金额结算" :visible.sync="dialogFormVisible" width="40%">
		    	  <img src="img/erweima.jpg"  style="width: 200px;display: block;margin: 0 auto;"/>
				  <div slot="footer" class="dialog-footer">
				    <el-button @click="dialogFormVisible = false">取 消</el-button>
				    <el-button type="primary" @click="moneyConfirm">确 定</el-button>
				  </div>
				</el-dialog>
		    </el-col>
		  </div>
		</template>
	</div>
	<%@include file="/inc/footer.inc"%>
</body>
<script src="/home/js/vue.js"></script>
<script src="/home/js/element.js"></script>
<script src="/home/js/jquery.min.js"></script>
<script src="/home/js/purchaseCar.js"></script>
<script src="/home/js/header.js"></script>
</html>
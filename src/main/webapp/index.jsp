<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0, user-scalable=no">
<title>校园二手淘</title>
<link rel="shortcut icon" href="img/icon_3.png" type="image/png" />
<link rel="stylesheet" href="css/element.css">
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<%@include file="/inc/header.inc"%>
	<div id="shouye">
		
		<div >
		  	  <el-carousel indicator-position="outside" height="350px">
			    <el-carousel-item style="text-align:center;" v-for="item in lbt" v-bind:key="item.turnId">
			      <el-image @click="toGoods(item.goodsId)" :src="item.turnPic"   fit="cover" style="min-width:70%;max-width:95%;"></el-image>
			    </el-carousel-item>
			  </el-carousel>
		</div>
		<el-container>
		  <el-main style="background: linear-gradient(to bottom, #fff , #eee);">
		  	<el-row :gutter="20" >
		  		<el-col :span="15" :offset="1">
		  		|<b id="shouye_eqph" class="shouye_zl">人气排行</b>
		  		</el-col>
		  		<el-col :span="7" >
		  		|<b id="shouye_qg" class="shouye_zl">求购</b>
		  		</el-col>
		  	</el-row>
		  	<el-row :gutter="20" >
			  <el-col :span="15"  :offset="1">
			  <el-row :gutter="20" >
			  <el-col :span="12" >  
			   <el-card style="margin-bottom:10px" v-for="(item,index) in hot1" v-bind:key="item.goodsId">
			  	<div style="float: left;height: 130px" class="hot_top">
			  		<div style="float: left;width:40%">
			  			<el-image :src="item.goodsPics[0]"  fit="contain" style="height:130px;" lazy></el-image>
			  		</div>
			  		<div style="float: left;margin-left: 5px;width:50%">
			  			<div style="height: 98px;margin-top: 3px">
			  				<el-link class="truncate3 " @click="toGoods(item.goodsId)">{{item.goodsName}}</el-link>
			  			</div>
			  			<div><b style="color: #673AB7;float: right;">￥{{item.goodsNewPrice}}.00</b>
			  			<span class="hot_top_viewNum" style="color: #999;font-size: 13px;margin-top: 5px;float: left;">
			  			<i class="el-icon-view"></i> {{item.goodsViewNum}}</span>
			  			<span class="hot_top_pchaseCar" style="color: #999;font-size: 13px;margin-top: 5px;float: left;">
			  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i><span style="font-size: 12px">加至购物车</span></el-link></span>
			  			
			  			</div>
			  			
			  		</div>
			  	</div>
			   </el-card>
			  </el-col>
			  <el-col :span="12" >
			   <el-card style="margin-bottom:10px" v-for="(item,index) in hot2" v-bind:key="item.goodsId">
			  	<div style="float: left;height: 130px" class="hot_top">
			  		<div style="float: left;width:40%">
			  			<el-image :src="item.goodsPics[0]"  fit="contain" style="height:130px;" lazy></el-image>
			  		</div>
			  		<div style="float: left;margin-left: 5px;width:50%">
			  			<div style="height: 98px;margin-top: 3px">
			  				<el-link class="truncate3 " @click="toGoods(item.goodsId)">{{item.goodsName}}</el-link>
			  			</div>
			  			<div><b style="color: #673AB7;float: right;">￥{{item.goodsNewPrice}}.00</b>
			  			<span class="hot_top_viewNum" style="color: #999;font-size: 13px;margin-top: 5px;float: left;">
			  			<i class="el-icon-view"></i> {{item.goodsViewNum}}</span>
			  			<span class="hot_top_pchaseCar" style="color: #999;font-size: 13px;margin-top: 5px;float: left;">
			  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i><span style="font-size: 12px">加至购物车</span></el-link></span>
			  			
			  			</div>
			  			
			  		</div>
			  	</div>
			   </el-card>
			  </el-col>
			  
			 </el-row>
			 <el-row :gutter="20" >
		  		<el-col :span="24" >
		  		|<b id="shouye_dzsm" class="shouye_zl">电子数码</b>
		  		</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="dzsm1.length>1" >
		  		<el-col :span="6" v-for="(item,index) in dzsm1" v-bind:key="item.goodsId">
			  		<el-card >
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="dzsm2.length>1" >
		  		<el-col :span="6" v-for="(item,index) in dzsm2" v-bind:key="item.goodsId">
			  		<el-card style="margin-bottom:10px">
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" >
		  		<el-col :span="24" >
		  		|<b id="shouye_fzss" class="shouye_zl">服装首饰</b>
		  		</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="fzss1.length>1" >
		  		<el-col :span="6" v-for="(item,index) in fzss1" v-bind:key="item.goodsId">
			  		<el-card >
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="fzss2.length>1" >
		  		<el-col :span="6" v-for="(item,index) in fzss2" v-bind:key="item.goodsId">
			  		<el-card style="margin-bottom:10px">
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" >
		  		<el-col :span="24" >
		  		|<b id="shouye_jsls" class="shouye_zl">酒水零食</b>
		  		</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="jsls1.length>1" >
		  		<el-col :span="6" v-for="(item,index) in jsls1" v-bind:key="item.goodsId">
			  		<el-card >
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="jsls2.length>1" >
		  		<el-col :span="6" v-for="(item,index) in jsls2" v-bind:key="item.goodsId">
			  		<el-card style="margin-bottom:10px">
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" >
		  		<el-col :span="24" >
		  		|<b id="shouye_wjts" class="shouye_zl">文具图书</b>
		  		</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="wjts1.length>1" >
		  		<el-col :span="6" v-for="(item,index) in wjts1" v-bind:key="item.goodsId">
			  		<el-card >
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="wjts2.length>1" >
		  		<el-col :span="6" v-for="(item,index) in wjts2" v-bind:key="item.goodsId">
			  		<el-card style="margin-bottom:10px">
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" >
		  		<el-col :span="24" >
		  		|<b id="shouye_sxsc" class="shouye_zl">生鲜食材</b>
		  		</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="sxsc1.length>1" >
		  		<el-col :span="6" v-for="(item,index) in sxsc1" v-bind:key="item.goodsId">
			  		<el-card >
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="sxsc2.length>1" >
		  		<el-col :span="6" v-for="(item,index) in sxsc2" v-bind:key="item.goodsId">
			  		<el-card style="margin-bottom:10px">
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" >
		  		<el-col :span="24" >
		  		|<b id="shouye_tyjs" class="shouye_zl">体育健身</b>
		  		</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="tyjs1.length>1" >
		  		<el-col :span="6" v-for="(item,index) in tyjs1" v-bind:key="item.goodsId">
			  		<el-card >
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="tyjs2.length>1" >
		  		<el-col :span="6" v-for="(item,index) in tyjs2" v-bind:key="item.goodsId">
			  		<el-card style="margin-bottom:10px">
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" >
		  		<el-col :span="24" >
		  		|<b id="shouye_wsjj" class="shouye_zl">卫生洁具</b>
		  		</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="wsjj1.length>1" >
		  		<el-col :span="6" v-for="(item,index) in wsjj1" v-bind:key="item.goodsId">
			  		<el-card >
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="wsjj2.length>1" >
		  		<el-col :span="6" v-for="(item,index) in wsjj2" v-bind:key="item.goodsId">
			  		<el-card style="margin-bottom:10px">
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" >
		  		<el-col :span="24" >
		  		|<b id="shouye_fnyy" class="shouye_zl">妇女婴幼</b>
		  		</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="fnyy1.length>1" >
		  		<el-col :span="6" v-for="(item,index) in fnyy1" v-bind:key="item.goodsId">
			  		<el-card >
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="fnyy2.length>1" >
		  		<el-col :span="6" v-for="(item,index) in fnyy2" v-bind:key="item.goodsId">
			  		<el-card style="margin-bottom:10px">
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" >
		  		<el-col :span="24" >
		  		|<b id="shouye_bgjj" class="shouye_zl">办公家居</b>
		  		</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="bgjj1.length>1" >
		  		<el-col :span="6" v-for="(item,index) in bgjj1" v-bind:key="item.goodsId">
			  		<el-card >
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 <el-row :gutter="20" v-if="bgjj2.length>1" >
		  		<el-col :span="6" v-for="(item,index) in bgjj2" v-bind:key="item.goodsId">
			  		<el-card style="margin-bottom:10px">
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
					  			<el-link @click="jiagou(item.goodsId)" ><i class="el-icon-shopping-cart-2"></i></el-link>
					  			</span></div>
					  			
					  		</div>
					  	</div>
					</el-card>
				</el-col>
			 </el-row>
			 
			</el-col> 
		  	<el-col :span="7" >
			   <el-card style="margin-bottom:10px;" v-for="(item,i) in qiugou" v-bind:key="item.needId" >
			  	<div style="float: left;min-height: 60px;width:100%"  class="qg_card">
			  		<div style="float: left;width:60px">
				  		<div style="float: left;">
				  			<el-avatar :src="item.userAvater" style="box-shadow: 1px 2px 5px #333"></el-avatar>
				  		</div>
				  		<div style="float: left;width:15px;height:15px;margin-top: 25px;margin-left: -15px">
				  			<el-image :src="item.userVip|vip"  style="width:15px;height:15px;" lazy></el-image>
				  		</div>
				  		<div style="float: left;margin-top: 45px;margin-left: -55px;width:75px;text-align: center;">
				  			<span style="color: #666;font-size: 13px;font-weight: 600">{{item.userName}}</span>
				  			<i class="el-icon-male" style="color: #409eff;font-size: 13px; " v-if="item.userSex == 0"></i>
				  			<i class="el-icon-female" style="color: #F44336;font-size: 13px;" v-if="item.userSex == 1"></i>
				  		</div>
				  		<el-button @click="liuyan(item.userId)" type="primary" style="padding: 8px 10px;margin: 5px 0px 0px -13px;" round><i class="el-icon-chat-line-round"></i> 留言</el-button>
			  		</div>
			  		<div style="float: right;width:73%;color: #333;font-size: 15px">
			  			<div v-html="item.needContent">	
			  			</div>
			  			<div class="demo-image__preview" style="margin-top: 5px" >
			  				<el-image v-for="(img,index) in item.needPics"  v-bind:key="index" @click="xr_lb(i)" style="width: 30%;border: 1px solid #eee;"  :src="img"  :preview-src-list="lunbo"></el-image>
			  			</div>
			  			<div style="float: right;margin: 10px 10px 0px 10px">
				  			<el-link type="primary"  class="qg_plsl"  :id='"qg_plsl"+item.needId'  ><i class="el-icon-chat-line-square"></i> {{item.needCommentNum}}</el-link>
				  			<el-link type="primary"  class="qg_zkpl"  :id='"qg_zkpl"+item.needId'  @click="zkpl(item.needId,i)" >展开评论</el-link>
				  			<el-link type="primary"  :id='"qg_sqpl"+item.needId' @click="sqpl(item.needId)" style="display:none"> 收起评论</el-link>
				  		</div>
			  			
			  		</div>
			  	</div>
			  	<div :id='"qg_pl"+item.needId' style="float:left;width: 100%;display: none">
			  	<el-divider ><i class="el-icon-chat-dot-square"></i> {{item.needCommentNum}}</el-divider>
			  		<div v-for="(cmt,j) in item.needTime" v-bind:key="j" style="float: left;width:100%;padding: 10px 0;border-bottom: 1px solid #ccc">
				  		<div style="float: left;width:60px">
				  			<div style="float: left;">
					  			<el-avatar :src="cmt.userAvater" style="box-shadow: 1px 2px 5px #333"></el-avatar>
					  		</div>
					  		<div style="float: left;width:15px;height:15px;margin-top: 25px;margin-left: -15px">
					  			<el-image :src="cmt.userVip|vip"  style="width:15px;height:15px;" ></el-image>
					  		</div>
					  		<div style="float: left;margin-top: 45px;margin-left: -55px;width:75px;text-align: center;">
					  			<span style="color: #999;font-size: 13px;font-weight: 600">{{cmt.userName}}</span>
					  			<i class="el-icon-male" style="color: #409eff;font-size: 13px; " v-if="cmt.userSex == 0"></i>
				  				<i class="el-icon-female" style="color: #F44336;font-size: 13px;" v-if="cmt.userSex == 1"></i>
					  		</div>
				  		</div>
				  		<div style="float: right;color: #666;font-size: 14px;width: 73%">
				  			<div style="float: right;color: #666;font-size: 14px">
					  			<el-link type="primary" style="float:right" @click="like(cmt.commentId,item.needId,i)"><i class="el-icon-thumb"></i> {{cmt.commentLikeNum}}</el-link>
					  			
					  		</div>
				  			<p style="margin-bottom: 0;width: 70%">{{cmt.commentContent}}</p>
				  			<div style="float: right;color: #666;font-size: 14px">
					  			{{cmt.commentTime|date}}
					  		</div>
				  		</div>

			  		</div>
			  		<div style="float: left;width:100%;margin-top: 15px">
			  			<el-input placeholder="说点什么..." maxlength="100"  v-model="text">
						    <el-button @click="fabu(item.needId,i)" slot="append" icon="el-icon-position" style="background-color: #409EFF; color: white;">发布</el-button>
						</el-input>
			  		</div>
			  	</div>
			   </el-card>
			   
			</el-col>
			</el-row>

		  </el-main>
		  	
		  </el-container>
		  
		  	
		  
		
	<%@include file="/inc/footer.inc"%>
	</div>
</body>
<script src="js/vue.js"></script>
<script src="js/element.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/index.js"></script>
<script src="js/header.js"></script>
<script >
function typePage(e) {
	  sessionStorage.setItem("typePage",e);
	  location.href="/home/typePage.do";
}
</script>
</html>
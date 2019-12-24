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
<link rel="stylesheet" href="/home/css/qiugou.css">
</head>
<body>
	<%@include file="/inc/header.inc"%>
	<div id="qiugou">
		<el-container>
		  <el-main style="background: linear-gradient(to bottom, #fff , #eee);">
		  	<el-row :gutter="20" >
			  <el-col :span="17" :offset="1">
			  	<el-tabs type="border-card">
			  	  <el-tab-pane >
				    <span slot="label" @click="type(1)">热度优先<i class="el-icon-download"></i> </span>
				  </el-tab-pane>
				  <el-tab-pane >
				    <span slot="label" @click="type(0)">创建时间<i class="el-icon-download"></i> </span>
				  </el-tab-pane>	  
				</el-tabs>
			  </el-col>
			  <el-col :span="6" >
			   <el-button type="primary" icon="el-icon-s-flag"  @click="fbqg()" round>发布求购</el-button>
			  </el-col>
			</el-row>
		  	<el-row :gutter="20" >
			 <el-col :span="22" :offset="1">
			  <el-col :span="8" >
			  	<el-card style="margin-bottom:10px;" v-for="(item,i) in items1" v-bind:key="item.needId" >
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
				  		<el-button @click="liuyan(item.userId)"  type="primary" style="padding: 8px 10px;margin: 5px 0px 0px -13px;" round><i class="el-icon-chat-line-round"></i> 留言</el-button>
			  		</div>
			  		<div style="float: right;width:73%;color: #333;font-size: 15px">
			  			<div v-html="item.needContent">	
			  			</div>
			  			<div class="demo-image__preview" style="margin-top: 5px" >
			  				<el-image v-if="item.needPics.length != 0" v-for="(img,index) in item.needPics"  v-bind:key="index" @click="xr_lb(i,1)" style="width: 30%;border: 1px solid #eee;"  :src="img"  :preview-src-list="lunbo" alt="暂无图片"></el-image>
			  			</div>
			  			<div style="float: right;margin: 10px 10px 0px 10px">
				  			<el-link type="primary"  class="qg_plsl"  :id='"qg_plsl"+item.needId'  ><i class="el-icon-chat-line-square"></i> {{item.needCommentNum}}</el-link>
				  			<el-link type="primary"  class="qg_zkpl"  :id='"qg_zkpl"+item.needId'  @click="zkpl(item.needId,i,1)" >展开评论</el-link>
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
					  			<el-link type="primary" style="float:right" @click="like(cmt.commentId,item.needId,i,1)"><i class="el-icon-thumb"></i> {{cmt.commentLikeNum}}</el-link>
					  			
					  		</div>
				  			<p style="margin-bottom: 0;width: 70%">{{cmt.commentContent}}</p>
				  			<div style="float: right;color: #666;font-size: 14px">
					  			{{cmt.commentTime|date}}
					  		</div>
				  		</div>

			  		</div>
			  		<div style="float: left;width:100%;margin-top: 15px">
			  			<el-input placeholder="说点什么..." maxlength="100"  v-model="text">
						    <el-button @click="fabu(item.needId,i,1)" slot="append" icon="el-icon-position" style="background-color: #409EFF; color: white;">发布</el-button>
						</el-input>
			  		</div>
			  	</div>
			   </el-card>
			  	
			  </el-col>
			  <el-col :span="8" >
			  	<el-card style="margin-bottom:10px;" v-for="(item,i) in items2" v-bind:key="item.needId" >
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
				  		<el-button @click="liuyan(item.userId)"  type="primary" style="padding: 8px 10px;margin: 5px 0px 0px -13px;" round><i class="el-icon-chat-line-round"></i> 留言</el-button>
			  		</div>
			  		<div style="float: right;width:73%;color: #333;font-size: 15px">
			  			<div v-html="item.needContent">	
			  			</div>
			  			<div class="demo-image__preview" style="margin-top: 5px" >
			  				<el-image v-if="item.needPics.length != 0"  v-for="(img,index) in item.needPics"  v-bind:key="index" @click="xr_lb(i,2)" style="width: 30%;border: 1px solid #eee;"  :src="img"  :preview-src-list="lunbo" alt="暂无图片"></el-image>
			  			</div>
			  			<div style="float: right;margin: 10px 10px 0px 10px">
				  			<el-link type="primary"  class="qg_plsl"  :id='"qg_plsl"+item.needId'  ><i class="el-icon-chat-line-square"></i> {{item.needCommentNum}}</el-link>
				  			<el-link type="primary"  class="qg_zkpl"  :id='"qg_zkpl"+item.needId'  @click="zkpl(item.needId,i,2)" >展开评论</el-link>
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
					  			<el-link type="primary" style="float:right" @click="like(cmt.commentId,item.needId,i,2)"><i class="el-icon-thumb"></i> {{cmt.commentLikeNum}}</el-link>
					  			
					  		</div>
				  			<p style="margin-bottom: 0;width: 70%">{{cmt.commentContent}}</p>
				  			<div style="float: right;color: #666;font-size: 14px">
					  			{{cmt.commentTime|date}}
					  		</div>
				  		</div>

			  		</div>
			  		<div style="float: left;width:100%;margin-top: 15px">
			  			<el-input placeholder="说点什么..." maxlength="100"  v-model="text">
						    <el-button @click="fabu(item.needId,i,2)" slot="append" icon="el-icon-position" style="background-color: #409EFF; color: white;">发布</el-button>
						</el-input>
			  		</div>
			  	</div>
			   </el-card>
			  	
			  </el-col>
			  <el-col :span="8" >
			  	<el-card style="margin-bottom:10px;" v-for="(item,i) in items3" v-bind:key="item.needId" >
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
				  		<el-button @click="liuyan(item.userId)"  type="primary" style="padding: 8px 10px;margin: 5px 0px 0px -13px;" round><i class="el-icon-chat-line-round"></i> 留言</el-button>
			  		</div>
			  		<div style="float: right;width:73%;color: #333;font-size: 15px">
			  			<div v-html="item.needContent">	
			  			</div>
			  			<div class="demo-image__preview" style="margin-top: 5px" >
			  				<el-image v-if="item.needPics.length != 0" v-for="(img,index) in item.needPics"  v-bind:key="index" @click="xr_lb(i,3)" style="width: 30%;border: 1px solid #eee;"  :src="img"  :preview-src-list="lunbo" alt="暂无图片"></el-image>
			  			</div>
			  			<div style="float: right;margin: 10px 10px 0px 10px">
				  			<el-link type="primary"  class="qg_plsl"  :id='"qg_plsl"+item.needId'  ><i class="el-icon-chat-line-square"></i> {{item.needCommentNum}}</el-link>
				  			<el-link type="primary"  class="qg_zkpl"  :id='"qg_zkpl"+item.needId'  @click="zkpl(item.needId,i,3)" >展开评论</el-link>
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
					  			<el-link type="primary" style="float:right" @click="like(cmt.commentId,item.needId,i,3)"><i class="el-icon-thumb"></i> {{cmt.commentLikeNum}}</el-link>
					  			
					  		</div>
				  			<p style="margin-bottom: 0;width: 70%">{{cmt.commentContent}}</p>
				  			<div style="float: right;color: #666;font-size: 14px">
					  			{{cmt.commentTime|date}}
					  		</div>
				  		</div>

			  		</div>
			  		<div style="float: left;width:100%;margin-top: 15px">
			  			<el-input placeholder="说点什么..." maxlength="100"  v-model="text">
						    <el-button @click="fabu(item.needId,i,3)" slot="append" icon="el-icon-position" style="background-color: #409EFF; color: white;">发布</el-button>
						</el-input>
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
<script src="/home/js/qiugou.js"></script>
<script src="/home/js/header.js"></script>
</html>
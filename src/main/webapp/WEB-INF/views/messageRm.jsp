<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息留言</title>
<link rel="shortcut icon" href="/home/img/icon_3.png" type="image/png" />
<link rel="stylesheet" href="/home/css/element.css">
<link rel="stylesheet" href="/home/css/fonts/element-icons.woff">
<link rel="stylesheet" href="/home/css/messageRm.css">
<link rel="stylesheet" href="/home/css/index.css">
</head>
<body>
	<%@include file="/inc/header2.inc"%>
	<div id="messageRm"  >
		<div style="float: left;width: 100%; box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);border-radius: 50px;">
			<div style="float: left;">
	  			<el-avatar :src="user.userAvater" style="width:100px;height:100px;border-radius:50%;box-shadow: 1px 2px 5px #666"></el-avatar>
	  		</div>
	  		<div style="float: left;width:25px;height:25px;margin-top: 75px;margin-left: -25px">
	  			<el-image :src="user.userVip|vip"  style="width:25px;height:25px;" ></el-image>
	  		</div>
	  		<div style="float: left;margin-top: 15px;margin-left: 15px;color: #444;">
	  			  {{user.userName}}
				  <i class="el-icon-male" style="color: #409eff;font-size: 13px; " v-if="user.userSex == 0"></i>
			  	  <i class="el-icon-female" style="color: #F44336;font-size: 13px;" v-if="user.userSex == 1"></i>
			  	  的留言空间
			  	  <br><br><br>
			  	  <span style="color: #666;font-weight: 600;font-size: 14px">个人简介：</span>
			  	  <span style="color: #409eff;border-bottom: 1px solid #999;font-size: 15px">{{user.userIntro}}</span>
			  	  
	  		</div>

		</div>
		<div style="float:left; min-height: 300px;width: 100%;">
		<el-row :gutter="20"  v-if="message.length == 0" style="margin-top:50px">
		  <el-col :span="4"  :offset="10" style="text-align:center;color:#666;">
		  	<el-image src="img/kong.png"  fit="contain" style="width:100%;" lazy></el-image>
		  	暂无留言...
		  </el-col>
		</el-row>
		<div v-for="(item,index) in message" v-bind:key="item.remainId">
		  <el-collapse v-model="activeNames" @change="handleChange(item.remainId)">
		    <el-row class="demo-avatar demo-basic">
		    	<el-col :span="2">
		      	  <div class="demo-basic--circle">
		            <div class="block"><el-avatar shape="square" :size="50" :src="item.userAvater"></el-avatar></div>
		          </div>
		    	</el-col> 
		    	<el-col :span="22">
			    	<div class="block" style="float: left;">
			        	<span style="color:#f56c6ce0;">{{item.userName}}&ensp;</span>
			        	<i class="el-icon-male" v-if="item.userSex == 0" style="color:blue;"></i>
			        	<i class="el-icon-female" v-if="item.userSex == 1" style="color:red;"></i>
			        	<p style="margin-top: 9px;width: 500px;	">{{item.remainContent}}</p>
			        </div>
			        <div style="float:right;">
			        	<span style="color:#666;">{{item.remainTime|dateFormat}}&emsp;&emsp;</span>
			        	<el-button icon="el-icon-delete" plain @click="deleteItem(item.remainId,item.remianLastId)"
			        		v-if="userId == liuyanId">删除</el-button>
			        	<el-button icon="el-icon-message" @click="openReply(item.remainId,index)" id="item.remainId" style="margin-left: 16px;">
						  回复
						</el-button>
			        </div>
			    </el-col>
			</el-row>  
		    <el-collapse-item :title="item.content" :name="item.remianId">
		      <div class="block" style="float: left;">
		      		<p v-for="subItem in item.subContent">
		      			<span style="color:#409eff;" v-if="ownerName != subItem.userName">{{subItem.userName}}</span>
		      			<span style="color:#a43eccfc;" v-if="ownerName == subItem.userName">{{subItem.userName}}（我）</span>
		      			（{{subItem.remainTime|dateFormat}}）：&emsp;{{subItem.remainContent}}&emsp;
		      			<span class="deleteSubItem" @click="deleteItem(subItem.remainId,subItem.remianLastId)"
		      				v-if="userId == liuyanId">删除</span>
		      		</p>
		      		<el-input type="textarea" :rows="4" placeholder="请输入内容" v-model="textarea" id="reply">
					</el-input>
					<el-button type="primary" style="float:right;margin:15px 15px 15px 0;" @click="reply(item.remainId,item.userId)">确定</el-button>
		      </div>
		    </el-collapse-item>
		  </el-collapse>
		</div>  
		</div>
		<el-input placeholder="说点什么吧..." maxlength="255"  v-model="text">
			    <el-button @click="addMainRemain()" slot="append" icon="el-icon-position" style="background-color: #409EFF; color: white;">留言</el-button>
		</el-input>
	</div>
	<%@include file="/inc/footer.inc"%>
</body>
<script src="/home/js/vue.js"></script>
<script src="/home/js/element.js"></script>
<script src="/home/js/jquery.min.js"></script>
<script src="/home/js/messageRm.js"></script>
<script src="/home/js/header.js"></script>
</html>
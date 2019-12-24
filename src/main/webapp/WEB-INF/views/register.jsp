<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册页面</title>
<link rel="shortcut icon" href="/home/img/icon_3.png" type="image/png" />
<link rel="stylesheet" href="/home/css/element.css">
<link rel="stylesheet" href="/home/css/fonts/element-icons.woff">
<link rel="stylesheet" href="/home/css/register.css">
<link rel="stylesheet" href="/home/css/index.css">
</head>
<body>
	<div id="register">
	<!-- 	<el-header>Header</el-header> -->
		<el-container class="header">
			<el-col :span="2">
			</el-col>
			<el-col :span="1.5">
				<div class="grid-content ">
			  		<el-link :underline="false"  href="/home/index.jsp" ><img src="img/icon_1.png" class="register_tubiao"></img></el-link>
			  	</div>
			</el-col>
				<el-col :span="10">
			  <span style="color: #1296db;font-size: 14px;font-weight: 600;float: left;margin-top: 29px;line-height: 20px;">校园二手淘<br>schooltao.com</span><p style="color: black;font-size:20px;"></p>
			</el-col>
			<el-col :span="10">
			  	<div style="text-align:right;padding-right:40px;margin-top: 38px;">
					<el-link :underline="false" type="info" >已有账号？&nbsp</el-link>
					<el-link :underline="false" type="danger"  href="/home/login.do">请登录&gt;</el-link>
				</div>  
			 </el-col>
		</el-container>
		<el-container style="min-height:521px;background-color:#eee;margin-top: 20px;">
			  <el-col :span="8">
			  </el-col>
			 <el-col :span="8">
				<div class="grid-content " style="margin-top: 50px;">
			 		<el-input v-model="root"  placeholder="请输入用户名"  clearable>
	  					 <el-button slot="prepend" icon="el-icon-user-solid"></el-button>
			 		</el-input>
			 		<br><br>
	  				<el-input placeholder="请输入密码" v-model="pass"  autocomplete="off" show-password>
	  					 <el-button slot="prepend" icon="el-icon-lock"></el-button>
	  				</el-input>		
	  				<br><br>	
	  				<el-input placeholder="请确认密码" v-model="checkPass"  autocomplete="off" show-password>
	  					 <el-button slot="prepend" icon="el-icon-lock"></el-button>
	  				</el-input>		
	  				<br><br>	
				</div>	
				<template >
					  <el-select v-model="value" placeholder="请选择一个密保问题" style="width:100%" >
					    <el-option
					      v-for="item in options"
					      :key="item.value"
					      :label="item.label"
					      :value="item.value">
					    </el-option>
					  </el-select>
				</template>	
					 <br><br>	
				<el-input placeholder="请输入密保答案" v-model="answer" clearable>
	  					 <el-button slot="prepend" icon="el-icon-s-comment"></el-button>
	  			 </el-input>	
		  			  <br><br>	
				<div>
					<el-button type="primary" style="width:100%;font-size:16px" @click="submitForm()">立即注册</el-button>	
				</div>
			  </el-col>
		</el-container>
		
		
		<%@include file="/inc/footer.inc"%>
	</div>
</body>
<script src="/home/js/vue.js"></script>
<script src="/home/js/element.js"></script>
<script src="/home/js/jquery.min.js"></script>
<script src="/home/js/register.js"></script>
</html>
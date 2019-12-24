<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="shortcut icon" href="/home/img/icon_3.png" type="image/png" />
<link rel="stylesheet" href="/home/css/element.css">
<link rel="stylesheet" href="/home/css/fonts/element-icons.woff">
<link rel="stylesheet" href="/home/css/login.css">
<link rel="stylesheet" href="/home/css/index.css">
</head>
<body>
	<div id="login">
	
		<div class="login_header" >
			
			<el-col :span="2">
				<br>
			</el-col>
			<el-col :span="1.5">
				<div class="grid-content ">
			  		<el-link :underline="false"  href="/home/index.jsp" ><img src="img/icon_1.png" class="login_tubiao"></img></el-link>
			  	</div>
			</el-col>
			<el-col :span="10">
			  <span style="color: #1296db;font-size: 14px;font-weight: 600;float: left;margin-top: 29px;line-height: 20px;">校园二手淘<br>schooltao.com</span><p style="color: black;font-size:20px;"></p>
			</el-col>
			<el-col :span="10">
			  	<div style="text-align:right;padding-right:40px;margin-top: 38px;">
					<el-link :underline="false" type="info" >没有账号？&nbsp</el-link>
					<el-link :underline="false" type="danger"  href="/home/register.do">请注册&gt;</el-link>
				</div>  
			 </el-col>
			 <div style="clear:both;"></div>
		</div>
			
		
		<div class="bc">
			<!-- <el-image src="img/lunbo_1.jpg"></el-image> -->
		</div> 
	
		<el-container class="logo-box">
		  <el-col :span="4">
		  </el-col>
		 <el-col :span="16">
			<div class="grid-content " style="margin-top: 75px;" >
			
		 		<el-input v-model="root"  placeholder="请输入用户名"  clearable>
  					 <el-button slot="prepend" icon="el-icon-user-solid"></el-button>
		 		</el-input>
		 		<br><br>
  				<el-input placeholder="请输入密码" v-model="password"  autocomplete="off" show-password>
  					 <el-button slot="prepend" icon="el-icon-lock"></el-button>
  				</el-input>		
  				<br><br>								 				
			</div>	
			<div>
				<el-button type="primary" style="width:100%;font-size:16px" @click="submitForm(root,password)">登      录</el-button>	
			</div>
			
			<p style="margin-top:20px;">
				<el-link :underline="false" type="primary" style="text-align:left;" href="/home/reset.do">忘记密码</el-link>
				<el-link :underline="false" type="primary" style="float:right;" href="/home/register.do">免费注册</el-link>
			</p>
		  </el-col>
 				 
 		
		</el-container>
		<div style="margin: -10px">
		<%@include file="/inc/footer.inc"%>
		</div>
	</div>
</body>
<script src="/home/js/vue.js"></script>
<script src="/home/js/element.js"></script>
<script src="/home/js/jquery.min.js"></script>
<script src="/home/js/login.js"></script>
</html>
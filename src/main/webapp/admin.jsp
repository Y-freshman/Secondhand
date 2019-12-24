<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=2.0, user-scalable=no">
<title>二手淘后台</title>
<link rel="shortcut icon" href="img/icon_3.png" type="image/png" />
<link rel="stylesheet" href="css/element.css">
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
	<div id="admin">
		<el-image src="img/icon_1.png" class="shouye_tubiao"  lazy></el-image>
		<span class="shouye_tubiao2" title="校园二手淘后台" >
			校园二手淘后台<br>schooltao.com
		</span>
		<el-input placeholder="请输入账号"  v-model="account" style="margin-top:50px">
		    <template slot="prepend"><i class="el-icon-user-solid"></i></template>
		</el-input>
		<el-input @keyup.enter="login()" placeholder="请输入密码"  v-model="password" show-password style="margin-top:20px">
		    <template slot="prepend"><i class="el-icon-s-grid"></i></template>
		</el-input>
		<el-button type="primary"  style="width:100%;margin-top:40px;font-size:18px;font-weight: 500;" @click="login()">
			<span style="float: left;margin-left: 135px;">登录&nbsp;</span>
			<i class="el-icon-loading" style="display:none;float:left;"></i> 
		</el-button>
	</div>
</body>
<script src="js/vue.js"></script>
<script src="js/element.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/admin.js"></script>
</html>
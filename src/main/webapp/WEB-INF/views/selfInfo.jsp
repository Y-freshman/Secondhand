<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
<title>个人信息</title>
<link rel="shortcut icon" href="/home/img/icon_3.png" type="image/png" />
<link rel="stylesheet" href="/home/css/element.css">
<link rel="stylesheet" href="/home/css/fonts/element-icons.woff">
<link rel="stylesheet" href="/home/css/selfInfo.css">
<link rel="stylesheet" href="/home/css/index.css">
</head>
<body>
	<%@include file="/inc/header2.inc"%>
	<div id="selfInfo">
		<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
		  <p class="selfInfo_title">尊敬的&ensp;<span>{{userName2}}</span>，填写真实的资料，更有助于物品交易哦。</p>
		  <el-form-item label="更换头像">
		     	<el-upload
			   	  ref='upload'
				  action="http://upload-z0.qiniup.com"
				  :data="tk"
				  list-type="picture-card"
				  accept="image/*"
				  :limit="imgLimit"
				  :file-list="productImgs"
				  :multiple="isMultiple"
				  :on-preview="handlePictureCardPreview"
				  :on-remove="handleRemove"
				  :on-success="handleAvatarSuccess"
				  :before-upload="beforeAvatarUpload"
				  :on-exceed="handleExceed"
				  :on-error="imgUploadError"
				  >
				  <i class="el-icon-plus"></i>
				</el-upload>
				<el-dialog :visible.sync="dialogVisible">
				  <img width="100%" :src="dialogImageUrl" alt="">
				</el-dialog>
		  </el-form-item>
		  <el-form-item label="昵称" prop="userName">
		    <el-input type="text" v-model="ruleForm.userName" style="width: 40%;"></el-input>
		  </el-form-item>
		  <el-form-item label="性别" prop="radio">
		     <el-radio v-model="ruleForm.radio" label="0">男</el-radio>
 			 <el-radio v-model="ruleForm.radio" label="1">女</el-radio>
		  </el-form-item>
		  <el-form-item label="自我介绍" prop="selfInfo">
		    <el-input type="textarea" v-model="ruleForm.selfInfo" style="width: 70%;"></el-input>
		  </el-form-item>
		  <el-form-item>
		    <el-button type="primary" @click="submitForm('ruleForm')">保存</el-button>
		    <el-button @click="resetForm('ruleForm')">重置</el-button>
		  </el-form-item>
		</el-form>
	</div>
	<%@include file="/inc/footer.inc"%>
</body>
<script src="/home/js/vue.js"></script>
<script src="/home/js/element.js"></script>
<script src="/home/js/jquery.min.js"></script>
<script src="/home/js/selfInfo.js"></script>
<script src="/home/js/header.js"></script>
</html>
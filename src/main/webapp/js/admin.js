$(document).ready(function(){
	var vm = new Vue({
		  el: '#admin',
		  data: {
			   account:'',
			   password: '',
		  },
		  methods: {
			  login: function () {
				  $(".el-icon-loading").css("display","block");
				  let that = this;
				  $.ajax({
			    		type: "post",
			    		dataType:"json",
			    		async:true,//同步异步
			            contentType:"application/json", 
			    		url: "/home/user/loginAdmin.do",
			    		data:  JSON.stringify({
			    			"root":vm.account,
			    			"password":vm.password,
			    		}), 
			    		success: function(data) {
			    			console.log(data);
			    			 if(data.code == "200"){
			    				 that.$message({message: '成功登录~',type: 'success'});
								  sessionStorage.setItem("admin",1);
								  location.href="admin/index.html";
			    			 }else{
			    				 that.$message.error('账号或密码错误！');
					    			$(".el-icon-loading").css("display","none");
			    			 }
			    		},
			    		error: function(){
			    			that.$message.error('账号或密码错误！');
			    			$(".el-icon-loading").css("display","none");
			    		}
					});
			  },
		  },
		  filters: {
			  
		  },
	});
	
});

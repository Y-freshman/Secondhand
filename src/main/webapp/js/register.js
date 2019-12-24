$(document).ready(function(){
	var vm = new Vue({
		  el: '#register',
		  data: {
			  options: [{
		          value: '0',
		          label: '您的电话号码'
		        }, {
		          value: '1',
		          label: '您的大学学校'
		        }, {
		          value: '2',
		          label: '您最喜欢的歌'
		        }, {
		          value: '3',
		          label: '您最喜欢的人'
		        }, {
		          value: '4',
		          label: '您的大学班主任'
		        }],
		        value: '',
				root: '',
				pass: '',
		        checkPass: '',
		        answer: ''
		  },
		  methods: {
			  submitForm() {
				  var that = this;
			            if(vm.root === '') {
			            	 this.$message.error('请输入用户名');
			              } 
			            else if(vm.pass === '' || vm.checkPass === '' ){
			            	this.$message.error('请输入密码');
			            }
			            else if(vm.pass!==vm.checkPass){
			            	this.$message.error('两次密码不一致');
			            }
			            else if(vm.value === ''){
			            	this.$message.error('请选择密保问题');
			            }
			            else if(vm.answer === ''){
			            	//this.$message.error(vm.value);
			            	 this.$message.error('请填入密码答案');
			            }else {
			            	 $.ajax({
								  url: "/home/user/registers.do",
								  async: false,
								  type: "post",
								  data: JSON.stringify({
									  root: vm.root,
									  pass: vm.pass,
									  value: vm.value,
								      answer: vm.answer
								  }),
								  contentType: "application/json",
								  dataType: 'json',
								  success: function(data){
									  console.log(data);
									  if(data.code == "600"){
										  console.log(data.code);
										  that.$message({
											  message: '该账号已注册，请跟换账号重新注册！',
											  type: 'error'
										  });
										  return false;
									  }else if(data.code == "200"){
										  that.$message({
											  message: '恭喜您注册成功',
											  type: 'success'
										  });
										  
										  $.ajax({
											  url: "/home/user/logins.do",
											  async: false,
											  type: "post",
											  data: JSON.stringify({
												  root: vm.root,
												  password: vm.pass,
											  }),
											  contentType: "application/json",
											  dataType: 'json', 
											  success: function(data){
												  console.log(data);
												  console.log(data.user.userId);
												  localStorage.setItem("userId",data.user.userId);
											  }
										  })
										  setTimeout(function(){ 
											  localStorage.setItem("root",vm.root);
											  localStorage.setItem("password",vm.pass);
											 location.href="/home/index.jsp"; 
											  }, 2000);
									  }else{
										  that.$message({
											  message: '注册失败，请重新注册！',
											  type: 'error'
										  });
									  }
								  }
							  })
			            }
			      }
		  },
		  filters: {
			  
		  },
		  
	});
	
});

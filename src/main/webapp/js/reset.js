$(document).ready(function(){
	var vm = new Vue({
		  el: '#reset',
		  data: {
			  options: [{
				  value: '0',
		          label: '您的电话号码'
		        }, {
		          value: '1',
		          label: '您的大学学校'
		        }, {
		          value: '2',
		          label: '您的生日'
		        }, {
		          value: '3',
		          label: '您最喜欢的歌手'
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
			            }else if(vm.value === ''){
				            	this.$message.error('请选择密保问题');
			            }else if(vm.answer === ''){
			            	this.$message.error('请填入密码答案');
			            }else if(vm.pass === '' || vm.checkPass === '' ){
			            	this.$message.error('请输入密码');
			            }
			            else if(vm.pass!==vm.checkPass){
			            	this.$message.error('两次密码不一致');
			            }else {
			            	 $.ajax({
								  url: "/home/user/resets.do",
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
									 if(data.code == "200"){
										 that.$message({
											 message: '重置成功，快去登录吧！',
											 type: 'success'
										 });
										 setTimeout(function(){  
											 location.href="/home/login.do"; 
										 }, 2000);
									 }else{
										  that.$message({
											  message: '重置失败，请输入正确的账号、问题、答案！',
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

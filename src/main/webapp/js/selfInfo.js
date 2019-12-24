$(document).ready(function(){
	var vm = new Vue({
		  el: '#selfInfo',
		  data: {
			  dialogImageUrl: '',
		      dialogVisible: false,
		      productImgs: [],
		      pics: [],
		      isMultiple: true,
		      imgLimit: 1,
		      tk:{
		    	  token:'',
		    	  key:'',
		      },
		      userId: '',
	          userName2: '',
			  ruleForm: {
		          region: '',
		          radio: '',
		          userName: '',
		          selfInfo: '',
		        },
		        rules: {
			          region: [
			            { required: true, message: '请选择活动区域', trigger: 'change' }
			          ],
			          resource: [
			            { required: true, message: '请选择您的性别', trigger: 'change' }
			          ],
			          userName: [
			        	  { required: true, message: '请输入昵称', trigger: 'blur' },
				          { min: 2, max: 7, message: '长度在 2 到 7 个字符', trigger: 'blur' }
			          ],
			          selfInfo: [
			        	  { required: true, message: '介绍介绍自己吧', trigger: 'blur' },
			        	  { min: 2, message: '少于2个字符的介绍怎么能显示你的魅力呢', trigger: 'blur' }
		        	  ]
			        },
			        imageUrl: '',
		  },
		  methods: {
			  submitForm(formName) {
				  		let that = this;
				  		console.log(vm.pics.length);
				  		console.log(111);
				  		if(vm.pics.length === 0){
				  			that.$message.error('请上传您的头像');
				  			return false;
				  		}else if(vm.ruleForm.userName === ''){
				  			that.$message.error('用户账号没填');
	  						return false;
				  		}else if(vm.ruleForm.radio === ''){
				  			that.$message.error('请上传您的头像');
	  						return false;
				  		}else if(vm.ruleForm.selfInfo === ''){
				  			that.$message.error('请输入您的自我介绍');
	  						return false;
				  		}else if(vm.ruleForm.userName == localStorage.getItem("root")){
				  			console.log(7777);
				  			$.ajax({
				  				type: "post",
				  				dataType:"json",
				  				async:false,
				  				contentType:"application/json", 
				  				url: "/home/user/selfs.do",
				  				data:  JSON.stringify({
				  					"userId": vm.userId,
				  					"userName": vm.ruleForm.userName,
				  					"userAvater": vm.pics.toString(),
				  					"userSex": vm.ruleForm.radio,
				  					"userIntro": vm.ruleForm.selfInfo,
				  					"panduan": 0,  //判断用户账号名没有修改
				  				}), 
				  				success: function(data) {
			  						localStorage.setItem("root",vm.ruleForm.userName);
			  						vm.tk.token = data.token;
			  						vm.tk.key = data.key;
			  						that.$message.success('个人信息修改成功！');
			  						vm.pics = [];
			  						vm.ruleForm.userName = '';
			  						vm.ruleForm.radio = '';
			  						vm.ruleForm.selfInfo = '';
			  						location.href="/home/personalCenter.do"; 
				  				}
				  			});
				  		}else{
				  			console.log(8888);
				  			$.ajax({
				  				type: "post",
				  				dataType:"json",
				  				async:false,
				  				contentType:"application/json", 
				  				url: "/home/user/selfs.do",
				  				data:  JSON.stringify({
				  					"userId": vm.userId,
				  					"userName": vm.ruleForm.userName,
				  					"userAvater": vm.pics.toString(),
				  					"userSex": vm.ruleForm.radio,
				  					"userIntro": vm.ruleForm.selfInfo,
				  					"panduan": 1,  //判断用户账号名修改
				  				}), 
				  				success: function(data) {
				  					if(data.code == '500'){
				  						that.$message.error('该用户已存在，请换个名字！！');
				  						return false;
				  					}else{
				  						localStorage.setItem("root",vm.ruleForm.userName);
				  						vm.tk.token = data.token;
				  						vm.tk.key = data.key;
				  						that.$message.success('个人信息修改成功！');
				  						vm.pics = [];
				  						vm.ruleForm.userName = '';
				  						vm.ruleForm.radio = '';
				  						vm.ruleForm.selfInfo = '';
				  						location.href="/home/personalCenter.do"; 
				  					}
				  				}
				  			});
				  		}
				    	
				    	
			      },
		      resetForm(formName) {
			        this.$refs[formName].resetFields();
			  },
			  handleRemove(file, fileList) {//移除图片
			         // console.log(file.response.key);
			         // var str = "http://schooltao.hcljy.top/"+file.response.key;
				  	var str = "http://time.freshman.top/"+file.response.key;
				  	// console.log(str);
			          vm.pics.pop(str);
			    	 // console.log(vm.pics);
			          //console.log(vm.pics[0]);
			      },
			      handlePictureCardPreview(file) {//预览图片时调用
			          //console.log(file);
			          this.dialogImageUrl = file.url;
			          this.dialogVisible = true;
			      },
			      beforeAvatarUpload(file) {//文件上传之前调用做一些拦截限制
			          //console.log(file.name);
			          const isJPG = true;
			          // const isJPG = file.type === 'image/jpeg';
			          const isLt2M = file.size / 1024 / 1024 < 2;
			   
			          // if (!isJPG) {
			          //   this.$message.error('上传头像图片只能是 JPG 格式!');
			          // }
			          if (!isLt2M) {
			            this.$message.error('上传图片大小不能超过 2MB!');
			            return false;
			          }
			          $.ajax({
				    		type: "post",
				    		dataType:"json",
				    		async:false,
				            contentType:"application/json", 
				    		url: "/home/token.do",
				    		data:  JSON.stringify({
				    			"fileName":file.name,
				    		}), 
				    		success: function(data) {
				    			console.log(data);
				    			vm.tk.token = data.token;
				    			vm.tk.key = data.key;
				    		}
						});
			         // console.log(this.tk)
			          return this.tk;
			       },
			       handleAvatarSuccess(res, file) {//图片上传成功
			         // console.log(res);
			         // console.log(file);
			    	 // var str = "http://schooltao.hcljy.top/"+vm.tk.key;
			    	   var str = "http://time.freshman.top/"+vm.tk.key;
			    	  vm.pics.push(str);
			    	 // console.log(vm.pics);
			          this.imageUrl = URL.createObjectURL(file.raw);
			        },
			        handleExceed(files, fileList) {//图片上传超过数量限制
			          this.$message.error('只能上传一张图片!');
			          //console.log(file, fileList);
			        },
			        imgUploadError(err, file, fileList){//图片上传失败调用
			         // console.log(err);
			          //console.log(this.tk.token);
			          //console.log(this.tk.key);
			          this.$message.error('上传图片失败!');
			        },
		  },
		  filters: {
			  
		  },
		  
	});
	function selfInfo() {
		if(!window.localStorage){
			return false;
		}
		if(localStorage.getItem("root")==null || localStorage.getItem("root")==undefined){
			return false;
		}
		vm.userName2 = localStorage.getItem("root");
		vm.userId = localStorage.getItem("userId");
		console.log(vm.userName2);
		console.log(vm.userId);
	 }
	selfInfo();
});
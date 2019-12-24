$(document).ready(function(){
	var vm = new Vue({
		  el: '#fabuqiugou',
		  data: {
			  dialogImageUrl: '',
		      dialogVisible: false,
		      productImgs: [],
		      pics: [],
		      isMultiple: true,
		      imgLimit: 6,
		      text:'',
		      tk:{
		    	  token:'',
		    	  key:'',
		      }
		  },
		  methods: { 
			  jubao: function () {
				  this.$message({
					  message: '我们已收到您的举报，感谢支持！',
					  type: 'warning'
				  });
			  },
			  fabu: function () {
				  if(vm.text.match(/^[ ]*$/)){
					  this.$message.error('内容不能为空！');
					  return false;
				  }else if(vm.text.length < 10){
					  this.$message.error('内容过短！');
					  return false;
				  }else{
					  let that = this;
					  $.ajax({
				    		type: "post",
				    		dataType:"json",
				    		async:true,//同步异步
				            contentType:"application/json", 
				    		url: "/home/need/insert.do",
				    		data:  JSON.stringify({
				    			"needContent":vm.text,
				    			"needPics":vm.pics.toString(),
				    			"userId":localStorage.getItem("userId"),
				    		}), 
				    		success: function(data) {
				    			console.log(data);
			    				that.$message({message: '发布成功~',type: 'success'});
			    				that.$refs.upload.clearFiles();
			    				vm.text = "";
			    				vm.pics = [];
			    				location.href="/home/qiugou.do";
				    		},
				    		error: function(){
				    			that.$message.error('发布失败！');
				    		}
						});
				  }
				  
			  },
		      handleRemove(file, fileList) {//移除图片
		          console.log(file.response.key);
		          //var str = "http://schooltao.hcljy.top/"+file.response.key;
		          var str = "http://time.freshman.top/"+file.response.key;
				  vm.pics.pop(str);
		    	  //console.log(vm.pics);
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
			    			//console.log(data);
			    			vm.tk.token = data.token;
			    			vm.tk.key = data.key;
			    		}
					});
		          //console.log(this.tk)
		          return this.tk;
		       },
		       handleAvatarSuccess(res, file) {//图片上传成功
		          //console.log(res);
		          //console.log(file);
		    	  //var str = "http://schooltao.hcljy.top/"+vm.tk.key;
		    	  var str = "http://time.freshman.top/"+vm.tk.key;
		    	  vm.pics.push(str);
		    	  //console.log(vm.pics);
		          this.imageUrl = URL.createObjectURL(file.raw);
		        },
		        handleExceed(files, fileList) {//图片上传超过数量限制
		          this.$message.error('上传图片不能超过6张!');
		          //console.log(file, fileList);
		        },
		        imgUploadError(err, file, fileList){//图片上传失败调用
		          console.log(err);
		          //console.log(this.tk.token);
		          //console.log(this.tk.key);
		          this.$message.error('上传图片失败!');
		        },
		  },
		  filters: {
			  
		  },
		  
	});
	
		
});

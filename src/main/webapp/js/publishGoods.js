$(document).ready(function(){
	var vm = new Vue({
		  el: '#publishGoods',
		  data: {
			  dialogImageUrl: '',
		      dialogVisible: false,
		      productImgs: [],
		      pics: [],
		      isMultiple: true,
		      imgLimit: 6,
		      tk:{
		    	  token:'',
		    	  key:'',
		      },
		      userName: '',
			  Avater: '',
			  sex: '',
			  vip: '',
			  goods: {
				   options: [{
				          value: '10',
				          label: '十成新'
				        }, {
				          value: '9',
				          label: '九成新'
				        }, {
				          value: '8',
				          label: '八成新'
				        }, {
				          value: '7',
				          label: '七成新'
				        }, {
				          value: '6',
				          label: '六成新'
				        }, {
					      value: '5',
					      label: '五成新'
				        }, {
				          value: '4',
				          label: '四成新'
				        }, {
				          value: '3',
				          label: '三成新'
				        }, {
				          value: '2',
				          label: '两成新'
				        }, {
				          value: '1',
				          label: '一成新'
				        }],	
		        optionsOnce: [{
				          value: '电子数码',
				          label: '电子数码'
				        }, {
				          value: '服装首饰',
				          label: '服装首饰'
				        }, {
				          value: '酒水零食',
				          label: '酒水零食'
				        }, {
				          value: '文具图书',
				          label: '文具图书'
				        }, {
				          value: '生鲜食材',
				          label: '生鲜食材'
				        }, {
					      value: '体育健身',
					      label: '体育健身'
				        }, {
				          value: '卫生洁具',
				          label: '卫生洁具'
				        }, {
				          value: '妇女婴幼',
				          label: '妇女婴幼'
				        }, {
				          value: '办公家居',
				          label: '办公家居'
				        }],	
			         name: '',
			         counterPrice: '',
			         retailPrice: '',
			         value: '',
			         picUrl: '',
			         num: '',
			         sealname: '',
			         phone: '',
			        },
		       rules: {
		    	   name: [
			        	  { required: true, message: '请输入商品名称和商品详情', trigger: 'blur' },
				          { min: 2, max: 7, message: '长度在 2 到 7 个字符', trigger: 'blur' }
			          ]
			        },
			  },
			  methods: {
				  submitForm(goods) {
					  var numReg = /^[0-9]+$/
					  var numRe = new RegExp(numReg)

					  if(vm.goods.name === ''){
						  this.$message.error('请输入商品名称！');
						  return false;
					  }else if(vm.goods.counterPrice === ''){
						  this.$message.error('请输入商品原价');
						  return false;
					  }else if(!numRe.test(vm.goods.counterPrice)){
						  this.$message.error('请输入正确的价格');
						  return false;
					  }else if(vm.goods.retailPrice === ''){
						  this.$message.error('请输入商品现售价');
						  return false;
					  }else if(!numRe.test(vm.goods.retailPrice)){
						  this.$message.error('请输入正确的价格');
						  return false;
					  }else if(vm.goods.options.value === ''){
						  this.$message.error('请选择商品折旧程度');
						  return false;
					  }else if(vm.goods.optionsOnce.value === ''){
						  this.$message.error('请选择商品类别');
						  return false;
					  }else if(vm.pics === ''){
						  this.$message.error('商品图片没有上传');
						  return false;
					  }else if(vm.goods.sealname === ''){
						  this.$message.error('请输入卖家姓名');
						  return false;
					  }else if(vm.goods.phone === ''){
						  this.$message.error('请输入卖家电话号码');
						  return false;
					  }else if(!/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test(vm.goods.phone)){
						  this.$message.error('固定电话有误，请重填');
						  return false;
					  }else{
						  let that = this;
						  $.ajax({
					    		type: "post",
					    		dataType:"json",
					    		async:true,//同步异步
					            contentType:"application/json", 
					    		url: "/home/gdsDetails/InsertGoods.do",
					    		data:  JSON.stringify({
					    			"goodsName":vm.goods.name,
					    			"goodsCounterPrice":vm.goods.counterPrice,
					    			"goodsRetailPrice":vm.goods.retailPrice,
					    			"goodsIsnew":vm.goods.options.value,
					    			"goodsClassfy":vm.goods.optionsOnce.value,
					    			"goodsPicUrl":vm.pics.toString(),
					    			"goodsNum":vm.goods.num,
					    			"goodsSealname":vm.goods.sealname,
					    			"goodsPhone":vm.goods.phone,
					    		}), 
					    		success: function(data) {
					    			console.log(data);
				    				that.$message({message: '发布成功~',type: 'success'});
				    				that.$refs.upload.clearFiles();
				    				vm.pics = [];
				    				vm.goods.name = '';
				    				vm.goods.counterPrice = '';
				    				vm.goods.retailPrice = '';
				    				vm.goods.options.value = '';
				    				vm.goods.optionsOnce.value = '';
				    				vm.goods.sealname = '';
				    				vm.goods.phone = '' ;
					    		},
					    		error: function(){
					    			that.$message.error('发布失败！');
					    		}
							});
					  }
				      },
			      resetForm(goods) {
				        this.$refs[goods].resetFields();
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
			    	  //console.log(vm.pics);
			          this.imageUrl = URL.createObjectURL(file.raw);
			        },
			        handleExceed(files, fileList) {//图片上传超过数量限制
			          this.$message.error('上传图片不能超过6张!');
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
	function user() {
		$.ajax({
    		type: "post",
    		dataType:"json",
    		async:false,//同步异步
            contentType:"application/json", 
    		url: "/home/user/users.do",
    		data:  JSON.stringify({
    			userId: localStorage.getItem("userId")
    		}), 
    		success: function(data) {
    			vm.Avater = data.user.userAvater;
    			vm.userName = data.user.userName;
    			vm.sex = data.user.userSex;
    			vm.vip = data.user.userVip;
    			console.log(vm.sex);
    		},
    		error: function(){
    			that.$message.error('用户信息加载失败~');
    		}
		});
	}
	user();
});

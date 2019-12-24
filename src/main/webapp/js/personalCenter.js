$(document).ready(function(){
	var vm = new Vue({
		  el: '#personalCenter',
		  data: {
			  index: '',
			  input: '',
			  isCollapse: true,
			  value: false,
			  maylike1:[],
			  maylike2:[],
			  picurl:[],
			  dialogVisible: false,
			  dialogVisible1: false,
			  dialogVisible2: false,
			  dialogVisible3: false,
			  dialogVisible4: false,
			  dialogVisible5: false,
			  userName: '',
			  Avater: '',
			  sex: '',
			  vips: '',
			  cartGds:[],
		  },
		  methods: {
				  logout: function () {
					  localStorage.removeItem("userId");
					  localStorage.removeItem("root");
					  localStorage.removeItem("password");
					  location.href="/home/index.jsp";
				  },
				  logoutOnce: function () {
					  localStorage.removeItem("userId");
					  localStorage.removeItem("root");
					  localStorage.removeItem("password");
					  location.href="/home/login.do";
				  },
			  	  handleOpen(key, keyPath) {
			        console.log(key, keyPath);
			      },
			      handleClose() {
			    	  console.log(key, keyPath);
			      },
			      handleClose1() {
			    	  this.$confirm('确认关闭？')
			    	  .then(_ => {
			    		  vm.dialogVisible1=false;
			    	  })
			    	  .catch(_ => {});
			      },
			      handleClose2() {
			    	  this.$confirm('确认关闭？')
			    	  .then(_ => {
			    		  vm.dialogVisible2=false;
			    	  })
			    	  .catch(_ => {});
			      },
			      handleClose3() {
			    	  this.$confirm('确认关闭？')
			    	  .then(_ => {
			    		  vm.dialogVisible3=false;
			    	  })
			    	  .catch(_ => {});
			      },
			      handleClose4() {
			    	  this.$confirm('确认关闭？')
			    	  .then(_ => {
			    		  vm.dialogVisible4=false;
			    	  })
			    	  .catch(_ => {});
			      },
			      handleClose5() {
			    	  this.$confirm('确认关闭？')
			    	  .then(_ => {
			    		  vm.dialogVisible5=false;
			    	  })
			    	  .catch(_ => {});
			      },
			      liuyan(){
			    	  console.log(9999);
			    	  sessionStorage.setItem("liuyanId",localStorage.getItem("userId"));
					  location.href = "/home/messageRm.do";
			      },
			      change(){
			    	  	like();
			      },
			      vip(){
			    	  let that = this;
			    		console.log(456);
			    		console.log(vm.vips);
			    	if(vm.vips === '1'){
			    		that.$message.warning('您已经是我们的VIP用户！！');
			    		vm.dialogVisible5 = false;
			    		console.log(111);
			    		return false;
			    	}
			    	console.log(222);
			  			$.ajax({
			  				type: "post",
			  				dataType:"json",
			  				async:false,
			  				contentType:"application/json", 
			  				url: "/home/user/vips.do",
			  				data:  JSON.stringify({
			  					"userId": localStorage.getItem("userId")
			  				}), 
			  				success: function(data) {
			  						that.$message.success('恭喜你，成为我们尊贵的VIP用户！');
			  					}
			  			});
			  			vm.dialogVisible5 = false;
			      },
			      toGoods: function (e) {
			    	  sessionStorage.setItem("goodsId",e);
					  $.ajax({
						  url: "/home/gdsDetails/incView.do",
						  async: false,
						  type: "post",
						  data: JSON.stringify({
							  goodsId: e
						  }),
						  contentType: "application/json",
						  dataType: 'json',
						  success: function(data){
							  window.open("/home/gdsDetail.do");
			              }
					  })
				  },
				  jiagou: function (goodsId) {
					  console.log(goodsId);
					  console.log(222);
					  let that = this;
					  if(localStorage.getItem("userId")==null || localStorage.getItem("userId")==undefined){
						  that.$message.error('请先登录再添加至购物车！！');
						  return false;
						}
					  $.ajax({
						  url: "/home/cart/select.do",
						  async: false,
						  type: "post",
						  data: JSON.stringify({
							  userId: localStorage.getItem("userId")
						  }),
						  contentType: "application/json",
						  dataType: 'json',
						  success: function(data){
							 console.log(999);
				              for(var i=0; i<data.length; i++){
				            	  vm.cartGds.push(data[i].goodsId);
				              }
				              if(data.length == 0){
				            	  console.log(888);
				            	  console.log(vm.cartGds);
				            	  $.ajax({
									  url: "/home/gdsDetails/adCart.do",
									  async: false,
									  type: "post",
									  data: JSON.stringify({
										  goodsId: sessionStorage.getItem("goodsId"),
										  userId: localStorage.getItem("userId"),
										  goodsNum: 1
									  }),
									  contentType: "application/json",
									  dataType: 'json',
									  success: function(res){
										  console.log(localStorage.getItem("userId"));
							              if(res.code == "200"){
							            	  that.$message({message: '添加购物车成功~',type: 'success'});
							              }else{
							            	  that.$message.error('啊哦！系统错误，请稍后添加');
							              }
							              
						              }
								  })
				              }
				              //console.log(vm.cartGds);
			            }
					  })
					  for(var i=0; i<vm.cartGds.length; i++){
						  if(vm.cartGds[i] == goodsId){
							  this.$message({
						          message: '您的购物车已有此商品哦~',
						          type: 'warning'
						        });
							  break;
						  }else{
							  $.ajax({
								  url: "/home/gdsDetails/adCart.do",
								  async: false,
								  type: "post",
								  data: JSON.stringify({
									  goodsId: goodsId,
									  userId: localStorage.getItem("userId"),
									  goodsNum: 1
								  }),
								  contentType: "application/json",
								  dataType: 'json',
								  success: function(res){
						              if(res.code == "200"){
						            	  that.$message({message: '添加购物车成功~',type: 'success'});
						              }else{
						            	  that.$message.error('啊哦！系统错误，请稍后添加');
						              }
						              
					              }
							  })
							  vm.cartGds = [];
							  break;
						  }
					  }
				  },
		  },
		  filters: {
			  
		  },
		  
	});
	function like() {
		$.ajax({
    		type: "post",
    		dataType:"json",
    		async:false,//同步异步
            contentType:"application/json", 
    		url: "/home/gdsDetails/maylike.do",
    		data:  JSON.stringify({
    			//needId:e1,
    		}), 
    		success: function(data) {
    			//vm.qiugou[e2].needTime = data.list;
    			console.log(data);
    			vm.maylike1 = data.list;
    			for(let i=0;i<data.list.length;i++){
    				vm.maylike1[i].goodsPics = data.list[i].goodsPics.split(',');
    			}
    			console.log(vm.maylike1);
    			console.log(vm.maylike1.length);
    			vm.picurl = vm.maylike1.picUrl;

    		},
    		error: function(){
    			that.$message.error('猜你喜欢加载失败~');
    		}
		});
	}
	like();
	
	function user() {
		console.log(111);
		console.log(222);
		console.log(localStorage.getItem("userId"));
		if(!window.localStorage){
			return false;
		}
		if(localStorage.getItem("userId")==null || localStorage.getItem("userId")==undefined){
			return false;
		}
		
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
    			vm.vips = data.user.userVip;
    			console.log(vm.vips);
    			console.log(999);
    		},
    		error: function(){
    			that.$message.error('用户信息加载失败~');
    		}
		});
	}
	user();
});

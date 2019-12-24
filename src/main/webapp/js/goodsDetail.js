$(document).ready(function(){
	var vm = new Vue({
		  el: '#goodsDetail',
		  data: {
			  goods:[],
			  dialogVisible:false,
			  visible:false,
			  num:1,
			  cartGds:[],
			  dialogFormVisible: false,
		  },
			
		  methods: {
			  cart() {
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
						  userId: localStorage.getItem("userId"),
					  }),
					  contentType: "application/json",
					  dataType: 'json',
					  success: function(data){
						  console.log(333);
						  //console.log(data);
			              for(let i=0; i<data.length; i++){
			            	  vm.cartGds.push(data[i].goodsId);
			              }
			              if(data.length == 0){
			            	  $.ajax({
								  url: "/home/gdsDetails/adCart.do",
								  async: false,
								  type: "post",
								  data: JSON.stringify({
									  goodsId: sessionStorage.getItem("goodsId"),
									  userId: localStorage.getItem("userId"),
									  goodsNum: vm.num
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
							  vm.visible = false;
			              }
			             // console.log(localStorage.getItem("userId"));
			              //console.log(vm.cartGds);
		            }
				  })
				  for(let i=0; i<vm.cartGds.length; i++){
					  console.log(555);
					  console.log(666);
					  if(vm.cartGds[i] == vm.goods.goodsId){
						  this.$message({
					          message: '您的购物车已有此商品哦~',
					          type: 'warning'
					        });
						  vm.visible = false;
						  break;
					  }else{
						  console.log(777);
						  console.log(localStorage.getItem("userId"));
						  $.ajax({
							  url: "/home/gdsDetails/adCart.do",
							  async: false,
							  type: "post",
							  data: JSON.stringify({
								  goodsId: sessionStorage.getItem("goodsId"),
								  userId: localStorage.getItem("userId"),
								  goodsNum: vm.num
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
						  vm.cartGds = [];
						  vm.visible = false;
						  break;
					  }
				  }
			  },
			  handleChange(value) {
				  //console.log(value);
			  },
			  
			  /**
			   * 取消购买
			   */
			  monenyCancel(){
				  /*var gdId = sessionStorage.getItem("goodsId");
				  var gdsList = [];
				  gdsList.push(gdId);
				  $.ajax({
					  url: "/home/order/addOrders.do",
					  async: false,
					  type: "post",
					  data: JSON.stringify({
						  gdsList: gdsList,
					  }),
					  contentType: "application/json",
					  dataType: 'json',
					  success: function(res){
			              
					  }
				  })*/
				  dialogFormVisible = false
			  },
			  buynow(){
				  let that = this;
				  console.log(111);
				  if(localStorage.getItem("userId")==null || localStorage.getItem("userId")==undefined){
					  that.$message.error('请先登录再添加至购物车！！');
					  return false;
					}
				  vm.dialogFormVisible = true
			  },
			  /**
			   * 立即购买
			   */
			  moneyConfirm(){
				  $.ajax({
					  url: "/home/order/addOrder.do",
					  async: false,
					  type: "post",
					  data: JSON.stringify({
						  goodsId: sessionStorage.getItem("goodsId"),
						  userId: localStorage.getItem("userId")
					  }),
					  contentType: "application/json",
					  dataType: 'json',
					  success: function(res){
			              
					  }
				  })
				  vm.dialogFormVisible = false;
				  this.$message({
			            type: 'success',
			            message: '购买成功',
			          });
		      },
		  },
		  filters: {
			  xinxian: function (value) {
			    if (!value) return '';
			    value = value.toString();
			    if(value == 1){
			    	return "一成新，望深思";
			    }else if(value == 2){
			    	return "两成新，望深思";
			    }else if(value == 3){
			    	return "三成新，望深思";
			    }else if(value == 4){
			    	return "四成新，望深思";
			    }else if(value == 5){
			    	return "五成新，还可以";
			    }else if(value == 6){
			    	return "六成新，还可以";
			    }else if(value == 7){
			    	return "七成新，还可以";
			    }else if(value == 8){
			    	return "八成新，很不错";
			    }else if(value == 9){
			    	return "九成新，非常棒";
			    }else{
			    	return "全新，简直完美";
			    }
			  },
			  date: function(date){
					var date = new Date(date);
					Y = date.getFullYear() ;
					M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) ;
					D = date.getDate();
					h = date.getHours() + ':';
					m = date.getMinutes() + ':';
					s = date.getSeconds(); 
					return (Y+"年"+M+"月"+D+"日");
			 },
		  }
		  
	});
	
	/**
	   * 添加购物车
	   */
	function adCart(){
		  
	  }
	
	/**
	 * 获取当前商品详细信息
	 * @returns
	 */
	function getGdsDetail(){
		var gdId = sessionStorage.getItem("goodsId");
		$.ajax({
			  url: "/home/gdsDetails/gdsDetails.do",
			  async: false,
			  type: "post",
			  data: JSON.stringify({
				  gdId: gdId
			  }),
			  contentType: "application/json",
			  dataType: 'json',
			  success: function(data){
	              vm.goods = data.goods;
	              //console.log(vm.goods);
	              vm.goods.goodsPics = data.goods.goodsPics.split(",");
	              //console.log(vm.goods.goodsNum);
	              console.log(vm.goods.goodsId);
              }
		  })
	  }
	getGdsDetail();
});

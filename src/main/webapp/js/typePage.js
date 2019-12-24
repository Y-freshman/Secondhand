$(document).ready(function(){
	var vm = new Vue({
		  el: '#typePage',
		  data: {
			  items1:[],
			  items2:[],
			  items3:[],
			  cartGds:[],
			  name:sessionStorage.getItem("typePage")
		  },
		  methods: { 
			  jubao: function () {
				  this.$message({
					  message: '我们已收到您的举报，感谢支持！',
					  type: 'warning'
				  });
			  },
			  back: function () {
				  window.history.go(-1);
			  },
			  toGoods: function (e) {
				  sessionStorage.setItem("goodsId",e);
				  var star=getCookieById("goodsId",e);
				    if(star==""){
				        addCookieById("goodsId",e,2); 
				    }else{
				    	window.open("/home/gdsDetail.do");
				    	return false;
				    }
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
			  jiagou: function(goodsId){
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
						  userId: 1
					  }),
					  contentType: "application/json",
					  dataType: 'json',
					  success: function(data){
			              for(var i=0; i<data.length; i++){
			            	  vm.cartGds.push(data[i].goodsId);
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
								  userId: 1,
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
	function xr_Page() {
		
		$.ajax({
			type: "post",
			dataType:"json",
			async:false,//同步异步
			contentType:"application/json", 
			url: "/home/gdsDetails/selectTypePage.do",
			data:  JSON.stringify({
				goodsType:sessionStorage.getItem("typePage"),
			}), 
			success: function(data) {
				//console.log(data.list);
				vm.items1 = [];
				vm.items2 = [];
				vm.items3 = [];
				for(let i =0;i<=data.list.length/3;i++){
					if((i*3)<data.list.length){
						vm.items1.push(data.list[i*3]);
						vm.items1[i].goodsPics = data.list[i*3].goodsPics.split(",");
					}
					if((i*3+1)<data.list.length){
						vm.items2.push(data.list[i*3+1]);
						vm.items2[i].goodsPics = data.list[i*3+1].goodsPics.split(",");
					}
					if((i*3+2)<data.list.length){
						vm.items3.push(data.list[i*3+2]);
						vm.items3[i].goodsPics = data.list[i*3+2].goodsPics.split(",");
					}
				}
			},
			error: function(){
				alert('数据加载失败~');
			}
		});
	}
	xr_Page();	
	
	/*
	* 获取特定cookie的值
	* @param    cookie键
	* @return   cookie该键对应的值
	* */
	function getCookie(cname){
	    var name=cname+"=";
	    var ca=document.cookie.split(';');
	    for(var i=0;i<ca.length;i++){
	        var c=ca[i].trim();
	        if(c.indexOf(name)==0)
	            return c.substring(name.length,c.length);
	    }
	    return "";
	}

	/*
	* 判断cookie键中是否有某个资源的id
	* @param    cookie键
	* @param    查询资源id
	* @return   存在返回true，否则返回""
	* */
	function getCookieById(cname,id){
	    var name=cname+"=";
	    var ca=document.cookie.split(';');
	    var cValue="";
	    for(var i=0;i<ca.length;i++){
	        var c=ca[i].trim();
	        if(c.indexOf(name)==0)
	            cValue=c.substring(name.length,c.length);
	    }
	    if(cValue!=""){
	        var cArray=cValue.split(",");
	        for(var i=0;i<cArray.length;i++){
	            var c=cArray[i].trim();
	            if(c.indexOf(id)==0){
	                return true;
	            }
	        }
	    }
	    return "";
	}


	/*
	* 添加某个资源id到cookie键中
	* @param    cookie键名
	* @param    资源id
	* @param    cookie过期时间
	* */
	function addCookieById(cname,id,exdays){
	    var cvalue=getCookie(cname);
	    if(cvalue==""){
	        cvalue=id;
	    }else {
	        var cArray=cvalue.split(",");
	        var flag=0;
	        for(var i=0;i<cArray.length;i++){
	            var c=cArray[i].trim();
	            if(c.indexOf(id)==0){
	                flag=1;
	                break;
	            }
	        }
	        if(flag==0) {
	            cvalue += "," + id;
	        }
	    }

	    var d=new Date();
	    d.setTime(d.getTime()+(exdays*60*60*1000));
	    var expires="expires="+d.toGMTString();
	    document.cookie=cname+"="+cvalue+"; "+expires;
	}
		
});

$(document).ready(function(){
	var vm = new Vue({
		  el: '#shouye',
		  data: {
			  lunbo:[],
			  hot1:[],
			  hot2:[],
			  dzsm1:[],
			  dzsm2:[],
			  fzss1:[],
			  fzss2:[],
			  jsls1:[],
			  wjts1:[],
			  sxsc1:[],
			  tyjs1:[],
			  wsjj1:[],
			  fnyy1:[],
			  bgjj1:[],
			  jsls2:[],
			  wjts2:[],
			  sxsc2:[],
			  tyjs2:[],
			  wsjj2:[],
			  fnyy2:[],
			  bgjj2:[],
			  qiugou:[],
			  text:'',
			  lbt:[],
			  cartGds:[],
		  },
		  methods: { 
			  jubao: function () {
				  this.$message({
					  message: '我们已收到您的举报，感谢支持！',
					  type: 'warning'
				  });
			  },
			  liuyan: function (e) {
				  if(localStorage.getItem("userId")==null || localStorage.getItem("userId")==undefined){
					  this.$message.error('请先登录！');
					  return false;
				  }
				  sessionStorage.setItem("liuyanId",e);
				  location.href = "/home/messageRm.do";
				    
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
			  jiagou: function (goodsId) {
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
			              for(var i=0; i<data.length; i++){
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
			  fabu: function (e1,e2) {
				  if(localStorage.getItem("userId")==null || localStorage.getItem("userId")==undefined){
					  this.$message.error('请先登录再发布评论！！');
					  return false;
					}
				  if(vm.text.match(/^[ ]*$/)){
					  this.$message.error('评论不能为空！');
					  return false;
				  }else{
					  let that = this;
					  $.ajax({
				    		type: "post",
				    		dataType:"json",
				    		async:true,//同步异步
				            contentType:"application/json", 
				    		url: "/home/comment/insert.do",
				    		data:  JSON.stringify({
				    			"commentContent":vm.text,
				    			"needId":e1,
				    			"userId":localStorage.getItem("userId"),
				    		}), 
				    		success: function(data) {
				    			//console.log(data);
			    				that.$message({message: '评论发布成功~',type: 'success'});
			    				vm.text = "";
			    				xr_qiugou();
			    				xr_comment(e1,e2);
			    				
				    		},
				    		error: function(){
				    			that.$message.error('发布失败！');
				    		}
						});
				  }
			  },
			  like: function (e,e1,e2) {
				  var star=getCookieById("star",e);
				    if(star==""){
				        addCookieById("star",e,2); 
				    }else{
				    	this.$message.error("您两个小时内已经点过赞了~");
				    	return false;
				    }
				  let that = this;
				  $.ajax({
					  type: "post",
					  dataType:"json",
					  async:true,//同步异步
					  contentType:"application/json", 
					  url: "/home/comment/update.do",
					  data:  JSON.stringify({
						  "commentId":e,
					  }), 
					  success: function(data) {
						  //console.log(data);
						  //that.$message({message: '点赞成功~',type: 'success'});
						  xr_comment(e1,e2);
						  
					  },
					  error: function(){
						  that.$message.error('点赞失败！');
					  }
				  });
				  
			  },
			  sqpl: function (e) {
				  $("#qg_sqpl"+e).css("display","none");
				  $("#qg_plsl"+e).fadeIn(500);
				  $("#qg_zkpl"+e).fadeIn(500);
				  $("#qg_pl"+e).slideUp(500);
			  },
			  zkpl: function (e,e1) {
				  xr_comment(e,e1)
				  $("#qg_plsl"+e).css("display","none");
				  $("#qg_zkpl"+e).css("display","none");
				  $("#qg_sqpl"+e).fadeIn(500);
				  $("#qg_pl"+e).slideDown(500);
				  var need=getCookieById("need",e);
				    if(need==""){
				        addCookieById("need",e,12); 
				    }else{
				    	//this.$message.error("您两个小时内已经点过赞了~");
				    	return false;
				    }
				  let that = this;
				  $.ajax({
					  type: "post",
					  dataType:"json",
					  async:true,//同步异步
					  contentType:"application/json", 
					  url: "/home/need/update.do",
					  data:  JSON.stringify({
						  "needId":e,
					  }), 
					  success: function(data) {
						 
					  },
					  error: function(){
						  //that.$message.error('浏览失败！');
					  }
				  });
			  },
			  xr_lb: function (e1) {
				  vm.lunbo = vm.qiugou[e1].needPics;
			  },
		  },
		  filters: {
			  vip: function (value) {
				    if (!value) return '';
				    value = value.toString();
				    if(value == 0){
				    	return "img/touming.png";
				    }else{
				    	return "img/vip_2.jpg";
				    }
			  },
			  date: function (value) {
				  if (!value) return '';
				  value = value.toString();
				  return time(value);
				  
			  },
		  },
		  updated:function (){
			  //window.addEventListener('scroll', scrollHandle(), true);
		  }
	});
	function xr_Type(e1,e2) {
		let that = this;
		$.ajax({
			type: "post",
			dataType:"json",
			async:false,//同步异步
			contentType:"application/json", 
			url: "/home/gdsDetails/selectByType.do",
			data:  JSON.stringify({
				goodsType:e1,
			}), 
			success: function(data) {
				//console.log(data.list);
				if(e2 == 1){
					vm.dzsm1 = [];
					vm.dzsm2 = [];
					for(let i =0;i<data.list.length/2;i++){
						vm.dzsm1.push(data.list[i*2]);
						vm.dzsm1[i].goodsPics = data.list[i*2].goodsPics.split(",");
						vm.dzsm2.push(data.list[i*2+1]);
						vm.dzsm2[i].goodsPics = data.list[i*2+1].goodsPics.split(",");
					}
				}else if(e2 == 2){
					vm.fzss1 = [];
					vm.fzss2 = [];
					for(let i =0;i<data.list.length/2;i++){
						vm.fzss1.push(data.list[i*2]);
						vm.fzss1[i].goodsPics = data.list[i*2].goodsPics.split(",");
						vm.fzss2.push(data.list[i*2+1]);
						vm.fzss2[i].goodsPics = data.list[i*2+1].goodsPics.split(",");
					}
				}else if(e2 == 3){
					vm.jsls1 = [];
					vm.jsls2 = [];
					for(let i =0;i<data.list.length/2;i++){
						vm.jsls1.push(data.list[i*2]);
						vm.jsls1[i].goodsPics = data.list[i*2].goodsPics.split(",");
						vm.jsls2.push(data.list[i*2+1]);
						vm.jsls2[i].goodsPics = data.list[i*2+1].goodsPics.split(",");
					}
				}else if(e2 == 4){
					vm.wjts1 = [];
					vm.wjts2 = [];
					for(let i =0;i<data.list.length/2;i++){
						vm.wjts1.push(data.list[i*2]);
						vm.wjts1[i].goodsPics = data.list[i*2].goodsPics.split(",");
						vm.wjts2.push(data.list[i*2+1]);
						vm.wjts2[i].goodsPics = data.list[i*2+1].goodsPics.split(",");
					}
				}else if(e2 == 5){
					vm.sxsc1 = [];
					vm.sxsc2 = [];
					for(let i =0;i<data.list.length/2;i++){
						vm.sxsc1.push(data.list[i*2]);
						vm.sxsc1[i].goodsPics = data.list[i*2].goodsPics.split(",");
						vm.sxsc2.push(data.list[i*2+1]);
						vm.sxsc2[i].goodsPics = data.list[i*2+1].goodsPics.split(",");
					}
				}else if(e2 == 6){
					vm.tyjs1 = [];
					vm.tyjs2 = [];
					for(let i =0;i<data.list.length/2;i++){
						vm.tyjs1.push(data.list[i*2]);
						vm.tyjs1[i].goodsPics = data.list[i*2].goodsPics.split(",");
						vm.tyjs2.push(data.list[i*2+1]);
						vm.tyjs2[i].goodsPics = data.list[i*2+1].goodsPics.split(",");
					}
				}else if(e2 == 7){
					vm.wsjj1 = [];
					vm.wsjj2 = [];
					for(let i =0;i<data.list.length/2;i++){
						vm.wsjj1.push(data.list[i*2]);
						vm.wsjj1[i].goodsPics = data.list[i*2].goodsPics.split(",");
						vm.wsjj2.push(data.list[i*2+1]);
						vm.wsjj2[i].goodsPics = data.list[i*2+1].goodsPics.split(",");
					}
				}else if(e2 == 8){
					vm.fnyy1 = [];
					vm.fnyy2 = [];
					for(let i =0;i<data.list.length/2;i++){
						vm.fnyy1.push(data.list[i*2]);
						vm.fnyy1[i].goodsPics = data.list[i*2].goodsPics.split(",");
						vm.fnyy2.push(data.list[i*2+1]);
						vm.fnyy2[i].goodsPics = data.list[i*2+1].goodsPics.split(",");
					}
				}else{
					vm.bgjj1 = [];
					vm.bgjj2 = [];
					for(let i =0;i<data.list.length/2;i++){
						vm.bgjj1.push(data.list[i*2]);
						vm.bgjj1[i].goodsPics = data.list[i*2].goodsPics.split(",");
						vm.bgjj2.push(data.list[i*2+1]);
						vm.bgjj2[i].goodsPics = data.list[i*2+1].goodsPics.split(",");
					}
				}
				
			},
			error: function(){
				that.$message.error('电子数码加载失败~');
			}
		});
	}
	function xr_comment(e1,e2) {
		$.ajax({
    		type: "post",
    		dataType:"json",
    		async:false,//同步异步
            contentType:"application/json", 
    		url: "/home/comment/select.do",
    		data:  JSON.stringify({
    			needId:e1,
    		}), 
    		success: function(data) {
    			vm.qiugou[e2].needTime = data.list;
    		},
    		error: function(){
    			that.$message.error('评论加载失败~');
    		}
		});
	}
	function xr_qiugou() {
		let that = this;
		$.ajax({
			type: "post",
			dataType:"json",
			async:false,//同步异步
			contentType:"application/json", 
			url: "/home/need/select.do",
			data:  JSON.stringify({
				type:0,
			}), 
			success: function(data) {
				console.log(data.list);
				vm.qiugou = data.list;
				for(let i =0;i<data.list.length;i++){
					vm.qiugou[i].needPics = data.list[i].needPics.split(",");
					vm.qiugou[i].needTime = [];
				}
			},
			error: function(){
				that.$message.error('数据加载失败~');
			}
		});
	}
	xr_qiugou();	
	function xr_hot() {
		let that = this;
		$.ajax({
			type: "post",
			dataType:"json",
			async:false,//同步异步
			contentType:"application/json", 
			url: "/home/gdsDetails/selectByView.do",
			data:  JSON.stringify({
				
			}), 
			success: function(data) {
				//console.log(data.list);
				vm.hot1 = [];
				vm.hot2 = [];
				for(let i =0;i<data.list.length/2;i++){
					vm.hot1.push(data.list[i*2]);
					vm.hot1[i].goodsPics = data.list[i*2].goodsPics.split(",");
					vm.hot2.push(data.list[i*2+1]);
					vm.hot2[i].goodsPics = data.list[i*2+1].goodsPics.split(",");
				}
			},
			error: function(){
				that.$message.error('人气排行加载失败~');
			}
		});
	}
	xr_hot();
	function xr_lbt() {
		let that = this;
		$.ajax({
			type: "post",
			dataType:"json",
			async:true,//同步异步
			contentType:"application/json", 
			url: "/home/turn/select.do",
			data:  JSON.stringify({
				
			}), 
			success: function(data) {
				//console.log(data.list);
				vm.lbt = data.list;
			},
			error: function(){
				that.$message.error('轮播图加载失败~');
			}
		});
	}
	xr_lbt();
	
	/*
	function scrollHandle () {
		let obj = $("#shouye_gyyl")[0];
	    const offset = obj.getBoundingClientRect(); // vue中，使用this.$el获取当前组件的根元素
	    const offsetTop = offset.top;
	    const offsetBottom = offset.bottom;
	    const offsetHeight = offset.height;
	    // 进入可视区域
	    if (offsetTop <= window.innerHeight && offsetBottom >= 0) {
	        console.log('进入可视区域');
	        // do something...
	    } else {
	        console.log('移出可视区域');
	        // do something...
	    }
	}*/
	var i1 = 0;
	var i2 = 0;
	var i3 = 0;
	var i4 = 0;
	var i5 = 0;
	var i6 = 0;
	var i7 = 0;
	var i8 = 0;
	var i9 = 0;
	$(window).scroll(function() {
	  //为了保证兼容性，这里取两个值，哪个有值取哪一个
	  //scrollTop就是触发滚轮事件时滚轮的高度
	  var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
	  dzsmTop = $("#shouye_dzsm")[0].getBoundingClientRect().top;
	  fzssTop = $("#shouye_fzss")[0].getBoundingClientRect().top;
	  jslsTop = $("#shouye_jsls")[0].getBoundingClientRect().top;
	  wjtsTop = $("#shouye_wjts")[0].getBoundingClientRect().top;
	  sxscTop = $("#shouye_sxsc")[0].getBoundingClientRect().top;
	  tyjsTop = $("#shouye_tyjs")[0].getBoundingClientRect().top;
	  wsjjTop = $("#shouye_wsjj")[0].getBoundingClientRect().top;
	  fnyyTop = $("#shouye_fnyy")[0].getBoundingClientRect().top;
	  bgjjTop = $("#shouye_bgjj")[0].getBoundingClientRect().top;
	  if(scrollTop >= dzsmTop && i1 == 0){
		  xr_Type("电子数码",1);
		  i1 = 1;
	  }
	  if(scrollTop >= fzssTop && i2 == 0){
		  xr_Type("服装首饰",2);
		  i2 = 1;
	  }
	  if(scrollTop >= jslsTop && i3 == 0){
		  xr_Type("酒水零食",3);
		  i3 = 1;
	  }
	  if(scrollTop >= wjtsTop && i4 == 0){
		  xr_Type("文具图书",4);
		  i4 = 1;
	  }
	  if(scrollTop >= sxscTop && i5 == 0){
		  xr_Type("生鲜食材",5);
		  i5 = 1;
	  }
	  if(scrollTop >= tyjsTop && i6 == 0){
		  xr_Type("体育健身",6);
		  i6 = 1;
	  }
	  if(scrollTop >= wsjjTop && i7 == 0){
		  xr_Type("卫生洁具",7);
		  i7 = 1;
	  }
	  if(scrollTop >= fnyyTop && i8 == 0){
		  xr_Type("妇女婴幼",8);
		  i8 = 1;
	  }
	  if(scrollTop >= bgjjTop && i9 == 0){
		  xr_Type("办公家居",9);
		  i9 = 1;
	  }
	  //console.log("滚动距离" + scrollTop);
	})
	function time(dateTimeStamp) {
	    var minute = 1000 * 60;
	    var hour = minute * 60;
	    var day = hour * 24;
	    var halfamonth = day * 15;
	    var month = day * 30;
	    var year = day * 365;
	    var now = new Date().getTime();
	    var diffValue = now - dateTimeStamp;
	    if(diffValue < 0){return;}
	    var yearC =diffValue/year;
	    var monthC =diffValue/month;
	    var weekC =diffValue/(7*day);
	    var dayC =diffValue/day;
	    var hourC =diffValue/hour;
	    var minC =diffValue/minute;
	    if(yearC>=1){
	        result="" + parseInt(yearC) + "年前";
	    }
	    else if(monthC>=1){
	    	result="" + parseInt(monthC) + "月前";
	    }
	    else if(weekC>=1){
	    	result="" + parseInt(weekC) + "周前";
	    }
	    else if(dayC>=1){
	        result=""+ parseInt(dayC) +"天前";
	    }
	    else if(hourC>=1){
	        result=""+ parseInt(hourC) +"小时前";
	    }
	    else if(minC>=1){
	        result=""+ parseInt(minC) +"分钟前";
	    }else
	        result="刚刚";
	    return result;
	};//时间戳转化为几天前，几小时前，几分钟前
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

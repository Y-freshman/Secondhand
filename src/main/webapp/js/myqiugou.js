$(document).ready(function(){
	var vm = new Vue({
		  el: '#myqiugou',
		  data: {
		    lunbo:[],
		    items1:[],
		    items2:[],
		    items3:[],
		    text:'',
		    start:localStorage.getItem("userId"),
		    type:1,
		  },
		  methods: { 
			  jubao: function () {
				  this.$message({
					  message: '我们已收到您的举报，感谢支持！',
					  type: 'warning'
				  });
			  },
			  typeChange: function (e) {
				  vm.type = e;
				  console.log(vm.type);
				  xr_qiugou();
			  },
			  fabu: function (e1,e2,e3) {
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
			    				xr_comment(e1,e2,e3);
			    				
				    		},
				    		error: function(){
				    			that.$message.error('发布失败！');
				    		}
						});
				  }
			  },
			  like: function (e,e1,e2,e3) {
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
						  xr_comment(e1,e2,e3);
						  
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
			  liuyan: function (e) {
				    console.log(e);
				    console.log("=========");
				    
				    this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
				          confirmButtonText: '确定',
				          cancelButtonText: '取消',
				          type: 'warning'
				        }).then(() => {
			        	 $.ajax({
							  type: "post",
							  dataType:"json",
							  async:false,//同步异步
							  contentType:"application/json", 
							  url: "/home/need/deleteNeed.do",
							  data:  JSON.stringify({
								  "needId":e,
							  }), 
						  });
			        	  xr_qiugou();
				          this.$message({
				            type: 'success',
				            message: '删除成功!'
				          });
				        }).catch(() => {
				          this.$message({
				            type: 'info',
				            message: '已取消删除'
				          });          
				        });
				    
				   
					 console.log("=========");
			  },
			  zkpl: function (e,e1,e2) {
				  xr_comment(e,e1,e2)
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
			  fbqg: function () {
				  window.open("/home/fabuqiugou.do");
			  },
			  xr_lb: function (e1,e2) {
				  if(e2 == 1){
					  vm.lunbo = vm.items1[e1].needPics;
				  }else if(e2 == 2){
					  vm.lunbo = vm.items2[e1].needPics;
				  }else{
					  vm.lunbo = vm.items3[e1].needPics;
				  }
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
		  
	});
	function xr_comment(e1,e2,e3) {
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
    			if(e3 == 1){
    				vm.items1[e2].needTime = data.list;
			  }else if(e3 == 2){
				  vm.items2[e2].needTime = data.list;
			  }else{
				  vm.items3[e2].needTime = data.list;
			  }
    			
    		},
    		error: function(){
    			that.$message.error('评论加载失败~');
    		}
		});
	}
	function xr_qiugou() {
		let that = this;
		console.log(2222);
		console.log(vm.type);
		
		$.ajax({
			type: "post",
			dataType:"json",
			async:false,//同步异步
			contentType:"application/json", 
			url: "/home/need/selectUser.do",
			data:  JSON.stringify({
				userId:vm.start,
				type:vm.type,
			}), 
			success: function(data) {
				//console.log(data.list);
				vm.items1 = [];
				vm.items2 = [];
				vm.items3 = [];
				for(let i =0;i<=data.list.length/3;i++){
					if((i*3)<data.list.length){
						vm.items1.push(data.list[i*3]);
						vm.items1[i].needPics = data.list[i*3].needPics.split(",");
						vm.items1[i].needTime = [];
					}
					if((i*3+1)<data.list.length){
						vm.items2.push(data.list[i*3+1]);
						vm.items2[i].needPics = data.list[i*3+1].needPics.split(",");
						vm.items2[i].needTime = [];
					}
					if((i*3+2)<data.list.length){
						vm.items3.push(data.list[i*3+2]);
						vm.items3[i].needPics = data.list[i*3+2].needPics.split(",");
						vm.items3[i].needTime = [];
					}
				}
			},
			error: function(){
				that.$message.error('数据加载失败~');
			}
		});
	}
	xr_qiugou();	
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

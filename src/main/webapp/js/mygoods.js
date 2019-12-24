$(document).ready(function(){
	var vm = new Vue({
		  el: '#mygoods',
		  data: {
			  input:sessionStorage.getItem("input"),
			  items1:[],
			  items2:[],
			  items3:[],
			  items4:[],
			  list:[],
			  list2:[],
			  loading:true,
			  qb:0,
			  dzsm:0,
			  fzss:0,
			  jsls:0,
			  wjts:0,
			  sxsc:0,
			  tyjs:0,
			  wsjj:0,
			  fnyy:0,
			  bgjj:0,
			  cartGds:[],
			  cartNums: '',
		  },
		  methods: { 
			  jubao: function () {
				  this.$message({
					  message: '我们已收到您的举报，感谢支持！',
					  type: 'warning'
				  });
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
				  console.log(goodsId);
				  
				  this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
			          confirmButtonText: '确定',
			          cancelButtonText: '取消',
			          type: 'warning'
			        }).then(() => {
			        	
			        	 $.ajax({
							  type: "post",
							  dataType:"json",
							  async:true,//同步异步
							  contentType:"application/json", 
							  url: "/home/gdsDetails/deleteGoods.do",
							  data:  JSON.stringify({
								  "goodsId":goodsId,
							  }), 
							  success: function(data) { 
							  }
						  });
			        	 this.$message({
					            type: 'success',
					            message: '删除成功!'
					          });
			        	 let that = this;
							
							$.ajax({
								type: "post",
								dataType:"json",
								async:true,//同步异步
								contentType:"application/json", 
								url: "/home/gdsDetails/selectMygoods.do",
								data:  JSON.stringify({
									userId:localStorage.getItem("userId"),
								}), 
								success: function(data) {
									vm.qb = data.list.length;
									vm.list2 = data.list;
									for(let i =0;i<data.list.length;i++){
										if(data.list[i].goodsType == "电子数码"){
											vm.dzsm++;
										}else if(data.list[i].goodsType == "服装首饰"){
											vm.fzss++;
										}else if(data.list[i].goodsType == "酒水零食"){
											vm.jsls++;
										}else if(data.list[i].goodsType == "文具图书"){
											vm.wjts++;
										}else if(data.list[i].goodsType == "生鲜食材"){
											vm.sxsc++;
										}else if(data.list[i].goodsType == "体育健身"){
											vm.tyjs++;
										}else if(data.list[i].goodsType == "卫生洁具"){
											vm.wsjj++;
										}else if(data.list[i].goodsType == "妇女婴幼"){
											vm.fnyy++;
										}else{
											vm.bgjj++;
										}
									}
									vm.items1 = [];
									vm.items2 = [];
									vm.items3 = [];
									vm.items4 = [];
									for(let i =0;i<=data.list.length/4;i++){
										if((i*4)<data.list.length){
											vm.items1.push(data.list[i*4]);
											vm.items1[i].goodsPics = data.list[i*4].goodsPics.split(",");
											
										}
										if((i*4+1)<data.list.length){
											vm.items2.push(data.list[i*4+1]);
											vm.items2[i].goodsPics = data.list[i*4+1].goodsPics.split(",");
											
										}
										if((i*4+2)<data.list.length){
											vm.items3.push(data.list[i*4+2]);
											vm.items3[i].goodsPics = data.list[i*4+2].goodsPics.split(",");
											
										}
										if((i*4+3)<data.list.length){
											vm.items4.push(data.list[i*4+3]);
											vm.items4[i].goodsPics = data.list[i*4+3].goodsPics.split(",");
											
										}
									}
									vm.loading = false;
								},
								error: function(){
									that.$message.error('商品加载失败~');
								}
							})
			          
			        }).catch(() => {
			          this.$message({
			            type: 'info',
			            message: '已取消删除'
			          });          
			        });
			  },
			  type: function (e) {
				    vm.list=[];
				  	if(e == 0){
				  		vm.list = vm.list2;
				  	}else if(e == 1){
			  			for(let i =0;i<vm.list2.length;i++){
			  				//vm.list2[i].goodsPics = vm.list2[i].goodsPics.split(",");
							if(vm.list2[i].goodsType == "电子数码"){
								vm.list.push(vm.list2[i]);
							}
						}
				  	}else if(e == 2){
			  			for(let i =0;i<vm.list2.length;i++){
			  				//vm.list2[i].goodsPics = vm.list2[i].goodsPics.split(",");
							if(vm.list2[i].goodsType == "服装首饰"){
								vm.list.push(vm.list2[i]);
							}
						}
				  	}else if(e == 3){
			  			for(let i =0;i<vm.list2.length;i++){
			  				//vm.list2[i].goodsPics = vm.list2[i].goodsPics.split(",");
							if(vm.list2[i].goodsType == "酒水零食"){
								vm.list.push(vm.list2[i]);
							}
						}
				  	}else if(e == 4){
			  			for(let i =0;i<vm.list2.length;i++){
			  				//vm.list2[i].goodsPics = vm.list2[i].goodsPics.split(",");
							if(vm.list2[i].goodsType == "文具图书"){
								vm.list.push(vm.list2[i]);
							}
						}
				  	}else if(e == 5){
			  			for(let i =0;i<vm.list2.length;i++){
			  				//vm.list2[i].goodsPics = vm.list2[i].goodsPics.split(",");
							if(vm.list2[i].goodsType == "生鲜食材"){
								vm.list.push(vm.list2[i]);
							}
						}
				  	}else if(e == 6){
			  			for(let i =0;i<vm.list2.length;i++){
			  				//vm.list2[i].goodsPics = vm.list2[i].goodsPics.split(",");
							if(vm.list2[i].goodsType == "体育健身"){
								vm.list.push(vm.list2[i]);
							}
						}
				  	}else if(e == 7){
			  			for(let i =0;i<vm.list2.length;i++){
			  				//vm.list2[i].goodsPics = vm.list2[i].goodsPics.split(",");
							if(vm.list2[i].goodsType == "卫生洁具"){
								vm.list.push(vm.list2[i]);
							}
						}
				  	}else if(e == 8){
			  			for(let i =0;i<vm.list2.length;i++){
			  				//vm.list2[i].goodsPics = vm.list2[i].goodsPics.split(",");
							if(vm.list2[i].goodsType == "妇女婴幼"){
								vm.list.push(vm.list2[i]);
							}
						}
				  	}else{
			  			for(let i =0;i<vm.list2.length;i++){
			  				//vm.list2[i].goodsPics = vm.list2[i].goodsPics.split(",");
							if(vm.list2[i].goodsType == "办公家居"){
								vm.list.push(vm.list2[i]);
							}
						}
				  	}
				    vm.items1 = [];
					vm.items2 = [];
					vm.items3 = [];
					vm.items4 = [];
					var data = vm.list;
					for(let i =0;i<=data.length/4;i++){
						if((i*4)<data.length){
							vm.items1.push(data[i*4]);
							//vm.items1[i].goodsPics = data[i*4].goodsPics.split(",");
							
						}
						if((i*4+1)<data.length){
							vm.items2.push(data[i*4+1]);
							//vm.items2[i].goodsPics = data[i*4+1].goodsPics.split(",");
							
						}
						if((i*4+2)<data.length){
							vm.items3.push(data[i*4+2]);
							//vm.items3[i].goodsPics = data[i*4+2].goodsPics.split(",");
							
						}
						if((i*4+3)<data.length){
							vm.items4.push(data[i*4+3]);
							//vm.items4[i].goodsPics = data[i*4+3].goodsPics.split(",");
							
						}
					}
			  },
			  goSy: function () {
				  sessionStorage.setItem("html","sy");
				  location.href="./index.jsp";
			  },
			  search: function () {
				  	let that = this;
					var val = this.input;
					
					console.log(localStorage.getItem("userId"));
					console.log(input);
					if(val.match(/^[ ]*$/)){
						  this.$message.error('搜索内容不能为空！');
						  return false;
					  }
					sessionStorage.setItem("input",val);
					
					$.ajax({
						type: "post",
						dataType:"json",
						async:true,//同步异步
						contentType:"application/json", 
						url: "/home/gdsDetails/search.do",
						data:  JSON.stringify({
							search: vm.input,
						}), 
						success: function(data) {
							console.log(7878);
							vm.qb = data.list.length;
							vm.list2 = data.list;
							vm.dzsm = 0;
							vm.fzss = 0;
							vm.jsls = 0;
							vm.sxsc = 0;
							vm.tyjs = 0;
							vm.wsjj = 0;
							vm.fnyy = 0;
							vm.bgjj = 0;
							vm.wjts = 0;
							for(let i =0;i<data.list.length;i++){
								if(data.list[i].goodsType == "电子数码"){
									vm.dzsm++;
								}else if(data.list[i].goodsType == "服装首饰"){
									vm.fzss++;
								}else if(data.list[i].goodsType == "酒水零食"){
									vm.jsls++;
								}else if(data.list[i].goodsType == "文具图书"){
									vm.wjts++;
								}else if(data.list[i].goodsType == "生鲜食材"){
									vm.sxsc++;
								}else if(data.list[i].goodsType == "体育健身"){
									vm.tyjs++;
								}else if(data.list[i].goodsType == "卫生洁具"){
									vm.wsjj++;
								}else if(data.list[i].goodsType == "妇女婴幼"){
									vm.fnyy++;
								}else{
									vm.bgjj++;
								}
							}
							vm.items1 = [];
							vm.items2 = [];
							vm.items3 = [];
							vm.items4 = [];
							for(let i =0;i<=data.list.length/4;i++){
								if((i*4)<data.list.length){
									vm.items1.push(data.list[i*4]);
									vm.items1[i].goodsPics = data.list[i*4].goodsPics.split(",");
									
								}
								if((i*4+1)<data.list.length){
									vm.items2.push(data.list[i*4+1]);
									vm.items2[i].goodsPics = data.list[i*4+1].goodsPics.split(",");
									
								}
								if((i*4+2)<data.list.length){
									vm.items3.push(data.list[i*4+2]);
									vm.items3[i].goodsPics = data.list[i*4+2].goodsPics.split(",");
									
								}
								if((i*4+3)<data.list.length){
									vm.items4.push(data.list[i*4+3]);
									vm.items4[i].goodsPics = data.list[i*4+3].goodsPics.split(",");
									
								}
							}
							vm.loading = false;
						},
						error: function(){
							that.$message.error('商品加载失败~');
						}
					});
			  },
			  
	
		  },
		  filters: {
			  
		  },
		  mounted: function () {
			  this.$nextTick(()=>{
						let that = this;
						console.log(localStorage.getItem("userId"));
						console.log("=============+++++");
						$.ajax({
							type: "post",
							dataType:"json",
							async:true,//同步异步
							contentType:"application/json", 
							url: "/home/gdsDetails/selectMygoods.do",
							data:  JSON.stringify({
								userId:localStorage.getItem("userId"),
							}), 
							success: function(data) {
								vm.qb = data.list.length;
								vm.list2 = data.list;
								for(let i =0;i<data.list.length;i++){
									if(data.list[i].goodsType == "电子数码"){
										vm.dzsm++;
									}else if(data.list[i].goodsType == "服装首饰"){
										vm.fzss++;
									}else if(data.list[i].goodsType == "酒水零食"){
										vm.jsls++;
									}else if(data.list[i].goodsType == "文具图书"){
										vm.wjts++;
									}else if(data.list[i].goodsType == "生鲜食材"){
										vm.sxsc++;
									}else if(data.list[i].goodsType == "体育健身"){
										vm.tyjs++;
									}else if(data.list[i].goodsType == "卫生洁具"){
										vm.wsjj++;
									}else if(data.list[i].goodsType == "妇女婴幼"){
										vm.fnyy++;
									}else{
										vm.bgjj++;
									}
								}
								vm.items1 = [];
								vm.items2 = [];
								vm.items3 = [];
								vm.items4 = [];
								for(let i =0;i<=data.list.length/4;i++){
									if((i*4)<data.list.length){
										vm.items1.push(data.list[i*4]);
										vm.items1[i].goodsPics = data.list[i*4].goodsPics.split(",");
										
									}
									if((i*4+1)<data.list.length){
										vm.items2.push(data.list[i*4+1]);
										vm.items2[i].goodsPics = data.list[i*4+1].goodsPics.split(",");
										
									}
									if((i*4+2)<data.list.length){
										vm.items3.push(data.list[i*4+2]);
										vm.items3[i].goodsPics = data.list[i*4+2].goodsPics.split(",");
										
									}
									if((i*4+3)<data.list.length){
										vm.items4.push(data.list[i*4+3]);
										vm.items4[i].goodsPics = data.list[i*4+3].goodsPics.split(",");
										
									}
								}
								vm.loading = false;
							},
							error: function(){
								that.$message.error('商品加载失败~');
							}
						});
					
			    })
		  },
		  
		  
	});
	
	function cartNum(){
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
				  //console.log(data);
				  console.log(data);
				  
	              vm.cartNums = data.length;
	              //console.log(vm2.cartNums);
          }
		  })
	}
	cartNum();
	
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

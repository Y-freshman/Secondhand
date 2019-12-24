$(document).ready(function(){
	var vm = new Vue({
		  el: '#messageRm',
		  data: {
			  activeNames: '1',
			  squareUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
			  ownerName: '风中旅人',
			  sex: '0',
			  message: [],
		      textarea: '',
		      text:'',
		      user:[],
		      liuyanId: '',
		      userId: '',
		  },
		  methods: {
			  handleChange(remainId) {
			        selectSub(remainId);
			  },
			  handleClose(done) {
		            done();
		      },
		      openReply(remainId,index){
		    	  selectSub(remainId);
		    	  openSub(index);
		      },
		      reply(remainId,receiverId){
		    	  var remainerId = localStorage.getItem("userId");
		    	  if(vm.textarea.match(/^[ ]*$/)){
					  this.$message.error('评论不能为空！');
					  return false;
				  }else{
			    	  $.ajax({
		    			  url: "/home/remain/addItem.do",
		    			  async: true,
		    			  type: "post",
		    			  data: JSON.stringify({
		    				  receiverId: receiverId,
		    				  remainerId: remainerId,
		    				  remianLastId: remainId,
		    				  remainContent: vm.textarea
		    			  }),
		    			  contentType: "application/json",
		    			  dataType: 'json',
		    			  success: function(res){
		    				  if(res.code == 200){
		    					  selectSub(remainId);
		    					  vm.textarea = "";
		    				  }
		                  }
		    		})
				  }
		      },
		      deleteItem(remainId,remianLastId){	//删除留言
		    	  console.log(remainId);
		    	  this.$confirm('此操作将使该留言被删除, 是否继续?', '提示', {
			            confirmButtonText: '确定',
			            cancelButtonText: '取消',
			            type: 'warning'
			          }).then(() => {
			        	$.ajax({
			    			  url: "/home/remain/deleteItem.do",
			    			  async: true,
			    			  type: "post",
			    			  data: JSON.stringify({
			    				  remainId: remainId
			    			  }),
			    			  contentType: "application/json",
			    			  dataType: 'json',
			    			  success: function(res){
			    				  //首先判断删除的是主留言还是子留言
			    				  if(res.code == 200 && remianLastId == 0){
			    					  getAllMain();
			    				  }else{
			    					  selectSub(remianLastId);
			    				  }
			                  }
			    		})
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
		      },
		      addMainRemain(){
		    	  var remainerId = localStorage.getItem("userId");
		    	  var receiverId = sessionStorage.getItem("liuyanId");
		    	  if(vm.text.match(/^[ ]*$/)){
					  this.$message.error('评论不能为空！');
					  return false;
				  }else{
			    	  $.ajax({
		    			  url: "/home/remain/addItem.do",
		    			  async: true,
		    			  type: "post",
		    			  data: JSON.stringify({
		    				  receiverId: receiverId,
		    				  remainerId: remainerId,
		    				  remianLastId: 0,
		    				  remainContent: vm.text
		    			  }),
		    			  contentType: "application/json",
		    			  dataType: 'json',
		    			  success: function(res){
		    				  if(res.code == 200){
		    					  getAllMain();
		    					  vm.text = "";
		    				  }
		                  }
		    		})
				  }
		      }
		  },
		  filters: {
			  dateFormat(date){
				  var date = new Date(date);
					Y = date.getFullYear() + '-';
					M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
					D = (date.getDate() < 10 ? '0' +(date.getDate()) : date.getDate()) +  ' ';
					h = (date.getHours() <10 ? '0' +(date.getHours()) : date.getHours()) + ':';
					m = (date.getMinutes() < 10 ? '0' +(date.getMinutes()) : date.getMinutes()) + ':';
					s = (date.getSeconds() < 10 ? '0' +(date.getSeconds()) : date.getSeconds()); 
					return (Y+M+D+h+m+s);
				},
				vip: function (value) {
				    if (!value) return '';
				    value = value.toString();
				    if(value == 0){
				    	return "img/touming.png";
				    }else{
				    	return "img/vip_2.jpg";
				    }
			  },
		  },
		  
	});
	
	/**
	 * 查询所有主留言
	 * @returns
	 */
	function getAllMain(){
		vm.liuyanId = sessionStorage.getItem("liuyanId");
		vm.userId = localStorage.getItem("userId");
		/*console.log(vm.liuyanId);
		console.log(vm.userId);*/
		$.ajax({
			  url: "/home/remain/selectMain.do",
			  async: false,
			  type: "post",
			  data: JSON.stringify({
				  receiverId: sessionStorage.getItem("liuyanId")
			  }),
			  contentType: "application/json",
			  dataType: 'json',
			  success: function(data){
				  vm.message = data.remains;
	              //console.log(vm.message);
            }
		  })
	}
	getAllMain();
	
	/**
	 * 查询当前留言主页
	 * @returns
	 */
	function getUser(){
		$.ajax({
			url: "/home/user/users.do",
			async: true,
			type: "post",
			data: JSON.stringify({
				userId: sessionStorage.getItem("liuyanId")
			}),
			contentType: "application/json",
			dataType: 'json',
			success: function(data){
				vm.user = data.user;
				console.log(data.user);
			}
		})
	}
	getUser();
	
	/**
	 * 查询所有子留言
	 * @param remainId
	 * @returns
	 */
	function selectSub(remainId){
		$.ajax({
			url: "/home/remain/selectSub.do",
			async: false,
			type: "post",
			data: JSON.stringify({
				lastId: remainId
			}),
			contentType: "application/json",
			dataType: 'json',
			success: function(data){
				for(var i=0; i<vm.message.length; i++){
					while(vm.message[i].remainId == remainId){
						vm.message[i].subContent = data.remains;
						break;
					}
				}
			}
		})
	}
	
	function openSub(index){
		$('.el-collapse-item__wrap')[index].style.display = 'block';
		location.href = "#relpy";
	}
	
});
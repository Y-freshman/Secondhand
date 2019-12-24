$(document).ready(function(){
	var vm = new Vue({
		  el: '#purchaseCar',
		  data: {
			    tableData: [],
			    delarr:[],//存放删除的数据
			    multipleSelection: [],
			    checked: false,
			    num1:0,
			    num2:0,
			    dialogFormVisible: false,
			    code: '',
		},

	    methods: {
	      toggleSelection(rows) {
	        if (rows) {
	          rows.forEach(row => {
	            this.$refs.multipleTable.toggleRowSelection(row);
	          });
	        } else {
	          this.$refs.multipleTable.clearSelection();
	        }
	      },
	      deleteRow(index, cartId) {
	          this.$confirm('此操作将使该商品从你的购物车中删除, 是否继续?', '提示', {
	            confirmButtonText: '确定',
	            cancelButtonText: '取消',
	            type: 'warning'
	          }).then(() => {
	        	$.ajax({
	    			  url: "/home/cart/delete.do",
	    			  async: true,
	    			  type: "post",
	    			  data: JSON.stringify({
	    				  cartId: cartId
	    			  }),
	    			  contentType: "application/json",
	    			  dataType: 'json',
	    			  success: function(){
	    				  
	                  }
	    		})
				this.$message({
		            type: 'success',
		            message: '删除成功!'
		        });
	        	getCart();
	        	/*rows.splice(index, 1);*/
	          }).catch(() => {
	            this.$message({
	              type: 'info',
	              message: '已取消删除'
	            });          
	          });
	      },
	      deleteRows(){
	    	  var length = vm.multipleSelection.length;
	    	  for (let i = 0; i < length; i++) {
	    	     vm.delarr.push(vm.multipleSelection[i].cartId)
	    	  }
	    	  //console.log(vm.multipleSelection);
	    	  commonDelete(vm.delarr);
			  getCart();
	      },
	      firstConfirm(){
	    	  var length = vm.multipleSelection.length;
	    	  for (let i = 0; i < length; i++) {
	    	     vm.delarr.push(vm.multipleSelection[i].cartId)
	    	  }
    		  if(vm.delarr.length == 0){
    			  this.$message({
    		          message: '请先选择您要购买的商品',
    		          type: 'warning'
    		        });
    		  }else{
    			  vm.dialogFormVisible = true;
    		  }
	      },
	      moneyConfirm(){
	    	  var length = vm.multipleSelection.length;
	    	  for (let i = 0; i < length; i++) {
	    	     vm.delarr.push(vm.multipleSelection[i].cartId)
	    	  }
			  //对数据进行封装，形成后台需要的pojo的数组形式
			  var gdsList = [];
	          var length1 = vm.multipleSelection.length;
	          for (let i = 0; i<length1; i++) {
	        	  /*gdsList[i] = {};
	        	  gdsList[i].goodsId=vm.multipleSelection[i].goodsId;
	        	  gdsList[i].userId=vm.multipleSelection[i].userId;
	        	  gdsList[i].cartGoodsNum=vm.multipleSelection[i].cartGoodsNum;
	        	  gdsList[i].orderState='1';
	        	  gdsList[i].orderTime='2019-11-23 16:04:43';*/
	        	  gdsList.push(vm.multipleSelection[i].goodsId);
		      }
	    	  console.log(gdsList);
			  addOrders(gdsList);
			  if(vm.code == 200){
				  commonDelete(vm.delarr);
				  getCart();
				  vm.dialogFormVisible = false;
			  }else{
				  alert("系统错误请稍后再试");
			  }
	      },
	      toDetail(goodsId){
	    	  sessionStorage.setItem("goodsId",goodsId);
	    	  location.href = "/home/gdsDetail.do";
	      },
	      handleSelectionChange(data) {
	          this.multipleSelection = data;
	    	  if(data.length > 0){
	    		  vm.num1 = data.length;
	    		  var sum = 0;
	    		  for(let i=0; i<data.length;i++){
	    			  sum += data[i].goodsNewPrice;
			      }
	    		  vm.num2 = sum;
	    	  }else{
	    		  vm.num1 = 0;
		          vm.num2 = 0;
	    	  }
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
			state(value){
				if (!value) return '';
			    value = value.toString();
			    if(value == 0){
			    	return "已下架";
			    }else if(value == 1){
			    	return "正常售卖";
			    }
			}
	    },
	  
	});
	
	/**
	 * 查询购物车里的商品
	 * @returns
	 */
	function getCart(){
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
	              vm.tableData = data;
	              //console.log(vm.tableData);
	              for(var i=0; i<vm.tableData.length; i++){
	            	  vm.tableData[i].goodsPics = vm.tableData[i].goodsPics.split(",");
	              }
            }
		})
	}
	getCart();
	
	/**
	 * 对购物车里商品批量删除
	 * @param delarr
	 * @returns
	 */
	function commonDelete(delarr){
		$.ajax({
			  url: "/home/cart/deleteRows.do",
			  async: false,
			  type: "post",
			  data: JSON.stringify({
				  cartId: delarr
			  }),
			  contentType: "application/json",
			  dataType: 'json',
			  success: function(data){
	              
          }
		  })
	}
	
	/**
	 * 批量添加订单
	 * @returns
	 */
	function addOrders(gdsList){
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
	              vm.code = res.code;
			  }
		})
	}
	
});
$(document).ready(function(){
	var vm = new Vue({
		  el: '#orderForm',
		  data: {
			  activeName: 'first',
			  input3: '',
		      select: '',
		      clear: true,
		      tableData: [],
			  tableData1: [],
			  tableData2: [],
			  currentPage1: 1,
			  totalAll: '',
			  totalNeed: '',
			  totalConfirm: '',
		  },
		  methods: {
			  handleClick(tab, event) {
			        
			  },
			  toggleSelection(rows) {
			    	var sum = 0;
			        if (rows) {
			          rows.forEach(row => {
			            this.$refs.multipleTable.toggleRowSelection(row);
			          });
			          for(var i=0; i<vm.tableData.length;i++){
				        	sum += vm.tableData[i].sum;
				        }
			        } else {
			          this.$refs.multipleTable.clearSelection();
			        }
			      },
			      handleSelectionChange(val) {
			        this.multipleSelection = val;
			      },
			      sizeOn(row, column, cell, event){
			        	/* $(".size").css("border","1px dashed red"); */
			      },
			      gdMdfySize(){
			    	  
			      },
			      handleSizeChange(val) {
			          console.log(`每页 ${val} 条`);
		        },
		        handleCurrentChange(val) {
		          console.log(`当前页: ${val}`);
		        },
		        gdSure(index,orderId){
		        	vm.tableData2[index].orderState = 2;
		        	confirmGds(orderId);
		        	this.$message({
		                message: '已确认收货',
		                type: 'success'
		              });
		        	getAllReceive();
		        	getAll();
		        },
		        gdSure0(index,orderId){
		        	vm.tableData[index].orderState = 2;
		        	confirmGds(orderId);
		        	this.$message({
		                message: '已确认收货',
		                type: 'success'
		              });
		        	getAllReceive();
		        },
		        toDetail(goodsId){
			    	  sessionStorage.setItem("goodsId",goodsId);
			    	  location.href = "/home/gdsDetail.do";
			     },
			     nextPage(){
			    	 vm.tableData.splice(0,7);
			     },
			     prePage(){
			    	 
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
				}
		  },
		  
	});
	
	/**
	 * 获取所有
	 * @returns
	 */
	function getAll(){
		$.ajax({
			  url: "/home/order/select.do",
			  async: true,
			  type: "post",
			  data: JSON.stringify({
				  userId: localStorage.getItem("userId"),
			  }),
			  contentType: "application/json",
			  dataType: 'json',
			  success: function(data){
				  vm.tableData = data.orders;
				  vm.totalAll = vm.tableData.length;
				  /*var data = data.orders;
				  for(var i=0; i<data.length; i++){
					  while(data[i].orderState != '0'){
						  data.splice(i-1,1);
						  break;
					  }
				  }
				  vm.tableData1 = data;
				  console.log(vm.tableData1);*/
            }
		})
	}
	getAll();
	
	/**
	 * 获取待付款
	 * @returns
	 */
	function getAllNeed(){
		$.ajax({
			url: "/home/order/selectNeed.do",
			async: true,
			type: "post",
			data: JSON.stringify({
				userId: localStorage.getItem("userId"),
				orderState: 0,
			}),
			contentType: "application/json",
			dataType: 'json',
			success: function(data){
				vm.tableData1 = data.orders;
				vm.totalNeed = data.orders.length;
			}
		})
	}
	getAllNeed();
	
	/**
	 * 获取待收货
	 * @returns
	 */
	function getAllReceive(){
		$.ajax({
			url: "/home/order/selectNeed.do",
			async: true,
			type: "post",
			data: JSON.stringify({
				userId: localStorage.getItem("userId"),
				orderState: 1,
			}),
			contentType: "application/json",
			dataType: 'json',
			success: function(data){
				vm.tableData2 = data.orders;
				vm.totalConfirm = data.orders.length;
				console.log(vm.tableData2);
			}
		})
	}
	getAllReceive();
	
	/**
	 * 确认收货
	 * @param goodsId
	 * @returns
	 */
	function confirmGds(orderId){
		$.ajax({
			url: "/home/order/confirm.do",
			async: true,
			type: "post",
			data: JSON.stringify({
				orderId: orderId
			}),
			contentType: "application/json",
			dataType: 'json',
			success: function(res){
				
			}
		})
	}
	
});
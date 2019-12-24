$(document).ready(function(){
	var vm2 = new Vue({
		  el: '#shouye_db',
		  data: {
		    value:"sy",
		    input:'',
		    dialogVisible: false,
		    notice:[],
		    noticeXq:[],
		    cartNums: '',
		    username:'',
		  },
		  methods: {
			  goSy: function () {
				  sessionStorage.setItem("html","sy");
				  //location.href="./index.jsp";
			  },
			  goSy2: function () {
				  sessionStorage.setItem("html","sy");
				  location.href="/home/index.jsp";
			  },
			  search: function () {
				  sessionStorage.setItem("input",vm2.input);
				  location.href="/home/search.do";
			  },
			  goQg: function () {
				  sessionStorage.setItem("html","qg");
				  //location.href="./qiugou.jsp";
			  },
			  alert: function (e) {
				  vm2.noticeXq = vm2.notice[e];
				  vm2.dialogVisible = true;
			  },
			  
		  },
		  filters: {
			  date: function (value) {
				  if (!value) return '';
				  value = value.toString();
				  return time(value);
				  
			  },
		  },
		  
	});
	
	if(sessionStorage.getItem("html") != null && sessionStorage.getItem("html") != undefined){
		vm2.value = sessionStorage.getItem("html");
		if(vm2.value == "sy"){
			$(".shouye_fl").click();
		}else{
			$(".shouye_fl").css("pointer-events","none ");
			$(".shouye_fl").css("cursor","no-drop ");
		}
	}else{
		$(".shouye_fl").click();
	}
	function xr_gg() {
		let that = this;
		$.ajax({
			type: "post",
			dataType:"json",
			async:true,//同步异步
			contentType:"application/json", 
			url: "/home/notice/selectGg.do",
			data:  JSON.stringify({
				
			}), 
			success: function(data) {
				//console.log(data.list);
				vm2.notice = data.list;
			},
			error: function(){
				that.$message.error('公告加载失败~');
			}
		});
	}
	xr_gg();
	function typePage(e) {
		  sessionStorage.setItem("typePage",e);
		  location.href="/home/typePage.do";
	 }
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
	
	function cartNum(){
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
				  //console.log(data);
	              vm2.cartNums = data.length;
	              //console.log(vm2.cartNums);
          }
		  })
	}
	
	if(localStorage.getItem("userId") != null && localStorage.getItem("userId") != undefined){
		cartNum();
	}
	function login() {
		if(!window.localStorage){
			return false;
		}
		if(localStorage.getItem("root")==null || localStorage.getItem("root")==undefined){
			return false;
		}
		$.ajax({
			type: "post",
			dataType:"json",
			async:false,//同步异步
			contentType:"application/json", 
			url: "/home/user/logins.do",
			data:  JSON.stringify({
				root: localStorage.getItem("root"),
				password: localStorage.getItem("password"),
			}), 
			success: function(data) {
				//localStorage.setItem("userId",data.list.userId);
				vm2.username = data.user.userName;
			},
			error: function(){
				alert('登录失败~');
			}
		});
	 }
	login();
});

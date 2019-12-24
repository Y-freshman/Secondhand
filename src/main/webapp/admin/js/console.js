"use strict";
layui.use(["okUtils", "table", "okCountUp", "okMock"], function () {
    var countUp = layui.okCountUp;
    var table = layui.table;
    var okUtils = layui.okUtils;
    var okMock = layui.okMock;
    var $ = layui.jquery;
    okLoading.close();
    /**
     * 订单、商品、求购、用户
     */
    var dd ;
    var sp ;
    var qg ;
    var yh ;
    $.ajax({
		type: "post",
		dataType:"json",
		async:false,//同步异步
        contentType:"application/json", 
		url: "/home/gdsDetails/console.do",
		data:  JSON.stringify({
			
		}), 
		success: function(data) {
			//console.log(data);
			dd = data.order;
			sp = data.goods;
			qg = data.need;
			yh = data.user;
			
		},
		error: function(){
			alert('数据渲染失败！');
		}
	});
    var spSum = 0;
    var yhSum = 0;
    for(let i=0;i<sp.length;i++){
    	spSum += sp[i].num;
    }
    var day0 = 0;
    var day1 = 0;
    var day2 = 0;
    var day3 = 0;
    var day4 = 0;
    var day5 = 0;
    var day6 = 0;
    function isToday(str,e) {
        if (new Date(str).toDateString() === new Date(new Date().getTime()-24*60*60*1000*e).toDateString()) {
            return true;
            //console.log(new Date().toDateString());
        } else if (new Date(str) < new Date()){
        	return false;
        }
    }
    for(let i=0;i<dd.length;i++){
    	if(isToday(dd[i].orderTime,0)){
    		day0 = dd[i].num;
    	}else if(isToday(dd[i].orderTime,1)){
    		day1 = dd[i].num;
    	}else if(isToday(dd[i].orderTime,2)){
    		day2 = dd[i].num;
    	}else if(isToday(dd[i].orderTime,3)){
    		day3 = dd[i].num;
    	}else if(isToday(dd[i].orderTime,4)){
    		day4 = dd[i].num;
    	}else if(isToday(dd[i].orderTime,5)){
    		day5 = dd[i].num;
    	}else if(isToday(dd[i].orderTime,6)){
    		day6 = dd[i].num;
    	}
    }
    for(let i=0;i<yh.length;i++){
    	yhSum += yh[i].num;
    	if(yh[i].userSex == "0"){
    		yh[i].userSex = "男";
    	}else{
    		yh[i].userSex = "女";
    	}
    	
    }
    function statText() {
        var options = {
    	      useEasing: true, 
    	      useGrouping: true, 
    	      separator: ',', 
    	      decimal: '.', 
    	 }
        var demo1 = new countUp(".incomes-num", 0, day0 , 0 , 3 , options);
        var demo2 = new countUp(".goods-num", 0, spSum , 0 , 3 , options);
        var demo3 = new countUp(".blogs-num", 0, qg[0].num , 0 , 3 , options);
        var demo4 = new countUp(".fans-num", 0, yhSum , 0 , 3 , options);
        demo1.start();
        demo2.start();
        demo3.start();
        demo4.start();
    }
    //饼图
    var myChart = echarts.init(document.getElementById('yhbl_bt'));
	var option = {
		tooltip: {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		color: ['#CD5C5C', '#00CED1'],
		series: [
			{
				name: '数量及比例',
				type: 'pie',
				radius: '55%',
				center: ['50%', '50%'],
				data: [
					{value: yh[0].num, name: yh[0].userSex},
					{value: yh[1].num, name: yh[1].userSex},
				],
				roseType: 'radius',
				label: {
					normal: {
						textStyle: {
							color: 'rgba(55, 55, 55, 0.9)'
						}
					}
				},
				labelLine: {
					normal: {
						lineStyle: {
							color: 'rgba(75, 75, 75, 0.8)'
						},
						smooth: 0.2,
						length: 10,
						length2: 20
					}
				},
				itemStyle: {
					emphasis: {
                        shadowBlur: 20,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(128, 128, 128, 0.5)'
                    }
				},
				animationType: 'scale',
				animationEasing: 'elasticOut',
				animationDelay: function (idx) {
					return Math.random() * 200;
				}
			}
		]
	};
	myChart.setOption(option);
	
	//折线图
    var userSourceOption = {
        "title": {"text": ""},
        "tooltip": {"trigger": "axis", "axisPointer": {"type": "cross", "label": {"backgroundColor": "#6a7985"}}},
        "legend": {"data": ["交易订单"]},
        "toolbox": {"feature": {"saveAsImage": {}}},
        "grid": {"left": "3%", "right": "4%", "bottom": "3%", "containLabel": true},
        "xAxis": [{"type": "category", "boundaryGap": false, "data": ["今日", "前一天", "前两天", "前三天", "前四天", "前五天", "前六天"]}],
        "yAxis": [{"type": "value"}],
        "series": [
            {"name": "交易订单", "type": "line", "stack": "总量", "label": {"normal": {"show": true, "position": "top"}}, "areaStyle": {"normal": {}}, "data": [day0,day1,day2,day3,day4,day5,day6]}
        ]
    };

    /**
     * 用户访问
     */
    function userSource() {
        var userSourceMap = echarts.init($("#userSourceMap")[0], "theme");
        userSourceMap.setOption(userSourceOption);
        okUtils.echartsResize([userSourceMap]);
    }

    //柱状图
    var myChart2 = echarts.init(document.getElementById('glspsl_zzt'));
	var option2 = {
		title: {
		    text: '',
		  },
		tooltip: {
			trigger: 'item',
			//formatter:'{c}'　　
		},
		legend: {
			//data: ['数量']
		},
		grid: {
			borderWidth: 0,
	        y: 80,
	        y2: 60
	    },
		xAxis: {
			type: 'category',
            //show: false,
			data: [sp[0].goodsType,sp[1].goodsType,sp[2].goodsType,sp[3].goodsType,sp[4].goodsType,sp[5].goodsType,sp[6].goodsType,sp[7].goodsType,sp[8].goodsType],
			axisLine: {  //这是x轴文字颜色
                lineStyle: {
                    color: "#999",
                }
            }
		},
		yAxis: {
			type: 'value',
            //show: false
			axisLine: {//这是y轴文字颜色
                lineStyle: {
                    color: "#999",
                }
            }
		},
		series: [{
			name: '各种类商品统计',
			type: 'bar',
			data: [sp[0].num,sp[1].num,sp[2].num,sp[3].num,sp[4].num,sp[5].num,sp[6].num,sp[7].num,sp[8].num],
			barWidth: 40,
            itemStyle:{
                normal:{
                	color: function(params) {
                         // build a color map as your need.
                         var colorList = [
                           '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                            '#FE8463','#9BCA63','#60C0DD',
                            '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                         ];
                         return colorList[params.dataIndex]
                     },
                     label: {
                         show: true,
                         position: 'top',
                        formatter: '{b}\n{c}'　　　　//这是关键，在需要的地方加上就行了
                    }
                }
            },
            
		}]
	};
	myChart2.setOption(option2);
    

    statText();
    userSource();
    
  
});



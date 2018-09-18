angular.module('dataApp',[]).controller('dataController',function($scope,$http){
	$scope.init=function(storeCode,time,storeName){
		$scope.storeName = storeName;
		if (storeCode == "undefined" || storeCode == null
				|| storeCode == "") {
			storeCode = "";
		}
		if(time=="day"){
			$scope.isShow=true;
			$scope.data="day";
		}if(time=="week"){
			$scope.isShow=true;
			$scope.data="week";
		}
		if(time=="month"){
			$scope.isShow=true;
			$scope.data="month";
		}if(time=="quarter"){
			$scope.isShow=true;
			$scope.data="quarter";
		}if(time=="year"){
			$scope.isShow=true;
			$scope.data="year";
		}
		$http({
			url:"queryStoreCodeAndStoreName",
			method:"get",
		}).then(function(resp){
			console.log(resp.data.data);
			$scope.storCodeAndStoreName=resp.data.data;
		});
		$http({
			url:"queryByStoreCodeAndTimeGetData",
			method:"get",
			params:{"storeCode":storeCode,"time":time}
		}).then(function(resp){
			$scope.matchLeastStyle=resp.data.data.matchLeastStyle;
			$scope.matchMostStyle=resp.data.data.matchMostStyle;
			$scope.matchTotalNum=resp.data.data.matchTotalNum;
			$scope.tryOnLeastStyle=resp.data.data.tryOnLeastStyle;
			$scope.tryOnMostStyle=resp.data.data.tryOnMostStyle;
			$scope.tryOnTotalNum=resp.data.data.tryOnTotalNum;
			$scope.tryOnTrend=resp.data.data.tryOnTrend;
			if($scope.matchMostStyle==null){
				$scope.matchMostStyle="无";
			}
			if($scope.matchLeastStyle==null){
				$scope.matchLeastStyle="无";
			}
			if($scope.tryOnLeastStyle==null){
				$scope.tryOnLeastStyle="无";
			}
			if($scope.tryOnMostStyle==null){
				$scope.tryOnMostStyle="无";
			}
			var storeDetail = echarts.init(document.getElementById("storeDetails"));
			var x=new Array();
			var y=new Array();
			angular.forEach($scope.tryOnTrend,function(v,k){
				x.push(k);
				y.push(v);
			});
			option2 = {
					title:{
					      text:'试穿总数据分析',
					      x:'left'
					    },
				    xAxis: {
				        type: 'category',
				        boundaryGap:false,
				        data: x,
				        axisLine:{
	                        lineStyle:{
	                            color:'#0174DF',
	                        }
	                    }
				    },
				    yAxis: {
				    	type: 'value',
				    	axisLine:{
	                        lineStyle:{
	                            color:'#0174DF',
	                        }
	                    }
				    },
				    series: [{
				        data: y,
				        type: 'line',
				        itemStyle: {//折线图包含的部分
				            normal: {
				                color: "#2ec7c9",
				                lineStyle: {
				                    color: "#2ec7c9"
				                }
				            }
				        },
				        areaStyle:{}
				    }]
				};
			storeDetail.setOption(option2,true);
		});
		$http({
			url:"queryTryOnData",
			method:"get",
			params:{"time":time,"storeCode":storeCode}
		}).then(function(resp){
			$scope.queryTryOnData=resp.data.data;
			var queryTryOnData = echarts.init(document.getElementById("queryTryOnData"));
			var style=new Array();
			var tryOnNum=new Array();
			angular.forEach($scope.queryTryOnData,function(v,k){
				style.push(v.style);
				tryOnNum.push(v.tryOnNum);
			});
			option = {
				    color: ['#3398DB'],
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    xAxis : [
				        {
				            type : 'category',
				            data : style,
				            axisTick: {
				                alignWithLabel: true
				            }
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value'
				        }
				    ],
				    series : [
				        {
				            name:'直接访问',
				            type:'bar',
				            barWidth: '20%',
				            data:tryOnNum
				        }
				    ]
				};
			queryTryOnData.setOption(option,true);
			
		});
		
		$http({
			url:"queryMatchData",
			method:"get",
			params:{"time":time,"storeCode":storeCode}
		}).then(function(resp){
			$scope.queryMatchData=resp.data.data;
			var queryMatchData = echarts.init(document.getElementById("queryMatchData"));
			var matchStyle=new Array();
			var viewNum=new Array();
			angular.forEach($scope.queryMatchData,function(v,k){
				matchStyle.push(v.matchStyle);
				viewNum.push(v.viewNum);
			});
			option = {
				    color: ['#FAD860'],
				    tooltip : {
				        trigger: 'axis',
				        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
				        }
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    xAxis : [
				        {
				            type : 'category',
				            data : matchStyle,
				            axisTick: {
				                alignWithLabel: true
				            }
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value'
				        }
				    ],
				    series : [
				        {
				            name:'直接访问',
				            type:'bar',
				            barWidth: '20%',
				            data:viewNum
				        }
				    ]
				};
			queryMatchData.setOption(option,true);
		});
	}
	$scope.init(null,'day', null);
});
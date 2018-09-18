angular.module('totalStoreDataApp',[]).controller('totalStoreDataController',function($scope,$http){
	
	$scope.init=function(time){
		$scope.text=null;
		if(time=="day"){
			text='所有门店一天的';
		}
		if(time=="week"){
			text='所有门店一周的';
		}
		if(time=="month"){
			text='所有门店一月的';
		}
		if(time=="quarter"){
			text='所有门店一季的';
		}
		if(time=="year"){
			text='所有门店一年的';
		}
		$http({
			url:"querytByTimeGetTotalStoreTryOnData",
			params:{"time":time},
			method:"get",
		}).then(function(resp){
			var x=new Array();
			var y=new Array();
			var storeName=new Array();
			var Series = [];  
			var Item = function(){  
	            return {  
	                name:'',  
	                type:'line',  
	                data:[],
	            }
	        };
			$scope.totalData=resp.data.data.totalData;
			$scope.detailDataList=resp.data.data.detailData;
			$scope.detailDatas=resp.data.data.detailData.data;
			if(time=="day"){
				$scope.isShow=true;
				$scope.data="day";
				angular.forEach($scope.detailDataList,function(v,k){
					storeName.push(v.storeName);
					var it = new Item(); 
					var arr=new Array();
	                it.name = v.storeName; 
	                arr.splice(0,0,v.data[10]);
	                arr.splice(1,0,v.data[12]);
	                arr.splice(2,0,v.data[14]);
	                arr.splice(3,0,v.data[16]);
	                arr.splice(4,0,v.data[18]);
	                arr.splice(5,0,v.data[20]);
	                arr.splice(6,0,v.data[22]);
	                arr.splice(7,0,v.data[24]);
	                it.data =arr;
	                Series.push(it); 
				});
			}if(time=="week"){
				$scope.isShow=true;
				$scope.data="week";
				angular.forEach($scope.detailDataList,function(v,k){
					storeName.push(v.storeName);
					var it = new Item(); 
					var arr=new Array();
	                it.name = v.storeName;
                	arr.splice(0,0,v.data.Monday);
                	arr.splice(1,0,v.data.Tuesday);
                	arr.splice(2,0,v.data.Wednesday);
                	arr.splice(3,0,v.data.Thursday);
                	arr.splice(4,0,v.data.Friday);
                	arr.splice(5,0,v.data.Saturday);
                	arr.splice(6,0,v.data.Sunday);
	                it.data =arr;
	                Series.push(it); 
				});
			}
			if(time=="month"){
				$scope.isShow=true;
				$scope.data="month";
				angular.forEach($scope.detailDataList,function(v,k){
					storeName.push(v.storeName);
					var it = new Item(); 
					var arr=new Array();
	                it.name = v.storeName; 
                	arr.splice(0,0,v.data['第一周']);
                	arr.splice(1,0,v.data['第二周']);
                	arr.splice(2,0,v.data['第三周']);
                	arr.splice(3,0,v.data['第四周']);
	                it.data =arr;
	                Series.push(it); 
				});
			}if(time=="quarter"){
				$scope.isShow=true;
				$scope.data="quarter";
				angular.forEach($scope.detailDataList,function(v,k){
					storeName.push(v.storeName);
					var it = new Item(); 
					var arr=new Array();
	                it.name = v.storeName;
                	arr.splice(0,0,v.data['第一月']);
                	arr.splice(1,0,v.data['第二月']);
                	arr.splice(2,0,v.data['第三月']);
	                it.data =arr;
	                Series.push(it); 
				});
			}if(time=="year"){
				$scope.isShow=true;
				$scope.data="year";
				angular.forEach($scope.detailDataList,function(v,k){
					storeName.push(v.storeName);
					var it = new Item(); 
					var arr=new Array([4]);
	                it.name = v.storeName;
                	arr.splice(0,0,v.data['第一季']);
                	arr.splice(1,0,v.data['第二季']);
                	arr.splice(2,0,v.data['第三季']);
                	arr.splice(3,0,v.data['第四季']);
	                it.data =arr;
	                Series.push(it); 
				});
			}
			if(time=="day"){
				angular.forEach($scope.totalData,function(v,k){
					x.push(k+"点");
				    y.push(v);
				});
			}else{
				angular.forEach($scope.totalData,function(v,k){
					x.push(k);
				    y.push(v);
				});
			}
			
			var totalData= echarts.init(document.getElementById("totalData"));
			option2 = {
					title:{
					      text:text+'试穿总数据分析',
					      x:'left'
					    },
				    tooltip: {
				        trigger: 'axis'
				    },
				    legend: {
				        data:storeName
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    xAxis: {
				        type: 'category',
				        boundaryGap:false,
				        data: x
				    },
				    yAxis: {
				    	type: 'value'
			    		
				    },
				    series: [{
				        data: y,
				        itemStyle: {
				            normal: {
				                color: "#2ec7c9",
				                lineStyle: {
				                    color: "#2ec7c9"
				                }
				            }
				        },
				        type: 'line',
				        areaStyle:{}
				    }]
				};
			totalData.setOption(option2,true);
			var totalDetailData = echarts.init(document.getElementById("totalDetailData"));
			option1 = {
				    title: {
				        text:text+'试穿数据分析',
				        x:'left'
				    },
				    tooltip: {
				        trigger: 'axis'
				    },
				    legend: {
				        data:storeName
				    },
				    grid: {
				        left: '3%',
				        right: '4%',
				        bottom: '3%',
				        containLabel: true
				    },
				    xAxis: {
				        type: 'category',
				        boundaryGap: false,
				        data: x
				    },
				    yAxis: {
				        type: 'value'
				    },
				    series: []
				};
			option1.series=Series;
			totalDetailData.setOption(option1,true);
		});
		$http({
			url:"queryTotalStoreData",
			method:"get",
			params:{time:time},
		}).then(function(resp){
			$scope.totalStoreMatchData=resp.data.data.matchData;
			$scope.totalStoreTryOnData=resp.data.data.tryOnData;
			var tryOnStoreName=new Array();
			var matchStoreName=new Array();
			var totalStoreTryOnDataArr=new Array();
			var totalStoreMatchDataArr=new Array();
			angular.forEach($scope.totalStoreTryOnData,function(v,k){
				totalStoreTryOnDataArr.push({
					name:v.storeName,
					value:v.tryOnNum
				});
				tryOnStoreName.push(v.storeName);
			});
			angular.forEach($scope.totalStoreMatchData,function(v,k){
				matchStoreName.push(v.storeName);
				totalStoreMatchDataArr.push({
					name:v.storeName,
					value:v.viewNum
				});
			});
			var totalStoreTryOnData = echarts.init(document.getElementById("totalStoreTryOnData"));
			option = {
					title:{
						text:text+'试穿数据',
						x:'center'
					},
				    tooltip: {
				        trigger: 'item',
				        formatter: "{a} <br/>{b}: {c} ({d}%)"
				    },
				    legend: {
				        orient: 'vertical',
				        x: 'left',
				        data:tryOnStoreName
				    },
				    series: [
				        {
				            name:'访问来源',
				            type:'pie',
				            radius: ['30%', '40%'],
				            avoidLabelOverlap: false,
				            label: {
				                normal: {
				                    show: false,
				                    position: 'center'
				                },
				                emphasis: {
				                    show: true,
				                    textStyle: {
				                        fontSize: '10',
				                        fontWeight: 'bold'
				                    }
				                }
				            },
				            labelLine: {
				                normal: {
				                    show: false
				                }
				            },
				            data:totalStoreTryOnDataArr
				        }
				    ]
				};
			if (option && typeof option === "object") {
				totalStoreTryOnData.setOption(option, true);
			}
			var totalStoreMathcData = echarts.init(document.getElementById("totalStoreMathcData"));
			option = {
					title:{
						text:text+'搭配数据',
						x:'center'
					},
				    tooltip: {
				        trigger: 'item',
				        formatter: "{a} <br/>{b}: {c} ({d}%)"
				    },
				    legend: {
				        orient: 'vertical',
				        x: 'left',
				        data:matchStoreName
				    },
				    series: [
				        {
				            name:'访问来源',
				            type:'pie',
				            radius: ['30%', '40%'],
				            avoidLabelOverlap: false,
				            label: {
				                normal: {
				                    show: false,
				                    position: 'center'
				                },
				                emphasis: {
				                    show: true,
				                    textStyle: {
				                        fontSize: '10',
				                        fontWeight: 'bold'
				                    }
				                }
				            },
				            labelLine: {
				                normal: {
				                    show: false
				                }
				            },
				            data:totalStoreMatchDataArr
				        }
				    ]
				};
			if (option && typeof option === "object") {
				totalStoreMathcData.setOption(option, true);
			}
		});
	}
	$scope.init('day');
});
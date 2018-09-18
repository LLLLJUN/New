<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/angular.js/1.4.6/angular.min.js"></script>
<script
	src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
<script type="text/javascript"
	src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
<script type="text/javascript"
	src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
<script type="text/javascript"
	src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
<script type="text/javascript"
	src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
<script type="text/javascript"
	src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
<script type="text/javascript"
	src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
<script type="text/javascript"
	src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
<script type="text/javascript">
	var app = angular.module('saleDataApp', []);
	app.controller('saleDataController', function($http, $scope) {
		$scope.init = function(time) {
			if (time == 'day') {
				$scope.timeData = "一天";
			}
			if (time == 'week') {
				$scope.timeData = "一周";
			}
			if (time == 'month') {
				$scope.timeData = "一月";
			}
			if (time == 'quarter') {
				$scope.timeData = "一季";
			}
			if (time == 'year') {
				$scope.timeData = "一年";
			}
			$http({
				url : "queryTotalSaleData",
				params : {
					"time" : time
				},
				method : "get",
			}).then(
					function(resp) {
						//console.log(resp.data.data);
						$scope.TotalSaleData = resp.data.data;
						var storeName = new Array();
						var Series = [];
						var Series1 = [];
						var Item = function() {
							return {
								name : '销售额',
								type : 'bar',
								label : {
									normal : {
										show : true,
										position : 'top'
									}
								},
								data : [],
							}
						};
						var Item1 = function() {
							return {
								name : '销售量',
								type : 'bar',
								label : {
									normal : {
										show : true,
										position : 'top'
									}
								},
								data : [],
							}
						};
						var salePrice = new Array();
						var saleNum = new Array();
						var it = new Item();
						var it1 = new Item1();
						angular.forEach($scope.TotalSaleData, function(v, k) {
							storeName.push(v.storeName);
							salePrice.push(v.salePrice);
							saleNum.push(v.saleNum);
						});
						it.data = salePrice;
						it1.data = saleNum;
						Series.push(it);
						Series1.push(it1);
						var queryTotalSaleData = echarts.init(document
								.getElementById("queryTotalSaleData"));
						option = {
							tooltip : {
								trigger : 'axis',
								axisPointer : {
									type : 'cross',
									crossStyle : {
										color : '#999'
									}
								}
							},
							toolbox : {
								feature : {
									dataView : {
										show : true,
										readOnly : false
									},
									magicType : {
										show : true,
										type : [ 'line', 'bar' ]
									},
									restore : {
										show : true
									},
									saveAsImage : {
										show : true
									}
								}
							},
							legend : {
								data : [ '销售额' ]
							},
							xAxis : [ {
								type : 'category',
								data : storeName,
								axisPointer : {
									type : 'shadow'
								}
							} ],
							yAxis : [ {
								type : 'value',
								name : '销售数据',
								min : 0,
								axisLabel : {
									formatter : '{value} 元'
								}
							} ],
							series : []
						};
						option.series = Series;
						queryTotalSaleData.setOption(option, true);
						var queryTotalSaleData1 = echarts.init(document
								.getElementById("queryTotalSaleData1"));
						option1 = {
							tooltip : {
								trigger : 'axis',
								axisPointer : {
									type : 'cross',
									crossStyle : {
										color : '#999'
									}
								}
							},
							toolbox : {
								feature : {
									dataView : {
										show : true,
										readOnly : false
									},
									magicType : {
										show : true,
										type : [ 'line', 'bar' ]
									},
									restore : {
										show : true
									},
									saveAsImage : {
										show : true
									}
								}
							},
							legend : {
								data : [ '销售量' ]
							},
							xAxis : [ {
								type : 'category',
								data : storeName,
								axisPointer : {
									type : 'shadow'
								}
							} ],
							yAxis : [ {
								type : 'value',
								name : '销售数据',
								min : 0,
								axisLabel : {
									formatter : '{value} 件'
								}
							} ],
							series : []
						};
						option1.series = Series1;
						queryTotalSaleData1.setOption(option1, true);
					});
			/* =========================================获取时间段内各款式销量最高与销量最低门店的数据============================================================= */
			$http({
				url : "querySaleBestWorstData",
				params : {
					"time" : time
				},
				method : "get",
			}).then(
					function(resp) {
						console.log(resp.data.data);
						$scope.saleBestWorstData = resp.data.data;
						var styles = new Array();
						var Series = [];
						var Item = function() {
							return {
								name : '销量最高',
								type : 'bar',
								label : {
									normal : {
										show : true,
										position : 'top'
									}
								},
								data : [],
							}
						};
						var Item1 = function() {
							return {
								name : '销量最低',
								type : 'bar',
								label : {
									normal : {
										show : true,
										position : 'top'
									}
								},
								data : [],
							}
						};
						var it = new Item();
						var it1 = new Item1();
						var bestSaleNum = new Array();
						var bestStoreName = new Array();
						var worstSaleNum = new Array();
						var worstStoreName = new Array();
						angular.forEach($scope.saleBestWorstData,
								function(v, k) {
									styles.push(v.style);
									bestSaleNum.push(v.bestSaleNum);
									bestStoreName.push(v.bestStoreName);
									worstSaleNum.push(v.worstSaleNum);
									worstStoreName.push(v.worstStoreName);
								})
						it.data = bestSaleNum;
						it1.data = worstSaleNum;
						Series.push(it);
						Series.push(it1);
						var querySaleBestWorstData = echarts.init(document
								.getElementById("querySaleBestWorstData"));
						option = {
							tooltip : {
								trigger : 'axis',
								axisPointer : {
									type : 'cross',
									crossStyle : {
										color : '#999'
									}
								}
							},
							toolbox : {
								feature : {
									dataView : {
										show : true,
										readOnly : false
									},
									magicType : {
										show : true,
										type : [ 'line', 'bar' ]
									},
									restore : {
										show : true
									},
									saveAsImage : {
										show : true
									}
								}
							},
							legend : {
								data : [ '销量最高', '销量最低' ]
							},
							xAxis : [ {
								type : 'category',
								data : styles,
								axisPointer : {
									type : 'shadow'
								}
							} ],
							yAxis : [ {
								type : 'value',
								name : '销售数据',
								min : 0,
								axisLabel : {
									formatter : '{value}件'
								}
							} ],
							series : []
						};
						option.series = Series;
						querySaleBestWorstData.setOption(option, true);
					});
		}
		$scope.init('day')
	});
</script>
</head>
<body ng-app="saleDataApp" ng-controller="saleDataController">

	<div class="col-md-10 col-md-offset-1">
		<div>
			<div class="dropdown" style="float: right;">
				<button type="button" class="btn dropdown-toggle"
					style="width: 150px;" id="dropdownMenu1" data-toggle="dropdown">
					时间 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu"
					aria-labelledby="dropdownMenu1">
					<li role="presentation"><a role="menuitem" tabindex="-1"
						ng-click="init('day')">最近一天</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						ng-click="init('week')">最近一周</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						ng-click="init('month')">最近一月</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						ng-click="init('quarter')">最近一季度</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						ng-click="init('year')">最近一年</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-md-10 col-md-offset-1">
		<h3>各门店{{timeData}}销售额和销售量</h3>
		<div id="queryTotalSaleData" class="col-md-12" style="height: 300px;"></div>
		<div id="queryTotalSaleData1" class="col-md-12" style="height: 300px;"></div>
		<div class="col-md-10 col-md-offset-1">
			<table class="table table-striped">
				<caption>各门店{{timeData}}销售额和销售量报表</caption>
				<thead>
					<tr>
						<th>门店</th>
						<th>销售额</th>
						<th>销售量</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="x in TotalSaleData">
						<td>{{x.storeName}}</td>
						<td>{{x.salePrice}}</td>
						<td>{{x.saleNum}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="col-md-10 col-md-offset-1">
		<h3>各款式销量最高与销量最低门店{{timeData}}的数据</h3>
		<div id="querySaleBestWorstData" class="col-md-12"
			style="height: 300px;"></div>
		<div class="col-md-10 col-md-offset-1">
			<table class="table table-striped">
				<caption>各款式销量最高与销量最低门店{{timeData}}的数据报表</caption>
				<thead>
					<tr>
						<th>最高销量门店</th>
						<th>最高销量</th>
						<th>款式</th>
						<th>最低销量门店</th>
						<th>最低销量</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="x in saleBestWorstData">
						<td>{{x.bestStoreName}}</td>
						<td>{{x.bestSaleNum}}</td>
						<td>{{x.style}}</td>
						<td>{{x.worstStoreName}}</td>
						<td>{{x.worstSaleNum}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>

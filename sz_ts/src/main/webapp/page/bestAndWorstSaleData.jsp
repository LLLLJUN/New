<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	app.controller('saleDataController',function($scope, $http) {
			$scope.init = function(time, storeCode, storeName) {
				$scope.storeName = storeName;
				if (storeCode == "undefined" || storeCode == null
						|| storeCode == "") {
					storeCode = "";
				}
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
/*==========================获取所有门店信息============================================================  */

			$http({
				url : "queryStoreCodeAndStoreName",
				method : "get",
			}).then(function(resp) {
				console.log(resp.data.data);
				$scope.storCodeAndStoreName = resp.data.data;
			});

/*===================================获取各门店时间段内各个款式的销售量和试穿量数据====================================================================  */
			$http({
				url : "querySaleTryData",
				params : {
					"time" : time,
					"storeCode" : storeCode
				},
				method : "get",
			}).then(function(resp) {
								console.log(resp.data.data);
								$scope.saleTryData = resp.data.data;
								var styles = new Array();
								var Series = [];
								var Series1 = [];
								var Item = function() {
									return {
										name : '销售数据',
										type : 'bar',
										data : [],
									}
								};
								var Item1 = function() {
									return {
										name : '试穿数据',
										type : 'bar',
										data : [],
									}
								};
								var it = new Item();
								var it1 = new Item1();
								var saleNums = new Array();
								var tryOnNums = new Array();
								angular.forEach(
												$scope.saleTryData,
												function(v, k) {
													styles.push(v.style);
													saleNums.push(v.saleNum);
													tryOnNums.push(v.tryOnNum);
												})
								it.data = saleNums;
								it1.data = tryOnNums;
								Series.push(it);
								Series.push(it1);
								var querySaleTryData = echarts.init(document.getElementById("querySaleTryData"));
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
												type : [
														'line',
														'bar' ]
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
										data : [ '销售数据', '试穿数据' ]
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
										name : '销售/试穿数据',
										min : 0,
										axisLabel : {
											formatter : '{value} 件'
										}
									} ],
									series : []
								};
								option.series = Series;
								querySaleTryData.setOption(
										option, true);
							});
/*====================================门店的各个款式的畅销款TOP10和滞销款Top10数据 =================================================================================*/
			$http({
				url : "querySaleBaseAndSaleWorstData",
				params : {
					"time" : time,
					"storeCode" : storeCode
				},
				method : "get",
			}).then(function(resp) {
								console.log(resp.data.data)
								$scope.SaleBaseAndSaleWorstData = resp.data.data;
								var beseStyle = new Array();
								var worstStyle = new Array();
								var Series = [];
								var Series1 = [];
								var Item = function() {
									return {
										name : '畅销款TOP10',
										type : 'bar',
										data : [],
									}
								};
								var Item1 = function() {
									return {
										name : '滞销款TOP10',
										type : 'bar',
										data : [],
									}
								};
								var beseNum = new Array();
								var worstNum = new Array();
								var it = new Item();
								var it1 = new Item1();
								angular.forEach($scope.SaleBaseAndSaleWorstData,function(v, k) {
													var styles = k;
													if (styles == "saleBestData") {
														$scope.style = v;
														angular.forEach($scope.style,function(v,k) {
																			beseStyle.push(v.style);
																			beseNum.push(v.saleNum);
		
																		})
													}
													if (styles == "saleWorstData") {
														$scope.style1 = v;
														angular.forEach($scope.style1,function(v,k) {
																			worstStyle.push(v.style);
																			worstNum.push(v.saleNum);
																		})
													}
												});
								it1.data = worstNum;
								it.data = beseNum;
								Series.push(it);
								Series1.push(it1);
								var querySaleBaseAndSaleWorstData = echarts.init(document.getElementById("querySaleBaseAndSaleWorstData"));
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
												type : [
														'line',
														'bar' ]
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
										data : [ '畅销款TOP10' ]
									},
									xAxis : [ {
										type : 'category',
										data : beseStyle,
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
								option.series = Series;
								querySaleBaseAndSaleWorstData.setOption(option, true);
								var querySaleBaseAndSaleWorstData1 = echarts.init(document.getElementById("querySaleBaseAndSaleWorstData1"));
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
												type : [
														'line',
														'bar' ]
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
										data : [ '滞销款TOP10' ]
									},
									xAxis : [ {
										type : 'category',
										data : worstStyle,
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
								querySaleBaseAndSaleWorstData1.setOption(option1,true);
							});
						}
						$scope.init('day', null, null);
					})
</script>
</head>
<body ng-app="saleDataApp" ng-controller="saleDataController">
	<div class="col-md-10">
		<div class="dropdown" style="float: right;">
			<button type="button" class="btn dropdown-toggle"
				style="width: 150px;" id="dropdownMenu1" data-toggle="dropdown">
				时间 <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				<li role="presentation"><a role="menuitem" tabindex="-1"
					ng-click="init('day',store.storeCode,store.storeName)">最近一天</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					ng-click="init('week',store.storeCode,store.storeName)">最近一周</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					ng-click="init('month',store.storeCode,store.storeName)">最近一月</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					ng-click="init('quarter',store.storeCode,store.storeName)">最近一季度</a>
				</li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					ng-click="init('year',store.storeCode,store.storeName)">最近一年</a></li>
			</ul>
		</div>
		<div>
			<select style="float: right; width: 140px; height: 35px;"
				ng-model="store"
				ng-options=" x.storeName for x in storCodeAndStoreName">
			</select>
		</div>
	</div>
	<div class="col-md-10 col-md-offset-1">
		<h3>{{storeName}}门店{{timeData}}的各个款式的畅销款TOP10和滞销款TOP10数据</h3>
		<div id="querySaleBaseAndSaleWorstData" class="col-md-12"
			style="height: 300px;"></div>
		<div id="querySaleBaseAndSaleWorstData1" class="col-md-12"
			style="height: 300px;"></div>
		<div class="col-md-5 col-md-offset-1">
			<table class="table table-striped">
				<caption>畅销款TOP10</caption>
				<thead>
					<tr>
						<th>畅销款式</th>
						<th>畅销款数量</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="x in style">
						<td>{{x.style}}</td>
						<td>{{x.saleNum}}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-md-5">
			<table class="table table-striped">
				<caption>滞销款TOP10</caption>
				<thead>
					<tr>
						<th>滞销款式</th>
						<th>滞销款数量</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="x in style1">
						<td>{{x.style}}</td>
						<td>{{x.saleNum}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-md-10 col-md-offset-1">
		<h3>{{storeName}}门店{{timeData}}的各个款式的销售量和试穿量数据</h3>
		<div id="querySaleTryData" class="col-md-12" style="height: 300px;"></div>
		<div class="col-md-10 col-md-offset-1">
			<table class="table table-striped">
				<caption>门店的各个款式的销售量和试穿量数据</caption>
				<thead>
					<tr>
						<th>款式</th>
						<th>销售数量</th>
						<th>试穿数量</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="x in saleTryData">
						<td>{{x.style}}</td>
						<td>{{x.saleNum}}</td>
						<td>{{x.tryOnNum}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>

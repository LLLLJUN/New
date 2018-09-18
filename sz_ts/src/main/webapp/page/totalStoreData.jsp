<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>搭配数据</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	<script src="https://cdn.bootcss.com/angular.js/1.4.6/angular.min.js"></script>
    <script type="text/javascript">
		$(function () { $('#collapseOne1').collapse({
			toggle: false
		})});
		$(function () { $('#collapseTwo').collapse('show')});
		$(function () { $('#collapseThree').collapse('toggle')});
		$(function () { $('#collapseOne').collapse('hide')});
	</script> 
	<style type="text/css">
		a:visited{
			text-decoration:none; 
		}
		a:link{
			text-decoration:none;
		 }
		a:hover{
			text-decoration:none;
		}
		a:active{
			text-decoration:none;
		}
	</style>	
  </head>
  <body ng-app="totalStoreDataApp" ng-controller="totalStoreDataController">
  	<div class="col-md-2 col-md-offset-10">
		<div class="dropdown">
			<button type="button" class="btn dropdown-toggle" style="width: 150px;" id="dropdownMenu1" 
					data-toggle="dropdown">
				时间
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				<li role="presentation">
					<a role="menuitem" tabindex="-1" ng-click="init('day')">最近一天</a>
				</li>
				<li role="presentation">
					<a role="menuitem" tabindex="-1" ng-click="init('week')">最近一周</a>
				</li>
				<li role="presentation">
					<a role="menuitem" tabindex="-1" ng-click="init('month')">最近一月</a>
				</li>
				<li role="presentation">
					<a role="menuitem" tabindex="-1" ng-click="init('quarter')">最近一季</a>
				</li>
				<li role="presentation">
					<a role="menuitem" tabindex="-1" ng-click="init('year')">最近一年</a>
				</li>
			</ul>
		</div>
	</div>
	<br>
	<br>
	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading" style="height:30px;">
				<h4 class="panel-title" >
					<a data-toggle="collapse" data-parent="#accordion" 
					   href="#collapseOne" style="float:right;">
					 	搭配/试穿数据
						<span class="glyphicon glyphicon-plus"></span>
					</a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="col-md-10 col-md-offset-1" style=" height: 150px;">
						<div class="col-md-6" style="height: 200px; float: right;" id="totalStoreTryOnData"></div>
						<div class="col-md-6" style="height: 200px; float: right;" id="totalStoreMathcData"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading" style="height:30px;">
			<div style="float:right;">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion" 
					   href="#collapseTwo">
						所有门店<span class="glyphicon glyphicon-plus"></span>
					</a>
				</h4>
			</div>
		</div>
		<div id="collapseTwo" class="panel-collapse collapse">
			<div class="panel-body">
				<div id="totalData" class="col-md-10 col-md-offset-1" style="height:300px;"></div>
				<div ng-if="isShow"></div>
				<div ng-switch on="data" >
					<div class="col-md-10 col-md-offset-1" ng-switch-when="day">
					   <table class="table table-bordered">
							<thead>
								<tr>
									<th>10点</th>
									<th>12点</th>
									<th>14点</th>
									<th>16点</th>
									<th>18点</th>
									<th>20点</th>
									<th>22点</th>
									<th>24点</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>{{totalData[10]}}</td>
									<td>{{totalData[12]}}</td>
									<td>{{totalData[14]}}</td>
									<td>{{totalData[16]}}</td>
									<td>{{totalData[18]}}</td>
									<td>{{totalData[20]}}</td>
									<td>{{totalData[22]}}</td>
									<td>{{totalData[24]}}</td> 
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-md-10" ng-switch-when="week">
						<table class="table table-bordered col-md-10 col-md-offset-1">
							<thead>
								<tr>
									<th>周一</th>
									<th>周二</th>
									<th>周三</th>
									<th>周四</th>
									<th>周五</th>
									<th>周六</th>
									<th>周日</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>{{totalData.Monday}}</td>
									<td>{{totalData.Tuesday}}</td>
									<td>{{totalData.Wednesday}}</td>
									<td>{{totalData.Thursday}}</td>
									<td>{{totalData.Friday}}</td>
									<td>{{totalData.Saturday}}</td>
									<td>{{totalData.Sunday}}</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-md-10" ng-switch-when="month">
						<table class="table table-bordered col-md-10 col-md-offset-1">
							<thead>
								<tr>
									<th>第一周</th>
									<th>第二周</th>
									<th>第三周</th>
									<th>第四周</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>{{totalData['第一周']}}</td>
									<td>{{totalData['第二周']}}</td>
									<td>{{totalData['第三周']}}</td>
									<td>{{totalData['第四周']}}</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-md-10" ng-switch-when="quarter">
						<table class="table table-bordered col-md-10 col-md-offset-1">
							<thead>
								<tr>
									<th>第一月</th>
									<th>第二月</th>
									<th>第三月</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>{{totalData['第一月']}}</td>
									<td>{{totalData['第二月']}}</td>
									<td>{{totalData['第三月']}}</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-md-10" ng-switch-when="year">
						<table class="table table-bordered col-md-10 col-md-offset-1">
							<thead>
								<tr>
									<th>第一季</th>
									<th>第二季</th>
									<th>第三季</th>
									<th>第四季</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>{{totalData['第一季']}}</td>
									<td>{{totalData['第二季']}}</td>
									<td>{{totalData['第三季']}}</td>
									<td>{{totalData['第四季']}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading" style="height:30px;">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion" 
					   href="#collapseOne1" style="float: right;">
						各个门店<span class="glyphicon glyphicon-plus"></span>
					</a>
				</h4>
			</div>
			<div id="collapseOne1" class="panel-collapse collapse in">
				<div id="totalDetailData" class="col-md-10 col-md-offset-1" style="height: 300px;"></div>
				<div class="panel-body">
					<div ng-if="isShow"></div>
					<div ng-switch on="data">
						<div class="col-md-10 col-md-offset-1" ng-switch-when="day">
						   <table class="table table-bordered col-md-12" >
								<thead>
									<tr>
										<th>门店代码</th>
										<th>10点</th>
										<th>12点</th>
										<th>14点</th>
										<th>16点</th>
										<th>18点</th>
										<th>20点</th>
										<th>22点</th>
										<th>24点</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="detailData in detailDataList">
										<td>{{detailData.storeName}}</td>
										<td>{{detailData.data[10]}}</td>
										<td>{{detailData.data[12]}}</td>
										<td>{{detailData.data[14]}}</td>
										<td>{{detailData.data[16]}}</td>
										<td>{{detailData.data[18]}}</td>
										<td>{{detailData.data[20]}}</td>
										<td>{{detailData.data[22]}}</td>
										<td>{{detailData.data[24]}}</td> 
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-md-10" ng-switch-when="week">
							<table class="table table-bordered col-md-10 col-md-offset-1">
								<thead>
									<tr>
										<th>门店代码</th>
										<th>周一</th>
										<th>周二</th>
										<th>周三</th>
										<th>周四</th>
										<th>周五</th>
										<th>周六</th>
										<th>周日</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="detailData in detailDataList">
										<td>{{detailData.storeName}}</td>
										<td>{{detailData.data.Monday}}</td>
										<td>{{detailData.data.Tuesday}}</td>
										<td>{{detailData.data.Wednesday}}</td>
										<td>{{detailData.data.Thursday}}</td>
										<td>{{detailData.data.Friday}}</td>
										<td>{{detailData.data.Saturday}}</td>
										<td>{{detailData.data.Sunday}}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-md-10" ng-switch-when="month">
							<table class="table table-bordered col-md-10 col-md-offset-1">
								<thead>
									<tr>
										<th>门店代码</th>
										<th>第一周</th>
										<th>第二周</th>
										<th>第三周</th>
										<th>第四周</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="detailData in detailDataList">
										<td>{{detailData.storeName}}</td>
										<td>{{detailData.data['第一周']}}</td>
										<td>{{detailData.data['第二周']}}</td>
										<td>{{detailData.data['第三周']}}</td>
										<td>{{detailData.data['第四周']}}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-md-10" ng-switch-when="quarter">
							<table class="table table-bordered col-md-10 col-md-offset-1">
								<thead>
									<tr>
										<th>门店代码</th>
										<th>第一月</th>
										<th>第二月</th>
										<th>第三月</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="detailData in detailDataList">
										<td>{{detailData.storeName}}</td>
										<td>{{detailData.data['第一月']}}</td>
										<td>{{detailData.data['第二月']}}</td>
										<td>{{detailData.data['第三月']}}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-md-10" ng-switch-when="year">
							<table class="table table-bordered col-md-10 col-md-offset-1">
								<thead>
									<tr>
										<th>门店代码</th>
										<th>第一季</th>
										<th>第二季</th>
										<th>第三季</th>
										<th>第四季</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="detailData in detailDataList">
										<td>{{detailData.storeName}}</td>
										<td>{{detailData.data['第一季']}}</td>
										<td>{{detailData.data['第二季']}}</td>
										<td>{{detailData.data['第三季']}}</td>
										<td>{{detailData.data['第四季']}}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	
	<script src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
	<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>	
	<script src="angularjs/totalStoreData.js"></script>
  </body>
</html>

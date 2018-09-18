<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>试穿数据</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	<script src="https://cdn.bootcss.com/angular.js/1.4.6/angular.min.js"></script>
	<script src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
	<script type="text/javascript">
		$(function () { $('#collapseFour').collapse({
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
  	<body ng-app="dataApp" ng-controller="dataController">
  		<div style=" float: right;margin-top: 20px; margin-bottom: 10px;" class="col-md-5">
			<form>
				<div  style="float: right;">
					<div class="dropdown">
						<button type="button" class="btn dropdown-toggle" style="width: 160px;" id="dropdownMenu1" 
								data-toggle="dropdown">
							时间
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
							<li role="presentation">
								<a role="menuitem" tabindex="-1" ng-click="init(store.storeCode,'day',store.storeName)">最近一天</a>
							</li>
							<li role="presentation">
								<a role="menuitem" tabindex="-1" ng-click="init(store.storeCode,'week',store.storeName)">最近一周</a>
							</li>
							<li role="presentation">
								<a role="menuitem" tabindex="-1" ng-click="init(store.storeCode,'month',store.storeName)">最近一月</a>
							</li>
							<li role="presentation">
								<a role="menuitem" tabindex="-1" ng-click="init(store.storeCode,'quarter',store.storeName)">最近一季</a>
							</li>
							<li role="presentation">
								<a role="menuitem" tabindex="-1" ng-click="init(store.storeCode,'year',storeName)">最近一年</a>
							</li>
						</ul>
					</div>
				</div>
				<div >
					<select style="float: right; width: 140px; height: 35px;"
						ng-model="store"
						ng-options=" x.storeName for x in storCodeAndStoreName">
					</select>
				</div>
			</form>
		</div>
		<br>
		<br>
		<br>
		<br>
		<div class="panel panel-default">
			<div class="panel-heading" style="height:30px;">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion" 
					   href="#collapseTwo" style="float: right;">
						{{storeName}}门店试穿/搭配数据详情<span class="glyphicon glyphicon-plus"></span>
					</a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse">
				<div class="panel-body">
					<div class="col-md-10 col-md-offset-1">
						<div class="col-md-10 col-md-offset-1">
							<ul class="thumbnails list-unstyled">
				              <li class="span4 col-md-4 col-md-offset-2">
				                  <div class="caption col-md-12" contenteditable="true" >
				                   	<button type="button" class="btn btn-info btn-lg" style="font-size: 20px">
									  <span class="glyphicon glyphicon-signal">试穿总次数</span> 
									  <br />
									  {{tryOnTotalNum}}
									</button>
				                  </div>
				              </li>
				             <li class="span4 col-md-4 col-md-offset-1">
				                  <div class="caption" contenteditable="true">
				                    	<button type="button" class="btn btn-info btn-lg" style="font-size: 20px">
										  <span class="glyphicon glyphicon-signal">搭配总次数</span> 
										  <br />
										  {{matchTotalNum}}
										</button>
				                  </div>
				              </li>
				            </ul>
						</div>
						<p></p>
						<div style="margin-top: 10px;" class="col-md-12" >
							<ul class="thumbnails list-unstyled">
				              <li class="span4 col-md-1">
				                  <div class="caption" contenteditable="true" >
				                    <button type="button" class="btn btn-success btn-lg" style="font-size: 20px">
									  <span class="glyphicon glyphicon-thumbs-up">试穿最多款</span> 
									  <br />
									  <h6>{{tryOnMostStyle}}</h6>
									</button>
				                  </div>
				              </li>
				              <li class="span4 col-md-1 col-md-offset-2">
				                  <div class="caption" contenteditable="true">
				                   <button type="button" class="btn btn-danger btn-lg" style="font-size: 20px">
									  <span class="glyphicon glyphicon-thumbs-down">试穿最少款</span> 
									  <br />
									  <h6>{{tryOnLeastStyle}}</h6>
									</button>
				                  </div>
				              </li>
				              <li class="span4 col-md-1 col-md-offset-2">
				                  <div class="caption" contenteditable="true">
				                    <button type="button" class="btn btn-success btn-lg" style="font-size: 20px">
									  <span class="glyphicon glyphicon-thumbs-up">搭配最多款</span> 
									  <br />
									  <h6>{{matchMostStyle}}</h6>
									</button>
				                  </div>
				              </li>
				              <li class="span4 col-md-1 col-md-offset-2">
				                  <div class="caption" contenteditable="true">
				                    <button type="button" class="btn btn-danger btn-lg" >
										<span class="glyphicon glyphicon-thumbs-down" style="font-size: 20px">搭配最少款</span> 
										<br />
										<h6>{{matchLeastStyle}}</h6>
									</button>
				                  </div>
				              </li>
				            </ul>
						</div>
					<div ng-if="isShow"></div>
					<div id="storeDetails" style="height: 300px;" class="col-md-12"></div>
					<div ng-switch on="data" class="col-md-10 col-md-offset-1">
					<br/>
						<div ng-switch-when="day" >
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
										<td>{{tryOnTrend[10]}}</td>
										<td>{{tryOnTrend[12]}}</td>
										<td>{{tryOnTrend[14]}}</td>
										<td>{{tryOnTrend[16]}}</td>
										<td>{{tryOnTrend[18]}}</td>
										<td>{{tryOnTrend[20]}}</td>
										<td>{{tryOnTrend[22]}}</td>
										<td>{{tryOnTrend[24]}}</td> 
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-md-10" ng-switch-when="week">
							<table class="table table-bordered col-md-12">
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
										<td>{{tryOnTrend.Monday}}</td>
										<td>{{tryOnTrend.Tuesday}}</td>
										<td>{{tryOnTrend.Wednesday}}</td>
										<td>{{tryOnTrend.Thursday}}</td>
										<td>{{tryOnTrend.Friday}}</td>
										<td>{{tryOnTrend.Saturday}}</td>
										<td>{{tryOnTrend.Sunday}}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-md-10" ng-switch-when="month">
							<table class="table table-bordered col-md-12">
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
										<td>{{tryOnTrend['第一周']}}</td>
										<td>{{tryOnTrend['第二周']}}</td>
										<td>{{tryOnTrend['第三周']}}</td>
										<td>{{tryOnTrend['第四周']}}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-md-10" ng-switch-when="quarter">
							<table class="table table-bordered col-md-12">
								<thead>
									<tr>
										<th>第一月</th>
										<th>第二月</th>
										<th>第三月</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>{{tryOnTrend['第一月']}}</td>
										<td>{{tryOnTrend['第二月']}}</td>
										<td>{{tryOnTrend['第三月']}}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-md-10" ng-switch-when="year">
							<table class="table table-bordered col-md-12">
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
										<td>{{tryOnTrend['第一季']}}</td>
										<td>{{tryOnTrend['第二季']}}</td>
										<td>{{tryOnTrend['第三季']}}</td>
										<td>{{tryOnTrend['第四季']}}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading" style="height: 30px;">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion" 
					   href="#collapseOne" style="float: right;">
						{{storeName}}门店各试穿/搭配款式<span class="glyphicon glyphicon-plus"></span>
					</a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="col-md-10 col-md-offset-1">
						<div class="col-md-4" style="margin-top:60px; min-height:200px;overflow-y:auto;max-height:200px;">
							<table class="table table-bordered ">
								<thead>
									<tr>
										<th>试穿款式</th>
										<th>试穿次数</th>
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="x in queryTryOnData">
										<td>{{x.style}}</td>
										<td>{{x.tryOnNum}}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div style="height: 270px;" class="col-md-8" id="queryTryOnData"></div>
						
						<div class="col-md-4" style=" margin-top:60px; min-height:200px;overflow-y:auto;max-height:200px;">
							<table class="table table-bordered ">
								<thead>
									<tr>
										<th>搭配款式</th>
										<th>搭配次数</th>
										
									</tr>
								</thead>
								<tbody>
									<tr ng-repeat="x in queryMatchData">
										<td>{{x.matchStyle}}</td>
										<td>{{x.viewNum}}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div style=" height:270px;" class="col-md-8" id="queryMatchData"></div>
					</div>
				</div>
			</div>
		</div>
		<script src="angularjs/storeTryOnData.js"></script>
	</body>
</html>

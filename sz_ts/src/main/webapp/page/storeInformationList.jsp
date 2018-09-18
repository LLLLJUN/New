<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>门店列表</title>
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
		var app=angular.module('storeApp',[]);
		app.controller('storeController',function($scope,$http){
			$scope.$watch('$viewContentLoaded', function() {  
				$scope.init(null,null,null); 
			});
			$scope.init=function(storeCode,storeArea,pageRow){
				$http({
					url:"pageQueryStore",
					method:"get",
					params:{"storeCode":storeCode,"storeArea":storeArea,"pageRow":pageRow},
				}).then(function(resp){
					console.log=resp.data.data.storeList;
					$scope.storeList=resp.data.data.storeList;
					$scope.page=resp.data.data.page;
				});
			}
			$scope.deleteStore=function(storeCode){
				$http({
					url:"deleteStore",
					method:"get",
					params:{"storeCode":storeCode},
				}).then(function(resp){
					console.log(resp.data);
					if(resp.data.code==1){
						alert("删除成功");
						window.location.reload();
					}
				});
			}
			
		});
	
	</script>
  </head>
 	<body ng-app="storeApp" ng-controller="storeController">
		<div style="margin-top: 20px;">
			<form>
				<button type="button" ng-click="init(storeCode,storeArea)" class="btn btn-primary" style="float: right;">搜索</button>
				<input type="text" class="form-control" ng-model="storeCode" placeholder="请输入门店编号" style="float: right; width: 200px;"/>
				<input type="text" class="form-control" ng-model="storeArea" placeholder="请输入门店所属区域" style="float: right; width: 200px;"/>
			</form>
		</div>
		<br />
		<br />
		<br />
		<div style="margin-left: 20px; margin-right: 20px;">
			<table class="table table-hover" id="storeList">
				<thead>
					<tr>
						<th>门店名称</th>
						<th>门店代码</th>
						<th>所属区域</th>
						<th>门店地址</th>
						<th>门店电话</th>
						<th>创建时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="x in storeList">
						<td>{{x.storeName}}</td>
						<td>{{x.storeCode}}</td>
						<td>{{x.storeArea}}</td>
						<td>{{x.storeAddress}}</td>
						<td>{{x.storeTel}}</td>
						<td>{{x.createTime}}</td>
						<td>
							<a href="page/storeInformationModification.jsp?storeCode={{x.storeCode}}"><input type='button' class='btn btn-info' value='编辑'></a>
							<input type="button" class="btn btn-danger" ng-click="deleteStore(x.storeCode)" onclick="return confirm('确定删除？？？')" value="删除">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-md-offset-4">
			<div>
			 	<font size="2">共 {{page.pages}}页</font>
			 	<font size="2">第{{page.pageRow}} 页</font>
			 	<a ng-if="page.pageRow===1" > 首页 </a>
				<a ng-if="page.pageRow!==1" ng-click="init(page.condition.storeCode,page.condition.storeArea,page.pageRow=1)"> 首页</a>
               	<a ng-if="page.pageRow<=1"> 上一页</a>
				<a ng-if="page.pageRow>1" ng-click="init(page.condition.storeCode,page.condition.storeArea,page.pageRow-1)"> 上一页</a>
				<a ng-if="page.pageRow>=page.pages"> 下一页</a>
				<a ng-if="page.pageRow<page.pages" ng-click="init(page.condition.storeCode,page.condition.storeArea,page.pageRow+1)"> 下一页</a>
				<a ng-if="page.pageRow>=page.pages"> 尾页</a>
				<a ng-if="page.pageRow<page.pages" ng-click="init(page.condition.storeCode,page.condition.storeArea,page.pageRow=page.pages)"> 尾页</a>
			</div>
		</div>
	</body>
</html>

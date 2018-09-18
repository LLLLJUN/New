<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>门店信息修改</title>
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
		app.config(['$locationProvider', function($locationProvider) {  
			         $locationProvider.html5Mode({
			          enabled: true,
			          requireBase: false
			        });
	       	 }]);
		app.controller('storeController',function($scope,$http,$location){
			$scope.init=function(storeCode){
				$http({
					method:"get",
					params:{"storeCode":storeCode},
					url:"queryStore",
				}).then(function(resp){
					console.log(resp.data.data[0]);
					$scope.store=resp.data.data[0];
				});
			}
			$scope.init($location.search().storeCode);
			$scope.submit=function(){
				$http({
					method:"post",
					params:{"storeName":$scope.store.storeName,"storeCode":$scope.store.storeCode,"storeTel":$scope.store.storeTel,"storeAddress":$scope.store.storeAddress,"storeArea":$scope.store.storeArea},
					url:"updateStores",
				}).then(function(resp){
					if(resp.data.code==1){
						alert("修改成功");
						window.location.href="page/storeInformationList.jsp";
					}
					
				});
			}
		});
	</script>
  </head>
  	<body style="width: 1000px;" ng-app="storeApp" ng-controller="storeController">
		<form role="form">
			<div class="row" style=" margin-top: 50px;">
				<div class="col-md-4 col-md-offset-4 ">
					<div class="coll-md-4 col-md-offset-4">
						<h3><b>编辑门店信息</b></h3>
					</div>
					<div >
						<label>门店名字：</label>
						<input type="text" class="form-control" ng-model="store.storeName" value="{{store.storeName}}" />
					</div>
					<div >
						<label>门店编码：</label>
						<input type="text" class="form-control" ng-model="store.storeCode" readonly  ng-value="{{store.storeCode}}" />
					</div>
					<div >
						<label>门店地址：</label>
						<input type="text" ng-model="store.storeAddress" class="form-control" value="{{store.storeAddress}}" />
					</div>
					<div >
						<label>门店所属地区：</label>
						<input type="text" ng-model="store.storeArea" class="form-control" value="{{store.storeArea}}"/>
					</div>
					<div >
						<label>门店电话：</label>
						<input type="text" ng-model="store.storeTel" class="form-control" value="{{store.storeTel}}" />
					</div>
					
					<div class="col-md-offset-5">
						<input type="button" value="提交" ng-click="submit()" class="btn btn-primary" />
					</div>
				</div>
			</div>
		</form>
	</body>
	
</html>

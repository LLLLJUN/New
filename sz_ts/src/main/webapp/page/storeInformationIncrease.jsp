<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>增加门店信息</title>
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
		var app = angular.module('storeApp',[]);
		app.controller('storeController',function($scope,$http){
			$scope.submit=function(){
				$http({
					method:"post",
					url:"increaseStore",
					params:{"storeCode":$scope.storeCode,"storeName":$scope.storeName,"storeTel":$scope.storeTel,"storeAddress":$scope.storeAddress,"storeArea":$scope.storeArea},
				}).then(function(resp){
					console.log(resp);
					$scope.num=resp.data.code;
					if($scope.num==1){
						alert("新增成功");
						window.location.href="page/storeInformationList.jsp";
					}
				})
			};
		});
	</script>	
  </head>
  <body style="width: 1000px;" ng-app="storeApp" ng-controller="storeController">
		<form role="form">
			<div class="row" style=" margin-top: 50px;">
				<div class="col-md-4 col-md-offset-4 ">
					<div class="coll-md-4 col-md-offset-4">
						<h3><b>增加门店{{num}}</b></h3>
					</div>
					<div >
						<label>门店名字：</label>
						<input type="text" id="storeName" ng-model="storeName" class="form-control" />
					</div>
					<div >
						<label>门店编码：</label>
						<input type="text" id="storeCode" ng-model="storeCode" class="form-control" />
					</div>
					<div >
						<label>门店地址：</label>
						<input type="text" id="storeAddress" ng-model="storeAddress" class="form-control" />
					</div>
					<div >
						<label>门店所属地区：</label>
						<input type="text" id="storeArea" ng-model="storeArea" class="form-control" />
					</div>
					<div >
						<label>门店电话：</label>
						<input type="text" id="storeTel" ng-model="storeTel" class="form-control" />
					</div>
					<div class="col-md-offset-5">
						<input type="button" ng-click="submit()" value="提交" class="btn btn-primary" />
					</div>
				</div>
			</div>
		</form>
	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<title>登录</title>
	<meta charset="utf-8">
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
	  	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	  	<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
	  	<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	  	<script src="https://cdn.bootcss.com/angular.js/1.4.6/angular.min.js"></script>
	  	<script type="text/javascript">
			var app=angular.module('loginApp',[]);
			app.controller('loginController',function($scope,$http){
				$scope.login=function(userCode,userPsw){
					$http({
						url:"tologin",
						params:{"userCode":userCode,"userPsw":userPsw},
						method:"get",
					}).then(function(resp){
						console.log=resp.data
						if(resp.data.code==1){
							window.location.href="index.jsp"; 							
						}
					});
				}
			});
		</script>
</head>
	<body ng-app="loginApp" ng-controller="loginController">
		<div class="container" style="margin-top: 150px;">
			<div class="col-sm-4 offset-md-4 bg-light text-dark">
					<div class="row">
						<div class="col-sm-4 offset-md-4">
							<span style="font-size: 20px;">用户登录</span>
						</div>
						<div class="col-sm-9 offset-md-1">
							<font id="fontname"></font><p>
							<label class="text-left">用户名</label>
							<input type="text" class="form-control" ng-model="userCode"  placeholder="请输入用户名"/>
						</div>
						<div class="col-sm-9 offset-md-1">
							<label class="text-left">密码</label>
							<input type="password" class="form-control" ng-model="userPsw"  placeholder="请输入密码"/>
						</div>
					</div>
					<div class="col-sm-1">
						<input type="button" ng-click="login(userCode,userPsw)" class="btn btn-info" style="width: 370px; margin-left: -30px;border: solid 1px;" value="登录">
					</div>
			</div>
		</div>
	</body>
</html>
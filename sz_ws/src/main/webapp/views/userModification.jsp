<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
	<script src="https://cdn.bootcss.com/angular.js/1.4.6/angular.min.js"></script>
	<script type="text/javascript">
		var app=angular.module('userModificationApp',[]);
		app.config(['$locationProvider', function($locationProvider) {  
	         $locationProvider.html5Mode({
	          enabled: true,
	          requireBase: false
	        });
  		 }]);
		app.controller('userController',function($http,$scope,$location){
			$scope.init=function(userCode){
				$http({
					url:"queryUserCodeInfo",
					params:{"userCode":userCode},
					method:"get",
				}).then(function(resp){
					$scope.user=resp.data.data;
				});
			}
			$scope.init($location.search().userCode);
		});
	
	</script>	
  </head>
  <body ng-app="userModificationApp" ng-controller="userController" class="bg-info">
	<div class="container-fluid col-md-6 col-md-offset-3 "  style="margin-top: 100px;">
    		<div class="col-md-offset-5">
    			<span style="font-size: 20px;">编辑用户</span>
    		</div>
    		<form class="form-inline">
    			<div class="row">
	    			<div class="form-group col-md-offset-3">
	    				<label class="form-label">用户姓名</label>
		    			<input type="text" ng-model="user.userName" value="{{user.userName}}" class="form-control"  />
	    			</div>
	    			<div class="col-md-offset-3">
	    				<label class="form-label">用户编码</label>
						<input type="text"  class="form-control" ng-model="user.userCode" value="{{user.userCode}}" />
	    			</div>
	    			<div class="col-md-offset-3">
    					<label class="form-label" style="margin-left: 27px;">密码</label>
    					<input type="password"  class="form-control" ng-model="user.userPsw" value="{{user.userPsw}}" disabled="disabled" />
					</div>
					<div class="col-md-offset-3">
    					<label class="form-label">用户角色</label>
    					<input type="text"  class="form-control" value="{{user.userRoleName}}" />
    				</div>
    				<div class="col-md-offset-3">
    					<label>用户邮箱</label>
    					<input type="text"  class="form-control" ng-model="user.userMail" value="{{user.userMail}}"/>
    				</div>
    				<div class="col-md-offset-3">
    					<label>联系电话</label>
    					<input type="text"  class="form-control" ng-model="user.userTel" value="{{user.userTel}}" />
    				</div>
    				<button type="button" class="btn btn-primary col-md-offset-5">提交</button>
    			</div>
    		</form>
    	</div>
  </body>
</html>

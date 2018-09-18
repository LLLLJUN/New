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
	$(function(){
		$("#addUser").click(function(){
			alert(1);
			$.ajax({
				url:"addUsers",
				data:{"userCode":$scope.userCode,"userName":$scope.userName,"userPsw":$scope.userPsw,"userTel":$scope.userTel,"userMail":$scope.userMail,"storeCode":$scope.store,"userRole":$scope.userRole},
				type:"post",
				dataType:"json",
				success:function(data){
					alert(1);
				}
			});
		});
	});
	
		var app=angular.module('userApp',[]);
		app.config(function($httpProvider){
            $httpProvider.defaults.headers.post = { 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8' }
        })
		app.controller('userAddController',function($scope,$http){
			$scope.submit=function(){
				$http({
					method:"get",
					url:"addUsers",
					params:{"userCode":$scope.userCode,"userName":$scope.userName,"userPsw":$scope.userPsw,"userTel":$scope.userTel,"userMail":$scope.userMail,"storeCode":$scope.store,"userRole":$scope.userRole},
				}).then(function(resp){
					console.log(resp.data.data);
				});
			}
			$scope.init=function(){
				$http({
  					url:"queryAllRoleInfo",
  					method:"get",
  				}).then(function(resp){
  						console.log(resp.data.data);
					 	$scope.roles=resp.data.data;				
  				});
  				$http({
  					url:"queryTotalStore",
  					method:"get",
  				}).then(function(resp){
 					console.log(resp.data.data);
				    $scope.stores=resp.data.data;				
  				});
			}
			$scope.init();
		});
	</script>	
  </head>
  <body ng-app="userApp" ng-controller="userAddController">
	<div class="container-fluid col-md-6 col-md-offset-3 bg-info"  style="margin-top: 100px;">
    		<div class="col-md-offset-5">
    			<span style="font-size: 20px;">新增用户</span>
    		</div>
    		<form class="form-inline">
    			<div class="row">
	    			<div class="form-group col-md-offset-3">
	    				<label class="form-label">用户姓名</label>
		    			<input type="text"  class="form-control" ng-model="userName" />
	    			</div>
	    			<div class="col-md-offset-3">
	    				<label class="form-label">用户编码</label>
						<input type="text"  class="form-control" ng-model="userCode" />
	    			</div>
	    			<div class="col-md-offset-3">
    					<label class="form-label" style="margin-left: 27px;">密码</label>
    					<input type="password"  class="form-control" ng-model="userPsw" />
					</div>
    				<div class="col-md-offset-3">
    					<label class="form-label">用户角色</label>
    					<select  style=" width: 200px; height: 30px;" ng-model="userRole">
							<option ng-repeat="x in roles" value="{{x.role}}">{{x.userRoleName}}</option>
						</select>
    				</div>
    				<div class="col-md-offset-3" >
    					<label>用户邮箱</label>
    					<input type="text"  class="form-control" ng-model="userMail"/>
    				</div>
    				<div class="col-md-offset-3" >
    					<label>联系电话</label>
    					<input type="text" class="form-control" ng-model="userTel"/>
    				</div>
    				<div class="col-md-offset-3">
    					<label>门店代码</label>
    					<select  style=" width: 200px; height: 30px;" ng-model="store">
							<option ng-repeat="x in stores" value="{{x.storeCode}}">{{x.storeName}}</option>
						</select>
    				</div>
    				<input type="button" ng-click="submit()" class="btn btn-primary col-md-offset-5" value="提交"/>
    			</div>
    		</form>
    	</div>
  </body>
</html>

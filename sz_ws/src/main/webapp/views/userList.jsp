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
  		var app=angular.module('userApp',[]);
  		app.controller('userController',function($scope,$http){
  			$scope.$watch('$viewContentLoaded', function() {  
				$scope.init(null,0,1,null); 
			});
  			$scope.init=function(userCode,userRole,pageRow,storeCode){
  				$http({
  					url:"queryUserList",
  					params:{"userCode":userCode,"userRole":userRole,"pageRow":pageRow},
  					method:"get",
  				}).then(function(resp){
  					console.log(resp.data)
  					$scope.userList=resp.data.data.userList; 
  					$scope.page=resp.data.data.page; 
  				});
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
  			$scope.deleteUser=function(userCode){
  				$http({
  					url:"deleteUsers",
  					params:{"userCode":userCode},
  					method:"get",
  				}).then(function(resp){
  					console.log(resp.data.data);
  					if(resp.data.code==1){
  						alert("删除成功");
  						window.location.reload();
  					}
  				});
  			}
  		});
  	</script>
  </head>
  <body ng-app="userApp" ng-controller="userController">
  	<div style="margin-top: 20px; margin-right: 230px;">
		<form>
			<button type="button" ng-click="init(userCode,userRole,storeCode)" class="btn btn-primary" style="float: right;">搜索</button>
			<input type="text" class="form-control" ng-model="userCode" placeholder="请输入用户编码" style="float: right; width: 200px;"/>
			<select  style="float: right; width: 140px; height: 35px;">
				<option selected="selected">--请选择门店--</option>
				<option ng-repeat="x in stores" value="{{x.storeCode}}">{{x.storeName}}</option>
			</select>
			<select  style="float: right; width: 140px; height: 35px;">
				<option selected="selected">--请选择角色--</option>
				<option ng-repeat="x in roles" value="{{x.role}}">{{x.userRoleName}}</option>
			</select>
		</form>
	</div>
  	<div class="col-md-11 col-md-offset-1" style="margin-bottom: 2px; margin-top: 20px;">
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>用户名字</td>
					<td>用户编码</td>
					<td>用户权限</td>
					<td>用户邮箱</td>
					<td>用户电话</td>
					<td>所属门店</td>
					<td>创建时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="user in userList">
					<td>{{user.userName}}</td>
					<td>{{user.userCode}}</td>
					<td>{{user.userRoleName}}</td>
					<td>{{user.userMail}}</td>
					<td>{{user.userTel}}</td>
					<td>{{user.storeName}}</td>
					<td>{{user.createTime}}</td>
					<td>
						<a href="views/userModification.jsp?userCode={{user.userCode}}"><input type='button' class='btn btn-info' value='编辑'></a>
						<input type="button" class="btn btn-danger" ng-click="deleteUser(user.userCode)" onclick="return confirm('确定删除？？？')" value="删除">
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<br>
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

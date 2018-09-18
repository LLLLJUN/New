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
	<style type="text/css">
		a:visited{text-decoration:none; 
			color: white;
		}
		a:link{text-decoration:none;
			color: white;
		 }
		a:hover{text-decoration:none;
			color: white;
		}
		a:active{text-decoration:none;
			color: white;
		}
		li{
		list-style-type:none; 
		}
		span{
			color:white;
		}
		ul{
			border: 1px white solid;
		}
	</style>
  </head>
  	<body>
  		<div style="background-color:#424242;">
  			<div style="border: solid 1px; width: 200px; height: 100px; float:left; background-color:#424242;" align="center">
	  			<h4 style="margin-top: 40px; color:white;">试衣屏后台管理</h4>
	  		</div>
	  		<div style="width: 1050px; height: 100px; float:left; background-color:#424242;" >
	  			<div style="float: right; margin-top: 40px; margin-right: 150px;">
	  				<div class="dropdown" style="background-color:#424242; ">
						<button type="button" class="btn dropdown-toggle" id="dropdownMenu1" 
								data-toggle="dropdown">
							<span class="glyphicon glyphicon-user"></span>
							&nbsp;
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
							<li role="presentation">
								<a role="menuitem" tabindex="-1" >门店代码:</a>
							</li>
							<li role="presentation">
								<a role="menuitem" tabindex="-1" >门店地址:</a>
							</li>
							<li role="presentation">
								<a role="menuitem" tabindex="-1">门店电话:</a>
							</li>
						</ul>
					</div>
	  			</div>
	  		</div> 
  		</div>
		 <div class="panel" style="height:550px; width: 200px; float:left; background-color: #424242;">
	        <div class="panel-heading" style="height: 30px;">
	            <h4 class="panel-title">
	            	<span class="glyphicon glyphicon-chevron-down" style="font-size: 15px;margin-left: 10px; "></span>
	                <a data-toggle="collapse" data-parent="#accordion"  href="#storeManagement" style="margin-left: 3px; color: white;">
	                	门店管理
	                </a>
	            </h4>
	        </div>
	        <div id="storeManagement" class="panel-collapse collapse" >
	            <div class="panel-body"  style="padding: 0px;">
	               <ul>
	               		<li><a href="page/storeInformationList.jsp" target="iframe">门店列表</a></li>
	               		<li><a href="page/storeInformationIncrease.jsp" target="iframe">增加门店信息</a></li>
	               </ul>
	            </div>
	        </div>
	        <div class="panel-heading" style="height: 30px;">
	            <h4 class="panel-title">
	            	<span class="glyphicon glyphicon-chevron-down" style="font-size: 15px;margin-left: 10px;"></span>
	                <a data-toggle="collapse" data-parent="#accordion"  href="#styleImg" style="margin-left: 3px;">
	                	试穿图片管理
	                </a>
	            </h4>
	        </div>
	        <div id="styleImg" class="panel-collapse collapse">
	            <div class="panel-body"  style="padding: 0px;">
	               <ul>
	               		<li><a href="" target="iframe">试穿图片列表</a></li>
	               		<li><a href="" target="iframe">试穿图片增加</a></li>
	               </ul>
	            </div>
	        </div>
	        <div class="panel-heading" style="height: 30px;" >
	            <h4 class="panel-title">
	            	<span class="glyphicon glyphicon-chevron-down" style="font-size: 15px;margin-left: 10px;"></span>
	                <a data-toggle="collapse" data-parent="#accordion"  href="#matchImg" style="margin-left: 3px;">
	                	搭配图片管理
	                </a>
	            </h4>
	        </div>
	        <div id="matchImg" class="panel-collapse collapse">
	            <div class="panel-body"  style="padding: 0px;">
	               <ul>
	               		<li><a href="" target="iframe">搭配图片列表</a></li>
	               		<li><a href="" target="iframe">搭配图片增加</a></li>
	               </ul>
	            </div>
	        </div>
	        <div class="panel-heading" style="height: 30px;">
	            <h4 class="panel-title">
	            	<span class="glyphicon glyphicon-chevron-down" style="font-size: 15px;margin-left: 10px;"></span>
	                <a data-toggle="collapse" data-parent="#accordion"  href="#data" style="margin-left: 3px;">
	                	试穿数据管理
	                </a>
	            </h4>
	        </div>
	        <div id="data" class="panel-collapse collapse">
	            <div class="panel-body"  style="padding: 0px;">
	               <ul>
	               		<li><a href="page/storeTryOnData.jsp" target="iframe">门店试穿数据分析</a></li>
	               		<li><a href="page/totalStoreData.jsp" target="iframe">所有门店试穿数据分析</a></li>
	               </ul>
	            </div>
	        </div>
	        <div class="panel-heading" style="height: 30px;" >
	            <h4 class="panel-title">
	            	<span class="glyphicon glyphicon-chevron-down" style="font-size: 15px;margin-left: 10px;"></span>
	                <a data-toggle="collapse" data-parent="#accordion"  href="#saleData" style="margin-left: 3px;">
	                	销售数据管理
	                </a>
	            </h4>
	        </div>
	        <div id="saleData" class="panel-collapse collapse">
	            <div class="panel-body"  style="padding: 0px;">
	               <ul>
	               		<li><a href="page/saleData.jsp" target="iframe">销售数据分析</a></li>
	               		<li><a href="page/bestAndWorstSaleData.jsp" target="iframe">畅/滞销数据分析</a></li>
	               </ul>
	            </div>
	        </div>
		 </div>
		   
	     <div style="float:left;">
              <div>
                  <iframe style=" height: 550px; width: 1050px; " id="iframe" name="iframe" src="page/storeInformationList.jsp" frameborder="1"></iframe>
              </div>
         </div>
	</body>
</html>

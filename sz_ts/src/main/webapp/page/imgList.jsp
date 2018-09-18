<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
  </head>
  <body>
  <div align="center">
  	<div style="border: 1px solid red; width: 700px;">
  		<table>
			<tr>
				<td>版本号</td>
				<td>图片路径</td>
				<td>编辑</td>	
			</tr>
				<c:forEach items="${advertisingList }" var="advertising">
					<tr>
						<td>${advertising.adVersion }</td>
						<td>${advertising.adUrl }</td>
						<td><a href="selectById?id=${advertising.id }">编辑</a></td>
					</tr>
				</c:forEach>
		</table>
  	</div>
  </div>
  </body>
</html>

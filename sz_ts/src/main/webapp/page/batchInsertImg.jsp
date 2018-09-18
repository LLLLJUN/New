<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<!-- <script type="text/javascript">
		$(function(){
			$("#submit").click(function(){
				$.ajax({
					url:"UserAction/userLogin.action",
					data:{"u.tname":$("#tname").val(),"u.tpad":$("#tpad").val()},
					type:"post",
					dataType:"json",
					success:function(data){
						if(data.meg){
							location.href="welcome.jsp";
						}else{
							$("#error").html("用户名或密码错误");
						}
					}
				});
			});
		});
	</script> -->
<body>
	<div align="center">
		<div style="border: 1px solid red; width: 500px; ">
		<form action="insertImg" method="get" encType="multipart/form-data">
			版本号:<input type="text" name="adVersion"><br>
			<span style="margin-left: 90px;">图片1：</span><input type="file" name="file"><br>
			<span style="margin-left: 90px;">图片2：</span><input type="file" name="file"><br>
			<span style="margin-left: 90px;">图片3：</span><input type="file" name="file"><br>
			<span style="margin-left: 90px;">图片4：</span><input type="file" name="file"><br>
			<span style="margin-left: 90px;">图片5：</span><input type="file" name="file"><br>
			
		<input type="submit" value="提交" />
			<a href="selectAllImg"><input type="button" value="查看图片列表"></a>
		
	</form>
	
	</div>
	</div>
</body>
</html>
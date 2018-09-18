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
	<link rel="shortcut icon" href="assets/ico/favicon.html">
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/theme.css" rel="stylesheet">
    <link href="assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/alertify.css" rel="stylesheet">
  </head>
  <body>
    <div id="wrap">
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span12">
          	<div class="row-fluid">
				<div class="widget container-narrow">
					<div class="widget-header">
						<i class="icon-user"></i>
						<h5>Log in to your account</h5>
					</div>  
					<div class="widget-body clearfix" style="padding:25px;">
		      			<form action="http://www.psdwars.com/bluth/realm/index.html">
		      				<div style="padding:10px 0">
		      					<a style="" href="#" class="btn btn-large btn-block btn-primary"><i class="icon-facebook-sign"></i> Login with Facebook</a>
		      				</div>
		      				<div class="divider">
		      					<hr class="pull-left"><span>or</span><hr class="pull-right">
		      				</div>
							<div class="control-group">
								<div class="controls">
									<input class="btn-block" type="text" id="inputEmail" placeholder="Email">
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input class="btn-block" type="password" id="inputPassword" placeholder="Password">
								</div>
							</div>
							 <div class="control-group">
								<div class="controls clearfix">
									<label style="width:auto" class="checkbox pull-left">
										<input type="checkbox"> Remember me
									</label>
									<a style="padding: 5px 0px 0px 5px;" href="#" class="pull-right">Forgot Password?</a>
								</div>
							</div>					
							<button type="submit" class="btn pull-right">Sign in</button>
		      			</form>
					</div>  
				</div>  
      			<div style="text-align:center">
      				<p>Neen an account? <a href="new_account.html">Create Account</a></p>
      			</div>
        	</div><!--/row-fluid-->
        </div><!--/span10-->
      </div><!--/row-fluid-->
    </div><!--/.fluid-container-->
    </div><!-- wrap ends-->
  </body>
</html>

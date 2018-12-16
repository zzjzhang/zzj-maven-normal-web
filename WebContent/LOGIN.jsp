<!DOCTYPE HTML>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" type="text/css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
	<body>
		<div class="container-fluid" style="height: 41px; border-bottom: solid 1px #EEE;"></div>
		<div class="container" style="height: 80px">
			<div class="row" style="padding-top: 15px">
				<div class="col-md-4">
					<img alt="Please refresh." src="<%=request.getContextPath()%>/resources/img/Logo.png" height="40px">
				</div>
				<div class="col-md-8"></div>
			</div>
		</div>
		<div class="container" style="margin-top: 40px">
			<div class="row">
				<div class="col-md-7">
					<img alt="Please refresh" src="<%=request.getContextPath()%>/resources/img/P2.png" style="height: 100%">
				</div>
				<div class="col-md-3" style="border-width: 1px; border-color: #DEDEDE; border-style: solid; height: 256px">
					<form method="post" action="<%=request.getContextPath()%>/business/login">
						<div style="padding-top: 60px;">
							<span class="glyphicon glyphicon-user" aria-hidden="true" style="font-size: 20px; margin-left: 10px; margin-top: 4px"></span>
							<input type="text" name="name" placeholder="  邮箱" style="width: 80%; height: 30px; float: right; border-style: solid; border-width: 1px; border-color: #DEDEDE" />
						</div>
						<div style="padding-top: 20px;">
							<span class="glyphicon glyphicon-lock" aria-hidden="true" style="font-size: 20px; margin-left: 10px; margin-top: 4px"></span>
							<input type="password" name="password" style="width: 80%; height: 30px; float: right; border-style: solid; border-width: 1px; border-color: #DEDEDE" />
						</div>
						<div style="padding-top: 45px;">
							<input type="submit" value="登    陆" style="width: 100%; height: 40px; border-width: 0; font-size: 16px; background-color: #232234; color: white; border-radius: 3px"/>
						</div>
					</form>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
		<div class="container" style="margin-top: 40px; border-top: solid 1px #EEE;">
			<div class="row">
				<div class="col-md-12">
				</div>
			</div>
		</div>

		<script src="<%=request.getContextPath()%>/resources/js/jquery-1.8.3.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

	</body>
</html>
<!DOCTYPE HTML>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<!--------------------------------->
		<!-- Bootstrap Necessary Content -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Bootstrap Necessary Content -->
		<!--------------------------------->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/RESOURCES/css/bootstrap.min.css">
		<title>Welcome 2 Online Market</title>
	</head>
	<body>
		<div class="container-fluid" style="border-bottom: solid 1px #EEE;">
			<div class="container">
				<div class="row">
					<div class="col-xs-6 col-md-6" style="margin: 5px 0 5px 0">
						<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>&nbsp;&nbsp;电话：56486193
					</div>
					<div class="col-xs-6 col-md-6" style="margin: 5px 0 5px 0">

						<!-- Login Button -->
						<a id="aOpenLoginModal" data-toggle="modal" data-target="#loginModal"
							href="#" style="color: black; text-decoration: none; outline: none; display: inline;">
							<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;&nbsp;登录
						</a>

						<!-- User Photo -->
						<a id="aOpenImgModal" data-toggle="modal" data-target="#imgModal"
							href="#" style="text-decoration: none; outline: none; display: none;">
							<img id="imgPhoto" src="" alt="..." class="img-circle" style="max-height: 18px;">
						</a>

						<!-- Login Window -->
						<div id="loginModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
							<div class="modal-dialog modal-sm">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" id="btnCloseLogin" class="close" data-dismiss="modal" aria-label="Close" style="outline: none;">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">登录</h4>
									</div>
									<div class="modal-body">

										<form>
											<div class="form-group">
												<label for="inputEmail" style="font-weight: normal;">用户名：</label>
												<input type="email" class="form-control" id="inputEmail" placeholder="">
											</div>
											<div class="form-group">
												<label for="inputPassword" style="font-weight: normal;">密码：</label>
												<input type="password" class="form-control" id="inputPassword" placeholder="">
											</div>
										</form>

									</div>
									<div class="modal-footer">
										<button id="btnLogin" type="button" class="btn btn-default" style="outline: none;"
											onclick="javascript: logIn()">登录</button>
									</div>
								</div>
							</div>
						</div>

						<!-- Photo Window -->
						<div id="imgModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
							<div class="modal-dialog modal-sm">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" id="btnCloseImg" class="close" data-dismiss="modal" aria-label="Close" style="outline: none;">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="imgModalLabel">用户信息</h4>
									</div>
									<div class="modal-body" style="text-align: center;">

										<img id="imgPhotoBig" src="" alt="..." class="img-circle">

									</div>
									<div class="modal-footer">
										<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
									    	<a href="#" class="btn btn-default" role="button" 
									    		style="border-width: 0; border-radius: 0;">
									    		<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
									    	</a>
									    	<a href="#" class="btn btn-default" role="button" 
									    		style="border-top-width: 0; border-bottom-width: 0; border-radius: 0;">
									    		<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
									    	</a>
									    	<a href="#" class="btn btn-default" role="button" 
									    		style="border-width: 0; border-radius: 0;" onclick="javascript: logOut()" >
									    		<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
									    	</a>
									    </div>
									</div>
								</div>
							</div>
						</div>
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-xs-2 col-sm-2 col-md-2">

					<div style="padding: 15px">
						<a href="#" style="padding: 4px;">
							<img src="<%=request.getContextPath()%>/RESOURCES/img/Logo.png" alt="..." style="max-height: 30px; width: auto;"/>
						</a>
					</div>

				</div>
				<div class="col-xs-10 col-sm-10 col-md-8">
					<div style="position: relative; padding: 15px 15px;">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="机器猫" aria-describedby="basic-addon2" style="border-top-right-radius: 0; border-bottom-right-radius: 0">
							<span class="input-group-addon" id="basic-addon2" style="border-top-left-radius: 0; border-bottom-left-radius: 0">搜索</span>
						</div>
					</div>
				</div>
				<div class="col-md-2"></div>
			</div>
			<div class="row">
				<div class="col-md-12">

					<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					  <!-- Indicators -->
					  <ol class="carousel-indicators">
					    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
					    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
					  </ol>

					  <!-- Wrapper for slides -->
					  <div class="carousel-inner" role="listbox">
					    <div class="item active">
					      <img src="<%=request.getContextPath()%>/RESOURCES/img/0.jpg" alt="...">
					      <div class="carousel-caption">
					        ...
					      </div>
					    </div>
					    <div class="item">
					      <img src="<%=request.getContextPath()%>/RESOURCES/img/1.jpg" alt="...">
					      <div class="carousel-caption">
					        ...
					      </div>
					    </div>
					    <div class="item">
					      <img src="<%=request.getContextPath()%>/RESOURCES/img/2.jpg" alt="...">
					      <div class="carousel-caption">
					        ...
					      </div>
					    </div>
					  </div>

					  <!-- Controls -->
					  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
					    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					  </a>
					  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					    <span class="sr-only">Next</span>
					  </a>
					</div>

				</div>
			</div>
			<div class="row">
				<div style="padding: 15px;">
					<div class="col-xs-12 col-md-12">
						
						<!-- Product Section -->
						<!-- Product Section -->
						<!-- Product Section -->
						<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingOne">
									<h4 class="panel-title">
										<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true"
											aria-controls="collapseOne" style="text-decoration: none;">
											<span class="glyphicon glyphicon-glass" aria-hidden="true"></span>&nbsp;&nbsp;饮料
										</a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
									<div class="panel-body">
										<div class="row">
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail" style="outline: none;"
													data-toggle="modal" data-target="#productDetailModal" >
													<img src="<%=request.getContextPath()%>/RESOURCES/img/1_Drink/tea.png" alt="..." />
												</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail" style="outline: none;"
													data-toggle="modal" data-target="#productDetailModal" >
													<img src="<%=request.getContextPath()%>/RESOURCES/img/1_Drink/soda.png" alt="..." />
												</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail" style="outline: none;"
													data-toggle="modal" data-target="#productDetailModal" >
													<img src="<%=request.getContextPath()%>/RESOURCES/img/1_Drink/wine.png" alt="..." />
												</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingTwo">
									<h4 class="panel-title">
										<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
											aria-expanded="false" aria-controls="collapseTwo" style="text-decoration: none;">
											<span class="glyphicon glyphicon-flash" aria-hidden="true"></span>&nbsp;&nbsp;电器
										</a>
									</h4>
								</div>
								<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
									<div class="panel-body">
										<div class="row">
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/2_Electric/Phone.png" alt="..." />
												</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/2_Electric/Thermos.png" alt="..." />
												</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/2_Electric/Printer.png" alt="..." />
												</a>
											</div>
										</div>
										
										<div class="row">
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/2_Electric/HardDisk.png" alt="..." />
												</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/2_Electric/NotebookComputer.png" alt="..." />
												</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/2_Electric/VacuumCleaner.png" alt="..." />
												</a>
											</div>
										</div>

										<div class="row">
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/2_Electric/PadController.png" alt="..." />
												</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/2_Electric/Microwave.png" alt="..." />
												</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/2_Electric/Fan.png" alt="..." />
												</a>
											</div>
										</div>

									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingThree">
									<h4 class="panel-title">
										<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree"
											aria-expanded="false" aria-controls="collapseThree" style="text-decoration: none;">
											<span class="glyphicon glyphicon-time" aria-hidden="true"></span>&nbsp;&nbsp;运动
										</a>
									</h4>
								</div>
								<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
									<div class="panel-body">
										<div class="row">
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/3_Sports/Basketball.png" alt="..." />
												</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/3_Sports/Boxing.png" alt="..." />
												</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/3_Sports/Athletics.png" alt="..." />
												</a>
											</div>
										</div>
										
										<div class="row">
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/3_Sports/PingPong.png" alt="..." />
												</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/3_Sports/Helmet.png" alt="..." />
												</a>
											</div>
											<div class="col-xs-4 col-sm-4 col-md-4">
												<a href="#" class="thumbnail">
													<img src="<%=request.getContextPath()%>/RESOURCES/img/3_Sports/Swimming.png" alt="..." />
												</a>
											</div>
										</div>
										
									</div>
								</div>
							</div>
						</div>
						<!-- Product Section -->
						<!-- Product Section -->
						<!-- Product Section -->



						<!-- Product Detail Window -->
						<!-- Product Detail Window -->
						<!-- Product Detail Window -->
						<div id="productDetailModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
							<div class="modal-dialog modal-sm">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" id="btnCloseProductDetail" class="close" data-dismiss="modal" aria-label="Close" style="outline: none;">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="imgModalLabel">商品信息</h4>
									</div>
									<div class="modal-body" style="text-align: center;">
										<div class="container-fluid">
											<div class="row">
												<div class="col-xs-12 col-sm-12 col-md-12">
													<img id="imgProductBig" src="" alt="..." class="img-circle" style="display: none;">
													<img id="imgProductDetailLoading" alt="..." 
												src="<%=request.getContextPath()%>/RESOURCES/img/Environment/Loading.gif" style="display: inline">
												</div>
											</div>
											<div class="row">
												<div class="col-xs-12 col-sm-12 col-md-12">
													<p id="pProductDescription" style="display: none;"></p>
												</div>
											</div>
											<div id="divProductPriceAndVolume" class="row" style="margin-top: 10px; display: inline;">
												<div class="col-xs-6 col-sm-6 col-md-6">
													<!-- product price -->
													<!-- product price -->
													<p id="pProductPrice"></p>
													<!-- product price -->
													<!-- product price -->
												</div>
            									<div class="col-xs-6 col-sm-6 col-md-6">
            										<!-- product volume -->
            										<!-- product volume -->
            										<p id="pProductVolume"></p>
            										<!-- product volume -->
            										<!-- product volume -->
            									</div>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
									    	<a href="#" class="btn btn-default" role="button" 
									    		style="border-width: 0; border-radius: 0;">
									    		<span class="glyphicon glyphicon-share" aria-hidden="true"></span>&nbsp;&nbsp;去结账
									    	</a>
									    	<a href="#" class="btn btn-default" role="button" 
									    		style="border-top-width: 0; border-right-width: 0; border-bottom-width: 0; border-radius: 0;">
									    		<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>&nbsp;&nbsp;放入购物车
									    	</a>
									    </div>
									</div>
								</div>
							</div>
						</div>
						<!-- Product Detail Window -->
						<!-- Product Detail Window -->
						<!-- Product Detail Window -->








					</div>
				</div>
			</div>
			<div class="row">
				<div style="padding-left: 15px; padding-right: 15px;">
					<div class="btn-group btn-group-justified" role="group" aria-label="Justified button group">
				    	<a href="#" class="btn btn-default" role="button" style="border-top-right-radius: 0; border-bottom-right-radius: 0;">
				    		<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>
				    	</a>
				    	<a href="#" class="btn btn-default" role="button" style="border-radius: 0">
				    		<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
				    	</a>
				    	<a href="#" class="btn btn-default" role="button" style="border-top-left-radius: 0; border-bottom-left-radius: 0;">
				    		<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
				    	</a>
				    </div>
			    </div>
			</div>
		</div>

		<!---------------->
		<!-- Javascript -->
		<script type="text/javascript" src="<%=request.getContextPath()%>/RESOURCES/js/jquery_1.9.1.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/RESOURCES/js/bootstrap.min.js"></script>

		<script type="text/javascript">
			//Load page - 'ready' method is invoked earlier than 'load'
			$(document).ready(function() {
				if(window.sessionStorage.getItem("name")) {
					//Change photo
					$("#imgPhoto").attr("src", "<%=request.getContextPath()%>/RESOURCES/img/0_Head/"+ window.sessionStorage.getItem("name") +".jpeg");
					$("#imgPhotoBig").attr("src", "<%=request.getContextPath()%>/RESOURCES/img/0_Head/"+ window.sessionStorage.getItem("name") +".jpeg");
					//Change Login button
					$("#aOpenLoginModal").css("display", "none");
					$("#aOpenImgModal").css("display", "inline");
				} else {
					//Do nothing
				}
			});

			//Log in
			function logIn() {
				//1. Get fields value
				var name = $("#inputEmail").val();
				var password = $("#inputPassword").val();
				//2. Send out request
				var jsonObj = {};
				jsonObj["name"] = name;
				jsonObj["password"] = password;
				var url = "<%=request.getContextPath()%>/ServletLogin";
				$.ajax({
					type : "POST",
					url : url,
					data : jsonObj,
					dataType : "JSON",
					beforeSend : function() {
						//3. Disable buttons
						$("#btnLogin").text("登录中");
						$("#btnLogin").attr("disabled", "disabled");
					},
					success : function(data) {
						//console
						console.log(data);
						//judge existence
						if(data[0]["name"] == "none") {
							//do nothing
						} else {
							//Close Login window
							$("#btnCloseLogin").trigger("click");
							//Change photo
							$("#imgPhoto").attr("src", "<%=request.getContextPath()%>/RESOURCES/img/0_Head/"+ data[0]["name"] +".jpeg");
							$("#imgPhotoBig").attr("src", "<%=request.getContextPath()%>/RESOURCES/img/0_Head/"+ data[0]["name"] +".jpeg");
							//Change Login button
							$("#aOpenLoginModal").css("display", "none");
							$("#aOpenImgModal").css("display", "inline");
							//Store name in local
							window.sessionStorage.setItem("name", data[0]["name"]);
						};
						//Clear input value
						$("#inputEmail").val("");
						$("#inputPassword").val("");
						//Enable buttons
						$("#btnLogin").text("登录");
						$("#btnLogin").removeAttr("disabled");
						//
						
					},
					error : function(e) {
						alert(JSON.stringify(e));
						console.log(e);
					}
				})
			};

			//Log out
			function logOut() {
				//1. Send out request
				var jsonObj = {};
				jsonObj["name"] = window.sessionStorage.getItem("name");
				var url = "<%=request.getContextPath()%>/ServletLogout";

				$.ajax({
					type : "POST",
					url : url,
					data : jsonObj,
					dataType : "JSON",
					beforeSend : function() {
						
					},
					success : function(data) {
						//console
						console.log(data);
						//judge existence
						if(data[0]["name"] == "none") {
							//do nothing
						} else {
							//delete user data in local
							window.sessionStorage.removeItem("name");
							//Close Photo window
							$("#btnCloseImg").trigger("click");
							//Change Login button
							$("#aOpenLoginModal").css("display", "inline");
							$("#aOpenImgModal").css("display", "none");
						};
					},
					error : function(e) {
						alert(JSON.stringify(e));
						console.log(e);
					}
				})
			}

			//Display product details
			$("#productDetailModal").on("show.bs.modal", function(event) {
				//1. Get the trigger button
				var btnProduct = $(event.relatedTarget);
				//2. Get the source of image
				var imgSrc = btnProduct.children().attr("src");
				//3. Change the image of product detail window
				$("#imgProductBig").attr("src", imgSrc);
				//4. Get product name
				var imgProductName = imgSrc.split("/").pop().toString();
				var productName = imgProductName.substring(0, imgProductName.indexOf("."));
				//5. Send out request
				var jsonObj = {};
				jsonObj["name"] = productName;
				var url = "<%=request.getContextPath()%>/ServletDisplayProductDetail";
				$.ajax({
					type : "POST",
					url : url,
					data : jsonObj,
					dataType : "JSON",
					beforeSend : function() {
						//Set image visibility
						$("#imgProductDetailLoading").css("display", "inline");
						$("#imgProductBig").css("display", "none");
						$("#pProductDescription").css("display", "none");
						$("#divProductPriceAndVolume").css("display", "none");
					},
					success : function(data) {
						//console
						console.log(data);
						//1. Set product detail price & volume
						$("#pProductPrice").text("单价：" + data[0]["price"] + data[0]["unit"]);
						$("#pProductVolume").text("库存：" + data[0]["volume"]);
						//2. Set image visibility
						$("#imgProductDetailLoading").css("display", "none");
						$("#imgProductBig").css("display", "inline");
						//3. Set product description
						$("#pProductDescription").text(data[0]["description"]);
						$("#pProductDescription").css("display", "inline");
						//4. Set price & volume visibility
						$("#divProductPriceAndVolume").css("display", "inherit");
					},
					error : function(e) {
						alert(JSON.stringify(e));
						console.log(e);
					}
				})
			});
		</script>
	</body>
</html>
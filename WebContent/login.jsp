<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>Book Store</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="css/custom.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div style="margin-top: 50px;"></div>
				<form class="mt-3 review-form-box" id="formLogin"
					action="logincontroller" method="post">
					<h1 style="font-weight: bolder; font-size: 35px;">Login</h1>
					<div class="form-row">
						<div class="form-group col-md-8">
							<label for="InputEmail" class="mb-0">Username</label> <input
								type="text" class="form-control" id="InputEmail"
								placeholder="Enter Username" name="username" required="required">
						</div>
						<div class="form-group col-md-8">
							<label for="InputPassword" class="mb-0">Password</label> <input
								type="password" class="form-control" id="InputPassword"
								placeholder="Enter Password" name="password" required="required">
						</div>
						<div class="col-md-5 mb-3">
							<label for="country">Select User</label> <select
								class="wide w-100" id="country" name="user">
								<option value="customer" data-display="Select">Customer</option>
								<option value="admin">Admin</option>
							</select>
						</div>
					</div>				
					<%
						if (request.getAttribute("rs")!=null) {
					%>
					<h3 style="color: red;">Please check your account!</h3>
					<%
						}
					%>
					<br>
					<div class="form-row">
						<div class="form-group col-md-8">
							<button type="submit" class="btn hvr-hover">Login</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div style="margin-bottom: 100px;"></div>
	<%@include file="footer.jsp"%>
	<!-- End Slider -->
	<!-- ALL JS FILES -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!-- ALL PLUGINS -->
	<script src="js/jquery.superslides.min.js"></script>
	<script src="js/bootstrap-select.js"></script>
	<script src="js/inewsticker.js"></script>
	<script src="js/bootsnav.js."></script>
	<script src="js/images-loded.min.js"></script>
	<script src="js/isotope.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/baguetteBox.min.js"></script>
	<script src="js/form-validator.min.js"></script>
	<script src="js/contact-form-script.js"></script>
	<script src="js/custom.js"></script>
</body>
</html>
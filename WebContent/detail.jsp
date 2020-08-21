<%@page import="bean.sachbean"%>
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

	<!-- Start Shop Detail  -->
	<div class="shop-detail-box-main">
		<div class="container">
			<%
				sachbean s = (sachbean) request.getAttribute("chitietsach");
			%>
			<div class="row">
				<div class="col-xl-5 col-lg-5 col-md-6">
					<div id="carousel-example-1"
						class="single-product-slider carousel slide" data-ride="carousel">
						<div class="carousel-inner" role="listbox">
							<div class="carousel-item active">
								<img style="border: 1px solid gray;" height="420"
									class="d-block w-100" src="<%=s.getAnh()%>" alt="Image">
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
						<h2><%=s.getTensach()%></h2>
						<h5><%=s.getGia()%>
							VNĐ
						</h5>
						<p class="available-stock">
							Author:
							<%=s.getTacgia()%>
						<p>
						<form action="cartcontroller?ms=<%=s.getMasach()%>" method="post">
							<ul>
								<li>
									<div class="form-group quantity-box">
										<label class="control-label">Quantity</label> <input
											class="form-control" name="sl" value="1" min="1" max="20"
											type="number">
									</div>
								</li>
							</ul>
							<div class="price-box-bar">
								<div class="cart-and-bay-btn">
									<button type="submit" class="btn hvr-hover"
										data-fancybox-close="">
										<span style="color: white; font-weight: bold;">Add to
											cart</span>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- End Cart -->


	<%@include file="footer.jsp"%>
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
	<script src="js/jquery-ui.js"></script>
	<script src="js/jquery.nicescroll.min.js"></script>
	<script src="js/form-validator.min.js"></script>
	<script src="js/contact-form-script.js"></script>
	<script src="js/custom.js"></script>
</body>
</html>
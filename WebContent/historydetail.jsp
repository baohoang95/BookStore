<%@page import="bean.sachbean"%>
<%@page import="bean.chitietbean"%>
<%@page import="bean.hoadonbean"%>
<%@page import="java.util.ArrayList"%>
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
<link rel="stylesheet" href="css/1meou.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div style="margin-top: 70px; margin-bottom: 250px;" class="container">
		<div class="row">
			<div class="col-md-12">
				<h1
					style="color: red; font-weight: bold; font-size: 35px; margin-left: 400px;">Chi
					tiết hóa đơn</h1>
				<br>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Mã chi tiết hóa đơn</th>
							<th>Mã sách</th>
							<th>Số lượng mua</th>
						</tr>
					</thead>
					<tbody>
						<% 
							ArrayList<chitietbean> ds = (ArrayList<chitietbean>) request.getAttribute("dschitiethoadon");
							for (chitietbean ctbean : ds) {
						%>
						<tr>
							<td><%=ctbean.getMaChiTietHD()%></td>
							<td><%=ctbean.getMaSach()%></td>
							<td><%=ctbean.getSoLuongMua()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
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
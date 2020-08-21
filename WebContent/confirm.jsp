<%@page import="bean.hoadonbean"%>
<%@page import="bean.sachbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.loaibean"%>
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
<head>
<body>
	<%@include file="adheader.jsp"%>
	<%
		int n = (int) request.getAttribute("n");
		if (n > 0) {
	%>
	<div style="margin-top: 40px;" class="container">
		<div class="row">
			<div class="col-md-12"></div>
			<h1
				style="color: red; font-weight: bold; font-size: 35px; margin-left: 400px;">Xác
				nhận đặt mua</h1>
			<br> <br> <br>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Mã hóa đơn</th>
						<th>Mã khách hàng</th>
					
						<th>Ngày mua</th>
						<th>Xác nhận</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<hoadonbean> ds = (ArrayList<hoadonbean>) request.getAttribute("dsconfirm");
							for (hoadonbean hdbean : ds) {
					%>
					<tr>
						<th><%=hdbean.getMaHoaDon()%></th>
						<th><%=hdbean.getMakh()%></th>
						
						<th><%=hdbean.getNgayMua()%></th>
						<th><a id="a"
							href="confirmcontroller?mahoadon=<%=hdbean.getMaHoaDon()%>">Xác
								nhận</a></th>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<div style="margin-bottom: 100px;"></div>
	<%
		} else {
	%>
	<div style="margin-top: 20px;margin-bottom: 50px;" class="container">
		<div class="row">
			<div class="col-md-12">
				<h1
					style="color: red; font-weight: bold; font-size: 30px; margin-left: 280px;">Hiện
					không có đơn hàng nào cần xác nhận!</h1>
				<img style="margin-left: 130px;" alt="Image"
					src="images/minions.png">
			</div>
		</div>
	</div>
	<%
		}
	%>
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
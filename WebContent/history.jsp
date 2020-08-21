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
	<%
		int n = (int) request.getAttribute("n");
		if (n > 0) {
	%>
	<div style="margin-top: 70px; margin-bottom: 200px;" class="container">
		<div class="row">
			<div class="col-md-12">
				<h1
					style="color: red; font-weight: bold; font-size: 35px; margin-left: 400px;">Lịch
					sử mua hàng</h1>
				<br>
				<table class="table table-hover" style="text-align: center;">
					<thead>
						<tr>
							<th>Mã hóa đơn</th>
							<th>Ngày mua</th>
							<th>Trạng thái</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<hoadonbean> ds = (ArrayList<hoadonbean>) request.getAttribute("dshoadon");
								for (hoadonbean hdbean : ds) {
						%>
						<tr>
							<td><%=hdbean.getMaHoaDon()%></td>
							<td><%=hdbean.getNgayMua()%></td>
							<td><%=hdbean.isDamua() == true ? "Đã xác nhận" : "Chưa xác nhận"%></td>
							<td><a id="a"
								href="historydetailcontroller?mahoadon=<%=hdbean.getMaHoaDon()%>">Chi
									tiết</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%
		} else {
	%>
	<div style="margin-top: 60px; margin-bottom: 100px;" class="container">
		<div class="row">
			<div class="col-md-12">
				<h1
					style="color: red; font-weight: bold; font-size: 35px; margin-left: 350px;">Không
					có lịch sử đặt mua!</h1>
				<img style="margin-left: 200px;" alt="Image"
					src="images/tengteng.png">
				<form action="shopcontroller">
					<button class="btn hvr-hover" type="submit"
						style="color: white; font-weight: bold; margin-left: 460px;">Continue
						Shopping</button>
				</form>
			</div>
		</div>
	</div>
	<%
		}
	%>
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
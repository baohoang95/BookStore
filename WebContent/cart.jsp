<%@page import="bean.giohangbean"%>
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
</head>
<body>
	<%@include file="header.jsp"%>

	<!-- Start Cart  -->
	<div class="cart-box-main">
		<%
			long tsl = (long) session.getAttribute("tsl");
			if (tsl != 0) {
		%>
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="table-main table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Images</th>
									<th>Name</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Update</th>
									<th>Total</th>
									<th>Remove</th>
								</tr>
							</thead>
							<tbody>
								<%
									ArrayList<giohangbean> ds = (ArrayList<giohangbean>) session.getAttribute("dsgh");
										for (giohangbean g : ds) {
								%>
								<tr>
									<td class="thumbnail-img"><a
										href="detailcontroller?ms=<%=g.getMasach()%>"> <img
											class="img-fluid" src="<%=g.getAnh()%>" alt="Image" />
									</a></td>
									<td class="name-pr"><a
										href="detailcontroller?ms=<%=g.getMasach()%>"> <%=g.getTensach()%>
									</a></td>
									<td class="price-pr">
										<p><%=g.getGia()%></p>
									</td>
									<form action="cartcontroller?cn=<%=g.getMasach()%>"
										method="post">
										<td class="quantity-box"><input type="number" size="4"
											value="<%=g.getSoluong()%>" min="1" max="50" step="1"
											class="c-input-text qty text" name="sl"></td>
										<td class="remove-pr"><button type="submit"
												class="btn btn-success">
												<i class="fas fa-check"></i>
											</button></td>
									</form>
									<td class="total-pr">
										<p><%=g.getSoluong() * g.getGia()%></p>
									</td>
									<td class="remove-pr"><a
										href="cartcontroller?x=<%=g.getMasach()%>"
										class="btn btn-danger"> <i class="fas fa-times"></i>
									</a></td>
								</tr>
								<%
									}
										long tt = (long) request.getAttribute("tt");
								%>
								<tr>
									<td colspan="3" style="text-align: right; padding-right: 80px;"><%=tsl%></td>
									<td colspan="3" style="text-align: right; padding-right: 70px;"><%=tt%></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row my-5">
				<div class="col-lg-7 col-sm-7">
					<div class="update-box">
						<form action="ordercontroller" method="post">
							<input value="Order" type="submit">
						</form>
					</div>
					<div class="update-box">
						<form action="cartcontroller?xoagiohang=1" method="post">
							<input value="Delete Cart" type="submit">
						</form>
					</div>
				</div>
			</div>
			<%
				} else {
			%>
			<img style="margin-left: 300px;" alt="Không thể hiển thị hình ảnh"
				src="images/tengteng.png">
			<h2
				style="text-align: center; color: #1700d6d1; font-family: 'Baloo Tamma', cursive; font-size: 20px;">Không
				có sản phẩm nào trong giỏ hàng của bạn</h2>
			<br>
			<form action="shopcontroller">
				<button class="btn hvr-hover" type="submit"
					style="color: white; font-weight: bold; margin-left: 600px;">Continue
					Shopping</button>
			</form>
			<%
				}
			%>
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
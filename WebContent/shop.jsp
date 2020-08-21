<%@page import="bean.loaibean"%>
<%@page import="bean.sachbean"%>
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
	<!-- Start Shop Page  -->
	<div class="shop-box-inner">
		<div class="container">
			<div class="row">
				<div
					class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
					<div class="right-product-box">
						<div class="product-categorie-box">
							<div class="tab-content">
								<%
									String tl = request.getParameter("tl");// the loai
									if (tl != null && !tl.isEmpty()) {
								%>
								<h1
									style="font-weight: bold; color: red; font-size: 30px; text-align: center;"><%=tl.toUpperCase()%></h1>
								<%
									} else {
								%>
								<h1
									style="font-weight: bold; color: red; font-size: 30px; text-align: center;">TẤT
									CẢ SÁCH</h1>
								<%
									}
								%>
								<br />
								<div role="tabpanel" class="tab-pane fade show active"
									id="grid-view">
									<div class="row">
										<%
											ArrayList<sachbean> dssach = (ArrayList<sachbean>) request.getAttribute("dssach");
											for (sachbean sach : dssach) {
										%>
										<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover"
													style="width: 230px; height: 230px; border: 1px solid gray;">
													<div class="type-lb">
														<p class="sale">New</p>
													</div>
													<img width="230" src="<%=sach.getAnh()%>" class="img-fluid"
														alt="Image">
													<div class="mask-icon">
														<ul>
															<li><a
																href="detailcontroller?ms=<%=sach.getMasach()%>"
																data-toggle="tooltip" data-placement="right"
																title="View"><i class="fas fa-eye"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Compare"><i
																	class="fas fa-sync-alt"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Add to Wishlist"><i
																	class="far fa-heart"></i></a></li>
														</ul>
														<a class="cart"
															href="cartcontroller?ms=<%=sach.getMasach()%>">Add to
															Cart</a>
													</div>
												</div>
												<div class="why-text"
													style="width: 230px; border: 1px solid gray;">
													<h4><%=sach.getTensach()%></h4>
													<h5><%=sach.getGia()%>
														VNĐ
													</h5>
												</div>
											</div>
										</div>
										<%
											}
										%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- hien thi the loai -->
				<div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left">
					<div class="product-categori">
						<div class="search-product">
							<form action="shopcontroller" method="get">
								<input class="form-control" placeholder="Search here..."
									name="search" type="text">
								<button type="submit">
									<i class="fa fa-search"></i>
								</button>
							</form>
						</div>
						<div class="filter-sidebar-left">
							<div class="title-left">
								<h3 style="font-size: 25px;">Categories</h3>
							</div>
							<div
								class="list-group list-group-collapse list-group-sm list-group-tree"
								id="list-group-men" data-children=".sub-men">
								<%
									ArrayList<loaibean> dsloai = (ArrayList<loaibean>) request.getAttribute("dsloai");
									for (loaibean loai : dsloai) {
								%>
								<a
									href="shopcontroller?ml=<%=loai.getMaloai()%>&tl=<%=loai.getTenloai()%>"
									class="list-group-item list-group-item-action"
									style="font-size: 20px;"><%=loai.getTenloai()%></a>
								<%
									}
								%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Shop Page -->
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
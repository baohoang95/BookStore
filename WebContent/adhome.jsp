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
	<div style="margin-top: 20px;" class="container">
		<div class="row">
			<div class="col-md-8">
				<%
					if (request.getAttribute("ktnhap") != null)
						out.print("<script>alert('Vui lòng nhập mã loại khác!');</script>");
					if (request.getAttribute("ktxoa") != null)
						out.print("<script>alert('Loại có sách không xóa được!');</script>");
					loaibean ll = (loaibean) request.getAttribute("chon");// show du dlieu khi click chon
				%>
				<form action="adhomecontroller" method="post">
					<label style="font-weight: bold; color: pink; font-size: 20px;">Cate
						Id</label><br> <input class="form-control" type="text"
						name="txtmaloai" value="<%=(ll != null ? ll.getMaloai() : "")%>">
					<label style="font-weight: bold; color: pink; font-size: 20px;">Cate
						Name</label><br> <input class="form-control" type="text"
						name="txttenloai" value="<%=(ll != null ? ll.getTenloai() : "")%>"><br>
					<input style="padding: 6px 23px;" class="btn btn-success"
						type="submit" name="butthem" value="Add"> <input
						style="padding: 6px 23px; margin-left: 15px;"
						class="btn btn-warning" type="submit" name="butsua" value="Edit">
				</form>
			</div>
		</div>
	</div>
	<div style="margin-top: 20px;" class="container">
		<div class="row">
			<div class="col-md-10">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Cate Id</th>
							<th>Cate Name</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<loaibean> ds = (ArrayList<loaibean>) request.getAttribute("dsloai");
							for (loaibean l : ds) {
						%>
						<tr>
							<td><%=l.getMaloai()%></td>
							<td><%=l.getTenloai()%></td>
							<td><a id="a" href="adhomecontroller?mlchon=<%=l.getMaloai()%>">Select</a>
							</td>
							<td><a id="b" href="adhomecontroller?mlxoa=<%=l.getMaloai()%>">Delete</a>
							</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div style="margin-bottom: 80px;"></div>
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
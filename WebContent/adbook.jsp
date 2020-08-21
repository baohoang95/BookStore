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
	<div style="margin-top: 20px; margin-bottom: 20px;" class="container">
		<div class="row">
			<div class="col-md-8">
				<%
					if (request.getAttribute("ktnhap") != null)
						out.print("<script>alert('Vui lòng nhập mã sách khác!');</script>");
					sachbean sbean = (sachbean) request.getAttribute("chon");
				%>
				<form action="adbookcontroller" method="post" enctype= "multipart/form-data">
					<div class="form-group">
						<label style="font-weight: bold; color: pink; font-size: 20px;">Book
							Id</label><br> <input class="form-control" type="text"
							name="txtmasach"
							value="<%=(sbean != null ? sbean.getMasach() : "")%>" required>
					</div>
					<div class="form-group">
						<label style="font-weight: bold; color: pink; font-size: 20px;">Book
							Name</label><br> <input class="form-control" type="text"
							name="txttensach"
							value="<%=(sbean != null ? sbean.getTensach() : "")%>" required>
					</div>
					<div class="form-group">
						<label style="font-weight: bold; color: pink; font-size: 20px;">Author</label><br>
						<input class="form-control" type="text" name="txttacgia"
							value="<%=(sbean != null ? sbean.getTacgia() : "")%>">
					</div>
					<div class="form-group">
						<label style="font-weight: bold; color: pink; font-size: 20px;">Price</label><br>
						<input class="form-control" type="number" min="0" name="txtgia"
							value="<%=(sbean != null ? sbean.getGia() : "")%>" required>
					</div>
					<div class="form-group">
						<label style="font-weight: bold; color: pink; font-size: 20px;">Image</label><br>
						<input class="form-control" type="file" name="txtfile">
					</div>
					<div class="form-group">
						<label style="font-weight: bold; color: pink; font-size: 20px;">Date</label><br>
						<input class="form-control" type="date" name="txtngaynhap"
							value="<%=(sbean != null ? sbean.getNgaynhap() : "")%>" required>
					</div>
					<div class="form-group">
						<label style="font-wesight: bold; color: pink; font-size: 20px;">Cate
							Name</label><br> <select name="txtmaloai" class="form-control"
							required>
							<%
								ArrayList<loaibean> ds = (ArrayList<loaibean>) request.getAttribute("dsloai");
								String selected = "";
								String maloai = "";
								if (sbean != null)
									maloai = sbean.getMaloai();
								for (loaibean l : ds) {
									if (l.getMaloai().equals(maloai))
										selected = "selected";
									else
										selected = "";
							%>
							<option <%=selected%> value="<%=l.getMaloai()%>"><%=l.getTenloai()%></option>
							<%
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<input style="padding: 6px 23px;" class="btn btn-success"
							type="submit" name="butthem" value="Add"> 
						<input
							style="padding: 6px 23px; margin-left: 15px;"
							class="btn btn-warning" type="submit" name="butsua" value="Edit">
					</div>
				</form>
			</div>
		</div>
	</div>
	<div style="margin-top: 20px;" class="container">
		<div class="row">
			<div class="col-md-12"></div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Book Id</th>
						<th>Book Name</th>
						<th>Author</th>
						<th>Price</th>
						<th>Image</th>
						<th>Date</th>
						<th>Cate Id</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<sachbean> ls = (ArrayList<sachbean>) request.getAttribute("dssach");
						for (sachbean s : ls) {
					%>
					<tr>
						<td style="width: 70px;"><%=s.getMasach()%></td>
						<td style="width: 170px;"><%=s.getTensach()%></td>
						<td style="width: 170px;"><%=s.getTacgia()%></td>
						<td><%=s.getGia()%></td>
						<td><img width="70" height="70" src="<%=s.getAnh()%>"></td>
						<td><%=s.getNgaynhap()%></td>
						<td><%=s.getMaloai()%></td>
						<td><a id="a"
							href="adbookcontroller?mschon=<%=s.getMasach()%>">Select</a></td>
						<td><a id="b"
							href="adbookcontroller?msxoa=<%=s.getMasach()%>">Delete</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
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
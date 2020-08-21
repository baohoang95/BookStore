<!-- Start Main Top -->
<header class="main-header">
	<!-- Start Navigation -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
		<div class="container">
			<!-- Start Header Navigation -->
			<div class="navbar-header">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbar-menu" aria-controls="navbars-rs-food"
					aria-expanded="false" aria-label="Toggle navigation">
					<i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="homecontroller"><img
					src="images/logobook.jpg" class="logo" alt=""> <span
					style="font-weight: bold; color: pink; font-size: 25px;">
						BOOKSTORE</span></a>
			</div>
			<!-- End Header Navigation -->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-menu">
				<ul class="nav navbar-nav ml-auto" data-in="fadeInDown"
					data-out="fadeOutUp">
					<li class="nav-item"><a class="nav-link" href="homecontroller">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="shopcontroller">Shop</a></li>
					<%
						if (session.getAttribute("tendn") == null) {
					%>
					<li class="nav-item"><a class="nav-link"
						href="logincontroller">Login</a></li>
					<%
						} else {
							String tendn = (String) session.getAttribute("tendn");
					%>
					<li class="nav-item"><a class="nav-link" href="historycontroller">History</a></li>
					<li class="nav-item"><a class="nav-link" style="color: pink;">Hi, <%=tendn%></a></li>
					<li class="nav-item"><a class="nav-link" href="logoutcontroller">Logout</a></li>
					<%
						}
					%>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
			<!-- Start Atribute Navigation -->
			<div class="attr-nav">
				<ul>
					<%
						if (session.getAttribute("tsl") == null) {
					%>
					<li class="side-menu"><a href="cartcontroller"> <i
							class="fa fa-shopping-bag"></i> <span class="badge">0</span>
							<p>My Cart</p></a></li>
					<%
						} else {
							long sl = (long) session.getAttribute("tsl");
					%>
					<li class="side-menu"><a href="cartcontroller"> <i
							class="fa fa-shopping-bag"></i><span class="badge"><%=sl%></span>
							<p>My Cart</p></a></li>
					<%
						}
					%>

				</ul>
			</div>
			<!-- End Atribute Navigation -->
		</div>
		<!-- End Side Menu -->
	</nav>
	<!-- End Navigation -->
</header>
<!-- End Main Top -->
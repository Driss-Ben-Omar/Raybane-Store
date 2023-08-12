
<%@ taglib prefix="s" uri="/struts-tags"%>


<s:set var="client" value="#session.client" />
<s:set var="nom" value="#client.fullName" />
<s:set var="id" value="#client.id" />


<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>My Info</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon"
	href="frontend/assets/img/raybanlogo-removebg-preview (1).png">
<!-- CSS here -->
<link rel="stylesheet" href="frontend/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="frontend/assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="frontend/assets/css/flaticon.css">
<link rel="stylesheet" href="frontend/assets/css/slicknav.css">
<link rel="stylesheet" href="frontend/assets/css/animate.min.css">
<link rel="stylesheet" href="frontend/assets/css/magnific-popup.css">
<link rel="stylesheet"
	href="frontend/assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="frontend/assets/css/themify-icons.css">
<link rel="stylesheet" href="frontend/assets/css/slick.css">
<link rel="stylesheet" href="frontend/assets/css/nice-select.css">
<link rel="stylesheet" href="frontend/assets/css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Profil</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
.inf-content {
	border: 1px solid #DDDDDD;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	box-shadow: 7px 7px 7px rgba(0, 0, 0, 0.3);
	margin-top: 20px;
}

.col-md-6 {
	margin-top: 50px;
	margin-left: 50px;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	background-color: white;
	position: absolute;
	min-width: 160px;
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.error1 {
	list-style: none;
	color: red;
}
</style>
</head>
<body style="background-color: rgb(238, 238, 238);">
	<header>
		<!-- Header Start -->
		<div class="header-area">
			<div class="main-header header-sticky">
				<div class="container-fluid">
					<div class="menu-wrapper">
						<!-- Logo -->
						<div class="logo">
							<a href="index"><img
								src="frontend/assets/img/raybanlogo-removebg-preview (1).png"
								alt=""></a>
						</div>
						<!-- Main-menu -->
						<div class="main-menu d-none d-lg-block">
							<nav>
								<ul id="navigation">
									<li><a style="font-size: 24px" href="index">Home</a></li>
									<li><a style="font-size: 24px" href="shop">Shop</a></li>

									<li><a style="font-size: 24px" href="mescommande">Order</a></li>




								</ul>
							</nav>
						</div>
						<!-- Header Right -->
						<div class="header-right">
							<ul>
								<li>
									<div class="nav-search search-switch">
										<span class="flaticon-search"></span>
									</div>
								</li>

								<li><a href="cart"><span class="flaticon-shopping-cart"></span></a>
								</li>
								<li><a href="mescommande"><span><img
											src="frontend\assets\img\clipboard.png"></span></a></li>
								<li class="dropdown"><a href="profil"><span> <s:property
												value="#nom" /> <img
											src="assets/img/<s:property value="#id" />.png" alt=""
											style="width: 30px; height: 30px; border-radius: 50%;" />
									</span></a>
									<div class="dropdown-content">
										<a href="pagesetting">Settings</a><a href="profil">profil</a>
										<a href="logout">Logout</a>
									</div></li>
							</ul>
						</div>
					</div>
					<!-- Mobile Menu -->
					<div class="col-12">
						<div class="mobile_menu d-block d-lg-none"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- Header End -->
	</header>
	<div class="container bootstrap snippets bootdey">
		<div class="panel-body inf-content"
			style="background-color: white; padding: 63px">
			<div class="row">
				<div class="col-md-4">
					<img alt="" style="width: 500px;" title=""
						class="img-circle img-thumbnail isTooltip"
						src="assets/img/<s:property value="#id" />.png"
						data-original-title="Usuario">
					<ul title="Ratings" class="list-inline ratings text-center">
						<li><a><span class="glyphicon glyphicon-star"></span></a></li>
						<li><a><span class="glyphicon glyphicon-star"></span></a></li>
						<li><a><span class="glyphicon glyphicon-star"></span></a></li>
						<li><a><span class="glyphicon glyphicon-star"></span></a></li>
						<li><a><span class="glyphicon glyphicon-star"></span></a></li>
					</ul>
				</div>
				<div class="col-md-6">
					<div class="section-tittle mb-70 text-center">
						<h2 style="margin-left: 22px; MARGIN-BOTTOM: -60px; padding: 24px">INFORMATION</h2>
					</div>
					<br>
					<div class="table-responsive">
						<table class="table table-user-information">
							<tbody>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-asterisk " style="color: #dc3545;"></span>
											Identificacion
									</strong></td>
									<td style="color: #dc3545;"><s:property value="#id" /></td>
								</tr>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-user  " style="color: #dc3545;"></span>Full
											Name
									</strong></td>
									<td style="color: #dc3545;"><s:property value="#nom" /></td>
								</tr>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-eye-open " style="color: #dc3545;"></span>
											Role
									</strong></td>
									<td style="color: #dc3545;">Client</td>
								</tr>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-envelope " style="color: #dc3545;"></span>
											Email
									</strong></td>
									<td style="color: #dc3545;"><a><s:property
												value="#client.email" /></a></td>
								</tr>
								<tr>
									<td><strong> <span
											class="glyphicon glyphicon-calendar " style="color: #dc3545;"></span>
											Number Commands
									</strong></td>
									<td style="color: #dc3545;"><s:property
											value="commandes.size()" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer class="text-center text-white"
		style="background-color: #f1f1f1; margin-top: 310px">
		<!-- Grid container -->

		<!-- Grid container -->

		<!-- Copyright -->
		<div class="text-center text-dark p-3"
			style="background-color: rgba(0, 0, 0, 0.2);">
			<img alt=""
				src="frontend/assets/img/raybanlogo-removebg-preview (1).png"
				style="margin-right: 808px"> © 2023 Copyright: <a
				class="text-dark" href="https://mdbootstrap.com/">Ray-ban</a>
		</div>
		<!-- Copyright -->
	</footer>
	<script data-cfasync="false"
		src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>
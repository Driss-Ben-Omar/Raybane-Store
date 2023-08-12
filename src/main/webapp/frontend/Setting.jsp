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
<style>
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

<body style="background-color: #eeeeee">
	<!--? Preloader Start -->

	<!-- Preloader Start -->
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

	<div class="container">

		<form action="setting" method="post" enctype="multipart/form-data">
			<div class="row gutters" id="gutters">
				<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12"
					style="margin-left: 112px">
					<div class="card h-100" style="border: 0px">
						<div class="card-body"
							style="box-shadow: 7px 7px 7px rgba(0, 0, 0, 0.3);">
							<div class="row gutters">
								<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
									<h6 st class="mb-3 text-primary">Personal Details</h6>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="fullName">Full Name</label> <input type="text"
											name="name" class="form-control"
											placeholder="Enter full name">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="eMail">Email</label> <input type="email"
											name="email" class="form-control" placeholder="Enter email">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="phone">Phone</label> <input type="text"
											name="phone" class="form-control"
											placeholder="Enter phone number">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="birthday">birthday</label> <input type="text"
											name="birthday" class="form-control" placeholder="birthday">
									</div>
								</div>
							</div>
							<div class="row gutters">
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="address">Address</label> <input type="text"
											name="address" class="form-control"
											placeholder="Enter your address">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="old password">old password</label> <input
											type="password" name="old" class="form-control"
											placeholder="Enter old password">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="password">new password</label> <input
											type="password" name="password" class="form-control"
											placeholder="Enter password">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<label for="confirm password">confirm password</label> <input
											type="password" name="confirm" class="form-control"
											placeholder="repeat password">
									</div>
								</div>
								<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
									<div class="form-group">
										<s:if test="hasActionErrors()">
											<s:actionerror cssClass="error1" />
										</s:if>
									</div>
								</div>
							</div>
							<div class="row gutters">
								<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
									<div class="text-right">
										<button class="btn btn-secondary">
											<input type="file" name="upload" />
										</button>
										<button type="submit" name="submit" class="btn btn-primary"
											style="background-color: red; border: 0px;">Update</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>

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
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
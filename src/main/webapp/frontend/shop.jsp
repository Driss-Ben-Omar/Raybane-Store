<%@ taglib prefix="s" uri="/struts-tags"%>



<s:set var="client" value="#session.client" />
<s:set var="nom" value="#client.fullName" />
<s:set var="id" value="#client.id" />
<s:set var="count" value="0" />



<!doctype html>
<html class="no-js" lang="zxx">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Welcome <s:property value="#nom" /></title>
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
</style>
</head>

<body style="background-color: rgb(238, 238, 238);">
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
										<a href="pagesetting">Settings</a> <a href="profil">profil</a><a
											href="logout">Logout</a>
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
	<main>
		<div class="popular-items section-padding30">
			<div class="container">
				<!-- Section tittle -->
				<div class="row justify-content-center">
					<div class="col-xl-7 col-lg-8 col-md-10">
						<div class="section-tittle mb-70 text-center">
							<h2>Articles</h2>
						</div>
					</div>
				</div>
				<div class="row">

					<s:iterator value="articles" var="article">
						<s:if test="%{#count < 30}">
							<div class="col-xl-4 col-lg-4 col-md-6 col-sm-6">
								<form action="add" method="POST">
									<div class="single-popular-items mb-50 text-center">
										<div class="popular-img">
											<img src="image/<s:property value="#article.image" />" alt="">
											<div class="img-cap">

												<button
													style="padding: 20px 140px; border: 0px; background: #f81f1f;"
													name="id"
													value="<s:property value="#article.codeArticle" />">Add
													to cart</button>
											</div>

										</div>
										<div class="popular-caption">
											<h3>
												<a href="#"><s:property value="#article.nomArticle" /></a>
											</h3>
											<p>
												<s:property value="#article.descriptionArticle" />
											</p>
											<span><s:property value="#article.prixArticle" />DH</span>
											<s:set var="count" value="#count+1" />
										</div>
									</div>
								</form>
							</div>
						</s:if>
					</s:iterator>
				</div>
				<!-- Button -->
				<div class="row justify-content-center">
					<div class="room-btn pt-70">
						<a href="shop" class="btn view-btn1">View More Products</a>
					</div>
				</div>
			</div>
		</div>
		<!-- Popular Items End -->
		<!--? Video Area Start -->

		<!-- Video Area End -->
		<!--? Watch Choice  Start-->

		<!-- Watch Choice  End-->
		<!--? Shop Method Start-->

		<!-- Shop Method End-->
	</main>
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
	<!--? Search model Begin -->
	<div class="search-model-box">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-btn">+</div>
			<form class="search-model-form">
				<input type="text" id="search-input"
					placeholder="Searching key.....">
			</form>
		</div>
	</div>
	<!-- Search model end -->

	<!-- JS here -->

	<script src="./frontend/assets/js/vendor/modernizr-3.5.0.min.js"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script src="./frontend/assets/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="./frontend/assets/js/popper.min.js"></script>
	<script src="./frontend/assets/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script src="./frontend/assets/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="./frontend/assets/js/owl.carousel.min.js"></script>
	<script src="./frontend/assets/js/slick.min.js"></script>

	<!-- One Page, Animated-HeadLin -->
	<script src="./frontend/assets/js/wow.min.js"></script>
	<script src="./frontend/assets/js/animated.headline.js"></script>
	<script src="./frontend/assets/js/jquery.magnific-popup.js"></script>

	<!-- Scrollup, nice-select, sticky -->
	<script src="./frontend/assets/js/jquery.scrollUp.min.js"></script>
	<script src="./frontend/assets/js/jquery.nice-select.min.js"></script>
	<script src="./frontend/assets/js/jquery.sticky.js"></script>

	<!-- contact js -->
	<script src="./frontend/assets/js/contact.js"></script>
	<script src="./frontend/assets/js/jquery.form.js"></script>
	<script src="./frontend/assets/js/jquery.validate.min.js"></script>
	<script src="./frontend/assets/js/mail-script.js"></script>
	<script src="./frontend/assets/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="./frontend/assets/js/plugins.js"></script>
	<script src="./frontend/assets/js/main.js"></script>

</body>
</html>
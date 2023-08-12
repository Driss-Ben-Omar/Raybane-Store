<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entities.Panier"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<s:set var="client" value="#session.client" />
<s:set var="nom" value="#client.fullName" />
<s:set var="id" value="#client.id" />

<!doctype html>
<html lang="zxx">
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

.order {
	display: inline-block;
	padding: 17px 50px;
	border-radius: 5px;
	background-color: red;
	border: 2px solid red;
	font-size: 15px;
	margin-top: 100px;
	font-weight: 500;
	-webkit-transition: 0.5s;
	transition: 0.5s;
	text-transform: capitalize;
	color: #fff;
}
</style>
</head>
<body style="background-color: #eeeeee">
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
	<main>
		<!-- Hero Area Start-->
		<div>
			<div
				stylet="background-image: url(../img/hero/about_hero.png);
    min-height: 100px;
    background-repeat: no-repeat;
    background-position: center center;">
				<div class="container">
					<div class="row">
						<div class="col-xl-12">
							<div class="hero-cap text-center">
								<h2 style="font-size: xxx-large; font-family: cursive;">Cart
									List</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--================Cart Area =================-->
		<section class="cart_area section_padding" style="padding: 56px 0px;">
			<div class="container">
				<div class="cart_inner">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th scope="col" style="color: #8f8f8f;">Product</th>
									<th scope="col" style="color: #8f8f8f;">Price</th>
									<th scope="col" style="color: #8f8f8f;">Quantity</th>
									<th scope="col" style="color: #8f8f8f;">Total</th>
									<th scope="col" style="color: #8f8f8f;">Delete</th>

								</tr>
							</thead>
							<tbody>
								<s:iterator value="panier" var="paniers">
									<tr>
										<td>
											<div class="media">
												<div class="d-flex">
													<img src="image/<s:property value="#paniers.img" />" alt="" />
												</div>
												<div class="media-body">
													<p>
														<s:property value="#paniers.name" />
													</p>
												</div>
											</div>
										</td>
										<td>
											<h5 style="color: black;">
												<s:property value="#paniers.prixTotal" />
												DH
											</h5>
										</td>
										<td>

											<form action="update" method="post" style="display: inline;">
												<s:if test="#paniers.quantiteArticle < 2">

													<input type="hidden" name="quantite"
														value="<s:property value="1" />">
												</s:if>
												<s:else>
													<input type="hidden" name="quantite"
														value="<s:property value="#paniers.quantiteArticle-1" />">

												</s:else>
												<input type="hidden" name="id"
													value="<s:property value="#paniers.id" />">
												<button type="submit"
													style="border-radius: 5px; border: 1px solid #00000038; color: black;">-</button>
											</form> <s:property value="#paniers.quantiteArticle" />
											<form action="update" method="post" style="display: inline;">
												<input type="hidden" name="quantite"
													value="<s:property value="#paniers.quantiteArticle+1" />"
													min="1"> <input type="hidden" name="id"
													value="<s:property value="#paniers.id" />">
												<button
													style="border-radius: 5px; border: 1px solid #00000038; color: black;">+</button>
											</form>
										</td>
										<td>
											<h5 style="color: black;">
												<s:property
													value="%{#paniers.quantiteArticle * #paniers.prixTotal}" />
											</h5>
										</td>
										<form action="remove" method="post">
											<td><input type="hidden" name="id"
												value="<s:property value="#paniers.id" />">
												<button style="border-radius: 5px">X</button>
										</form>

										</td>
									</tr>
								</s:iterator>
								<tr>
									<td></td>
									<td></td>
								</tr>

							</tbody>
						</table>
						<div class="checkout_btn_inner float-right">
							<form action="commander" method="post">
								<input type="hidden" name="id">
								<button style="background: red" class="order">Order</button>
							</form>
						</div>
					</div>
				</div>
		</section>
		<!--================End Cart Area =================-->
	</main>
	>
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

	<!-- Scrollup, nice-select, sticky -->
	<script src="./frontend/assets/js/jquery.scrollUp.min.js"></script>
	<script src="./frontend/assets/js/jquery.nice-select.min.js"></script>
	<script src="./frontend/assets/js/jquery.sticky.js"></script>
	<script src="./frontend/assets/js/jquery.magnific-popup.js"></script>

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
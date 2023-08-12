<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<s:set var="client" value="#session.client" />
<s:set var="nom" value="#client.fullName" />
<s:set var="id" value="#client.id" />
<s:set var="count" value="0" />
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
<!-- CSS here -->

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
#delevered {
	width: 100px;
	height: 40px;
	background: #28a745;
	text-align: center;
	padding-top: 7px;
	border-radius: 10px;
	color: white;
}

#proccess {
	width: 100px;
	height: 40px;
	background: #ffc107;
	text-align: center;
	padding-top: 7px;
	border-radius: 10px;
	color: white;
}

#shipped {
	width: 100px;
	height: 40px;
	background: #17a2b8;
	text-align: center;
	padding-top: 7px;
	border-radius: 10px;
	color: white;
}

.open-row {
	display: table-row;
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

header {
	margin-top: 20px;
}
</style>
</head>
<body style="background-color: rgb(238, 238, 238)">
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
	</header>
	<main>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-xl-7 col-lg-8 col-md-10">
					<div class="section-tittle mb-70 text-center">
						<h2 style="margin-left: 316px;">My Orders</h2>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">Mes Commandes</div>
					<div class="panel-body">
						<table class="table table-condensed table-striped">
							<thead>
								<tr>
									<th></th>
									<th>Date Commande</th>
									<th>Date Livraison</th>
									<th>Prix Total</th>
									<th>Status</th>
									<th>Facture</th>
								</tr>
							</thead>
							

							<tbody>

								<s:iterator value="commandes" var="commande">
									<tr data-toggle="collapse"
										data-target="#demo<s:property value="#count" />"
										class="accordion-toggle <s:if test="%{#open==true}">open-row</s:if><s:else>
									</s:else>">
										<form action="commande" method="POST">
											<input type="hidden" name="count"
												value="<s:property value="#count" />" />
											<td><button style="background-color: #f9f9f9"
													name="open" value="<s:property value="open" />"
													class="btn btn-default btn-xs">
													<img alt="" src="image/expand-button.png">
												</button></td>
											<td><s:property
													value="#commande.dateCommande.toString().split(' ')[0]" /></td>
											<td><s:property value="#commande.dateLivraison" /></td>
											<td><s:property value="#commande.prixTotal" /></td>
											<td><p id="<s:property value="#commande.status" />">
													<s:property value="#commande.status" />
												</p></td>
											<td>
										</form>
										<div>
											<form action="invoice" method="post">
												<input type="hidden" name="id"
													value="<s:property value="#commande.codeCommande" />">
												<button class="btn btn-primary"
													style="border-radius: 8px; font-size: 13px;">Facture</button>
											</form>
										</div>
										</td>
									</tr>

									<tr class="hiddenRow <s:if test="!open">collapse</s:if>">
										<td colspan="6" class="hiddenRow">
											<div id="demo<s:property value="#count" />"
												class="accordian-body">
												<table class="table table-striped">
													<thead>
														<tr class="info">
															<th>Product</th>
														</tr>
													</thead>
													<tbody>

														<s:iterator value="cmdArticles" var="cmdArticle">
															<tr data-toggle="collapse" class="accordion-toggle"
																data-target="#demo10">
																<td><s:property
																		value="#cmdArticle.article.getNomArticle()" /></td>

															</tr>
														</s:iterator>
														<s:set var="count" value="%{#count+1}" />
													</tbody>
												</table>
											</div>

										</td>

									</tr>

								</s:iterator>
							</tbody>
	
						</table>
					</div>

				</div>

			</div>
		</div>
	</main>
	<footer class="text-center text-white"
		style="background-color: #f1f1f1; margin-top: 520px">
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

	<script type="text/javascript">
		
	</script>

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>


	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>

</body>
</html>
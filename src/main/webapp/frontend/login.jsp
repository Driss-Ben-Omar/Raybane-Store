<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Welcome</title>
<link href="frontend/style.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="shortcut icon" type="image/x-icon"
	href="frontend/assets/img/raybanlogo-removebg-preview (1).png">
<
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<style type="text/css">
.error1 {
	list-style: none;
	color: red;
}
</style>
</head>
<body class="bg-primary">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div>
							<div class="card"></div>
							<div class="card">
								<h1 class="title"
									style="color: #DE4747; border-left: 5px solid #DE4747;">Login</h1>
								<div>
									<form method="post" action="login">
										<div class="input-container">
											<input id="inputEmail" type="email" name="email" /> <label
												for="inputEmail">Email address</label>
											<div class="bar"></div>
										</div>
										<div class="input-container">
											<input id="inputPassword" type="password"
												placeholder="Password" name="password" /> <label
												for="inputPassword">Password</label>
											<div class="bar"></div>
										</div>
										<div class="form-floating mb-3">
											<s:if test="hasActionErrors()">
												<s:actionerror cssClass="error1" />
											</s:if>
										</div>
										<div class="form-check mb-3">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<input id="inputRememberPassword" type="checkbox" value="" />
											<label for="inputRememberPassword">Remember Password</label>
										</div>
										<div class="button-container">
											<br>
											<!--<a class="small" href="password.html">Forgot Password?</a>-->
											<button class="btn btn-primary"
												style="border: 2px solid #DE4747;">Login</button>
										</div>
									</form>
								</div>
								<div class="footer">
									<a href="password.html">Forgot your password?</a>
								</div>
								<div class="footer">
									<a href="pageregister">Need an account? Sign up!</a>
								</div>
							</div>
						</div>
						<div class="card alt">
							<div class="toggle" style="background: #DE4747;">
								<!--  <i class="fa-solid fa-right-to-bracket" style="color: #ffffff;"></i>-->
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Register Client</title>
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<link href="frontend/style1.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<style type="text/css">
.error1 {
	list-style: none;
	color: white;
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
							<div class="card " style="background: #DE4747;">
								<h1 class="title">Create Account</h1>
								<div>
									<form action="register" method="post"
										enctype="multipart/form-data">
										<table>
											<tr>
												<td>
													<div class="input-container">
														<input name="name" id="inputFirstName" type="text"
															placeholder="Enter your first name" /> <label
															for="inputFirstName"></label>
														<div class="bar"></div>
													</div>
												</td>
												<td>
													<div class="input-container">
														<input name="address" id="inputLastName" type="text"
															placeholder="Enter your Address" /> <label
															for="inputLastName"></label>
														<div class="bar"></div>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<div class="input-container">
														<input name="birthday" id="inputFirstName" type="text"
															placeholder="Enter yourBirthday" /> <label
															for="inputFirstName"></label>
														<div class="bar"></div>
													</div>
												</td>
												<td>
													<div class="input-container">
														<input name="phone" id="inputLastName" type="text"
															placeholder="Enter your Phone" /> <label
															for="inputLastName"></label>
														<div class="bar"></div>
													</div>
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<div class="input-container">

														<input name="email" id="inputEmail" type="email"
															placeholder="name@example.com" /> <label
															for="inputEmail"></label>
														<div class="bar"></div>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<div class="input-container">
														<input name="password" id="inputPassword" type="password"
															value="Create a password" /> <label for="inputPassword"></label>
														<div class="bar"></div>
													</div>
												</td>
												<td>
													<div class="input-container">
														<input name="confirm" id="inputPasswordConfirm"
															type="password" placeholder="Confirm password" /> <label
															for="inputPasswordConfirm"></label>
														<div class="bar"></div>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<div class="row mb-6">
														<s:if test="hasActionErrors()">
															<s:actionerror cssClass="error1" />
														</s:if>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<button class="btn btn-secondary">
														<input name="upload" type="file" />
													</button>
												</td>
											</tr>
										</table>
										<div class="button-container">
											<br>
											<button class="btn btn-primary">
												<span style="color: black;">Register</span>
											</button>
										</div>

									</form>
									<div class="footer">
										<a href="pagelogin">Have an account? Go to login</a>
									</div>

								</div>
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
	<script src="js/scripts.js"></script>
</body>
</html>

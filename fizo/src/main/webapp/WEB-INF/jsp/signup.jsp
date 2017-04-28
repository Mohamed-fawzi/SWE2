<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE-edge">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
		<title>Fizo</title>
		<link href="static/css/style.css" rel="stylesheet">
		<link href="static/css/bootstrap.min.css" rel="stylesheet">
		<!-- [if lt IE 9] -->
			<script src="static/js/html5shiv.min.js"></script>
			<script src="static/js/respond.min.js"></script>
		<!-- [endif] -->
		<style type="text/css">
				.bg-1 {
			  background: url('static/images/background.jpg') no-repeat center center fixed;
		    -webkit-background-size: cover;
		    -moz-background-size: cover;
		    background-size: cover;
		    -o-background-size: cover;
			}
			.panel-transparent {
        background: none;
   			 }
		</style>
	</head>
	<body  >
		<script src="static/js/jquery-1.11.1.min.js"></script>
		<script src="static/js/bootstrap.min.js"></script>
		
		
				<div role="navigation">
					<div class="navbar navbar-inverse">
						<a href="/" class="navbar-brand">Fizo</a>
						<div class="navbar-collapse collapse">
							<div class ="nav navbar-nav pull-right btn-info btn">
								<a href ="/sign-in" class="navbar-brand" >Sign in</a>
							</div>
							<ul class = "nav navbar-nav ">
							<li><a href="#">about</a></li>
							</ul>
						</div>
					</div>
				</div>
		<div class="container text-center">
			<form class="form-horizontal" action="/sign-up" method="POST" >
				<div class ="form-group">
					<label class="control-label col-md-3 ">Name:</label>
					<div class="col-md-5">
						<input type="text" class="form-control" name="Name"  placeholder="Name" required >
					</div>
				</div>
				<div class ="form-group">
					<label class="control-label col-md-3 ">E-mail:</label>
					<div class="col-md-5">
						<input type="email" class="form-control" name="Email" placeholder="Email"  required >
					</div>
				</div>
				<div class ="form-group">
					<label class="control-label col-md-3 ">UserName:</label>
					<div class="col-md-5">
						<input type="text" class="form-control" name="UserName" placeholder="UserName" required >
					</div>
					<c:choose><c:when test="${mode=='MODE_NOT_VALID' }"><label class="control-label col-md-3 text-danger ">UserName is already taken</label></c:when></c:choose>
				</div>
				<div class ="form-group">
					<label class="control-label col-md-3 ">Password:</label>
					<div class="col-md-5">
						<input id="password" class="form-control" name="Password" type="password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must have at least 6 characters' : ''); if(this.checkValidity()) form.password_two.pattern = this.value;" placeholder="Password" required>


					</div>
				</div>
				<div class ="form-group">
					<label class="control-label col-md-3 ">Password:</label>
					<div class="col-md-5">
						<input id="password_two"  class="form-control" name="password_two" type="password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Please enter the same Password as above' : '');" placeholder="Verify Password" required>
					</div>
				</div>
				<div class ="form-group">
					<label class="control-label col-md-3 ">AccountType:</label>
					<div class="col-md-7">
						<input type="radio" class="col-sm-1 " name="Type" value="Student" checked>
						<div class="col-sm-1">Student</div>
						<input type="radio" class="col-sm-1"  name="Type" value="Teacher" >
						<div class="col-sm-1">Teacher</div>
					</div>
				</div>
				<div class="form-group" >
					<input type="submit" class="btn btn-primary" value="sign up">
					
				</div>
			</form>
		</div>	
			</body>
</html>

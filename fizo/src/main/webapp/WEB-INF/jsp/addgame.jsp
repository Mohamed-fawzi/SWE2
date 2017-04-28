<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="bg-1">
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
	<body class="panel-transparent" >
			<c:choose>
			<c:when test="${logged == false}">
			 <c:redirect url="/"/>
			</c:when>
			<c:when test="${type == 'Student'}">
			 <c:redirect url="/"/>
			</c:when>
			
			</c:choose>
				<div role="navigation">
								<div class="navbar navbar-inverse">
									<a href="/" class="navbar-brand">Fizo</a>
									<div class="navbar-collapse collapse">
										<div class ="nav navbar-nav pull-right btn-danger btn">
											<a href ="/sign-out" class="navbar-brand" >Sign out</a>
										</div>
										<ul class = "nav navbar-nav ">
										<li><a href="/add-course">New Course</a></li>
										<li><a href="/show-courses">Courses</a></li>
										<li><a href="#">about</a></li>
										</ul>
									</div>
								</div>
							</div>				
							
			<div class="container text-center">
			<h3>Add New Game </h3>
			<form class="form-horizontal" method="POST" action="/add-game">
				<input type="hidden" name="courseid" value="${classid}">
				<div class ="form-group">
					<label class="control-label col-md-3 ">Game Name:</label>
					<div class="col-md-7">
						<input type="text" class="form-control" name="name" required >
					</div>
				</div>
				<div class ="form-group">
					<label class="control-label col-md-3 ">Game Description:</label>
					<div class="col-md-7">
						<input type="text" class="form-control" name="desc" required >
					</div>
				</div>
				
				<div class="form-group" >
					<input type="submit" class="btn btn-primary" value="add">
				</div>
			</form>
			</div>
			
			
	
		
		<script src="static/js/jquery-1.11.1.min.js"></script>
		<script src="static/js/bootstrap.min.js"></script>
		
				
	</body>
</html>

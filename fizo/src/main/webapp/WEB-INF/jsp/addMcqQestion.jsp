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
											<div class ="nav navbar-nav pull-right btn-danger btn">
												<a href ="/sign-out" class="navbar-brand" >Sign out</a>
											</div>
											<ul class = "nav navbar-nav ">
											<li><a href="/add-course">New Course</a></li>
											<li><a href="#">New Game</a></li>
											<li><a href="/show-courses">Courses</a></li>
											<li><a href="#">about</a></li>
											</ul>
										</div>
									</div>
								</div>				 					
	<div class="container" id="homeDiv">
		<div class="container text-center">
			<form class="form-horizontal" action="/save-Question" method="POST" >
				<div class ="form-group">
					<label class="control-label col-md-3 ">Question:</label>
					<div class="col-md-6">
						<input type="hidden" name="Type" value="MCQ">
						<input type="text" class="form-control" name="Question"  required >
						<input type="hidden" name="gameid" value="${gameid }">
						<input type="hidden" name="courseid" value="${courseid }">
						
					</div>
				</div>
				<div class ="form-group">
					<label class="control-label col-md-3 ">Answer1:</label>
					<input type="radio" class="col-sm-1 " name="Correct" value="0" checked>
					<div class="col-md-5">
						<input type="text" class="form-control" name="Answer1"  required >
					</div>
				</div>
				<div class ="form-group">
					<label class="control-label col-md-3 ">Answer2:</label>
					<input type="radio" class="col-sm-1 " name="Correct" value="1" >
					<div class="col-md-5">
						<input type="text" class="form-control" name="Answer2"  required >
					</div>
				</div>
				<div class ="form-group">
					<label class="control-label col-md-3 ">Answer3:</label>
					<input type="radio" class="col-sm-1 " name="Correct" value="2" >
					<div class="col-md-5">
						<input type="text" class="form-control" name="Answer3"  required >
					</div>
				</div>
				<div class ="form-group">
					<label class="control-label col-md-3 ">Answer4:</label>
					<input type="radio" class="col-sm-1 " name="Correct" value="3" >
					<div class="col-md-5">
						<input type="text" class="form-control" name="Answer4"  required >
					</div>
				</div>
				
				<div class="form-group" >
					<input type="submit" class="btn btn-primary" value="Add">
					
				</div>	
			</form>
		</div>
	</div>
 </body>
</html>

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
	<c:choose>	
		<c:when test="${type == 'Teacher' }">	
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
					
						<div class="container" id="gamesDiv">
							<h3>Games:</h3>
							<hr>
							<div class="table-responsive">
								<table class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>Name</th>
											<th>Play Game</th>
											<th>Show Questions</th>
											<th>add Question</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="list" items="${list}">
											<tr>
												<td>${list.name}</td>
												<td class="col-md-1 text-center"><a href="/play-game?gameid=${list.id }&courseid=${courseid}"><span class="glyphicon glyphicon-play"></span></a>
												<td class="col-md-1 text-center"><a href="/show-Question?gameid= ${list.id}&courseid=${courseid}"><span class="glyphicon glyphicon-menu-hamburger"></span></a>
												<td class="col-md-1 text-center"><a href="/add-quesion?gameid=${list.id}&courseid=${courseid}"><span class="glyphicon glyphicon-plus-sign"></span></a>
												<td class="col-md-1 text-center"><a href="/delete-game?gameid=${list.id}&courseid=${courseid}"><span class="glyphicon glyphicon-trash"></span></a> </td>
											</tr>
										</c:forEach>
										
									</tbody>
								</table>
							</div>
						</div>
		</c:when>	
		<c:when test="${type == 'Student' }">
				<div role="navigation">
									<div class="navbar navbar-inverse">
										<a href="/" class="navbar-brand">Fizo</a>
										<div class="navbar-collapse collapse">
											<div class ="nav navbar-nav pull-right btn-danger btn">
												<a href ="/sign-out" class="navbar-brand" >Sign out</a>
											</div>
											<ul class = "nav navbar-nav ">
											<li><a href="/show-courses">Courses</a></li>
											<li><a href="#">about</a></li>
											</ul>
										</div>
									</div>
								</div>				 	
						<div class="container" id="courseDiv">
							<h3>Games:</h3>
							<hr>
							<div class="table-responsive">
								<table class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>Name</th>
											<th>Play Game</th>
								
										</tr>
									</thead>
									<tbody>
										<c:forEach var="list" items="${list}">
											<tr>
												<td>${list.name}</td>
												<td class="col-md-1 text-center"><a href="/play-game?id=${list.id }"><span class="glyphicon glyphicon-play"></span></a>
								
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
		</c:when>	
	</c:choose>
	</body>
</html>

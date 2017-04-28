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

	</head>
	<body class="panel-transparent" >
			<c:choose> 	
			 	<c:when  test="${mode == 'MODE_INDEX' }">
			 			<c:redirect url="/"/>
			 	</c:when>
			 	<c:when  test="${mode == 'MODE_SHOWCOURSES' }">
			 			<c:redirect url="/show-courses"/>
			 	</c:when>
				<c:when  test="${mode == 'MODE_SHOWQUESTIONS' }">
			 			<c:redirect url="/show-Question?gameid= ${gameid}&courseid=${courseid}"/>
			 	</c:when>
			 	<c:when  test="${mode == 'MODE_SHOWGAMES' }">
			 			<c:redirect url="/show-games?id=${courseid}"/>
			 	</c:when>
			</c:choose>
		
	</body>
</html>

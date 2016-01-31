<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Music</title>
</head>
<body>
<!-- 	<form action="Year.do" method="GET"> -->
<!-- 		<h3>Choose a Year</h3> -->
<!-- 		Album of the year:<input type="text" name="year" />  -->
<!-- 		<input type="submit" value="Submit" /><br> -->
<!-- 	</form> -->
	
		<form action="getYearList.do" method="POST">
		<select name="year">
			<c:forEach var="album" items="${albums}">
				<option value="${album.year}">${album.year}</option>
			</c:forEach>
		</select> <input type="submit" value="Pick a Year" />
	</form>



	
	
	
</body>
</html>
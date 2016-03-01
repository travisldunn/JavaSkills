<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>The Unfatalator!</h1>
	<form action="rest/fatForm" method="get" name = fatForm>
<input type="text" name="cFat" placeholder="Current Fat"/>
<input type="text" name="gFat" placeholder="Goal Fat"/>
<input type="text" name="Diet" placeholder="Diet"/>

<input class="button" type="submit" name="submit" value="Calculate" />
</form>
	
	<table id = table></table> 
	 <script src = "js/fat.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MusicResult</title>
</head>
<body>




	<audio controls>
  	<source src="Tunes/${bean.tune}" type="audio/mpeg">
	</audio>

	<iframe
		src="https://widgets.itunes.apple.com/widget.html?c=us&brc=FFFFFF&blc=FFFFFF&trc=FFFFFF&tlc=FFFFFF&d=&t=&m=music&e=album&w=250&h=300&ids=${bean.itunesLink}&wt=discovery&partnerId=&affiliate_id=&at=&ct="
		style="overflow-x: hidden; overflow-y: hidden; width: 250px; height: 300px; border: 0px">
		</iframe>


	<form action="getYearList.do" method="POST">
		<select name="year">
			<c:forEach var="album" items="${albums}">
				<option value="${album.year}">${album.year}</option>
			</c:forEach>
		</select> <input type="submit" value="Pick a Year" />
	</form>
	
	<form action="favorite.do" method="GET">
	    <input type="submit" value="Add Album to Favorites List">	
	</form>
	
	<form action="deleteFavorite.do" method="GET">
		<input type="submit" name="input" value="Delete From Favorites List" /> 
	</form>
	
	<form action="goToFavorite.do" method="GET">
	    <input type="submit" value="Veiw Favorites List">	
	</form>
	
	
	<form action="button.do" method="GET">
		<input type="submit" name="input" value="Previous" /> 
		<input type="submit" name="input" value="Next" /><br>
	</form>
	

	<form action="comment.do" method="get">
		<h3>Leave A Comment</h3>
		<input type="text" name="comment" /> 
		<input type="submit" value="Submit">
		<c:forEach var="comment" items="${bean.comments}">
			<p>${comment}</p>
		</c:forEach>
	</form>
	
	<form action="deletebutton.do" method="GET">
		<input type="submit" name="input" value="Delete" /> 
	</form>
	
	
	<img src="Grammy/${bean.albumLink}" />
	<br>
	<p>
		The Album of the Year for ${bean.year} was: <br>
		${bean.albumName}<br>
	</p>
	By the Artist: ${bean.name}
	<br>
</body>
</html>
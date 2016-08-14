<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ServiceProvider"%>
<%
	request.setAttribute("film", ServiceProvider.getCompanyService().getAllFilms());
%>

<!DOCTYPE html>
<html>
<head>
<title>Films</title>
<meta charset="iso-8859-1" />
<script type="text/javascript" src="/css/script.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Slideshow.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/mystyles.css">
<link rel="stylesheet" type="text/css" href="/css/formStyle.css">
</head>

<body>
	<div>
		<table>
			<tr>
				<th>Filmcode</th>
				<th>Naam</th>
				<th>Cast</th>
				<th>Beschrijving</th>
				<th>Genre</th>
				<th>Visie</th>
				<th>Zaalnummer</th>
				<th>Beschikbaarheid</th>
				<th>Prijs</th>
				<th>IMDB Rating</th>
			</tr>
			<c:forEach items="${film}" var="film">
				<tr>
					<td>${film.filmcode}</td>
					<td>${film.naam}</td>
					<td>${film.cast}</td>
					<td>${film.beschrijving}</td>
					<td>${film.genre}</td>
					<td>${film.visie}</td>
					<td>${film.zaalnummer}</td>
					<td>${film.beschikbaarheid}</td>
					<td>${film.prijs}</td>
					<td>${film.IMDB_rating}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a class="button" href="/index.jsp">Terug</a>


	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ServiceProvider"%>
<%
	request.setAttribute("film", ServiceProvider.getCompanyService().getAllFilms());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>B3</title>
<script type="text/javascript" src="/css/script.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Slideshow.css"
	media="screen" />
<link rel="stylesheet" type="text/css" href="/css/mystyles.css">
<link rel="stylesheet" type="text/css" href="/css/formStyle.css">
</head>

<body>

	<div id="fixedheader">
		<span style="font-size: 30px; cursor: pointer" onmouseover="openNav()">=Menu</span>
	</div>

	<div id="mySidenav" class="sidenav">
		<span class="closebtn" onclick="closeNav()">×</span>
		<h1>Menu:</h1>
		<a href="index.jsp">Home</a> 
		<a href="bestelFilms.jsp">Bestel</a>
		<a href="/webshop/winkelwagen.jsp">Bestelling</a>
		<a href="/account/klantAccount.jsp">Account</a> 
		<a href="/bioscoopmedewerker/bioscoopmedewerkerAccount.jsp">Medewerker</a>
		<a href="/inlog/login.jsp">Login</a> 
		<a href="/inlog/register.jsp">Register</a>
		<a href="/LogoutServlet"> Logout</a>
	</div>

	<div>
		<br> <br>
		<div style="text-align:center">
			<h1>Bestel een film:</h1>
		</div>
		<br>
		<form action="/webshop/BestellingServlet" method="post">
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
					<th>IMDB Rating</th>
					<th>Bestellen</th>
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
						<td>${film.IMDB_rating}</td>
						<td><button name="voegToe" value="${film.filmcode}" type="submit">Voeg toe</button></td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<a style="text-align: right;"class="button" href="/index.jsp">Home</a>
	</div>

	<div id="fixedfooter">Gemaakt door de al zo geweldige Brian van
		Yperen</div>

</body>
</html>
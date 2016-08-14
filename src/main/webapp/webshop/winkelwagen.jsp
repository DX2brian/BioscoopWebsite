<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ServiceProvider"%>
<%@ page import="domain.Klant" %>
<%
	request.setAttribute("bestelling", ServiceProvider.getCompanyService().getJouwBestelling(((Klant)request.getSession().getAttribute("loggedKlant")).getKlantnummer()));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="10" /> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BestelPagina</title>
<script type="text/javascript" src="/css/script.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Slideshow.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/mystyles.css">
<link rel="stylesheet" type="text/css" href="/css/formStyle.css">
</head>

<body>

	<div id="fixedheader">
		<span style="font-size:30px;cursor:pointer" onmouseover="openNav()">=Menu</span>
	</div>

	<div id="mySidenav" class="sidenav">
		<span class="closebtn" onclick="closeNav()">×</span>
		<h1>Menu:</h1>
		<a href="/index.jsp">Home</a>
		<a href="/bestelFilms.jsp">Bestel</a>
		<a href="winkelwagen.jsp">Bestelling</a>
		<a href="/account/klantAccount.jsp">Account</a>
		<a href="/bioscoopmedewerker/bioscoopmedewerkerAccount.jsp">Medewerker</a>
		<a href="/inlog/login.jsp">Login</a>
		<a href="/inlog/register.jsp">Register</a>
		<a href="/LogoutServlet"> Logout</a>
	</div>

			<div>
			<form action="/webshop/BestellingServlet" method="post">
			<br>
			<h1 style="text-align: center;">Jouw bestelling:</h1>
				<table>
					<tr>
						<th>Bestellingnummer</th>
						<th>Achternaam klant</th>
						<th>Achternaam bioscoopmedewerker</th>
						<th>Eten</th>
						<th>Grootte</th>
						<th>Drinken</th>
						<th>Film</th>
						<th>Status</th>
						<th>Verwijder</th>
						<th>Pas aan</th>
					</tr>
					<c:forEach items="${bestelling}" var="bestelling">
					<tr>
						<td>${bestelling.bestellingnummer}</td>
						<td>${bestelling.klant.achternaam}</td>
						<td>${bestelling.bioscoopmedewerker.achternaam}</td>
						<td>${bestelling.eten.naam}</td>
						<td>${bestelling.eten.grootte}</td>
						<td>${bestelling.drinken.naam}</td>
						<td>${bestelling.film.naam}</td>
						<td>${bestelling.status}</td>
						<td> <button name="Delete" value="${bestelling.bestellingnummer}" type="submit">Verwijder</button> </td>
						<td> <button name="Update" value="${bestelling.bestellingnummer}" type="submit">Update</button> </td>
					</c:forEach>
				</table>
			</form>
			<br>
			<a style="text-align: right;"class="button" href="/index.jsp">Home</a>
			<a class="button" href="/bestelFilms.jsp">Andere bestelling</a>
		</div>

	<div id="fixedfooter">Gemaakt door de al zo geweldige Brian van Yperen</div>

</body>
</html>
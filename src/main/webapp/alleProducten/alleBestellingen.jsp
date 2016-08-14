<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ServiceProvider"%>
<%
	request.setAttribute("bestelling", ServiceProvider.getCompanyService().getAllBestellingen());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>B3</title>
<script type="text/javascript" src="/css/script.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Slideshow.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/mystyles.css">
<link rel="stylesheet" type="text/css" href="/css/formStyle.css">

</head>

<body>
	
	<!-- Use any element to open the sidenav -->
		<div>
			<br>
			<form action="/BestellingServlet" method="post">
				<table>
					<tr>
						<th>Bestellingnummer</th>
						<th>Klant</th>
						<th>Bioscoopmedewerker</th>
						<th>Eten</th>
						<th>Drinken</th>
						<th>Film</th>
						<th>Prijs</th>
						<th>Status</th>
					</tr>
					<c:forEach items="${bestelling}" var="bestelling">
					<tr>
						<td>${bestelling.bestellingnummer}</td>
						<td>${bestelling.klant.achternaam}</td>
						<td>${bestelling.bioscoopmedewerker.personeelsnummer}</td>
						<td>${bestelling.eten.naam}</td>
						<td>${bestelling.drinken.naam}</td>
						<td>${bestelling.film.filmcode}</td>
						<td>${bestelling.prijs}</td>
						<td>${bestelling.status}</td>
					</c:forEach>
				</table>
			</form>
			<br>
			<a class="button" href="/index.jsp">Terug</a>
		</div>

</body>
</html>
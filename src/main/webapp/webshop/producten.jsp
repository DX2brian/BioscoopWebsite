<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ServiceProvider"%>
<%@ page import="domain.Klant" %>
<%
	request.setAttribute("eten", ServiceProvider.getCompanyService().getAllEten());
%>
<%
	request.setAttribute("drinken", ServiceProvider.getCompanyService().getAllDrinken());
%>
<%
	request.setAttribute("bestelling", ServiceProvider.getCompanyService().getJouwBestelling(((Klant)request.getSession().getAttribute("loggedKlant")).getKlantnummer()));
%>
<%
	request.setAttribute("bestellingv2", ServiceProvider.getCompanyService().getJouwBestellingV2(((Klant)request.getSession().getAttribute("loggedKlant")).getKlantnummer()));
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
	
	<!-- Use any element to open the sidenav -->
		<div>
		<br>
		<br>
			<div style="text-align: center;">
			<h1>De pagina van het eten en drinken</h1>
				<a class="loggedbutton" href="/webshop/winkelwagen.jsp">Bestel</a> 
			</div>
		<br>
		<br>
			<h1 style="text-align: center;">Jouw voorlopige winkelwagen:</h1>
				<table>
					<tr>
						<th>Eten</th>
						<th>Grootte</th>
						<th>Drinken</th>
						<th>Film</th>
					</tr>
						<c:forEach items="${bestelling}" var="bestelling">
					<tr>
						<td>${bestelling.eten.naam}</td>
						<td>${bestelling.eten.grootte}</td>
						<td>${bestelling.drinken.naam}</td>
						<td>${bestelling.film.naam}</td>
						</c:forEach>
				</table>
			<br>
			<br>
				<h1 style="text-align: center;">Eten in winkelwagen:</h1>
				<table class="tussenTabel" >
					<tr class="tussenTabelRow">
						<th>Eten</th>
						<th>Grootte</th>
					</tr>
						<c:forEach items="${bestelling}" var="bestelling">
					<tr>
						<td>${bestelling.eten.naam}</td>
						<td>${bestelling.eten.grootte}</td>
						</c:forEach>
				</table>
			<br>
			<br>
				<h1 style="text-align: center;">Al ons eten:</h1>
				<form action="/webshop/EtenDrinkenServlet" method="post">
				<table>
					<tr>
						<th>Barcode</th>
						<th>Naam</th>
						<th>Merk</th>
						<th>Grootte</th>
						<th>Gram</th>
						<th>Bestel</th>
					</tr>
					<c:forEach items="${eten}" var="eten">
						<tr>
							<td>${eten.barcode}</td>
							<td>${eten.naam}</td>
							<td>${eten.merk}</td>
							<td>${eten.grootte}</td>
							<td>${eten.gram}</td>
							<td><button name="voegEtenToe" value="${eten.barcode}" type="submit">Voeg toe</button></td>
						</tr>
					</c:forEach>
				</table>
			<br>
			<br>
			<h1 style="text-align: center;">Drinken in winkelwagen:</h1>
				<table class="tussenTabel" >
					<tr>
						<th>Drinken</th>
						<th>Merk</th>
					</tr>
						<c:forEach items="${bestelling}" var="bestelling">
					<tr>
						<td>${bestelling.drinken.naam}</td>
						<td>${bestelling.drinken.merk}</td>
						</c:forEach>
				</table>
			<br>
			<br>
				<h1 style="text-align: center;">Al ons drinken:</h1>
				<table>
			<tr>
				<th>Barcode</th>
				<th>Naam</th>
				<th>Merk</th>
				<th>mL</th>
				<th>Gekoelt?</th>
				<th>Bestel</th>
			</tr>
			<c:forEach items="${drinken}" var="drinken">
				<tr>
					<td>${drinken.barcode}</td>
					<td>${drinken.naam}</td>
					<td>${drinken.merk}</td>
					<td>${drinken.liters}</td>
					<td>${drinken.gekoelt}</td>
					<td>
					<button name="voegDrinkenToe" value="${drinken.barcode}" type="submit">Voeg toe</button>
				</tr>
			</c:forEach>
		</table>
		</form>
		<br>
		<a class="button" href="/index.jsp">Terug</a>
		</div>
	
	<div id="fixedfooter">Gemaakt door de al zo geweldige Brian van Yperen</div>

</body>
</html>
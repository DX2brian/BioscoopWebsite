<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ServiceProvider"%>
<%
	request.setAttribute("bestelling", ServiceProvider.getCompanyService().getAllBestellingen());
%>
<%
	request.setAttribute("bestellingv2", ServiceProvider.getCompanyService().getAllBestellingenV2());
%>
<%
	request.setAttribute("bioscoopmedewerker", ServiceProvider.getCompanyService().getAllBioscoopmedewerkers());
%>
<%
	request.setAttribute("drinken", ServiceProvider.getCompanyService().getAllDrinken());
%>
<%
	request.setAttribute("eten", ServiceProvider.getCompanyService().getAllEten());
%>
<%
	request.setAttribute("film", ServiceProvider.getCompanyService().getAllFilms());
%>
<%
	request.setAttribute("klant", ServiceProvider.getCompanyService().getAllKlanten());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="10" /> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alle onderdelen</title>
<script type="text/javascript" src="/css/script.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Slideshow.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/mystylesmedewerker.css">
<link rel="stylesheet" type="text/css" href="/css/formStyle.css">

<style>
.gegevens {
	text-align: center;
}

.buttons {
	text-align: center;
}
</style>

</head>

<body>
	<div id="fixedheader">
		<span style="font-size: 30px; cursor: pointer" onmouseover="openNav()">=Menu</span>
	</div>

	<div id="mySidenav" class="sidenav">
		<span class="closebtn" onclick="closeNav()">×</span>
		<h1>Menu:</h1>
		<a href="/index.jsp">Home</a>
		<a href="/bioscoopmedewerker/bioscoopmedewerkerAccount.jsp">Account</a>
		<a href="/bioscoopmedewerker/statusOverzicht.jsp">Orders</a>
		<a href="/alleProducten/alles.jsp">Overzicht</a>
		<a href="/LogoutServlet"> Logout</a>
	</div>

	<div class="gegevens">
	<form action="/bioscoopmedewerker/AllesDeleteServlet" method="post">
		<div>
			<br>
			<h1>Alle Bestellingen:</h1>
			<table>
				<tr>
					<th>Bestellingnummer</th>
					<th>Achternaam klant</th>
					<th>Achternaam bioscoopmedewerker</th>
					<th>Eten</th>
					<th>Drinken</th>
					<th>Film</th>
					<th>Status</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${bestelling}" var="bestelling">
					<tr>
						<td>${bestelling.bestellingnummer}</td>
						<td>${bestelling.klant.achternaam}</td>
						<td>${bestelling.bioscoopmedewerker.achternaam}</td>
						<td>${bestelling.eten.naam}</td>
						<td>${bestelling.drinken.naam}</td>
						<td>${bestelling.film.naam}</td>
						<td>${bestelling.status}</td>
						<td> <button name="DeleteBestelling" value="${bestelling.bestellingnummer}" type="submit">Verwijder</button> </td>
					</tr>
				</c:forEach>
			</table>
			<br><a class="button" href="/alleProducten/alles.jsp">Omhoog</a>
		</div>
		
		<div>
		<br>
		<br>
		<br>
			<h1>Alle Bestellingen (Primarykeys):</h1>
			<table>
				<tr>
					<th>Bestellingnummer</th>
					<th>Klant</th>
					<th>Bioscoopmedewerker</th>
					<th>Eten</th>
					<th>Drinken</th>
					<th>Film</th>
					<th>Status</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${bestellingv2}" var="bestellingv2">
					<tr>
						<td>${bestellingv2.bestellingnummer}</td>
						<td>${bestellingv2.klant}</td>
						<td>${bestellingv2.bioscoopmedewerker}</td>
						<td>${bestellingv2.eten}</td>
						<td>${bestellingv2.drinken}</td>
						<td>${bestellingv2.film}</td>
						<td>${bestellingv2.status}</td>
						<td> <button name="DeleteBestelling" value="${bestellingv2.bestellingnummer}" type="submit">Verwijder</button> </td>
					</tr>
				</c:forEach>
			</table>
			<br> <a class="button" href="/voegToe/voegBestellingToe.jsp">Voeg bestelling toe</a>
			<a class="button" href="/alleProducten/alles.jsp">Omhoog</a>
		</div>


		<div>
			<br>
			<br>
			<br>
			<h1>Alle Bioscoopmedewerkers:</h1>
			<table>
				<tr>
					<th>Personeelsnummer</th>
					<th>Emailadres</th>
					<th>Wachtwoord</th>
					<th>Achternaam</th>
					<th>Tussenvoegsel</th>
					<th>Initialen</th>
					<th>Status</th>
					<th>Rang</th>
					<th>Leeftijd</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${bioscoopmedewerker}" var="bioscoopmedewerker">
					<tr>
						<td>${bioscoopmedewerker.personeelsnummer}</td>
						<td>${bioscoopmedewerker.email_adres}</td>
						<td>${bioscoopmedewerker.wachtwoord}</td>
						<td>${bioscoopmedewerker.achternaam}</td>
						<td>${bioscoopmedewerker.tussenvoegsel}</td>
						<td>${bioscoopmedewerker.initialen}</td>
						<td>${bioscoopmedewerker.status}</td>
						<td>${bioscoopmedewerker.rang}</td>
						<td>${bioscoopmedewerker.leeftijd}</td>
						<td> <button name="DeleteBioscoopmedewerker" value="${bioscoopmedewerker.personeelsnummer}" type="submit">Verwijder</button> </td>
					</tr>
				</c:forEach>
			</table>
			<br> <a class="button" href="/voegToe/voegBioscoopmedewerkerToe.jsp">Voeg bioscoopmedewerker toe</a>
			<a class="button" href="/alleProducten/alles.jsp">Omhoog</a>
		</div>


		<div>
			<br>
			<br>
			<br>
			<h1>Al het Drinken:</h1>
			<table>
				<tr>
					<th>Barcode</th>
					<th>Naam</th>
					<th>Merk</th>
					<th>miliLiters</th>
					<th>Gekoelt?</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${drinken}" var="drinken">
					<tr>
						<td>${drinken.barcode}</td>
						<td>${drinken.naam}</td>
						<td>${drinken.merk}</td>
						<td>${drinken.liters}</td>
						<td>${drinken.gekoelt}</td>
						<td> <button name="DeleteDrinken" value="${drinken.barcode}" type="submit">Verwijder</button> </td>
					</tr>
				</c:forEach>
			</table>
			<br> <a class="button" href="/voegToe/voegDrinkenToe.jsp">Voeg drinken toe</a>
			<a class="button" href="/alleProducten/alles.jsp">Omhoog</a>
		</div>


		<div>
			<br>
			<br>
			<br>
			<h1>Al het eten:</h1>
			<table>
				<tr>
					<th>Barcode</th>
					<th>Naam</th>
					<th>Merk</th>
					<th>Grootte</th>
					<th>Gram</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${eten}" var="eten">
					<tr>
						<td>${eten.barcode}</td>
						<td>${eten.naam}</td>
						<td>${eten.merk}</td>
						<td>${eten.grootte}</td>
						<td>${eten.gram}</td>
						<td> <button name="DeleteEten" value="${eten.barcode}" type="submit">Verwijder</button> </td>
					</tr>
				</c:forEach>
			</table>
			<br> <a class="button" href="/voegToe/voegEtenToe.jsp">Voeg eten toe</a>
			<a class="button" href="/alleProducten/alles.jsp">Omhoog</a>
		</div>

		<div>
			<br>
			<br>
			<br>
			<h1>Alle films:</h1>
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
					<th>Delete</th>
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
						<td> <button name="DeleteFilm" value="${film.filmcode}" type="submit">Verwijder</button> </td>
					</tr>
				</c:forEach>
			</table>
			<br> <a class="button" href="/voegToe/voegFilmToe.jsp">Voeg film toe</a>
			<a class="button" href="/alleProducten/alles.jsp">Omhoog</a>
		</div>

		<div>
			<br>
			<br>
			<br>
			<h1>Alle klanten:</h1>
			<table>
				<tr>
					<th>Klantnummer</th>
					<th>Achternaam</th>
					<th>Tussenvoegsel</th>
					<th>Initialen</th>
					<th>Email-adres</th>
					<th>Wachtwoord</th>
					<th>Leeftijd</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${klant}" var="klant">
					<tr>
						<td>${klant.klantnummer}</td>
						<td>${klant.achternaam}</td>
						<td>${klant.tussenvoegsel}</td>
						<td>${klant.initialen}</td>
						<td>${klant.email_adres}</td>
						<td>${klant.wachtwoord}</td>
						<td>${klant.leeftijd}</td>
						<td> <button name="DeleteKlant" value="${klant.klantnummer}" type="submit">Verwijder</button> </td>
					</tr>
				</c:forEach>
			</table>
			<br> <a style="text-align: right;" class="button" href="/voegToe/voegKlantToe.jsp">Voeg klant toe</a>
			<a class="button" href="/alleProducten/alles.jsp">Omhoog</a>
		</div>
	</form>
	</div>
	<div id="fixedfooter">Gemaakt door de al zo geweldige Brian van
		Yperen</div>

</body>
</html>
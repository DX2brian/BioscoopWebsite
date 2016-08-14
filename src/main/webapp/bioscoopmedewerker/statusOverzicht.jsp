<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ServiceProvider" %>
<% request.setAttribute("bestelling", ServiceProvider.getCompanyService().getAllBestellingen()); %>

<!DOCTYPE html>
<html>
	<head>
	<title>Overzicht</title>
	<meta charset="iso-8859-1" />
	<meta http-equiv="refresh" content="10" /> 
<script type="text/javascript" src="/css/script.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Slideshow.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/mystylesmedewerker.css">
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
		<a href="/bioscoopmedewerker/bioscoopmedewerkerAccount.jsp">Account</a>
		<a href="/bioscoopmedewerker/statusOverzicht.jsp">Orders</a>
		<a href="/alleProducten/alles.jsp">Overzicht</a>
		<a href="/LogoutServlet"> Logout</a>
	</div>
	
		<div id="results">	
		<h1 style="text-align:center;">Overzicht bestellingen</h1>
			<form action="/bioscoopmedewerker/OverzichtServlet" method="post">			
				<table>
					<tr>
						<th>Bestellingnummer</th>
						<th>Klant</th>
						<th>Bioscoopmedewerker</th>
						<th>Eten</th>
						<th>Grootte</th>
						<th>Drinken</th>
						<th>Film</th>
						<th>Status</th>
						<th>Update</th>
						<th>Wie werkt hieraan?</th>
						<th>Verwijder</th>
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
							<td> <button name="Bezig" value="${bestelling.bestellingnummer}" type="submit">Bezig</button> 
								 <button name="Klaar" value="${bestelling.bestellingnummer}" type="submit">Klaar</button> </td>
							<td> <button name="Accepteer" value="${bestelling.bestellingnummer}" type="submit">Accepteer</button> </td>
							<td> <button name="Delete" value="${bestelling.bestellingnummer}" type="submit">Verwijder</button> </td>
						</tr>
					</c:forEach>
				</table>
			</form>
		<br>
	<a class="button" href="/bioscoopmedewerker/bioscoopmedewerkerAccount.jsp">Terug</a>
		</div>
		
		<div id="fixedfooter">Gemaakt door de al zo geweldige Brian van Yperen</div>
	</body>
</html>
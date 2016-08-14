<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="domain.Klant"%>
<%@page import="crud.KlantServlet"%>
<%@page import="controller.RegisterServlet"%>
<%@page import="model.ServiceProvider"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Brioscoop</title>
<link rel="stylesheet" type="text/css" href="/css/Slideshow.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/mystyles.css">
<link rel="stylesheet" type="text/css" href="/css/formStyle.css">
<link rel="stylesheet" type="text/css" href="/css/colourcards.css">
</head>

<body>

	<div id="fixedheader"  style="display: none;">
		<span style="font-size:30px;cursor:pointer" onmouseover="openNav()">=Menu</span>
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
	
	<!-- Use any element to open the sidenav -->
		<div>
		<br>
		<br>
			<div class="titel">
			<br>
				<h2>Brian's Brovie Brioscoop</h2>
				<h1>Path aangepast! Terug veranderen anders werkt het niet meer!</h1>
				<br>
					
			</div>
		<br>
		<br>
			<div class="colourcard1">
			<h1>Nuttige feiten over deze website:</h1>
				<%
				Object hoofdbericht = request.getAttribute("hoofdbericht");
				if (hoofdbericht != null) {
					out.println(hoofdbericht);
				} else {
					out.println("Druk hier voor extra informatie over de website");
				}
				%>
				<br>
				<br>
				<form action="/TextServlet" method="post">
					<button name="Random Text Generator" value="0" type="submit">Volgende feit</button>
				</form>
			</div>
		<br>
			<div class="colourcard2">
				<h1>Filmpie bestellen?</h1>
				<p><i>Inloggen is vereist om een film te bestellen</i></p>
				<br>
				 <a class="loggedbutton" href="bestelFilms.jsp">Klik hier</a> 
			</div>
		<br>
			<div class="colourcard3">
			
				<h1><a class="loggedbutton" href="/inlog/login.jsp">Login</a> of <a class="loggedbutton" href="/inlog/register.jsp">Registreer</a></h1>
				
				<% String Gebruikersnaam = "";
				if(((Klant)request.getSession().getAttribute("loggedKlant")) == null){
				Gebruikersnaam = "U bent nog niet ingelogt en hierdoor mist u belangrijke functies zoals het bestellen van films (wat het doel van deze website is)";
				} else {
				Gebruikersnaam = "Welkom: " + ((Klant)request.getSession().getAttribute("loggedKlant")).getTussenvoegsel() +" "+ ((Klant)request.getSession().getAttribute("loggedKlant")).getAchternaam() + ", enjoy your stay!";}%>
				
				<%= Gebruikersnaam %>
			</div>
		<br>
			<div class="colourcard4">
			
				<h1>Bestelling gedaan met eten en/of drinken?</h1>
				<p>Bekijk en track je bestelling hier:</p>
				<br>
				 <a class="loggedbutton" href="/webshop/winkelwagen.jsp">Bestellingen</a> 
			</div>
		<br>
			<div class="colourcard5">
			
				<h1>Hier is wat pure informatie over de website</h1>
				<p>Deze website is gemaakt voor om mijn IPASS the halen. Dit is een project die je compleet zelf moet verzinnen en ook vanuit het niets moet opbouwen.
				Mijn IPASS verhaal ging over een nieuw bioscoopwebsite systeem waarbij je niet alleen een film kan bestellen, maar ook een hapje en een drankje. Aan 
				de andere kant moeten de medewerkers van de bioscoop deze bestellingen kunnen bijhouden en de status ervan veranderen waardoor de klant weet of zijn
				bestelling klaar is of niet. Uiteindelijk is dat allemaal gelukt en zijn er twee inlog actors: de klant en de bioscoopmedewerker. </p>
				<br>
				<p>Als klant kan je op dit moment: <ul> <li>registeren <li>inloggen <li>je account bekijken <li>je wachtwoord wijzigen <li>je account verwijderen <li>een film bestellen
				<li>eten bestellen <li>drinken bestellen <li>je winkelwagen onderhouden</ul>
				<br>
				<p>Als Bioscoopmedewerker kan je op dit moment: <ul> <li>inloggen <li>je account bekijken <li>je status aanpassen <li>alle bestellingen onderhouden <li>alle onderdelen van de database inzien
				<li>alles kunnen toevoegen <li>alles kunnen verwijderen</ul>
				<br>
				<p>Bij deze is bijna alles gelukt wat er in hoort te komen. Er is maar 1 ding wat ik heb opgegeven en dat is de prijs aanpassen als je een nieuw hapje of drankje toevoegt. Daarom is bij deze al het eten en drinken gratis. <br>
				Maar verder is deze website super gelukt en is (op de sidebar na) alles gemaakt door mij. Ook is dit trouwens mijn eerste website ooit...
				<br>
				<p> Brian van Yperen
				<br>
			</div>
		</div>
	
	<div id="fixedfooter"  style="display: none;">Gemaakt door de al zo geweldige Brian van Yperen</div>

	<script type="text/javascript" src="/css/jquery.js"></script>
	<script type="text/javascript" src="/css/script.js"></script>
</body>
</html>
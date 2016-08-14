<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registreer</title>
<script type="text/javascript" src="/css/script.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Slideshow.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/mystylesmedewerker.css">
<link rel="stylesheet" type="text/css" href="/css/formStyleMedewerker.css">
	
</head>

<body>
	<div id="fixedheader">
		<span style="font-size:30px;cursor:pointer" onclick="openNav()">=Menu</span>
	</div>
	
	<div id="mySidenav" class="sidenav">
		<span class="closebtn" onclick="closeNav()">×</span>
		<h1>Menu:</h1>
		<a href="/index.jsp">Home</a>
		<a href="/bioscoopmedewerker/bioscoopmedewerkerAccount.jsp">Account</a>
		<a href="/bioscoopmedewerker/statusOverzicht.jsp">Orders</a>
		<a href="/alleProducten/alles.jsp">Overzicht</a>
		<a href="/LogoutServlet">Logout</a>
	</div>
	
	<div class="specialcard">
	
	<div style="text-align:center;">
		<h1>Voeg een nieuwe bestelling toe</h1>
	</div>
	<form action="/toevoegen/VoegBestellingToeServlet" method="post">
	<div class="container">
		<label>Voer hier het bestellingnummer in (Kan vanalles zijn)):</label> <br>
			<input type="number" name="bestellingnummer" required="required"></input> <br><br>
		<label>Voer hier het klantnummer in (Moet een bestaande klant zijn):</label> <br>
			<input type="number" name="klant" required="required"></input> <br><br>
		<label>Voer hier de bioscoopmedewerker in (Moet een bestaande medewerker zijn):</label><br>
			<input type="number" name="bioscoopmedewerker" ></input> <br><br>
		<label>Voer hier het eten in (Moet een bestaand product zijn):</label> <br>
			<input type="text" name="eten" ></input><br><br>
		<label>Voer hier het drinken in (Moet een bestaand product zijn):</label> <br>
			<input type="text" name="drinken" ></input><br><br>
		<label>Voer hier uw filmcode in (Moet een bestaande filmcode zijn):</label> <br>
			<input type="number" name="film" required="required"></input><br><br>
		<label>Voer hier uw prijs (euro) in (tussen de 1 en de 999):</label> <br>
			<input type="number" name="prijs" required="required"></input><br><br>
		<label>Voer hier uw status in (Standaard onaangeraakt):</label> <br>
			<input type="text" name="status" required="required"></input><br><br>
		<input type="submit" value="voegBestellingToe">
		</div>
	</form>
	</div>
	<div id="fixedfooter">Gemaakt door de al zo geweldige Brian van Yperen</div>

</body>
</html>
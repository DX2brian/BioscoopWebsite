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
		<span style="font-size:30px;cursor:pointer" onmouseover="openNav()">=Menu</span>
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
		<h1>Voeg een nieuwe Drank toe</h1>
	</div>
	
	<form action="/toevoegen/VoegDrinkenToeServlet" method="post">
	<div class="container">
		<label>Voer hier de barcode in (groot text of getal):</label> <br>
			<input type="text" name="barcode" required="required"></input> <br><br>
		<label>Voer hier de naam in:</label> <br>
			<input type="text" name="naam" required="required"></input> <br><br>
		<label>Voer hier het merk in:</label><br>
			<input type="text" name="merk" required="required"></input> <br><br>
		<label>Voer hier de prijs (euro) in (getal tussen de 1 en 99):</label> <br>
			<input type="number" name="prijs" required="required"></input><br><br>
		<label>Voer hier het aantal miliLiters in (getal tussen de 1 en 999):</label> <br>
			<input type="number" name="liter" required="required"></input><br><br>
		<label>Voer hier in of het gekoelt staat (ja/nee):</label> <br>
			<input type="text" name="gekoelt" required="required"></input><br><br>
		<input type="submit" value="voegDrankToe">
		</div>
	</form>
	</div>
	<div id="fixedfooter">Gemaakt door de al zo geweldige Brian van Yperen</div>

</body>
</html>
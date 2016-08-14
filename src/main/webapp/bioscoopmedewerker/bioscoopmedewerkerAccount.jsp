<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="domain.Bioscoopmedewerker"%>
<%@page import="model.ServiceProvider"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminSwag</title>
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
	
	<div>
	<div class="gegevens">
	<h1>Welkom <%= ((Bioscoopmedewerker)request.getSession().getAttribute("loggedMedewerker")).getEmail_adres() %>!</h1>
	<table>
		<tr>
			<th>Personeelsnummer: </th>
			<td><%= ((Bioscoopmedewerker)request.getSession().getAttribute("loggedMedewerker")).getPersoneelsnummer() %></td>
		</tr>
		<tr>
			<th>Email adres: </th>
			<td><%= ((Bioscoopmedewerker)request.getSession().getAttribute("loggedMedewerker")).getEmail_adres() %></td>
		</tr>
		<tr>
			<th>Achternaam: </th>
			<td><%= ((Bioscoopmedewerker)request.getSession().getAttribute("loggedMedewerker")).getAchternaam() %></td>
		</tr>
		<tr>
			<th>Tussenvoegsel: </th>
			<td><%= ((Bioscoopmedewerker)request.getSession().getAttribute("loggedMedewerker")).getTussenvoegsel() %></td>
		</tr>
		<tr>
			<th>Initailen: </th>
			<td><%= ((Bioscoopmedewerker)request.getSession().getAttribute("loggedMedewerker")).getInitialen() %></td>
		</tr>
		<tr>
			<th>Rang: </th>
			<td><%= ((Bioscoopmedewerker)request.getSession().getAttribute("loggedMedewerker")).getRang() %></td>
		</tr>
		<tr>
			<th>Leeftijd: </th>
			<td><%= ((Bioscoopmedewerker)request.getSession().getAttribute("loggedMedewerker")).getLeeftijd() %></td>
		</tr>
	</table>
	</div>
	<br>
		<div class="card">
			<h1><i>Snel bestellingen afhandelen?</i></h1>
			<a class="loggedbutton" href="/bioscoopmedewerker/statusOverzicht.jsp">Aan de slag!</a>
		</div>
	<br>
		<div class="card">
			<form action="/bioscoopmedewerker/BioscoopmedewerkerServlet" method="post">
				<h1><i>Statusupdate:</i></h1><br>
					<p>Druk hier als je ergens anders bent dan in de bioscoop:</p>
						<button name="NAHW" value="NAHW" type="submit">Niet aan het werk</button>
					<p>Druk hier als je aan het werk bent:</p>
						<button name="AHW" value="AHW" type="submit">Aan het werk</button>
					<p>Druk hier als je ziek bent:</p>
						<button name="Z" value="Z" type="submit">Ziek</button>				
			</form>
		</div>
	</div>
	<div id="fixedfooter">Gemaakt door de al zo geweldige Brian van Yperen</div>
</body>
</html>
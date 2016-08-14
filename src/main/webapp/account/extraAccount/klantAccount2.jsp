<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--suppress FeatureEnvy --%>
<%--suppress ClassWithoutLogger --%>
<%--suppress FeatureEnvy --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="domain.Klant"%>
<%@page import="model.ServiceProvider"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account</title>
<script type="text/javascript" src="/css/script.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Slideshow.css" media="screen" />
<link rel="stylesheet" type="text/css" href="accountCss/mystyles2.css">


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
		<a href="/bestelFilms.jsp">Bestel</a>
		<a href="/webshop/winkelwagen.jsp">Bestelling</a>
		<a href="/account/klantAccount.jsp">Account</a>
		<a href="/bioscoopmedewerker/bioscoopmedewerkerAccount.jsp">Medewerker</a>
		<a href="/inlog/login.jsp">Login</a>
		<a href="/inlog/register.jsp">Register</a>
		<a href="/LogoutServlet"> Logout</a>
	</div>
	
	<div class="gegevens">
	<h1>Welkom <%= ((Klant)request.getSession().getAttribute("loggedKlant")).getEmail_adres() %>!</h1>
	<table>
		<tr>
			<th>Klantnummer: </th>
			<td><%= ((Klant)request.getSession().getAttribute("loggedKlant")).getKlantnummer() %></td>
		</tr>
		<tr>
			<th>Achternaam: </th>
			<td><%= ((Klant)request.getSession().getAttribute("loggedKlant")).getAchternaam() %></td>
		</tr>
		<tr>
			<th>Tussenvoegsel: </th>
			<td><%= ((Klant)request.getSession().getAttribute("loggedKlant")).getTussenvoegsel() %></td>
		</tr>
		<tr>
			<th>Initalen: </th>
			<td><%= ((Klant)request.getSession().getAttribute("loggedKlant")).getInitialen() %></td>
		</tr>
		<tr>
			<th>Email-adres: </th>
			<td><%= ((Klant)request.getSession().getAttribute("loggedKlant")).getEmail_adres() %></td>
		</tr>
		<tr>
			<th>Leeftijd: </th>
			<td><%= ((Klant)request.getSession().getAttribute("loggedKlant")).getLeeftijd() %></td>
		</tr>
	</table>
	</div>
	<br>
		<div class="card">
			<h1><i>Gelijk een film bestellen?</i></h1><p>Dat kan als je nu op deze knop drukt!</p><br>
			<a class="loggedbutton" href="/bestelFilms.jsp">Bestel</a>
		</div>
	<br>
		<div class="card">
			<form action="/account/StemmingServlet" method="post">
				<h1>Je hebt gekozen voor Vreugde...</h1>
					<p>Bij deze raadde we je dan natuurlijk een <b>BROMEDIE</b> film aan!</p>
				<button name=standaard value="1" type="submit">Standaard</button>
				<button name=vreugde value="1" type="submit">Vreugde</button>
				<button name=verdriet value="1" type="submit">Verdriet</button>
				<button name=angst value="1" type="submit">Angst</button>
				<button name=woede value="1" type="submit">Woede</button>
				<button name=verbazing value="1" type="submit">Verbazing</button>
				<button name=afschuw value="1" type="submit">Afschuw</button>
			</form>
		</div>
	<br>
		<div class="card">
		<div>
			<%
				Object bericht = request.getAttribute("msgs3");
				if (bericht != null) {
					out.println(bericht);
				}
			%>
		</div>
			<form action="/account/VeranderwwServlet" method="post">
				<h1><i>Wachtwoord wijzigen?</i></h1><p>Ook dat kan hier</p><br>
					<p>Voer je oude wachtwoord in:</p>
						<input type="text" name="controleww1" required="required"></input><br>
					<p>Voer je nieuwe wachtwoord in:</p>
						<input type="password" name="controleww2" required="required"></input><br>
					<p>Herhaal je nieuwe wachtwoord:</p>
						<input type="password" name="controleww3" required="required"></input><br><br>
						<input type="submit" value="Verander!"></input>
			</form>
		</div>
	<br>
		<div class="card">
			<form action="/KlantServlet" method="post">
				<h1><i>Account toch niet meer nodig?</i></h1>
					<p>Verwijder hem hier!</p>
					<p><i>Een verwijderd account blijft verwijdert</i></p>
				<button name="verwijderKlant" value="<%= ((Klant)request.getSession().getAttribute("loggedKlant")).getKlantnummer() %>" type="submit">Verwijder</button>
			</form>
		</div>
	
	<div id="fixedfooter">Gemaakt door de al zo geweldige Brian van Yperen</div>
</body>
</html>
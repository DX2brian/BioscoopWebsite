<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registreer</title>
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
		<span class="closebtn" onclick="closeNav()">�</span>
		<h1>Menu:</h1>
		<a href="/index.jsp">Home</a>
		<a href="/bestelFilms.jsp">Bestel</a>
		<a href="/account/klantAccount.jsp">Account</a>
		<a href="/bioscoopmedewerker/bioscoopmedewerkerAccount.jsp">Medewerker</a>
		<a href="/inlog/login.jsp">Login</a>
		<a href="/inlog/register.jsp">Register</a>
		<a href="/LogoutServlet"> Logout</a>
	</div>
	
	<div class="specialcard">
	
	<div class="header">
		<h1>Registreer je Movie account</h1>
	</div>
	
	
		<div id="messagebox">
		
		<%
			Object msgs = request.getAttribute("msgs");
			if (msgs != null) {
				out.println(msgs);
			}
		%>
		</div><br>
		
	<form action="/RegisterServlet" method="post">
	<div class="container">
		<label>Voer hier uw achternaam in:</label> <br>
			<input type="text" name="achternaam" required="required"></input> <br> <br>
		<label>Voer hier uw tussenvoegsel in:</label> <br>
			<input type="text" name="tussenvoegsel"></input> <br> <br>
		<label>Voer hier uw initialen in:</label><br>
			<input type="text" name="initialen" required="required"></input> <br> <br>
		<label>Voer hier uw e-mailadres in:</label> <br>
			<input type="email" name="email_adres" required="required"></input><br> <br>
		<label>Voer hier uw wachtwoord in:</label> <br>
			<input type="password" name="wachtwoord" required="required"></input><br> <br>
		<label>Bevestig uw wachtwoord:</label> <br>
			<input type="password" name="bvwachtwoord" required="required"></input><br> <br>
		<label>Voer hier uw leeftijd in:</label> <br>
			<input type="number" name="leeftijd" required="required"></input> <br>
		<br>
		<input type="submit" value="Registeer">
		<br>
		<br>
		<br>
		<p>P.S. neem deze website nou niet te serieus en vul niet te serieuse gegevens in...</p>
		</div>
	</form>
	</div>
	<div id="fixedfooter">Gemaakt door de al zo geweldige Brian van Yperen</div>

</body>
</html>
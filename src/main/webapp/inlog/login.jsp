<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
		<a href="/account/klantAccount.jsp">Account</a>
		<a href="/bioscoopmedewerker/bioscoopmedewerkerAccount.jsp">Medewerker</a>
		<a href="/inlog/login.jsp">Login</a>
		<a href="/inlog/register.jsp">Register</a>
		<a href="/LogoutServlet"> Logout</a>
	</div>
	
	<div class="specialcard">
		<div>
			<%
				Object bericht = request.getAttribute("bericht1");
				if (bericht != null) {
					out.println(bericht);
				}
			%>
		</div>
		<br>
		<%	
		String koeknaam = "";
		for(Cookie c: request.getCookies()){
			if (c.getName().equals("koek")){
				koeknaam = c.getValue();
			}
		} %>
		<form action="/LoginServlet" method="post">
		<div class="container">
		<h1>Login pagina</h1>
			<label> Voer hier uw email-adres in: </label><br>
				<input type="email" name="email_adres" required="required" value=<%= koeknaam %> ></input> <br><br>
			<label> Voer hier uw wachtwoord in: </label><br> 
				<input type="password" name="wachtwoord" required="required"></input> <br> <br><br>
				<input type="submit" value="login"></input>
		</div>
	</form>
	</div>
	<div id="fixedfooter">Gemaakt door de al zo geweldige Brian van Yperen</div>
	
</body>
</html>
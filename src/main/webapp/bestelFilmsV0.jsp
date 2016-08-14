<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ServiceProvider"%>
<%
	request.setAttribute("film", ServiceProvider.getCompanyService().getAllFilms());
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
		<span style="font-size:30px;cursor:pointer" onclick="openNav()">=Menu</span>
	</div>

	<div id="mySidenav" class="sidenav">
		<span class="closebtn" onclick="closeNav()">×</span>
		<h1>Menu:</h1>
		<a href="index.jsp">Home</a>
		<a href="bestelFilms.jsp">Bestel film</a>
		<a href="/account/klantAccount.jsp">Account</a>
		<a href="/bioscoopmedewerker/bioscoopmedewerkerAccount.jsp">Medewerker</a>
		<a href="/inlog/login.jsp">Login</a>
		<a href="/inlog/register.jsp">Register</a>
		<a href="/LogoutServlet"> Logout</a>
	</div>
	
		<div>
		<br>
		<br>
			<div class="titel">
				<h1>Brian's Brovie Brioscoop</h1>
					<h2>Niet te moeilijk doen, gewoon bestellen die handel!</h2>
			</div>
			<br>
			<form action="/webshop/BestellingServlet" method="post">
				<table>
					<tr>
						<th>Films</th>
						<th>Omschrijving</th>
						<th>Bestel</th>
					</tr>
						<tr>
							<td><a href="/films/B-men.jsp "><img alt="B-men" src="/images/B-men.jpg" style="width:150px;height:150px;"></a>
							<td>B-men:
							<br>
							Word de wereld gered of juist verwoest door de B-men?</td>
							<td><button name="voegToe" value=1 type="submit">Voeg toe</button></td>
						</tr>
						<tr>
							<td><a href="/films/Brinception.jsp"><img alt="Brinception" src="/images/Brinception.jpg" style="width:150px;height:150px;"></a>
							<td>Brinception:
							<br>
							Heb je wel eens het gevoel dat iets niet klopt. Wel dan heb je een Brinception</td>
							<td><button name="voegToe" value=2 type="submit">Voeg toe</button></td>
						</tr>
						<tr>
							<td><a href="/films/Bruntouchables.jsp"><img alt="Bruntouchables" src="/images/Bruntouchables.jpg" style="width:150px;height:150px;"></a>
							<td>Bruntouchables:
							<br>
							Onaanraakbaar voor een bepaald moment</td>
							<td><button name="voegToe" value=3 type="submit">Voeg toe</button></td>
						</tr>
						<tr>
							<td><a href="/films/The Brark Knight.jsp"><img alt="The Brark Knight" src="/images/The Brark Knight.jpg" style="width:150px;height:150px;"></a>
							<td>The Brark Knight:
							<br>
							Bratman vs the Broker</td>
							<td><button name="voegToe" value=4 type="submit">Voeg toe</button></td>
						</tr>
						<tr>
							<td><a href="/films/The Bratrix.jsp"><img alt="The Bratrix" src="/images/The Bratrix.jpg" style="width:150px;height:150px;"></a>
							<td>The Bratrix:
							<br>
							Mensen en computers en dan een film daarover. Toch wel spectaculair allemaal</td>
							<td><button name="voegToe" value=5 type="submit">Voeg toe</button></td>
						</tr>
						<tr>
							<td><a href="/films/The Brawshank Bredemption.jsp"><img alt="/The Brawshank Bredemption" src="/images/The Brawshank Bredemption.jpg" style="width:150px;height:150px;"></a>
							<td>The Brawshank Bredemption:
							<br>
							De beste film over een gevangenis uitbraak die er is</td>
							<td><button name="voegToe" value=6 type="submit">Voeg toe</button></td>
						</tr>
						<tr>
							<td><a href="/films/The Breen Mile.jsp"><img alt="/The Breen Mile" src="/images/The Breen Mile.jpg" style="width:150px;height:150px;"></a>
							<td>The Breen Mile:
							<br>
							Het gaat over een groene lijn </td>
							<td><button name="voegToe" value=7 type="submit">Voeg toe</button></td>
						</tr>
						<tr>
							<td><a href="/films/The Brodfather.jsp"><img alt="/The Brodfather" src="/images/The Brodfather.jpg" style="width:150px;height:150px;"></a>
							<td>The Brodfather:
							<br>
							Het is gewoon weer een maffia film</td>
							<td><button name="voegToe" value=8 type="submit">Voeg toe</button></td>
						</tr>
						<tr>
							<td><a href="/films/The Brord of the Brings.jsp"><img alt="/The Brord of the Brings" src="/images/The Brord of the Brings.jpg" style="width:150px;height:150px;"></a>
							<td>The Brord of the Brings:
							<br>
							Het gevecht om de bring start hier!</td>
							<td><button name="voegToe" value=9 type="submit">Voeg toe</button></td>
						</tr>
						<tr>
							<td><a href="/films/The Brunisher.jsp"><img alt="/The Brunisher" src="/images/The Brunisher.jpg" style="width:150px;height:150px;"></a>
							<td>The Brunisher:
							<br>
							Het is de film 'Punisher' maar dan net iets anders</td>
							<td><button name="voegToe" value=10 type="submit">Voeg toe</button></td>
						</tr>
				</table>
			</form>
		</div>
	
	<div id="fixedfooter">Gemaakt door de al zo geweldige Brian van Yperen</div>

</body>
</html>
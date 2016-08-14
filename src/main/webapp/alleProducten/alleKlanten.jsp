<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ServiceProvider"%>
<%
	request.setAttribute("klant", ServiceProvider.getCompanyService().getAllKlanten());
%>

<!DOCTYPE html>
<html>
<head>
<title>Customers</title>
<meta charset="iso-8859-1" />
<script type="text/javascript" src="/css/script.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Slideshow.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/mystyles.css">
<link rel="stylesheet" type="text/css" href="/css/formStyle.css">
</head>


<body>
	<div id="results">
		<form action="/KlantServlet" method="post">
			<table>
				<tr>
					<th>Klantnummer</th>
					<th>Achternaam</th>
					<th>Tussenvoegsel</th>
					<th>Initialen</th>
					<th>email-adres</th>
					<th>wachtwoord</th>
					<th>leeftijd</th>
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
					</tr>
				</c:forEach>
			</table>
		</form>
		<br> <a class="button" href="/index.jsp">Terug</a>
	</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ServiceProvider" %>
<% request.setAttribute("bioscoopmedewerker", ServiceProvider.getCompanyService().getAllBioscoopmedewerkers()); %>

<!DOCTYPE html>
<html>
	<head>
		<title>Bioscoopmedewerkers</title>
		<meta charset="iso-8859-1" />
<script type="text/javascript" src="/css/script.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Slideshow.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/mystyles.css">
<link rel="stylesheet" type="text/css" href="/css/formStyle.css">
	</head>
	
	<body>
			<div>
				<table>
					<tr><th>Personeelsnummer</th><th>Achternaam</th><th>Tussenvoegsel</th><th>Initialen</th><th>Rang</th>
					<th>Leeftijd</th></tr>
					<c:forEach items="${bioscoopmedewerker}" var="bioscoopmedewerker">
						<tr>
							<td>${bioscoopmedewerker.personeelsnummer}</td>
							<td>${bioscoopmedewerker.email_adres}</td>
							<td>${bioscoopmedewerker.wachtwoord}</td>
							<td>${bioscoopmedewerker.achternaam}</td>
							<td>${bioscoopmedewerker.tussenvoegsel}</td>
							<td>${bioscoopmedewerker.initialen}</td>
							<td>${bioscoopmedewerker.rang}</td>
							<td>${bioscoopmedewerker.leeftijd}</td>
						</tr>
					</c:forEach>
				</table>
			<br>
		<a class="button" href="/index.jsp">Terug</a>
		</div>
	</body>
</html>
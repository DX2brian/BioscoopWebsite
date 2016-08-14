<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ServiceProvider"%>
<%
	request.setAttribute("drinken", ServiceProvider.getCompanyService().getAllDrinken());
%>

<!DOCTYPE html>
<html>
<head>
<title>Drinken</title>
<meta charset="iso-8859-1" />
<script type="text/javascript" src="/css/script.js"></script>
<link rel="stylesheet" type="text/css" href="/css/Slideshow.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/css/mystyles.css">
<link rel="stylesheet" type="text/css" href="/css/formStyle.css">
</head>

<body>
	<div>
		<table>
			<tr>
				<th>Barcode</th>
				<th>Naam</th>
				<th>Merk</th>
				<th>Prijs</th>
				<th>Liters</th>
				<th>Gekoelt?</th>
			</tr>
			<c:forEach items="${drinken}" var="drinken">
				<tr>
					<td>${drinken.barcode}</td>
					<td>${drinken.naam}</td>
					<td>${drinken.merk}</td>
					<td>${drinken.prijs}</td>
					<td>${drinken.liters}</td>
					<td>${drinken.gekoelt}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a class="button" href="/index.jsp">Terug</a>
	</div>
</body>
</html>
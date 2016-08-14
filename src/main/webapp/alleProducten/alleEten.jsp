<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ServiceProvider"%>
<%
	request.setAttribute("eten", ServiceProvider.getCompanyService().getAllEten());
%>

<!DOCTYPE html>
<html>
<head>
<title>Eten</title>
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
				<th>Grootte</th>
				<th>Gram</th>
			</tr>
			<c:forEach items="${eten}" var="eten">
				<tr>
					<td>${eten.barcode}</td>
					<td>${eten.naam}</td>
					<td>${eten.merk}</td>
					<td>${eten.prijs}</td>
					<td>${eten.grootte}</td>
					<td>${eten.gram}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a class="button" href="/index.jsp">Terug</a>
	</div>
</body>
</html>
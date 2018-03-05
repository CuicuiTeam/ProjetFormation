<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="toto" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Liste Periodique</title>
</head>
<body>
<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Customer</h1>
			<p>Liste des périodiques</p>
		</div>
	</div>
	</section>

	<section class="container">
	<div class="row">
	<toto:forEach items="${listePeriodique}" var="lPeriodiques">
		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
			<div class="thumbnail">
				<div class="caption">
					<h3>${lPeriodiques.titre}</h3>
					<p>${lPeriodiques.description}</p>
					<p>${lPeriodiques.prix}</p>
					<p>${lPeriodiques.datePublication}</p>
					<p>${lPeriodiques.imagePath}</p>
				</div>
			</div>
		</div>
		</toto:forEach>
	</div>
	</section>
</body>
</html>
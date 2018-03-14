<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="baseurl" value="http://localhost:8080/ProjetFormation/"
	scope="application" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title><c:out value="${titre}"></c:out></title>
</head>
<body>
	<div class="jumbotron" style="padding-bottom: 5px">
		<div class="container">
			<c:if test="${!empty msgErreur}">
				<div class="alert alert-danger" role="alert">${msgErreur}</div>
			</c:if>
			<h2>
				<c:out value="${titre}"></c:out>
			</h2>
			<p>Pas seulement des livres sur les cuicui</p>
			<form class="form-horizontal" method="POST"
				action="${baseurl}recherche" class="pull-right" />

			<input class="form-control mr-sm-2" placeholder="Recherche"
				id="motRecherche" name="motRecherche"
				style="width: 20%; float: right" />
			<button type="submit" class="btn btn-info" style="font-size: 20px; float: right">
				<span class="glyphicon glyphicon-search"></span>
			</button>
			</form>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a href="${baseurl}" class="navbar-brand">Accueil</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="${baseurl}auteurs">Auteurs</a></li>

					<li><a class="dropdown-toggle" data-toggle="dropdown" href="#">Catégories<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${baseurl}categorie/roman">Roman</a></li>
							<li><a href="${baseurl}categorie/biographie">Biographie</a></li>
							<li><a href="${baseurl}categorie/jeunesse">Jeunesse</a></li>
						</ul></li>

					<li><a href="${baseurl}categorie/jeunesse">Jeunesse</a></li>
					<li><a href="${baseurl}periodiques">Périodiques</a></li>
					<li><a href="${baseurl}bibliotheques">Bibliothèques</a></li>
				</ul>
				<ul class="nav navbar-nav pull-right">
					<c:if test="${empty sessionScope.user}">
						<li><a href="${baseurl}connexion">Connexion</a></li>
					</c:if>
					<c:if test="${!empty sessionScope.user}">
						<li><a href="${baseurl}deconnexion">Déconnexion</a></li>
					</c:if>
				</ul>
			</div>
			</nav>
		</div>
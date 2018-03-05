<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Bibliothèques</title>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Bibliothèques</h1>
			<p>Pas seulement des livres sur les cuicui</p>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<nav class="navbar">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand">Accueil</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Employés<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Liste des employés</a></li>
							<li><a href="#">Ajouter un employé</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Entreprises<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Liste des entreprises</a></li>
							<li><a href="#">Ajouter un entreprise</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Factures<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Liste des factures</a></li>
							<li><a href="#">Ajouter une facture</a></li>
						</ul></li>
				</ul>
			</div>
			</nav>
		</div>
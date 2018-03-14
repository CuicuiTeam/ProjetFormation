<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="template/header.jsp" />

<style>
h1 {
	text-align: center;
}
</style>


<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h1>${livre.titre}</h1>
			<p style="text-align:center"><c:forEach items="${livre.auteurs}" var="auteur"><b><i>${auteur.prenom}  ${auteur.nom}</i></b></c:forEach></p>
		</div>
		<p></p>
		<p><c:if test="${!empty livre.imagePath}">
						<img src="<c:url value="/ressources/${livre.imagePath}"/>" width="100px" height="150px" class="rounded text-center center-block">
						</c:if>
					<c:if test="${empty livre.imagePath}">
						<img src="<c:url value="/ressources/images/imageVide.jpg"/>" width="100px" height="150px" class="rounded text-center center-block">
						</c:if> </p>
		<h3>Resumé :</h3>
			<p>${livre.description}</p>
	</div>
	<div class="thumbnail" >
	<p><strong>editeur :</strong> ${livre.editeur.nom}</p>
	<p><strong>adresse editeur :</strong> ${livre.editeur.adresse}</p>
	<p><strong>date de publication :</strong> ${livre.datePublication}</p>
	<p><strong>prix :</strong> ${livre.prix} &euro;</p>
	<p><strong>catégorie :</strong> ${livre.categorie.nom}</p>
	</div>
	<button type="button" class="btn-outline-success and-all-other-classes center-block " style="background-color:#ddd" >
		<a href="${baseurl}livre">ajout panier </a>
	</button>
</div>
<jsp:include page="template/footer.jsp" />
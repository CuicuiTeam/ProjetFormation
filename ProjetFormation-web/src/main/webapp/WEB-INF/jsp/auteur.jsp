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
			<h1>${auteur.prenom} ${auteur.nom}</h1>
		</div>
		<div class="panel-body">
			<h3>biographie</h3>
			<p>${auteur.biographie}</p>
		</div>
	</div>
	<c:forEach items="${livres}" var="livre">
	<div class="col-lg-4" style="padding-bottom: 15px">

		
			<div class="thumbnail" style="min-height:450px">
				<div class="caption">
					<h3>${livre.titre}</h3>
					<p>${livre.description}</p>
					<p>${livre.prix}&euro;</p>
					<p>${livre.datePublication}</p>
					<c:if test="${!empty livre.imagePath}">
						<img src="<c:url value="/ressources/${livre.imagePath}"/>" width="100px" height="150px" class="rounded text-center center-block">
						</c:if>
					<c:if test="${empty livre.imagePath}">
						<img src="<c:url value="/ressources/images/imageVide.jpg"/>" width="100px" height="150px" class="rounded text-center center-block">
						</c:if>
						<p></p>
						<button type="button"
							class="btn btn-outline-success and-all-other-classes " style="background-color:#d9edf7" >
							<a href="${baseurl}livre/{livre}" style="color: inherit">
								Plus d'info </a>
						</button>
						<button type="button"
							class="btn-outline-success and-all-other-classes right " style="background-color:#d9edf7" >
							<a href="${baseurl}livre" style="color: inherit">
								ajout panier </a>
						</button>
				</div>
			</div>
		

	</div>
	</c:forEach>
</div>
<jsp:include page="template/footer.jsp" />
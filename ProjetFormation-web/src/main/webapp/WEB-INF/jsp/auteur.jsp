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
			<h1>${auteur.prenom}${auteur.nom}</h1>
		</div>
		<div class="panel-body">
			<h3>Biographie</h3>
			<p>${auteur.biographie}</p>
		</div>
	</div>
	<c:forEach items="${livres}" var="livre">
		<div class="col-lg-4" style="padding-bottom: 15px">


			<div class="thumbnail" style="min-height: 530px; margin-bottom: 0px">
				<div class="caption">
					<h3>${livre.titre}</h3>
					<p
						style="width: 340px; max-height: 144px; overflow: hidden; text-overflow: ellipsis">${livre.description}</p>
					<p>Prix : ${livre.prix}&euro;</p>
					<p>Date de publication : ${livre.datePublication}</p>
					<div style="text-align: center; bottom: 25px; position: absolute; margin-left: auto; margin-right: auto; left: 0; right: 0;">
						<c:if test="${!empty livre.imagePath}">
							<img src="<c:url value="/ressources/${livre.imagePath}"/>"
								width="100px" height="150px"
								class="rounded text-center center-block">
						</c:if>
						<c:if test="${empty livre.imagePath}">
							<img src="<c:url value="/ressources/images/imageVide.jpg"/>"
								width="100px" height="150px"
								class="rounded text-center center-block">
						</c:if>
						<p></p>
						<button type="button" class="btn btn-default">
							<a href="${baseurl}livre/${livre.slug}"><span
								class="glyphicon glyphicon-info-sign"></span> Plus d'information
							</a>
						</button>
						<button type="button" class="btn btn-default">
							<a href="${baseurl}livre"> <span
								class="glyphicon  glyphicon-shopping-cart"></span> Ajout au
								panier
							</a>
						</button>
					</div>
				</div>
			</div>


		</div>
	</c:forEach>
</div>
<jsp:include page="template/footer.jsp" />
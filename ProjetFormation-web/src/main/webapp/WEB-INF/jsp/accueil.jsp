<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="template/header.jsp" />
<div class="row">
	<c:forEach items="${livres}" var="livre">
		<div class="col-md-3" style="padding-bottom: 15px">
			<div class="thumbnail" style="min-height: 564px">
				<div class="caption">
					<h3>${livre.titre}</h3>
					<p>
						<c:forEach items="${livre.auteurs}" var="auteur">
							<b><i>${auteur.prenom} ${auteur.nom}</i></b>
						</c:forEach>
					</p>
					<p
						style="width: 250px; max-height: 144px; overflow-y: hidden; text-overflow-y: ellipsis">${livre.description}</p>
					<p>Prix: ${livre.prix}&euro;</p>
					<p>Date de publication: ${livre.datePublication}</p>
					<div
						style="text-align: center; bottom: 55px; position: absolute; margin-left: auto; margin-right: auto; left: 0; right: 0;">
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
								class="glyphicon glyphicon-info-sign"></span> Plus d'info
							</a>
						</button>
						<button type="button" class="btn btn-default">
							<a href="${baseurl}livre"> <span
								class="glyphicon  glyphicon-shopping-cart"></span> Ajout panier
							</a>
						</button>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<jsp:include page="template/footer.jsp" />
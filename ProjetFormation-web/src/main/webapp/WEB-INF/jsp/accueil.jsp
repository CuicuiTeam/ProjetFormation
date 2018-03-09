<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="template/header.jsp" />
<div class="row">
	<c:forEach items="${livres}" var="livre">
		<div class="col-md-3" style="padding-bottom: 15px">
			<div class="thumbnail">
				<div class="caption">
					<h3>${livre.titre}</h3>
					<p><c:forEach items="${livre.auteurs}" var="auteur"><b><i>${auteur.prenom}  ${auteur.nom}</i></b></c:forEach></p>
					<p>${livre.description}</p>
					<p>${livre.prix} &euro;</p>
					<p>${livre.datePublication}</p>
					<img src="<c:url value="/ressources/${livre.imagePath}"/>" width="100px" height="150px">
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<jsp:include page="template/footer.jsp" />
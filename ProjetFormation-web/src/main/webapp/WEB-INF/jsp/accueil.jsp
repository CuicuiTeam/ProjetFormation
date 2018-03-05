<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="titre" value="Accueil" scope="session"></c:set>
<jsp:include page="template/header.jsp" />
<div class="row">
	<c:forEach items="${livres}" var="livre">
		<div class="col-md-3" style="padding-bottom: 15px">
			<div class="thumbnail">
				<div class="caption">
					<h3>${livre.titre}</h3>
					<p>${livre.description}</p>
					<p>${livre.prix} €</p>
					<p>${livre.datePublication}</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<jsp:include page="template/footer.jsp" />
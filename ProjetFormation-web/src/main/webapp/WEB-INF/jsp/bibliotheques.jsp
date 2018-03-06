<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="titre" value="Accueil" scope="session"></c:set>
<jsp:include page="template/header.jsp" />
<div class="row">
	<c:forEach items="${bibliotheques}" var="bibliotheque">
		<div class="col-md-3" style="padding-bottom: 15px">
			<div class="thumbnail">
				<div class="caption">
					<h3>${bibliotheque.nom}</h3>
					<p>${bibliotheque.adresse}</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<jsp:include page="template/footer.jsp" />
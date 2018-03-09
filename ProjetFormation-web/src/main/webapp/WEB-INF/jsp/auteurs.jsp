<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="template/header.jsp" />
<div class="row">
	<c:forEach items="${auteurs}" var="auteur">
		<div class="col-md-3" style="padding-bottom: 30px">
			<div class="thumbnail">
				<div class="caption">
					<h3><i>${auteur.prenom}</i> ${auteur.nom}</h3>
					<button type="button"
						class="btn btn-outline-success and-all-other-classes">
						<a href="${baseurl}auteur/${auteur.slug}" style="color: inherit"> Plus d'info </a>
					</button>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<jsp:include page="template/footer.jsp" />
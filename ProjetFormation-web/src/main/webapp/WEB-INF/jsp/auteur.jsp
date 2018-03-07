<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="template/header.jsp" />

<style>
h1 {
    text-align: center;
}
</style>


<div class="row">

	<div class="panel panel-default">
		<div class="panel-heading"><h1>${auteur.prenom} ${auteur.nom}</h1></div>
		<div class="panel-body">
			<h3>biographie</h3>
			<p>${auteur.biographie}</p>
		</div>
	</div>

	<c:forEach items="${livres}" var="livre">
		<div class="col-md-3" style="padding-bottom: 15px">
			<div class="thumbnail">
				<div class="caption">
					<h3>${livre.titre}</h3>
					<p>${livre.description}</p>
					<p>${livre.prix}&euro;</p>
					<p>${livre.datePublication}</p>
				</div>
			</div>
	</c:forEach>
</div>
<jsp:include page="template/footer.jsp" />
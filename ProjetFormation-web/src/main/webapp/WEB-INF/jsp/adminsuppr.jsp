<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="titre" value="Supprimer un livre" scope="session"></c:set>
<jsp:include page="template/header.jsp" />
<legend>Supprimer un livre </legend>
<div class="row">
	<h2>Liste des livres</h2>
	<table class="table table-striped">
		<tr>
			<th>Titre</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Date de publication</th>
			<th>Recommandé</th>
			<th>Periodique</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${livres}" var="livre">
			<tr>
				<td>${livre.titre}</td>
				<td>${livre.description}</td>
				<td>${livre.prix}</td>
				<td>${livre.datePublication}</td>
				<td>${livre.popular}</td>
				<td>${livre.periodic}</td>
				<td><a href="#" class="btn btn-primary"><span
						class="glyphicon glyphicon-pencil"></span></a>
					<button onclick="loadDel(${livre.id})" class="btn btn-danger"
						data-toggle="modal" data-target="#modalDel">
						<span class="glyphicon glyphicon-trash"></span>
					</button></td>
			</tr>
		</c:forEach>
	</table>
</div>
<div class="modal fade" id="modalDel" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title">Supprimer un livre</h3>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<h5>Etes vous sûr de vouloir supprimer ce livre ?</h5>
			</div>
			<div class="modal-footer">
				<form action="${baseurl}supprimer" method="post">
					<input type="hidden" name="livreId" id="livreId" />
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					<button type="submit" class="btn btn-danger">Supprimer</button>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
function loadDel(id_livre){
 document.getElementById('livreId').value = id_livre;
}

</script>
<jsp:include page="template/footer.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="titre" value="Supprimer un membre" scope="session"></c:set>
<jsp:include page="template/header.jsp" />
<legend>Supprimer un membre </legend>
<div class="row">
	<h2>Liste des membres</h2>
	<table class="table table-striped">
		<tr>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Email</th>
			<th>Adresse</th>
			<th>Ville</th>
			<th>Code Postal</th>
			<th>Telephone</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${membres}" var="membre">
			<tr>
				<td>${membre.nom}</td>
				<td>${membre.prenom}</td>
				<td>${membre.email}</td>
				<td>${membre.adresse}</td>
				<td>${membre.ville}</td>
				<td>${membre.codePostal}</td>
				<td>${membre.telephone}</td>
				<td><form method="GET" action="${baseurl}editmembre" style="display: inline;">

						<input type="hidden" id="idMembre" name="idMembre" value="${membre.id}"/>
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-pencil"></span>
						</button>

					</form>
					<button onclick="loadDel(${membre.id})" class="btn btn-danger"
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
				<h3 class="modal-title">Supprimer un membre</h3>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<h5>Etes vous sûr de vouloir supprimer ce membre ?</h5>
			</div>
			<div class="modal-footer">
				<form action="${baseurl}supprimerMembre" method="post">
					<input type="hidden" name="membreId" id="membreId" />
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fermer</button>
					<button type="submit" class="btn btn-danger">Supprimer</button>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
function loadDel(id_membre){
 document.getElementById('membreId').value = id_membre;
}


</script>
<jsp:include page="template/footer.jsp" />
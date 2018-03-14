<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="titre" value="Modifier" scope="session"></c:set>
<jsp:include page="template/header.jsp" />
<form:form modelAttribute="edit" class="form-horizontal">
	<fieldset>
		<legend>Créez votre compte</legend>
		<div class="form-group">
			<label class="control-label col-lg-2" for="email">Email*</label>
			<div class="col-lg-10">
				<form:input id="email" path="email" type="email" required="required"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="nom">Nom</label>
			<div class="col-lg-10">
				<form:input id="nom" path="nom" type="text" class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="prenom">Prenom</label>
			<div class="col-lg-10">
				<form:input id="prenom" path="prenom" type="text"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="adresse">Adresse</label>
			<div class="col-lg-10">
				<form:input id="adresse" path="adresse" type="text"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="ville">Ville</label>
			<div class="col-lg-10">
				<form:input id="ville" path="ville" type="text"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="codePostal">Code
				Postal</label>
			<div class="col-lg-10">
				<form:input id="codePostal" path="codePostal" type="text"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="telephone">Telephone</label>
			<div class="col-lg-10">
				<form:input id="telephone" path="telephone" type="text"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="admin">Administrateur</label>
			<div class="col-lg-10">
				<form:checkbox id="admin" path="admin" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-10 col-lg-offset-2">
				<input type="submit" id="btnAdd" class="btn btn-primary"
					value="Modifier" />
			</div>
		</div>
		<i>*: Champs obligatoires</i>
	</fieldset>
</form:form>
<jsp:include page="template/footer.jsp" />
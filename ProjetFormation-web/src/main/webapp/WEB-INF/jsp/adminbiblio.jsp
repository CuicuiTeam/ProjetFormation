<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="titre" value="Ajouter une bibliotheque" scope="session"></c:set>
<jsp:include page="template/header.jsp" />
<form:form name="creerbibliotheque" modelAttribute="newBiblio"
	class="form-horizontal" >
	<fieldset>
		<legend>Ajouter une bibliotheque </legend>
		<div class="form-group">
			<label class="control-label col-lg-2" for="nom">Nom</label>
			<div class="col-lg-10">
				<form:input id="nom" path="nom" type="text" required="required"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="adresse">Adresse</label>
			<div class="col-lg-10">
				<form:input id="adresse" path="adresse" type="text"
					required="required" class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-10 col-lg-offset-2">
				<input type="submit" name="btnAddexit" class="btn btn-primary"
					value="Ajouter" />
			</div>
		</div>
		<!-- <div class="form-group">
			<div class="col-lg-10 col-lg-offset-2">
				<input type="submit" name="btnAdd" class="btn btn-primary"
					value="Ajouter puis créer un nouveau livre" />
			</div>
		</div> -->
	</fieldset>
</form:form>
<jsp:include page="template/footer.jsp" />
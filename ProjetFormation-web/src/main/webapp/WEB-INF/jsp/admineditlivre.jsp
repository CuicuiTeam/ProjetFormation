<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="titre" value="Modifier" scope="session"></c:set>
<jsp:include page="template/header.jsp" />
<form:form modelAttribute="edit" class="form-horizontal">
	<fieldset>
		<legend>Modifiez le livre</legend>
		<div class="form-group">
			<label class="control-label col-lg-2" for="titre">Titre*</label>
			<div class="col-lg-10">
				<form:input id="titre" path="titre" type="text" required="required"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="description">Description*</label>
			<div class="col-lg-10">
				<form:input id="description" path="description" type="text"
					required="required" class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="prix">Prix*</label>
			<div class="col-lg-10">
				<form:input id="prix" path="prix" type="text" required="required"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="date">Date de
				publication</label>
			<div class="col-lg-10">
				<form:input id="date" path="datePublication" type="date"
					required="required" class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="image">Image</label>
			<div class="col-lg-10">
				<form:input id="image" path="imagePath" type="text"
					required="required" class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="populaire">Recommande</label>
			<div class="col-lg-10">
				<form:checkbox id="populaire" path="popular" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="periodique">Periodique</label>
			<div class="col-lg-10">
				<form:checkbox id="periodique" path="periodic" />
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
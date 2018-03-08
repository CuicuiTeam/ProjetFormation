<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="titre" value="Inscription" scope="session"></c:set>
<jsp:include page="template/header.jsp" />
<form:form modelAttribute="newMembre" class="form-horizontal">
	<fieldset>
		<legend>Cr�ez votre compte</legend>
		<div class="form-group">
			<label class="control-label col-lg-2" for="email">Email</label>
			<div class="col-lg-10">
				<form:input id="email" path="email" type="email" required="required"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="mdp">Mot de passe</label>
			<div class="col-lg-10">
				<form:input id="mdp" path="password" type="password" required="required"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-10 col-lg-offset-2">
				<input type="submit" id="btnAdd" class="btn btn-primary" value="Cr�er" />
			</div>
		</div>
	</fieldset>
</form:form>
<jsp:include page="template/footer.jsp" />
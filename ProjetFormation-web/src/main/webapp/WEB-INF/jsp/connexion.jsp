<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="titre" value="Connexion" scope="session"></c:set>
<jsp:include page="template/header.jsp" />
<form:form modelAttribute="login" action="${baseurl}connexioncheck" class="form-horizontal">
	<fieldset>
		<legend>Accedez à votre compte</legend>
		<div class="form-group">
			<label class="control-label col-lg-2" for="email">Email</label>
			<div class="col-lg-10">
				<form:input id="email" path="email" type="email"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-lg-2" for="mdp">Mot de passe</label>
			<div class="col-lg-10">
				<form:input id="mdp" path="password" type="password"
					class="form:input-large" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-lg-10 col-lg-offset-2">
				<input type="submit" id="btnAdd" class="btn btn-primary"
					value="Connexion" />
			</div>
		</div>
	</fieldset>
</form:form>
<jsp:include page="template/footer.jsp" />
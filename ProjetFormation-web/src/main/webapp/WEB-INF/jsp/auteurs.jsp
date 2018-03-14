<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="template/header.jsp" />
<div class="row">
	<div class="container">
		<c:forEach items="${auteurs}" var="auteur">
			
				<div class="col-lg-4" style="padding-bottom: 30px">
					<!-- <div class="thumbnail"> -->
					<div class="caption">
					<div class="panel panel-default" style="background-color:#eee; border-color: #999" >
						<h3 class="text-center" >
							<i>${auteur.prenom}</i> <b>${auteur.nom}</b>
						</h3>
						<c:if test="${!empty auteur.imagePath}">
						<img src="<c:url value="/ressources/${auteur.imagePath}"/>" width="75px" height="125px" class="rounded text-center center-block">
						</c:if>
						<c:if test="${empty auteur.imagePath}">
						<img src="<c:url value="/ressources/images/imageVide.jpg"/>" width="75px" height="125px" class="rounded text-center center-block">
						</c:if>
						<button type="button"
							class="btn btn-default center-block" >
							<a href="${baseurl}auteur/${auteur.slug}"><span
								class="glyphicon glyphicon-info-sign"></span>
								Plus d'information </a>
						</button>
					</div>
					<!-- </div> -->
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<jsp:include page="template/footer.jsp" />
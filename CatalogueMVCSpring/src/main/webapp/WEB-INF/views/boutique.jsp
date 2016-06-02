<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<a href="<c:url value="/j_spring_security_logout" />"> Retour
	Accueil</a>
<div class="errors">${exception}</div>
<div id="tabProduits" class="cadre">
	<table class="tabStyle1">
		<tr>
			<th>ID</th>
			<th>Désignation</th>
			<th>Description</th>
			<th>catégorie</th>
			<th>Prix</th>
			<th>Quantité</th>
			<th>Selected</th>
			<th>Photo</th>
		</tr>
		<c:forEach items="${produits}" var="p">
			<tr>
				<td>${p.idProduit }</td>
				<td>${p.designation }</td>
				<td>${p.description }</td>
				<td>${p.categorie.nomCategorie }</td>
				<td>${p.prix }</td>
				<td>${p.quantite }</td>
				<td>${p.selectionne }</td>
				<td><img src="photoProd?idProd=${p.idProduit }" /></td>
				<td><a href="addPanier?idProd=${p.idProduit }">Ajouter au
						panier</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<h1>Panier</h1>
<div id="tabPanier" class="cadre">
	<table class="tabStyle1">
		<tr>
			<th>Produit</th>
			<th>Quantite</th>
		</tr>
		<c:forEach items="${panier.items}" var="lc">
			<tr>
				<td>${lc.produit.designation}</td>
				<th>${lc.quantite}</th>
			</tr>
		</c:forEach>
	</table>
</div>

<div id="formClient" class="cadre">
	<f:form modelAttribute="client" action="savePanier" method="post">
		<table>
			<tr>
				<td>ID Client</td>
				<td>${client.idClient}<f:input type="hidden" path="idClient" /></td>
				<td><f:errors path="idClient" cssClass="errors">
					</f:errors></td>
			</tr>
			<tr>
				<td>Nom</td>
				<td><f:input path="nomClient" /></td>
				<td><f:errors path="nomClient" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Adresse</td>
				<td><f:input path="adresse" /></td>
				<td><f:errors path="adresse" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><f:input path="email" /></td>
				<td><f:errors path="email" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Telephone</td>
				<td><f:input path="tel" /></td>
				<td><f:errors path="tel" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td><input type="submit" value="Commander"></td>
			</tr>
		</table>
	</f:form>
</div>
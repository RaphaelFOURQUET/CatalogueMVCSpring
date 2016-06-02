<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
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
				<td><img src="photoProd?idProd=${p.idProduit }" /></td>	<!-- TODO photoProd A CODER  -->
<%-- 				<td><a href="suppProd?idProd=${p.idProduit }">Supp</a></td>
				<td><a href="editProd?idProd=${p.idProduit }">Edit</a></td> --%>
				<td>TODO : ajouter au panier</td>
			</tr>
		</c:forEach>
	</table>
</div>
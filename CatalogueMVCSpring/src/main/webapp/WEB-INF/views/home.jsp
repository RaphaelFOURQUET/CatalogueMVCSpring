<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="<c:url value="/login" />"> Login</a> <br/>
<a href="<c:url value="/produits/index" />"> Produits</a><br/>
<a href="<c:url value="/adminProd/index" />"> Admin Produits</a><br/>
<a href="<c:url value="/adminCat/index" />"> Admin Categories</a><br/>
</body>
</html>
